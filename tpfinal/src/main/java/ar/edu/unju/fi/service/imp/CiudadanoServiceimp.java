package ar.edu.unju.fi.service.imp;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.repository.ICiudadanoDAO;
import ar.edu.unju.fi.repository.IOfertaDAO;
import ar.edu.unju.fi.service.ICiudadanoService;
@Service
public class CiudadanoServiceimp implements ICiudadanoService {
	
	@Autowired
	ICiudadanoDAO ciudadanoDaoImp;
	@Autowired
	IOfertaDAO ofertaDaoImp;

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

	@Override
	public List<Oferta> buscarOfertasContratado(long id) {
		//Obtener el objeto Ciudadano del ciudadano conectado
				Ciudadano ciudadano = ciudadanoDaoImp.findByCiudadanoId(id).get();
				//encontrar la lista de ofertas, pueden no estar activas pero igualmente contrato al ciudadano conectado
				Iterable<Oferta> listaOferta = ofertaDaoImp.findAll();
				//aqui guardamos las ofertas donde el ciudadano se encuenta
				List<Oferta> ofertas = new ArrayList<>();
				
				//filtrar de esas ofertas activas en cuales el ciudadano conectado fue contratado
				for(Oferta oferta: listaOferta)
				{
					if(oferta.getCiudadanos().contains(ciudadano))
					{
						ofertas.add(oferta);
						
					}
				}
				
				return ofertas;
	}

}