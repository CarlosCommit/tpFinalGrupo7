package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

	@Entity
	@Table(name="curriculum")
	public class Cv implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="cv_id")
		private Long id;
		@Column(name="cv_dni")
	    @Min(value=1,message="no puede ser menor a 1000000")
		private long dni;
		@Column(name="cv_email")
		@NotEmpty
		private String email;
		@Column(name="cv_nombre")
		@NotEmpty
		private String nombre;
		@Column(name="cv_exLaboral")
		@NotEmpty
		private String exLaboral;
		@Column(name="cv_idioma")
		@NotEmpty
		private String idioma;
		@Column(name="cv_fechaNacimiento")
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private LocalDate fechaNacimiento;
		@Column(name="cv_infoComplementaria")
		@NotEmpty
		private String infoComplementaria;
		@Column(name="cv_datAdicional")
		@NotEmpty
		private String datAdicional;
		@Column(name="cv_eduacion")
		@NotEmpty
		private String educacion;
		@OneToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name = "ciudadano_id")
		private Ciudadano ciudadano;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public long getDni() {
			return dni;
		}
		public void setDni(long dni) {
			this.dni = dni;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getExLaboral() {
			return exLaboral;
		}
		public void setExLaboral(String exLaboral) {
			this.exLaboral = exLaboral;
		}
		public String getIdioma() {
			return idioma;
		}
		public void setIdioma(String idioma) {
			this.idioma = idioma;
		}
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}
		public void setFechaNacimiento(LocalDate fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}
		public String getInfoComplementaria() {
			return infoComplementaria;
		}
		public void setInfoComplementaria(String infoComplementaria) {
			this.infoComplementaria = infoComplementaria;
		}
		public String getDatAdicional() {
			return datAdicional;
		}
		public void setDatAdicional(String datAdicional) {
			this.datAdicional = datAdicional;
		}
		public String getEducacion() {
			return educacion;
		}
		public void setEducacion(String educacion) {
			this.educacion = educacion;
		}
		public Ciudadano getCiudadano() {
			return ciudadano;
		}
		public void setCiudadano(Ciudadano ciudadano) {
			this.ciudadano = ciudadano;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		

	}
