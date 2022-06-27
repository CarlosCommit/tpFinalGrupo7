package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Oferta;

public interface IOfertaService {

	public void guardarOferta(Oferta oferta);
	public Oferta getOferta();
	public void eliminarOferta(long id);
	public void editarOferta(Oferta unaOferta) throws Exception;
	 public void mapearOferta(Oferta desde, Oferta hacia);
	 public Oferta encontrar(long id) throws Exception ;
	 public Iterable<Oferta> getListaOferta();
}