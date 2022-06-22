package ar.edu.unju.fi.service.imp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.repository.ICiudadanoDAO;
import ar.edu.unju.fi.service.ICiudadanoService;
@Service
public class CiudadanoServiceimp implements ICiudadanoService {
	
	@Autowired
	ICiudadanoDAO ciudadanoDaoImp;

	@Override
	public void guardarCiudadano(Ciudadano ciudadano) {
		ciudadanoDaoImp.save(ciudadano);

	}

	@Override
	public Ciudadano getCiudadano() {
		return new Ciudadano();
	}

	@Override
	public Iterable<Ciudadano> getListaCiudadano() {
		return ciudadanoDaoImp.findAll();
	}

	@Override
	public void eliminarCiudadano() {
		// TODO Auto-generated method stub
		
	}

}