package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="autor2")
public class Autor2 {

	@Id
	@Column(name="auto_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aut2_id_seq")
	@SequenceGenerator(name = "aut2_id_seq", sequenceName = "aut2_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="auto_nombre")
	private String nombre;
	
	@OneToMany(mappedBy ="autor2")
	private List<Libro2Autor2> libros2autores2;



	@Override
	public String toString() {
		return "Autor2 [id=" + id + ", nombre=" + nombre + ", libros2autores2=" + libros2autores2 + "]";
	}

	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro2Autor2> getLibros2autores2() {
		return libros2autores2;
	}

	public void setLibros2autores2(List<Libro2Autor2> libros2autores2) {
		this.libros2autores2 = libros2autores2;
	}


	
	
}