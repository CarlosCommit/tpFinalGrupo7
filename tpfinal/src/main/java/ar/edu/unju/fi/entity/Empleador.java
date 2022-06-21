package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleadores")
public class Empleador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="emp_cuit")
	private int cuit; 
	@Column(name="emp_passw")
	private String passw;
	@Column(name="emp_razon")
	private String razonSocial; 
	@Column(name="emp_nombreComercio")
	private String nombreComercial; 
	@Column(name="emp_inicio")
	private LocalDate inicioActividad; 
	@Column(name="emp_email")
	private String email; 
	@Column(name="emp_telefono")
	private int telefono;//podria ser una tabla
	@Column(name="emp_domicilio")
	private String domicilio;//podria ser una tabla
	@Column(name="emp_provincia")
	private String provincia;//podria convertirse en tabla
	@Column(name="emp_web")
	private String web;
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
