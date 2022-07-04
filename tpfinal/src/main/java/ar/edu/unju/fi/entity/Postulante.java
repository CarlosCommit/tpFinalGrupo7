package ar.edu.unju.fi.entity;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="postulados")
public class Postulante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pos_id")
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL,
	           fetch = FetchType.EAGER)
	private Oferta oferta;
	
	@ManyToOne(cascade = CascadeType.ALL,
	           fetch = FetchType.EAGER)
	private Ciudadano ciudadano;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	public void setCiudadano(Ciudadano ciudadano2) {
		this.ciudadano = ciudadano2;
	}

}
