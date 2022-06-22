package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Ciudadano;

public interface ICiudadanoService {

	public void guardarCiudadano(Ciudadano ciudadano);
	public Ciudadano getCiudadano();
	public Iterable<Ciudadano> getListaCiudadano();
	public void eliminarCiudadano();
	

}
