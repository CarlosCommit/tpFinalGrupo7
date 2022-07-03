package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {

	public Optional<Usuario> findByUser(Long userName);
}
