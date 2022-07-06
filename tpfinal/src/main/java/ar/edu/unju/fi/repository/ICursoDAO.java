package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unju.fi.entity.Curso;


public interface ICursoDAO extends CrudRepository<Curso, Long>{
	@Query(value= "SELECT * FROM cursos WHERE cursos.cur_disponible = true AND cursos.emp_id = :id", nativeQuery = true)	
	public Iterable<Curso> findByActiveAndId (@Param("id")long id );
	@Query(value= "SELECT * FROM cursos WHERE cursos.cur_disponible = true", nativeQuery = true)	
	public Iterable<Curso> findByActive();
	
	
}
