package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Cliente;
import com.uce.edu.demo.repository.modelo.onetomany.Pedido;
import com.uce.edu.demo.service.IClienteService;
import com.uce.edu.demo.service.IPedidoService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2EcApplication.class);

	@Autowired
	private IClienteService iClienteService;

	@Autowired
	private IPedidoService iPedidoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Tito");
		cliente1.setApellido("Hernandez");
		this.iClienteService.insertar(cliente1);

		Cliente cliente = new Cliente();
		cliente.setId(1);

		Pedido pedido1 = new Pedido();
		pedido1.setNumero("12");
		pedido1.setFecha(LocalDateTime.now());
		pedido1.setCosto("3.50");
		pedido1.setCliente(cliente);
		// this.iPedidoService.insertar(pedido1);

		// Buscar
		this.iClienteService.buscarPorId(2);
		// Actualizar
		Cliente cliente2 = new Cliente();
		cliente2.setId(1);
		cliente2.setApellido("Ortiz");
		cliente2.setNombre("Gillermo");
	
		this.iClienteService.actualizar(cliente2);
		// Eliminar
		this.iClienteService.eliminar(5);

	}

}
