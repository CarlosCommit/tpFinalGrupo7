package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IEmpleadorService;

@Controller
public class LoginController {

	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	IEmpleadorService empleadorService;
	
@GetMapping("/login")
public ModelAndView loginCiudadano(Model model) {
	ModelAndView mav = new ModelAndView("login_ciudadano");
	/*
	if(tipo.equals("empleador"))
	{
		mav.addObject("String","Cuit");
	}else if (tipo.equals("ciudadano"))
	{
		mav.addObject("String","Dni");	
	}
	*/
	return mav;
}
}
