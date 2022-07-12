package com.uce.edu.demo.estudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.repository.IEstudianteJpaRepository;
@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService{
	@Autowired
	private IEstudianteJpaRepository iEstudianteJpaRepository;
	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iEstudianteJpaRepository.eliminar(id);
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorId(id);
	}

	@Override
	public List<Estudiante> buscarPorEdadTyped(String edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorEdadTyped(edad);
	}

	@Override
	public List<Estudiante> buscarPorNombreEdadTyped(String nombre, String edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreEdadTyped(nombre, edad);
	}

	@Override
	public List<Estudiante> buscarPorGeneroNamed(String genero) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorGeneroNamed(genero);
	}

	@Override
	public List<Estudiante> buscarPorEdadNamed(String edad) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorEdadNamed(edad);
	}

	@Override
	public List<Estudiante> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public List<Estudiante> buscarPorApellidoGenero(String apellido, String genero) {
		// TODO Auto-generated method stub
		return this.iEstudianteJpaRepository.buscarPorApellidoGenero(apellido, genero);
	}

	

}
