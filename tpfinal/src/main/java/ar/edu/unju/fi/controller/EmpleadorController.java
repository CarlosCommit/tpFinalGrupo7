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

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.service.IEmpleadorService;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

	@Autowired
	IEmpleadorService empleadorService;
	
	@GetMapping("/nuevo")
public ModelAndView crearEmpleador(Model model)
{
		ModelAndView mav = new ModelAndView("alta_empleador");
		mav.addObject("empleador",empleadorService.getEmpleador());
		return mav;
}
	
	@PostMapping("/guardar")
	public ModelAndView guardarEmpleador(@Validated @ModelAttribute("empleador") Empleador empleador, BindingResult bindingResult)
	{
		 if (bindingResult.hasErrors()) {
		    	ModelAndView mav = new ModelAndView("alta_empleador");
		    	mav.addObject("empleador", empleador);
		    	return mav;
		    }
		
		ModelAndView mav = new ModelAndView("redirect:/empleador/alta_empleador");
		empleadorService.guardarEmpleador(empleador);
		return mav;
	}
}
