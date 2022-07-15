package com.uce.edu.demo.estudiante.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="estudiante")

@NamedQuery(name = "Estudiante.buscarPorGeneroNamed",
query="SELECT e FROM Estudiante e WHERE e.genero = :genero")

@NamedQuery(name = "Estudiante.buscarPorEdadNamed",
query="SELECT e FROM Estudiante e WHERE e.edad = :edad ")

@NamedQuery(name = "Estudiante.buscarPorNombreApellido",
query="SELECT e FROM Estudiante e WHERE e.nombre = :nombre AND e.apellido = :apellido ")

@NamedQuery(name = "Estudiante.buscarPorApellidoGenero",
query="SELECT e FROM Estudiante e WHERE e.apellido = :apellido AND e.genero = :genero ")

@NamedNativeQuery(name="Estudiante.buscarPorEdadNative",query="SELECT * FROM estudiante WHERE estu_edad = :edad",resultClass =Estudiante.class)

@NamedNativeQuery(name="Estudiante.buscarPorApellidoNative",query="SELECT * FROM estudiante WHERE estu_apellido = :apellido",resultClass =Estudiante.class)
public class Estudiante {
	@Id
	@Column(name= "estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator1")
	@SequenceGenerator(name = "name_generator1", sequenceName = "estu_id_seq", allocationSize = 1)
	private Integer id;
	@Column(name= "estu_nombre")
	private String nombre;
	@Column(name= "estu_apellido")
	private String apellido;
	@Column(name= "estu_edad")
	private String edad;
	@Column(name= "estu_genero")
	private String genero;
	
	
	
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero="
				+ genero + "]";
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
