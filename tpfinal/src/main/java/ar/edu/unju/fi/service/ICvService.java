package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Cv;


public interface ICvService {

	public Cv BuscarCv(Long id);
	public void GuardarCv(Cv cv);
	public Cv getCv();
	
}
