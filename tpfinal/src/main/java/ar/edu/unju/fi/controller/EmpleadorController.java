package ar.edu.unju.fi.controller;

import java.security.Principal;

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

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Postulante;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICvService;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.IOfertaService;
import ar.edu.unju.fi.service.IPostuladoService;
import ar.edu.unju.fi.service.util.Provincia;
import ar.edu.unju.fi.service.util.PuestoLaboral;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
	private static final Log LOGGER = LogFactory.getLog(EmpleadorController.class);
	@Autowired
	IEmpleadorService empleadorService;
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	IOfertaService ofertaService;
	@Autowired
	IPostuladoService postuladoService;
	@Autowired
    ICvService cvService;
	@Autowired
	private Provincia listaProvincia;
	@Autowired
	private PuestoLaboral puesto;
	@GetMapping("/nuevo")
public ModelAndView crearEmpleador(Model model)
{
		ModelAndView mav = new ModelAndView("alta_empleador");
		mav.addObject("empleador",empleadorService.getEmpleador());
		mav.addObject("lista",listaProvincia.getLista());
		return mav;
}
	
	@PostMapping("/guardar")
	public ModelAndView guardarEmpleador(@Validated @ModelAttribute("empleador") Empleador empleador, BindingResult bindingResult)
	{
		 if (bindingResult.hasErrors()) {
		    	ModelAndView mav = new ModelAndView("alta_empleador");
		    	mav.addObject("empleador", empleador);
		    	mav.addObject("lista", listaProvincia.getLista());
		    	LOGGER.info("error de validacion");
		    	return mav;
		    }
		
		ModelAndView mav = new ModelAndView("redirect:/empleador/home");
		empleadorService.guardarEmpleador(empleador);
		LOGGER.info("nuevo empleador creado");
		return mav;
	}
	// pagina principal de empleador
	@GetMapping("/home")
	public ModelAndView homeEmpleador(Model model,Principal principal) {
		
		ModelAndView mav = new ModelAndView("home_empleador");
		mav.addObject("lista", ofertaService.getListaOfertaEmpleador(empleadorService.getId(Long.parseLong(principal.getName()))));
		return mav;
	}
	@GetMapping("/postulantes")
	public ModelAndView verPostulantes(Model model,Principal principal) {
		ModelAndView mav = new ModelAndView("lista_postulantes");
		mav.addObject("lista",empleadorService.getListaPostulante(empleadorService.getId(Long.parseLong(principal.getName()))));
		mav.addObject("listaProvincia",listaProvincia.getLista());
		mav.addObject("puestoLaboral",puesto);
		return mav;
	}
	@GetMapping("/filtro/{pro}")
	public ModelAndView verPostulantesProvincia(@PathVariable(name="pro")String pro, Model model,Principal principal) {
		ModelAndView mav = new ModelAndView("lista_postulantes");
		//le paso el id del empleador conectado(id, no cuit) y le paso la palabra clave para buscar
		mav.addObject("lista",empleadorService.getListaPostulanteProvincia(empleadorService.getId(Long.parseLong(principal.getName())),pro ));
		mav.addObject("listaProvincia",listaProvincia.getLista());
		mav.addObject("puestoLaboral",puesto);
		
		return mav;
	}
	
	@PostMapping("/palabra")
	public ModelAndView guardarEmpleador(@ModelAttribute("puestoLaboral") PuestoLaboral puesto,Principal principal)
	{
		ModelAndView mav = new ModelAndView("lista_postulantes");
		//le paso el id del empleador conectado(id, no cuit) y le paso la palabra clave para buscar
		System.out.println("jefe".contains("JEFE") );
		mav.addObject("lista",empleadorService.getListaPostulantePalabra( empleadorService.getId(Long.parseLong(principal.getName())) , puesto.getPuesto() ));
		mav.addObject("listaProvincia",listaProvincia.getLista());
		mav.addObject("puestoLaboral",puesto);
		
		return mav;
	}
	
	
	// para ver curriculum del postulado
	@GetMapping("/verCurriculum/{id}")
	public ModelAndView verPostulantes(@PathVariable(name="id")long id,Principal principal) {
		ModelAndView mav = new ModelAndView("cv_mostrar");
		mav.addObject("curriculum",cvService.BuscarCv(id).get() );
		return mav;
	}

}
