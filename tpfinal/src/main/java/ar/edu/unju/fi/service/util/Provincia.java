package ar.edu.unju.fi.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class Provincia {

	private List<String> provincias = new ArrayList<String>();

	public Provincia()
	{
		provincias.add("Jujuy");
		provincias.add("Salta");
		provincias.add("Tucuman");
		provincias.add("San Juan");
		provincias.add("La Rioja");
		provincias.add("Formosa");
		provincias.add("Corrientes");
		provincias.add("Chaco");
		provincias.add("Chubut");
		provincias.add("Santiago Del Estero");
		provincias.add("Buenos Aires");
		provincias.add("Misiones");
		provincias.add("Mendoza");
		provincias.add("Santa Cruz");
		provincias.add("Entre Rios");
		provincias.add("Tierra del Fuego");
		provincias.add("Catamarca");
		provincias.add("Santa Fe");
		provincias.add("Rio Negro");
		provincias.add("La Pampa");
		provincias.add("Neuquen");
		provincias.add("Cordoba");
		provincias.add("San Luis");	
	}
	public List<String> getLista() {
		return provincias;
	}

	public void setLista(List<String> lista) {
		this.provincias = lista;
	}
	
	
}
