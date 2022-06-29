package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Curso;

public interface ICursoService {

	
	public Curso getCurso();
	public void guardarCurso(Curso curso);
	public void eliminarCurso(int id);
	public Iterable<Curso> getListaCurso();
	
	
	
}
