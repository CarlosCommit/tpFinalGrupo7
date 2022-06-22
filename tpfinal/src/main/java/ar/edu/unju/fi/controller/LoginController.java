package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.IEmpleadorService;
@RequestMapping("/login")
@Controller
public class LoginController {

	@Autowired
	ICiudadanoService ciudadanoService;
	IEmpleadorService empleadorService;
@GetMapping("/ciudadano")
public String loginCiudadano(Model model) {
	model.addAttribute("ciudadano", ciudadanoService.getCiudadano());
	return "login_ciudadano";
}

@GetMapping("/empleador")
public String loginEmpleador(Model model) {
	model.addAttribute("empleador", empleadorService.getEmpleador());
	return "login_empleador";
}

}
