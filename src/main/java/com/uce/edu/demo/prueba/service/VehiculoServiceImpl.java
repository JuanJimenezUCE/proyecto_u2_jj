package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.repository.IVehiculoRepository;
@Service
public class VehiculoServiceImpl implements IVehiculoService{
	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Override
	public void ingresar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.insertar(v);
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.actualizar(v);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscarPorPlaca(placa);
	}

	@Override
	public void borrarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.eliminarPorPlaca(placa);
	}

}
