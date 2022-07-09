package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner{
	
	private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2EcApplication.class);


	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//Actualizar con JPQL
		//int resultado =this.iPersonaJpaService.actualizarPorApellido("FE", "Cayambe");
		//LOG.info("Cantidad de registros actualizados : "+resultado);
		
		int resultado2=this.iPersonaJpaService.eliminarPorGenero("M");
		LOG.info("Cantidad de eliminados : "+resultado2);
	}

}
