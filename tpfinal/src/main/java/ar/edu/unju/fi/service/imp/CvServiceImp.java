package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Cv;
import ar.edu.unju.fi.repository.ICvDAO;
import ar.edu.unju.fi.service.ICvService;
@Service
public class CvServiceImp implements ICvService {

	@Autowired
	ICvDAO cvDaoImp;
	
	@Override
	public Cv BuscarCv(Long id) {
		
		return cvDaoImp.findById(id).get();
	}

	@Override
	public void GuardarCv(Cv cv) {
		cvDaoImp.save(cv);

	}

	@Override
	public Cv getCv() {
		// TODO Auto-generated method stub
		return new Cv();
	}



}
