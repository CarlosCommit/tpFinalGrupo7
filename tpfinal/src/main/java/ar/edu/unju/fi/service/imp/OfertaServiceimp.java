package ar.edu.unju.fi.service.imp;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.entity.Postulante;
import ar.edu.unju.fi.repository.IEmpleadorDAO;
import ar.edu.unju.fi.repository.IOfertaDAO;
import ar.edu.unju.fi.repository.IPostuladosDAO;
import ar.edu.unju.fi.service.IOfertaService;
@Service
public class OfertaServiceimp implements IOfertaService {

	@Autowired
	IOfertaDAO ofertaDaoImp; 
	@Autowired
	IEmpleadorDAO empleadorImp;
	@Autowired
	IPostuladosDAO postuladoImp;
	@Override
	public void guardarOferta(Oferta oferta,String username) {
	
		oferta.setEmpleador(empleadorImp.findByUsuarioId(Long.parseLong(username) ).get());
		oferta.setDisponible(true);
		ofertaDaoImp.save(oferta);
	}
	@Override
	public Oferta getOferta() {
		return new Oferta();
	}
	@Override
	public void eliminarOferta(long id) {
		Optional<Oferta> oferta = ofertaDaoImp.findById(id);
		oferta.get().setDisponible(false);
		ofertaDaoImp.save(oferta.get());
	}
	@Override
	public void editarOferta(Oferta unaOferta) throws Exception{
		Oferta oferta = encontrar(unaOferta.getId());
		mapearOferta(unaOferta, oferta);
	    ofertaDaoImp.save(oferta);
	}
	
  @Override
   public void mapearOferta(Oferta desde, Oferta hacia)
{
 
}
  @Override
  public Oferta encontrar(long id) throws Exception {
	  
	  return ofertaDaoImp.findById(id).orElseThrow(() -> new Exception("El usuario no existe"));
  }
  
@Override
public Iterable<Oferta> getListaOferta() {
	
	 return ofertaDaoImp.findByActive();
	 
}
@Override
public Optional<Oferta> buscarOferta(long id) {
Optional<Oferta> oferta = ofertaDaoImp.findById(id);
	return oferta;
}
@Override
public Iterable<Oferta> getListaOfertaEmpleador(long id) {
	return ofertaDaoImp.findByActiveAndId(id);
}
@Override
public Iterable<Oferta> getListaFiltroProvincia(String provincia) {
	
	return ofertaDaoImp.findByProvincia(provincia);
}
@Override
public void agregarCiudadanoContratado(Oferta oferta, Ciudadano ciudadano) {
	List<Ciudadano> ciudadano2 = oferta.getCiudadanos();
	ciudadano2.add(ciudadano);
	oferta.setCiudadanos(ciudadano2);
	oferta.setVacante(oferta.getVacante()-1);
	ofertaDaoImp.save(oferta);
	
}




}

