package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="empleadores")
public class Empleador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="emp_cuit")
	@NotNull @Min(value=1,message="no puede ser menor a 1000000")
	private int cuit; 
	@Column(name="emp_passw")
	@NotEmpty
	private String passw;
	@Column(name="emp_razon")
	@NotEmpty
	private String razonSocial; 
	@Column(name="emp_nombreComercio")
	@NotEmpty
	private String nombreComercial; 
	@Column(name="emp_inicio")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate inicioActividad; 
	@Column(name="emp_email")
	@NotEmpty
	private String email; 
	@Column(name="emp_telefono")
	@NotNull
	private int telefono;//podria ser una tabla
	@Column(name="emp_domicilio")
	@NotEmpty
	private String domicilio;//podria ser una tabla
	@Column(name="emp_provincia")
	@NotEmpty
	private String provincia;//podria convertirse en tabla
	@Column(name="emp_web")
	@NotEmpty
	private String web;
	@NotEmpty
	@Column(name="emp_descripcion")
	private String descripcion;
	
	public Empleador()
	{
		
	}
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public LocalDate getInicioActividad() {
		return inicioActividad;
	}
	public void setInicioActividad(LocalDate inicioActividad) {
		this.inicioActividad = inicioActividad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
