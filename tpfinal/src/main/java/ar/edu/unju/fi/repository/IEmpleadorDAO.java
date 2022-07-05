package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unju.fi.entity.Empleador;




public interface IEmpleadorDAO extends CrudRepository<Empleador, Long> {
@Query(value= "SELECT * FROM empleadores WHERE empleadores.usuario_id = :id", nativeQuery = true)	
public Optional<Empleador> findByUsuarioId(@Param("id")Long id);
}
