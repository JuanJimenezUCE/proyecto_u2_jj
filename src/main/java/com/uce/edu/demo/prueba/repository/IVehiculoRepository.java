package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	public void insertar(Vehiculo v );
	
	public void actualizar(Vehiculo v);
	
	public Vehiculo buscarPorPlaca(String placa);
	
	
	public int eliminarPorPlaca(String placa);
	
	
}
