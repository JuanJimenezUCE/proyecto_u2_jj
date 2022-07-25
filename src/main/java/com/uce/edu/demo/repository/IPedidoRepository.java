package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Pedido;

public interface IPedidoRepository {

	public void insertar(Pedido pedido);
	public Pedido buscarPorId(Integer id);
	public void actualizar(Pedido pedido);
	public void eliminar (Integer id);
}
