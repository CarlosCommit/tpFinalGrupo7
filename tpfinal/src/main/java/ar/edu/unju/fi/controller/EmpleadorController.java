package ar.edu.unju.fi.controller;

import java.security.Principal;

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

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

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
		    	return mav;
		    }
		
		ModelAndView mav = new ModelAndView("redirect:/empleador/home");
		empleadorService.guardarEmpleador(empleador);
		return mav;
	}
	
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
		return mav;
	}
	
	@GetMapping("/verCurriculum/{id}")
	public ModelAndView verPostulantes(@PathVariable(name="id")long id,Principal principal) {
		ModelAndView mav = new ModelAndView("cv_mostrar");
		mav.addObject("curriculum",cvService.BuscarCv(id).get() );
		return mav;
	}

}
