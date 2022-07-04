package ar.edu.unju.fi.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Cv;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICvService;

@Controller
@RequestMapping("/curriculum")
public class CvController {

	@Autowired
	ICvService cvService;
	@Autowired
	ICiudadanoService ciudadanoService;
	
	@GetMapping("/nuevo")
	public ModelAndView nuevoCv() {
		ModelAndView mav = new ModelAndView("cv_alta");
		mav.addObject("curriculum", cvService.getCv());
		return mav;
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCv(@Validated @ModelAttribute("cv")Cv cv, BindingResult bindingResult,Principal principal) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("cv_alta");
			mav.addObject("curriculum", cv);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/home");
		
		cv.setCiudadano(ciudadanoService.buscarId(Long.parseLong( principal.getName() )).get()  );
		cvService.GuardarCv(cv);
		
		return mav;
	}
	
	@GetMapping("/ver")
	public ModelAndView verCurriculum(Principal principal) {
		
		ModelAndView mav = new ModelAndView("index");
		//mav.addObject("curriculum", cvService.getCv());
		Optional<Cv> curriculum = cvService.BuscarCv(ciudadanoService.buscarId(Long.parseLong( principal.getName() )).get().getId() );
		System.out.println(curriculum.get().getEmail());
		return mav;
	}
	
	
}
