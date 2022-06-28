package com.uce.edu.demo.estudiante.repository;

import com.uce.edu.demo.estudiante.to.Estudiante;

public interface IEstudianteJdbcRepository {

	public Estudiante buscarPorId(int id);
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void eliminar (int id);
}
