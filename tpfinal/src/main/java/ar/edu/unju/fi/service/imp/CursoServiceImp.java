package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ciudadano;
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
	public void eliminarCurso(long id) {
	
		Optional<Curso> curso = cursoDAOimp.findById(id);
		curso.get().setDisponible(false);
		cursoDAOimp.save(curso.get());

	}

	@Override
	public Iterable<Curso> getListaCurso() {
		
		return cursoDAOimp.findByActive();
	}

	@Override
	public Iterable<Curso> getListaCursoEmpleador(long id) {
		
		return cursoDAOimp.findByActiveAndId(id);
	}

	@Override
	public Iterable<Curso> getListaCategoria(String categoria) {
		Iterable<Curso> cursos = cursoDAOimp.findByCategoria(categoria);
		return cursos;
	}
	@Override
	public void agregarCiudadanoInscripto(Curso curso, Ciudadano ciudadano) {
	
		curso.setVacante(curso.getVacante()-1);
		curso.getCiudadanos().add(ciudadano);
		if(curso.getVacante()==0)
		{
			curso.setDisponible(false);
		}
		
		cursoDAOimp.save(curso);
		
	}
	@Override
	public Optional<Curso> buscarCurso(long id)
	{
		Optional<Curso> curso = cursoDAOimp.findById(id);
		return curso;
	}


}
