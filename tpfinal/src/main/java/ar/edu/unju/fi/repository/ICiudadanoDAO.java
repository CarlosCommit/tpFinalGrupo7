package ar.edu.unju.fi.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Ciudadano;

public interface ICiudadanoDAO extends CrudRepository<Ciudadano, Long>{

	//public Optional<Ciudadano> findByDni(Long dni);
}
