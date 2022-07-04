package ar.edu.unju.fi.service;


import java.util.Optional;

import ar.edu.unju.fi.entity.Oferta;

public interface IOfertaService {

	public void guardarOferta(Oferta oferta,String username);
	public Oferta getOferta();
	public void eliminarOferta(long id);
	public void editarOferta(Oferta unaOferta) throws Exception;
	 public void mapearOferta(Oferta desde, Oferta hacia);
	 public Oferta encontrar(long id) throws Exception ;
	 public Iterable<Oferta> getListaOferta();
	 public Optional<Oferta> buscarOferta(long id);
	 public Iterable<Oferta> getListaOfertaEmpleador(long id);
	 
	 public Iterable<Oferta> getListaFiltroProvincia(String provincia);
	 
}