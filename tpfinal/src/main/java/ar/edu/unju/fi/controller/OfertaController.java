package ar.edu.unju.fi.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.IOfertaService;

@Controller
@RequestMapping("/oferta")
public class OfertaController {

	@Autowired
	IOfertaService ofertaService;
	@Autowired
	IEmpleadorService empleadorService;
	
	
   @GetMapping("/nuevo")
   public ModelAndView crearOferta(Model model,Principal principal)
   {
	 ModelAndView mav = new ModelAndView("alta_oferta");
	 //Optional<Empleador> empleador =   empleadorService.buscarEmpleador(Long.parseLong(principal.getName()));
	 //System.out.println(empleador.get().getNombreComercial() );
	  mav.addObject("oferta",ofertaService.getOferta());
	  return mav;
   }
	
   @PostMapping("/guardar")
   
   public ModelAndView guardarOferta(@Validated @ModelAttribute("oferta")Oferta oferta,BindingResult bindingResult,Principal principal)
   {
	   if(bindingResult.hasErrors()) {
		   ModelAndView mav = new ModelAndView("alta_oferta");
		  mav.addObject("oferta", oferta);
		   return mav; 
	   }
	   ModelAndView mav = new ModelAndView("redirect:/empleador/home");
	   
	ofertaService.guardarOferta(oferta, principal.getName());
	  
	  
	   return mav; 
   }
   
   @GetMapping("/eliminar/{id}")
   
   public ModelAndView eliminarOferta(@PathVariable(name="id") long id,Model model)
   {
	  ofertaService.eliminarOferta(id); 
	  ModelAndView mav = new ModelAndView("redirect:/empleador/home");
	  return mav;
   }
   
}
