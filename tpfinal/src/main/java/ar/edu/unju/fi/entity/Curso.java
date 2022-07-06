package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="emp_id")
	private Empleador empleador;
	@ManyToMany(cascade = {CascadeType.ALL},
	           fetch = FetchType.EAGER)
	private List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();	
	
	@Column(name="cur_nombre")
	@NotEmpty
	private String nombre; 
	@Column(name="cur_vacante")
	@NotNull
	private int vacante; 
	@Column(name="cur_categoria")
	@NotEmpty
	private String categoria;
	@Column(name="cur_disponible")
	private boolean disponible;
	@Column(name="cur_detalle")
	@NotEmpty
	private String detalle; 
	@Column(name="cur_duracion")
	@Min(value = 1, message = "*El valor del código debe ser mayor o igual a 1")
	private int duracion;
	@Column(name="cur_precio")
	@NotNull
	private long precio;
	
	public Empleador getEmpleador() {
		return empleador;
	}
	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}
	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}
	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}
	
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
	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}