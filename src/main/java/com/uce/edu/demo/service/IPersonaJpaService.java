package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

public interface IPersonaJpaService {
	
	public List<Persona> buscarPorNombre(String nombre);
	public List<Persona> buscarPorGenero(String genero);
	public List<Persona> buscarPorApellido(String apellido);
	
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido);
	
	public List<Persona> buscarPorNombreApellido(String nombre,String apellido);
	
	
	public Persona buscarPorCedula(String cedula);
	
	public Persona buscarPorCedulaTyped(String cedula);
	
	public Persona buscarPorCedulaTypedNamed(String cedula);

	public Persona buscarPorCedulaNamed(String cedula);
	
	public Persona buscarPorCedulaNative(String cedula);
	
	public Persona buscarPorCedulaNamedNative(String cedula);
	
	public Persona buscarPorCedulaCriteriaApi(String cedula);
	
	public Persona buscarDinamicamente(String nombre,String apellido,String genero);
	public Persona buscarDinamicamentePredicados(String nombre,String apellido,String genero);

	public void guardar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(Integer id);
	public Persona buscarPorId(Integer id);
	
	public int actualizarPorApellido(String genero,String apellido);
	public int eliminarPorGenero(String genero);
	
	public List<PersonaContadorGenero> consultarCantidadPorGenero();
}
