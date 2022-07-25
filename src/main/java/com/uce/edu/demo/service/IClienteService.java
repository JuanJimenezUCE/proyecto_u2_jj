package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Cliente;

public interface IClienteService {

	public void insertar(Cliente cliente);
	public Cliente buscarPorId(Integer id);
	public void actualizar(Cliente cliente);
	public void eliminar (Integer id);
}
