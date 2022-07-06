package ar.edu.unju.fi.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.IOfertaService;
import ar.edu.unju.fi.service.IPostuladoService;
import ar.edu.unju.fi.service.util.Provincia;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	private static final Log LOGGER = LogFactory.getLog(OfertaController.class);
	@Autowired
	IOfertaService ofertaService;
	@Autowired
	IEmpleadorService empleadorService;
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	IPostuladoService postulanteService;
	@Autowired
	private Provincia listaProvincia;
	
   @GetMapping("/nuevo")
   public ModelAndView crearOferta(Model model,Principal principal)
   {
	 ModelAndView mav = new ModelAndView("alta_oferta");
	 //Optional<Empleador> empleador =   empleadorService.buscarEmpleador(Long.parseLong(principal.getName()));
	 //System.out.println(empleador.get().getNombreComercial() );
	  mav.addObject("oferta",ofertaService.getOferta());
	  mav.addObject("lista",listaProvincia.getLista());
	  return mav;
   }
	
   @PostMapping("/guardar")
   
   public ModelAndView guardarOferta(@Validated @ModelAttribute("oferta")Oferta oferta,BindingResult bindingResult,Principal principal)
   {
	   if(bindingResult.hasErrors()) {
		   ModelAndView mav = new ModelAndView("alta_oferta");
		  mav.addObject("oferta", oferta);
		  mav.addObject("lista",listaProvincia.getLista());
		   return mav; 
	   }
	   ModelAndView mav = new ModelAndView("oferta_creada");
	   
	ofertaService.guardarOferta(oferta, principal.getName());
	  LOGGER.info("nueva oferta creada");
	
	   return mav; 
   }
   
   @GetMapping("/eliminar/{id}")
   
   public ModelAndView eliminarOferta(@PathVariable(name="id") long id,Model model)
   {
	  ofertaService.eliminarOferta(id); 
	  LOGGER.info("ofert eliminada");
	  ModelAndView mav = new ModelAndView("oferta_eliminada");
	  return mav;
   }
   // toma como parametro id de of y usu
 @GetMapping("/contratar/{id}/{idUsuario}")
   
   public ModelAndView contratar(@PathVariable(name="id") long id,@PathVariable(name="idUsuario")long idUsuario)
   {
	 
	  ModelAndView mav = new ModelAndView("contratado_exitoso");
	  Long idciudadano = ciudadanoService.buscarId(idUsuario).get().getId();
	  ofertaService.agregarCiudadanoContratado( ofertaService.buscarOferta(id).get() ,ciudadanoService.buscarId(idUsuario).get() );
	  postulanteService.eliminarPostulante(idciudadano,id);
	 
	  return mav;
   }
   
 	@GetMapping("/editar/{id}")
 	public ModelAndView editarOferta(@PathVariable(value="id")long id,Principal principal) throws Exception {
 		ModelAndView mav = new ModelAndView("editar_oferta");
 		mav.addObject("oferta",ofertaService.buscarOferta(id).get());
 		mav.addObject("lista", listaProvincia.getLista());
 		return mav;
 	}
 	
 	@PostMapping("/modificar/{id}")
 	public ModelAndView modificarOferta(@PathVariable(value="id")long idof,@ModelAttribute("oferta")Oferta oferta,Principal p) throws Exception {
 	
 		ModelAndView mav = new ModelAndView("redirect:/empleador/home");
 		oferta.setEmpleador(empleadorService.buscarEmpleador(Long.parseLong(   p.getName()   )).get());
 		oferta.setId(idof);
 		ofertaService.editarOferta(oferta);
 		LOGGER.info("oferta editada");
 		
 		return mav;
 	}
	@GetMapping("/contratados/{id}")
 	public ModelAndView verContratados(@PathVariable(value="id")long id,Principal principal) throws Exception {
 		ModelAndView mav = new ModelAndView("contratados_oferta");
 		
 		mav.addObject("contratados",ofertaService.buscarOferta(id).get().getCiudadanos());
 		mav.addObject("oferta",ofertaService.buscarOferta(id).get());
 		return mav;
 	}
}
