package ar.edu.unju.fi.service;

import java.util.Optional;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Curso;

public interface ICursoService {

	
	public Curso getCurso();
	public void guardarCurso(Curso curso, String Username);
	public void eliminarCurso(long id);
	public Iterable<Curso> getListaCurso();
	public Iterable<Curso> getListaCursoEmpleador(long id);
	public Iterable<Curso> getListaCategoria(String categoria);
	public void agregarCiudadanoInscripto(Curso curso,Ciudadano ciudadano);
	public Optional<Curso> buscarCurso(long id);
	public void modificar(Curso curso);
	
	
	
	
}
