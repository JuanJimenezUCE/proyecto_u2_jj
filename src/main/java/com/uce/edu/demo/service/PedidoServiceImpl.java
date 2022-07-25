package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPedidoRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Pedido;
@Service
public class PedidoServiceImpl implements IPedidoService{
	@Autowired
	private IPedidoRepository iPedidoRepository;
	@Override
	public void insertar(Pedido pedido) {
		// TODO Auto-generated method stub
		this.iPedidoRepository.insertar(pedido);
	}

	@Override
	public Pedido buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iPedidoRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Pedido pedido) {
		// TODO Auto-generated method stub
		this.iPedidoRepository.actualizar(pedido);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPedidoRepository.eliminar(id);
	}

}
