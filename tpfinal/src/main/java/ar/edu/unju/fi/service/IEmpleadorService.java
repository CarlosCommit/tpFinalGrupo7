package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Postulante;

public interface IEmpleadorService {

	public void guardarEmpleador(Empleador empleador);
	public Empleador getEmpleador();
	public Iterable<Empleador> getListaEmpleador();
	public Optional<Empleador> buscarEmpleador(long id);
	public long getId(long id);
	public List<Postulante> getListaPostulante(long id);
	public List<Postulante> getListaPostulanteProvincia(long id,String provincia);
}
