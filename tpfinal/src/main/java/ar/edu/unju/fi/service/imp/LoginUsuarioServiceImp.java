package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioDAO;

@Service
public class LoginUsuarioServiceImp implements UserDetailsService {

	@Autowired
	private IUsuarioDAO iUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuarioEncontrado = iUsuario.findByUser(Long.parseLong(username)).orElseThrow(()-> new UsernameNotFoundException("Usuario no existe en la BD"));
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(String.valueOf(usuarioEncontrado.getRol())); 
	    tipos.add(grantedAuthority);
	    
	    UserDetails user = (UserDetails) new User(username, usuarioEncontrado.getPassw(),tipos);
	    
	    return user;
		
	}

}
