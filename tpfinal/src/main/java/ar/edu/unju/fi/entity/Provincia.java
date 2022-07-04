package ar.edu.unju.fi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="provincias")
public class Provincia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pro_id")
	private Long id;
	@Column(name="pro_nombre")
	private String nombre;
	
}
