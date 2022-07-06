package ar.edu.unju.fi.controller;

import java.security.Principal;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Cv;
import ar.edu.unju.fi.service.ICvService;
import ar.edu.unju.fi.service.IPostuladoService;

@Controller
@RequestMapping("/postulante")
public class PostulanteController {
	
	@Autowired
	IPostuladoService postulanteService;
	@Autowired
	ICvService cvService;
	@GetMapping("/postularse/{id}")
	public ModelAndView postularse(@PathVariable(name="id")Long id,Principal prin)
	{
	
		try {
		ModelAndView mav = new ModelAndView("postulado_exitoso");
	    Cv curriculum = cvService.BuscarCvDni( Long.parseLong(prin.getName())).get();
		postulanteService.guardarPostulante(postulanteService.getPostulante(),prin.getName() , id);
		
		return mav;
		}catch (NoSuchElementException e) {
			ModelAndView mav = new ModelAndView("error_postular");
			return mav;
		}
	}

}
