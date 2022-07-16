package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2EcApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("Criteria API : ");

		Persona perTyped = this.iPersonaJpaService.buscarPorCedulaCriteriaApi("1723029900");


		LOG.info("Persona : " + perTyped);
		
		LOG.info("Dinamica  : ");	
		Persona perDinamica=this.iPersonaJpaService.buscarDinamicamente("Diana", "Mancero", "F");
		LOG.info("Persona Dinamica : " + perDinamica);
		
		LOG.info("Dinamica Predicados : ");	
		Persona perDinamicaP=this.iPersonaJpaService.buscarDinamicamentePredicados("Edison", "Cayambe", "M");
		LOG.info("Persona Dinamica : " + perDinamicaP);
		
	}

}
