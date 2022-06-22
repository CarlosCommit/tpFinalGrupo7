package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.repository.IOfertaDAO;
import ar.edu.unju.fi.service.IOfertaService;

public class OfertaServiceimp implements IOfertaService {

	@Autowired
	IOfertaDAO ofertaDaoImp; 
	@Override
	public void guardarOferta(Oferta oferta) {
	
		ofertaDaoImp.save(oferta);
	}

}
