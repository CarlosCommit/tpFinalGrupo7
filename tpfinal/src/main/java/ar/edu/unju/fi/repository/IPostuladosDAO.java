package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unju.fi.entity.Postulante;

public interface IPostuladosDAO extends CrudRepository<Postulante, Long> {

	@Query(value= "SELECT * FROM postulados WHERE postulados.oferta_ofe_id = :id", nativeQuery = true)	
	public Iterable<Postulante> findByIdOferta(@Param("id")Long id);
}
