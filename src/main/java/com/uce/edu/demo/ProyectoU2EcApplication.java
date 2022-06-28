package com.uce.edu.demo;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner{
	
	private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2EcApplication.class);
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		Persona persona = new Persona();
		persona.setId(4);
		persona.setNombre("Juan");
		persona.setApellido("Jimenez");
		
		//Insertar
		//this.iPersonaJdbcService.guardar(persona);
		Persona per1 = new Persona();
		per1.setId(1);
		per1.setNombre("A");
		per1.setApellido("B");
		
		//Actualizar
		//this.iPersonaJdbcService.actualizar(per1);
		
		//Eliminar
		//this.iPersonaJdbcService.eliminar(2);
		
        //Buscar
	    LOG.info(this.iPersonaJdbcService.buscar(3).toString());
	}

}
