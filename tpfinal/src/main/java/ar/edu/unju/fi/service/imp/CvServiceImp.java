package ar.edu.unju.fi.service.imp;

import java.security.Principal;
import java.util.Optional;

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
	public Optional<Cv> BuscarCv(Long id) {
		
		Optional<Cv> curriculum = cvDaoImp.findByIdCiudadano(id);
		return curriculum;
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

	
	public void mapear(Cv curriculum,Cv curri) {
		curri.setDatAdicional(curriculum.getDatAdicional());
		curri.setEducacion(curriculum.getEducacion());
		curri.setDni(curriculum.getDni());
		curri.setFechaNacimiento(curriculum.getFechaNacimiento());
		curri.setEmail(curriculum.getEmail());
		curri.setExLaboral(curriculum.getExLaboral());
		curri.setInfoComplementaria(curriculum.getInfoComplementaria());
		curri.setNombre(curriculum.getNombre());
		
	}

}
