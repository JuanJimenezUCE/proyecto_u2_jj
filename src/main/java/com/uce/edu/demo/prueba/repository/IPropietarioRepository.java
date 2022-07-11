package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.Propietario;

public interface IPropietarioRepository {

	public void crear(Propietario p );
	
	public int eliminarPorCedula(String cedula );
	
	public Propietario consultarPorCedula(String cedula);
}
