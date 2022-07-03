package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Empleador;
public interface IEmpleadorService {

	public void guardarEmpleador(Empleador empleador);
	public Empleador getEmpleador();
	public Iterable<Empleador> getListaEmpleador();
}
