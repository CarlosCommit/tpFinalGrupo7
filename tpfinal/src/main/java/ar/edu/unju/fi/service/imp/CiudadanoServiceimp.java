package ar.edu.unju.fi.service.imp;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		ciudadano.getUsuario().setRol("CIUDADANO");
		String passwd = ciudadano.getUsuario().getPassw();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		ciudadano.getUsuario().setPassw(bCryptPasswordEncoder.encode(passwd));
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

	@Override
	public Optional<Ciudadano> buscarId(long id) {
		Optional<Ciudadano> ciudadano = ciudadanoDaoImp.findByCiudadanoId(id);
		return ciudadano;
	}

}