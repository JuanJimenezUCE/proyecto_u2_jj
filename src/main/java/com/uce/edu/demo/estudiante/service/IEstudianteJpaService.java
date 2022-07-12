package com.uce.edu.demo.estudiante.service;

import java.util.List;

import com.uce.edu.demo.estudiante.modelo.Estudiante;

public interface IEstudianteJpaService {

	public void guardar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void eliminar(Integer id);
	public Estudiante buscarPorId(Integer id);
	
	//Typed
	public List<Estudiante> buscarPorEdadTyped(String edad);
	public List<Estudiante> buscarPorNombreEdadTyped(String nombre, String edad);
	//Named
	public List<Estudiante> buscarPorGeneroNamed(String genero);	
	public List<Estudiante> buscarPorEdadNamed(String edad);
	
	//Typed y Named
	
	public List<Estudiante> buscarPorNombreApellido(String nombre, String apellido);
	public List<Estudiante> buscarPorApellidoGenero(String apellido, String genero);
}
