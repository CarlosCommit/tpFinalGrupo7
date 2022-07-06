package ar.edu.unju.fi.service;

import java.util.Optional;

import ar.edu.unju.fi.entity.Cv;


public interface ICvService {

	public Optional<Cv> BuscarCv(Long id);
	public void GuardarCv(Cv cv,long dni);
	public Cv getCv();
	public void mapear(Cv curriculum,Cv curri);
	public Optional<Cv> BuscarCvDni(Long id);
	
}
