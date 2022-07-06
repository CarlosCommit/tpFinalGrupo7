package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.entity.Postulante;
import ar.edu.unju.fi.repository.ICiudadanoDAO;
import ar.edu.unju.fi.repository.IOfertaDAO;
import ar.edu.unju.fi.repository.IPostuladosDAO;
import ar.edu.unju.fi.service.IPostuladoService;
@Service
public class PostulanteServiceImp implements IPostuladoService {

	@Autowired
	IPostuladosDAO postulanteDaoImp;
	@Autowired
	IOfertaDAO ofertaDaoImp;
	@Autowired
	ICiudadanoDAO ciudadanoDaoImp;
	@Override
	public Postulante getPostulante() {
		return new Postulante();
	}

	@Override
	public void guardarPostulante(Postulante postulante,String username,long id) {
		
		Optional<Oferta> oferta = ofertaDaoImp.findById(id);
		Optional<Ciudadano> ciudadano = ciudadanoDaoImp.findByCiudadanoId(Long.parseLong(username));
		postulante.setCiudadano(ciudadano.get());
		postulante.setOferta(oferta.get());
		postulanteDaoImp.save(postulante);
		
		
	}

	@Override
	public Iterable<Postulante> buscarIdOferta(long id) {
		
		Iterable<Postulante> postulante = postulanteDaoImp.findByIdOferta(id);
		
		return postulante;
	}

	@Override
	public Optional<Postulante> buscarPostulante(Long id, Long q) {
		Optional<Postulante> post =  postulanteDaoImp.findByPost(id, q);
		return post;
	}

	@Override
	public void eliminarPostulante(Long id, Long q) {
		postulanteDaoImp.delete(buscarPostulante(id, q).get());
		
	}

	@Override
	public List<Postulante> buscarPostulacionCiudadano(long idCiudadano) {
		
		//Obtener el objeto Ciudadano del ciudadano conectado
		Ciudadano ciudadano = ciudadanoDaoImp.findByCiudadanoId(idCiudadano).get();
		//encontrar la lista de ofertas activas
		Iterable<Oferta> listaOferta = ofertaDaoImp.findByActive();
		//filtrar de esas ofertas activas en cuales el ciudadano conectado se postulo
		
		List<Postulante> postulantes = new ArrayList<Postulante>();
		
		/*
		for(Oferta oferta: listaOferta)
		{
			if(oferta.getCiudadanos().contains(ciudadano))
			{
				postulantes.add()
			}
		}*/
		for(Oferta oferta: listaOferta)
		{
			if(postulanteDaoImp.findByPost(ciudadano.getId(), oferta.getId()).isPresent())
			{ 
				
				postulantes.add(postulanteDaoImp.findByPost(ciudadano.getId(), oferta.getId()).get());
			}
		}
		
		return postulantes;
		
	}
	
	

}
