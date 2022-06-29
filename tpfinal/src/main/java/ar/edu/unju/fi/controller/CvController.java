package ar.edu.unju.fi.controller;

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
import ar.edu.unju.fi.service.ICvService;

@Controller
@RequestMapping("/curriculum")
public class CvController {

	@Autowired
	ICvService cvService;
	@GetMapping("/nuevo")
	public ModelAndView nuevoCv() {
		ModelAndView mav = new ModelAndView("cv_alta");
		mav.addObject("curriculum", cvService.getCv());
		return mav;
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCv(@Validated @ModelAttribute("cv")Cv cv, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("cv_alta");
			mav.addObject("curriculum", cv);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/home");
		cvService.GuardarCv(cv);
		
		return mav;
	}
	
}
