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

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.ICursoService;


@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	ICursoService cursoService;

	@GetMapping("/lista")
	public ModelAndView listaCursos() {
		ModelAndView mav = new ModelAndView("lista_curso");
		mav.addObject("lista", cursoService.getListaCurso());
		return mav;
	}
	
	@GetMapping("/nuevo")
	public ModelAndView nuevoCurso() {
		ModelAndView mav = new ModelAndView("alta_curso");
		mav.addObject("curso", cursoService.getCurso());
		return mav;
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCurso(@Validated @ModelAttribute("curso")Curso curso,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("alta_curso");
			mav.addObject("curso", curso);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/curso/lista");
		cursoService.guardarCurso(curso);
		return mav;
	}
	
}
