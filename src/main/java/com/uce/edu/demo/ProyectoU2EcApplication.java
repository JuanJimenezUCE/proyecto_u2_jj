package com.uce.edu.demo;

import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner{

	private static Logger LOG =Logger.getLogger(ProyectoU2EcApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		LOG.info("Hola mundo");
	}

}
