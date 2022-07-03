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
	private int user;
	@Column(name="usu_passw")
	private String passw;
	@Column(name="usu_tipo")
	private int rol;
	
	public int getUserName() {
		return user;
	}
	public void setUserName(int userName) {
		this.user = userName;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	
}
