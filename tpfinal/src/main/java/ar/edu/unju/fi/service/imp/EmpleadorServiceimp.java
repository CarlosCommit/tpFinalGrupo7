package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.entity.Oferta;
import ar.edu.unju.fi.entity.Postulante;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IEmpleadorDAO;
import ar.edu.unju.fi.repository.IOfertaDAO;
import ar.edu.unju.fi.repository.IPostuladosDAO;
import ar.edu.unju.fi.service.IEmpleadorService;
@Service
public class EmpleadorServiceimp implements IEmpleadorService {

	@Autowired
	IEmpleadorDAO empleadorDaoImp;
	@Autowired
	IOfertaDAO ofertaDaoImp;
	@Autowired
	IPostuladosDAO postuladoDaoImp;

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
	@Override
	public Optional<Empleador> buscarEmpleador(long id) {
		// TODO Auto-generated method stub
		Optional<Empleador> empleador = empleadorDaoImp.findByUsuarioId(id);
		return  empleador;
		//return null;
	}
	@Override
	public long getId(long id) {
		Optional<Empleador> empleador = empleadorDaoImp.findByUsuarioId(id);
		return empleador.get().getId();
	} 
	@Override
	public List<Postulante> getListaPostulante(long id) {
	
		Iterable<Oferta> listaOferta = ofertaDaoImp.findByActiveAndId(id);
		List<Postulante> listaPostulantes = new ArrayList<Postulante>();
		
		//Iterable<Postulante> listaPostulantes = postuladoDaoImp.findByIdOferta(Long.parseLong("1"));
		
		for (Oferta oferta: listaOferta)
		{
			listaPostulantes.addAll(postuladoDaoImp.findByIdOferta(oferta.getId()));
			
		}
		
		/*for(Oferta oferta: listaOferta)
		{
			if(postuladoDaoImp.findByIdOferta(oferta.getId()).isPresent())
			{
			System.out.println(postuladoDaoImp.findByIdOferta(oferta.getId()).get().getId());
				listaPostulantes.add(postuladoDaoImp.findByIdOferta(oferta.getId()).get());
			}else
				
			{
				System.out.println("error");
			}
			//System.out.println(oferta.getPuestoRequerido());
		}*/
		
		return listaPostulantes;
		
	
	} 
	
	
	
}
