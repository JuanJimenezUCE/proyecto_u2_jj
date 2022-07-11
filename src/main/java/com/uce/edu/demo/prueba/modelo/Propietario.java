package com.uce.edu.demo.prueba.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="propietario")
public class Propietario {
	
	@Id
	@Column(name= "prop_cedula")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_generator")
	//@SequenceGenerator(name = "name_generator",sequenceName = "prop_id_seq", allocationSize = 1)
	private String cedula;
	@Column(name= "prop_nombre")
	private String nombre;
	@Column(name= "prop_apellido")
	private String apellido;
	@Column(name= "prop_fecha")
	private LocalDateTime fecha;
	@Override
	public String toString() {
		return "Propietario [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", fecha=" + fecha
				+ "]";
	}
	
	//SET Y GET
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
}


