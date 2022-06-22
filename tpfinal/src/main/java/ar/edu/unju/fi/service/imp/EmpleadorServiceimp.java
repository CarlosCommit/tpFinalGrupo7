package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.entity.Empleador;
import ar.edu.unju.fi.repository.IEmpleadorDAO;
import ar.edu.unju.fi.service.IEmpleadorService;

public class EmpleadorServiceimp implements IEmpleadorService {

	@Autowired
	IEmpleadorDAO empleadorDaoImp;

	@Override
	public void guardarEmpleador(Empleador empleador) {
	
		empleadorDaoImp.save(empleador);
		
	} 
	
}
