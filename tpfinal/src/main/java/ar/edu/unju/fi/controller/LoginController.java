package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IEmpleadorService;

@Controller
public class LoginController {

	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	IEmpleadorService empleadorService;
	
@GetMapping("/login")
public String loginCiudadano(Model model) {
	return "login_ciudadano";
}
}
