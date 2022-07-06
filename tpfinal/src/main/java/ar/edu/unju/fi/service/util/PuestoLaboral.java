package ar.edu.unju.fi.service.util;

import org.springframework.stereotype.Component;

@Component
public class PuestoLaboral {

	private String puesto;

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
}
