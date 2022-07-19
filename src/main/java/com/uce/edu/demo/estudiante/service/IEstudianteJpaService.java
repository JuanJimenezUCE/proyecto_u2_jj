package com.uce.edu.demo.estudiante.service;

import java.util.List;

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.modelo.EstudianteSencillo;

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
	
	//NativeQuery
	public List<Estudiante> buscarPoredadGeneroNative(String edad, String genero);
	public List<Estudiante> buscarPorApellidoEdadNative(String apellido, String edad);
	//NamedNativeQuery
	public List<Estudiante> buscarPorEdadNamedNative(String edad);
	public List<Estudiante> buscarPorApellidoNamedNative(String apellido);
	
	//CriteriaAPIQueri
	
	public Estudiante buscarPorIdGeneroCriteriaApi(String id,String genero);
		
	public List<Estudiante>  buscarDinamicamente(String genero,String apellido,String edad);
	
	//DTO
	public List<EstudianteSencillo> buscarPorNombreSencillo(String nombre);
	public List<EstudianteContadorEdad> consultarCantidadPorEdad(String genero);
	
}
