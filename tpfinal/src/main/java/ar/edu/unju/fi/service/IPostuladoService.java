package ar.edu.unju.fi.service;

import java.util.Optional;

import ar.edu.unju.fi.entity.Postulante;

public interface IPostuladoService {

	public Postulante getPostulante();
	public void guardarPostulante(Postulante postulante,String username,long id);
   public Iterable<Postulante> buscarIdOferta(long id);	
}
