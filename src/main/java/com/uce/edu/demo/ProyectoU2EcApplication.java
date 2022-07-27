package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2EcApplication.class);

	@Autowired
	private IFacturaService iFacturaService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Factura fact=this.iFacturaService.consultar(1);
		
		LOG.info("Numero: "+fact.getNumero());
		LOG.info("Fecha: "+fact.getFecha());
		LOG.info("Cliente: "+fact.getCliente().getNumeroTarjeta());
		
		List<DetalleFactura> detalles=fact.getDetalles();
		for(DetalleFactura deta :detalles) {
			LOG.info("Detalle: "+deta);
			
		}
		
	}

}
