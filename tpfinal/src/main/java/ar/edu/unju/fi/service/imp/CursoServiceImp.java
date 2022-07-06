package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Curso;
import ar.edu.unju.fi.repository.ICursoDAO;
import ar.edu.unju.fi.repository.IEmpleadorDAO;
import ar.edu.unju.fi.service.ICursoService;
@Service
public class CursoServiceImp implements ICursoService {

	@Autowired
	ICursoDAO cursoDAOimp;
	@Autowired
	IEmpleadorDAO empleadorImp;
	@Override
	public Curso getCurso() {
		
		return new Curso();
	}

	@Override
	public void guardarCurso(Curso curso, String Username) {
		//le mandamos el empleador que encontramos por el (USERNAME DEL QUE ESTA CONECTADO
		curso.setEmpleador(empleadorImp.findByUsuarioId(Long.parseLong(Username)).get());
		//System.out.println(empleadorImp.findByUsuarioId(Long.parseLong(Username)).get().getId());
		curso.setDisponible(true);
		cursoDAOimp.save(curso);

	}

	@Override
	public void eliminarCurso(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<Curso> getListaCurso() {
		
		return cursoDAOimp.findByActive();
	}

	@Override
	public Iterable<Curso> getListaCursoEmpleador(long id) {
		
		return cursoDAOimp.findByActiveAndId(id);
	}

}
