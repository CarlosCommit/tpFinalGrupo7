package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.IEmpleadorDAO;
import ar.edu.unju.fi.service.IEmpleadorService;
@Service
public class EmpleadorServiceimp implements IEmpleadorService {

	@Autowired
	IEmpleadorDAO empleadorDaoImp;

	@Override
	public void guardarEmpleador(Empleador empleador) {
		//Mandamos el rol de forma directa, porque se sobreentiende que lo que accedan a este metodo estan cargando un perfil empleador
        empleador.getUsuario().setRol("EMPLEADOR");
        //encriptacion de contraseña
        String passw = empleador.getUsuario().getPassw();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		empleador.getUsuario().setPassw(bCryptPasswordEncoder.encode(passw));
		//una vez hecho guardamos el empleador en la base de datos
		empleadorDaoImp.save(empleador);
		
	} 
	@Override
	public Empleador getEmpleador() {
		return new Empleador();
	}
	@Override
	public Iterable<Empleador> getListaEmpleador() {
		
		return empleadorDaoImp.findAll();
	} 
	
}
