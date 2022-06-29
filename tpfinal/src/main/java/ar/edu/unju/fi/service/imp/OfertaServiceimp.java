package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.repository.IOfertaDAO;
import ar.edu.unju.fi.service.IOfertaService;
@Service
public class OfertaServiceimp implements IOfertaService {

	@Autowired
	IOfertaDAO ofertaDaoImp; 
	@Override
	public void guardarOferta(Oferta oferta) {
	
		ofertaDaoImp.save(oferta);
	}
	@Override
	public Oferta getOferta() {
		return new Oferta();
	}
	@Override
	public void eliminarOferta(long id) {
		ofertaDaoImp.deleteById(id);
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
	return ofertaDaoImp.findAll();
}

}
