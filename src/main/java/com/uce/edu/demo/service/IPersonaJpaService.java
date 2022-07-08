package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {
	
	
	public List<Persona> buscarPorGenero(String genero);
	public List<Persona> buscarPorApellido(String apellido);
	public List<Persona> buscarPorNombre(String nombre);
	public Persona buscarPorCedula(String cedula);
	public void guardar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(Integer id);
	public Persona buscarPorId(Integer id);
}
