package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Pedido;

public interface IPedidoService {

	public void insertar(Pedido pedido);
	public Pedido buscarPorId(Integer id);
	public void actualizar(Pedido pedido);
	public void eliminar (Integer id);
}
