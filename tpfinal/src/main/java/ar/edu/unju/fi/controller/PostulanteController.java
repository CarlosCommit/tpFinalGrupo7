package ar.edu.unju.fi.controller;

import java.security.Principal;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Cv;
import ar.edu.unju.fi.entity.Postulante;
import ar.edu.unju.fi.service.ICiudadanoService;
import ar.edu.unju.fi.service.ICvService;
import ar.edu.unju.fi.service.IOfertaService;
import ar.edu.unju.fi.service.IPostuladoService;

@Controller
@RequestMapping("/postulante")
public class PostulanteController {
	private static final Log LOGGER = LogFactory.getLog(PostulanteController.class);
	@Autowired
	IPostuladoService postulanteService;
	@Autowired
	ICvService cvService;
	@Autowired
	ICiudadanoService ciudadanoService;
	@Autowired
	IOfertaService ofertaService;
	@GetMapping("/postularse/{id}")
	public ModelAndView postularse(@PathVariable(name="id")Long id,Principal prin)
	{
	 
		if(cvService.BuscarCvDni( Long.parseLong(prin.getName())).isPresent())
		{
			
			
		    Ciudadano ciudadano= ciudadanoService.buscarId(Long.parseLong(prin.getName())).get();
		    Long idCiudadano = ciudadano.getId();
			if(ofertaService.buscarOferta(id).get().getCiudadanos().contains(ciudadano) )
			{
				return new ModelAndView("error_contratado");
			}else if(postulanteService.buscarPostulante(idCiudadano,id).isPresent())	
			{
				System.out.println("Postulante ya postulado");
				return new ModelAndView("erro_postular_nuevamente");
			}else
			{
				postulanteService.guardarPostulante(postulanteService.getPostulante(),prin.getName() , id);
				System.out.println("No existe ni contratado ni postulante, guardar");
				return new ModelAndView("postulado_exitoso");
			}
			
			
			
			
			
		}else
		{
			return new ModelAndView("error_postular");
		}
		
			
			 

	}

}
