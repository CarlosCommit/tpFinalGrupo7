package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Curso;

public interface ICursoService {

	
	public Curso getCurso();
	public void guardarCurso(Curso curso, String Username);
	public void eliminarCurso(int id);
	public Iterable<Curso> getListaCurso();
	public Iterable<Curso> getListaCursoEmpleador(long id);
	
	
	
}
