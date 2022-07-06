package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Oferta;

public interface ICiudadanoService {
	
	public void guardarCiudadano(Ciudadano ciudadano);
	public Ciudadano getCiudadano();
	public Iterable<Ciudadano> getListaCiudadano();
	public void eliminarCiudadano();
	public Optional<Ciudadano> buscarId(long id);
	public List<Oferta> buscarOfertasContratado(long id);

}
