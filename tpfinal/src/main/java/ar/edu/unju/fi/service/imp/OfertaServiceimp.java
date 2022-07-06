package ar.edu.unju.fi.service.imp;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.entity.Provincia;
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
 hacia.setPuestoRequerido(desde.getPuestoRequerido());
 hacia.setBeneficios(desde.getBeneficios());
 hacia.setDatosContacto(desde.getDatosContacto());
 hacia.setJornada(desde.getJornada());
 hacia.setProvincia(desde.getProvincia());
 hacia.setRequisitos(desde.getRequisitos());
 hacia.setResumenPuesto(desde.getResumenPuesto());
 hacia.setSalario(desde.getSalario());
 hacia.setTareas(desde.getTareas());
 hacia.setVacante(desde.getVacante());
 hacia.setEmpleador(desde.getEmpleador());
}
  @Override
  public Oferta encontrar(long id) throws Exception {
	  
	  return ofertaDaoImp.findById(id).orElseThrow(() -> new Exception("La oferta no existe"));
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
	oferta.setVacante(oferta.getVacante()-1);
	oferta.getCiudadanos().add(ciudadano);
	if (oferta.getVacante()==0) {
		oferta.setDisponible(false);
	}
	ofertaDaoImp.save(oferta);
}

public ArrayList<Provincia> getProvincias() {
	 ArrayList<Provincia> provincias = new ArrayList<Provincia>();
			provincias.add(new Provincia("Jujuy"));
			provincias.add(new Provincia("Salta"));
			provincias.add(new Provincia("Tucuman"));
			provincias.add(new Provincia("San Juan"));
			provincias.add(new Provincia("La Rioja"));
			provincias.add(new Provincia("Formosa"));
			provincias.add(new Provincia("Corrientes"));
			provincias.add(new Provincia("Chaco"));
			provincias.add(new Provincia("Chubut"));
			provincias.add(new Provincia("Santiago Del Estero"));
			provincias.add(new Provincia("Buenos Aires"));
			provincias.add(new Provincia("Misiones"));
			provincias.add(new Provincia("Mendoza"));
			provincias.add(new Provincia("Santa Cruz"));
			provincias.add(new Provincia("Entre Rios"));
			provincias.add(new Provincia("Tierra del Fuego"));
			provincias.add(new Provincia("Catamarca"));
			provincias.add(new Provincia("Santa Fe"));
			provincias.add(new Provincia("Rio Negro"));
			provincias.add(new Provincia("La Pampa"));
			provincias.add(new Provincia("Neuquen"));
			provincias.add(new Provincia("Cordoba"));
			provincias.add(new Provincia("San Luis"));
			return provincias;
	}


}

