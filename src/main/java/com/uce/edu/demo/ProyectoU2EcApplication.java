package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner{
	
	private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2EcApplication.class);
	//@Autowired
	//private IPersonaJdbcService iPersonaJdbcService;

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	
	//@Autowired
	//private IEstudianteJpaService iEstudianteJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//LOG.info("Datos con JPA: "+this.iPersonaJpaService.buscarPorId(4));
	    Persona p = new Persona();
	    //p.setId(9);
	    p.setNombre("Pepito");
	    p.setApellido("Cayambe");
	    //Guardar
		this.iPersonaJpaService.guardar(p);
	    Persona p1 = new Persona();
	    p1.setId(4);
	    p1.setNombre("AndreaA");
	    p1.setApellido("SolisA");
	    //Actualizacion
		//this.iPersonaJpaService.actualizar(p1);

		//this.iPersonaJpaService.eliminar(7);
	}

}
