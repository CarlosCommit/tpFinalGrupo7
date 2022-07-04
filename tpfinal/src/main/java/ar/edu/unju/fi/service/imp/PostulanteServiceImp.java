package ar.edu.unju.fi.service.imp;

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

}
