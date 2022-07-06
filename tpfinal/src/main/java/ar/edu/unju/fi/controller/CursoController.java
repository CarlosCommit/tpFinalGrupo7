package ar.edu.unju.fi.controller;

import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICursoService;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.util.Categoria;


@Controller
@RequestMapping("/curso")
public class CursoController {
	private static final Log LOGGER = LogFactory.getLog(CursoController.class);
	@Autowired
	ICursoService cursoService;
    @Autowired
    IEmpleadorService empleadorService;
    @Autowired
    private Categoria categorias;
    @Autowired
   	ICiudadanoService ciudadanoService;
	@GetMapping("/lista")
	public ModelAndView listaCursos(Principal principal) {
		ModelAndView mav = new ModelAndView("lista_curso");
		
		long idEmpleador = empleadorService.getId(Long.parseLong(principal.getName()));
		//mando la lista de cursos que pertenecen al empleador conectado
		mav.addObject("lista", cursoService.getListaCursoEmpleador(idEmpleador));
		return mav;
	}
	@GetMapping("/lista/ciudadano")
	public ModelAndView listaCursosCiudadano(Principal principal) {
		
		ModelAndView mav = new ModelAndView("lista_curso");
		//mando la lista de cursos que esten activas para el ciudadano
		mav.addObject("lista", cursoService.getListaCurso());
		//mando la lista de categorias para filtrar
		mav.addObject("categorias", categorias.getLista());
		return mav;
	}
	//nuevo curso
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
	
	@GetMapping("/eliminar/{id}")
    public ModelAndView eliminarCurso(@PathVariable(name="id") long id,Model model)
    {
		cursoService.eliminarCurso(id);
		LOGGER.info("curso eliminado");
		ModelAndView mav = new ModelAndView("borrado_curso");
		return mav;
    }
	@GetMapping("/inscribir/{id}")
	 public ModelAndView inscribir(@PathVariable(name="id") long id,Principal prin) {
		ModelAndView mav = new ModelAndView("inscribir_exitoso");
		Curso curso = cursoService.buscarCurso(id).get();
		Ciudadano ciudadano = ciudadanoService.buscarId(Long.parseLong(prin.getName())).get();
	
		if (curso.getCiudadanos().contains(ciudadano))
		{
			return new ModelAndView("error_inscribirse");
		}
	
		//le paso dos parametros el ciudadano y el curso donde se va a agregar
	    cursoService.agregarCiudadanoInscripto(curso, ciudadano);
		
		return mav;
		
		
	}
	
}
