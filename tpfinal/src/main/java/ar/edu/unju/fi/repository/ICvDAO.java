package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unju.fi.entity.Cv;


public interface ICvDAO extends CrudRepository<Cv, Long>{
	
	@Query(value= "SELECT * FROM curriculum WHERE curriculum.ciudadano_id = :id", nativeQuery = true)	
	public Optional<Cv> findByIdCiudadano(@Param("id")Long id);
}
