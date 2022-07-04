package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {

	@Id
	@Column(name="usu_id")
	private long user;
	@Column(name="usu_passw")
	private String passw;
	@Column(name="usu_tipo")
	private String rol;
	

	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

}
