package ar.edu.unju.fi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.service.IPostuladoService;

@Controller
@RequestMapping("/postulante")
public class PostulanteController {
	
	@Autowired
	IPostuladoService postulanteService;
	@GetMapping("/postularse/{id}")
	public ModelAndView postularse(@PathVariable(name="id")Long id,Principal prin)
	{
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/home");
	    
		postulanteService.guardarPostulante(postulanteService.getPostulante(),prin.getName() , id);
		
		return mav;
	}

}
