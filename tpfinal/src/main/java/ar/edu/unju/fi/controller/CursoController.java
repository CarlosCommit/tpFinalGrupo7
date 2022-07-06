package ar.edu.unju.fi.controller;

import java.security.Principal;

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
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.util.Categoria;


@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	ICursoService cursoService;
    @Autowired
    IEmpleadorService empleadorService;
    @Autowired
    private Categoria categorias;
	@GetMapping("/lista")
	public ModelAndView listaCursos(Principal principal) {
		ModelAndView mav = new ModelAndView("lista_curso");
		long idEmpleador = empleadorService.getId(Long.parseLong(principal.getName()));
		
		mav.addObject("lista", cursoService.getListaCursoEmpleador(idEmpleador));
		return mav;
	}
	@GetMapping("/lista/ciudadano")
	public ModelAndView listaCursosCiudadano(Principal principal) {
		ModelAndView mav = new ModelAndView("lista_curso");
		mav.addObject("lista", cursoService.getListaCurso());
		return mav;
	}
	
	@GetMapping("/nuevo")
	public ModelAndView nuevoCurso() {
		ModelAndView mav = new ModelAndView("alta_curso");
		mav.addObject("curso", cursoService.getCurso());
		mav.addObject("categorias", categorias.getLista());
		return mav;
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCurso(@Validated @ModelAttribute("curso")Curso curso,BindingResult bindingResult,Principal prin) {
		
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("alta_curso");
			mav.addObject("curso", curso);
			mav.addObject("categorias", categorias.getLista());
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/curso/lista");
		cursoService.guardarCurso(curso,prin.getName());
		return mav;
	}
	
}
