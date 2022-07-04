package ar.edu.unju.fi.service.imp;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Override
	public Usuario getUsuario() {
	
		return new Usuario();
	}

}
