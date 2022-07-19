package com.uce.edu.demo.estudiante.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String edad;
	
	public EstudianteSencillo() {
	
	}
	public EstudianteSencillo(String nombre, String edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	//GET Y SET
	@Override
	public String toString() {
		return "EstudianteSencillo [nombre=" + nombre + ", edad=" + edad + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	
	
	
}
