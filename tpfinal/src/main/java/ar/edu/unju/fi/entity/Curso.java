package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="cursos")
public class Curso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;                                            
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cur_id")
	private Long id;
	
	@Column(name="cur_nombre")
	@NotEmpty
	private String nombre; 
	@Column(name="cur_vacante")
	private int vacante; 
	@Column(name="cur_detalle")
	@NotEmpty
	private String detalle; 
	@Column(name="cur_duracion")
	@NotNull
	private int duracion;
	@Column(name="cur_precio")
	private String precio;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVacante() {
		return vacante;
	}
	public void setVacante(int vacante) {
		this.vacante = vacante;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}