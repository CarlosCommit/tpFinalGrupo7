package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.repository.ICursoDAO;
import ar.edu.unju.fi.service.ICursoService;
@Service
public class CursoServiceImp implements ICursoService {

	@Autowired
	ICursoDAO cursoDAOimp;
	@Override
	public Curso getCurso() {
		
		return new Curso();
	}

	@Override
	public void guardarCurso(Curso curso) {
		cursoDAOimp.save(curso);

	}

	@Override
	public void eliminarCurso(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<Curso> getListaCurso() {
		
		return cursoDAOimp.findAll();
	}

}
