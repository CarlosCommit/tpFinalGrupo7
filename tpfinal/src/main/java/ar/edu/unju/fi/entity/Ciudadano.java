package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ciudadanos")
public class Ciudadano implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ciu_id")
	private Long id;
	@Column(name="ciu_dni")
    @Min(value=1,message="no puede ser menor a 1000000")
	private int dni;
	@Column(name="ciu_email")
	@NotEmpty
	private String email;
	@Column(name="ciu_estado")
	@NotEmpty
	private String estadoCivil;
	@Column(name="ciu_provincia")//podria ser una tabla
	@NotEmpty
	private String provincia;
	@Column(name="ciu_telefono")
	@NotEmpty
	private String telefono;
	@Column(name="ciu_fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@Column(name="ciu_passw")
	@NotEmpty
	private String passw;
	@Column(name="ciu_tramite")
	@NotEmpty
	private String numeroTramite;
	@Column(name="ciu_tipo")
	private String tipo = "ciudadano";
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	
	public Ciudadano()
	{
		
	}
	
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public String getNumeroTramite() {
		return numeroTramite;
	}
	public void setNumeroTramite(String numeroTramite) {
		this.numeroTramite = numeroTramite;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
