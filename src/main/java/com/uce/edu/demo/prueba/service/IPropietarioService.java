package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.modelo.Propietario;

public interface IPropietarioService {

	public void ingresar(Propietario p );
	
	public void borrarPorCedula(String cedula );
}
