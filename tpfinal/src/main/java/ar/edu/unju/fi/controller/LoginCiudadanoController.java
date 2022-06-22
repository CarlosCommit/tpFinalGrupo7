package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.ICiudadanoService;
@RequestMapping("/login")
@Controller
public class LoginCiudadanoController {

	@Autowired
	ICiudadanoService ciudadanoService;
	
@GetMapping("/ciudadano")
public String loginCiudadano(Model model) {
	model.addAttribute("ciudadano", ciudadanoService.getCiudadano());
	return "login_ciudadano";
}
}
