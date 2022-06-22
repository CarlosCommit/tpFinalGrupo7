package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.service.ICiudadanoService;

@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {
	
	@Autowired
	ICiudadanoService ciudadanoService;

@GetMapping("/nuevo")
public ModelAndView nuevociudadano(Model model) {
	ModelAndView mav = new ModelAndView("alta_ciudadano");
	Ciudadano ciudadano = new Ciudadano();
	mav.addObject("ciudadano", ciudadano);
	return mav;
}

@PostMapping("/guardar")
public ModelAndView guardarciudadano(@Validated @ModelAttribute("ciudadano")Ciudadano ciudadano, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
    	ModelAndView mav = new ModelAndView("alta_ciudadano");
    	mav.addObject("ciudadano", ciudadano);
    	return mav;
    }
	
	ciudadanoService.guardarCiudadano(ciudadano);
ModelAndView mav = new ModelAndView("redirect:/ciudadano/home");
return mav;
}
}
