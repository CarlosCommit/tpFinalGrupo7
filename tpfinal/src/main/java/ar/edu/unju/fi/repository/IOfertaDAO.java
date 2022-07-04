package ar.edu.unju.fi.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unju.fi.entity.Oferta;

public interface IOfertaDAO extends CrudRepository<Oferta, Long> {

	@Query(value= "SELECT * FROM ofertas WHERE ofertas.ofe_disponible = true", nativeQuery = true)	
	public Iterable<Oferta> findByActive();
	
	@Query(value= "SELECT * FROM ofertas WHERE ofertas.ofe_disponible = true AND ofertas.emp_id = :id", nativeQuery = true)	
	public Iterable<Oferta> findByActiveAndId (@Param("id")long id );
	
	@Query(value= "SELECT * FROM ofertas WHERE ofertas.ofe_disponible = true AND ofertas.ofe_provincia= :q", nativeQuery = true)	
	public Iterable<Oferta> findByProvincia (@Param("q")String q );
	
}
