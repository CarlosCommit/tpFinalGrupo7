package ar.edu.unju.fi.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unju.fi.entity.Ciudadano;


public interface ICiudadanoDAO extends CrudRepository<Ciudadano, Long>{

	@Query(value= "SELECT * FROM ciudadanos WHERE ciudadanos.usuario_id = :id", nativeQuery = true)	
	public Optional<Ciudadano> findByCiudadanoId(@Param("id")Long id);
}
