package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.modelo.Vehiculo;

public interface IVehiculoService {
	
	public void ingresar(Vehiculo v );

	public void actualizar(Vehiculo v);
	
	public Vehiculo buscarPorPlaca(String placa);
	
	public void borrarPorPlaca(String placa);
}
