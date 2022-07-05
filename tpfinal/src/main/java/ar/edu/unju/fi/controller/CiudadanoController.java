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

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IOfertaService;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {
	
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	IOfertaService ofertaService;
	@Autowired
	IUsuarioService usuarioService;


@GetMapping("/nuevo")
public ModelAndView nuevociudadano(Model model) {
	ModelAndView mav = new ModelAndView("alta_ciudadano");
	
	//mav.addObject("usuario",usuarioService.getUsuario());
	mav.addObject("ciudadano", ciudadanoService.getCiudadano());
	mav.addObject("lista", ofertaService.getProvincias());
	
	
	return mav;
}

@PostMapping("/guardar")
public ModelAndView guardarciudadano(@Validated @ModelAttribute("ciudadano")Ciudadano ciudadano, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
    	ModelAndView mav = new ModelAndView("alta_ciudadano");
    	mav.addObject("lista", ofertaService.getProvincias());
    	mav.addObject("ciudadano", ciudadano);
    	return mav;
    }
	
	ciudadanoService.guardarCiudadano(ciudadano);
ModelAndView mav = new ModelAndView("redirect:/login");
return mav;
}

@GetMapping("/home")
public ModelAndView homeciudadano(Model model,Principal principal) {

	ModelAndView mav = new ModelAndView("home_ciudadano");
	mav.addObject("lista", ofertaService.getListaOferta());
	
	//System.out.println(principal.getClass);
	
	return mav;
	
}


@GetMapping("/login")
public ModelAndView loginc() {
	ModelAndView mav = new ModelAndView("login_ciudadano");
	mav.addObject("ciudadano", ciudadanoService.getCiudadano());
return mav;	
}

@GetMapping("/filtrar/{pro}")
public ModelAndView filtrarProvincia(@PathVariable(name="pro")String pro)
{
	ModelAndView mav = new ModelAndView("home_ciudadano");
	mav.addObject("lista", ofertaService.getListaFiltroProvincia(pro));
	return mav;
}




}