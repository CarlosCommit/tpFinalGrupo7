package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.service.IEmpleadorService;
import ar.edu.unju.fi.service.IOfertaService;

@Controller
@RequestMapping("/oferta")
public class OfertaController {

	@Autowired
	IOfertaService ofertaService;
	@Autowired
	IEmpleadorService empleadorService;
	
	
   @GetMapping("/nuevo")
   public ModelAndView crearOferta(Model model)
   {
	  ModelAndView mav = new ModelAndView("alta_oferta");
	  mav.addObject("oferta",ofertaService.getOferta());
	  mav.addObject("empleadores",empleadorService.getListaEmpleador());
	  return mav;
   }
	
   @PostMapping("/guardar")
   
   public ModelAndView guardarOferta(@ModelAttribute("oferta")Oferta oferta, Model model)
   {
	   ModelAndView mav = new ModelAndView("alta_oferta");
	   ofertaService.guardarOferta(oferta);
	   return mav; 
   }
   
   @GetMapping("/eliminar/{id}")
   
   public ModelAndView eliminarOferta(@PathVariable(name="id") long id,Model model)
   {
	  ofertaService.eliminarOferta(id); 
	  ModelAndView mav = new ModelAndView("redirect:/empleador/home");
	  return mav;
   }
   
}
