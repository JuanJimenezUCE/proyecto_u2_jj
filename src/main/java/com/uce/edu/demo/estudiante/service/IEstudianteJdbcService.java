package com.uce.edu.demo.estudiante.service;

import com.uce.edu.demo.estudiante.to.Estudiante;

public interface IEstudianteJdbcService {
	public void guardar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void eliminar(int id);
	public Estudiante buscar(int id);
}
