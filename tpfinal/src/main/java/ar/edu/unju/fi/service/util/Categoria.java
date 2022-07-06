package ar.edu.unju.fi.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Categoria {

	private List<String> lista = new ArrayList<>();

	public Categoria()
	{
		lista.add("Idiomas");
		lista.add("Tecnologia");
		lista.add("Arte");
		lista.add("Economia");
		lista.add("Programacion");
		lista.add("Otros");
	}
	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}
	
	
}
