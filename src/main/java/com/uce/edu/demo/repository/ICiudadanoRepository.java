package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

public interface ICiudadanoRepository {

	public void insertar(Ciudadano ciudadano);
	public Ciudadano buscarPorId(Integer id);
	public void actualizar(Ciudadano ciudadano);
	public void eliminar (Integer id);
}
