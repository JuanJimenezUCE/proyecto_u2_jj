package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJdbcService;
import com.uce.edu.demo.estudiante.to.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner{
	
	private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2EcApplication.class);
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("Datos con JPA: "+this.iPersonaJpaService.buscarPorId(3));
	    Persona p = new Persona();
	    p.setId(7);
	    p.setNombre("Jose");
	    p.setApellido("Cayambe");
	    //Guardar
		//this.iPersonaJpaService.guardar(p);
	    Persona p1 = new Persona();
	    p.setId(4);
	    p.setNombre("Andrea");
	    p.setApellido("Solis");
	    //Actualizacion
		//this.iPersonaJpaService.actualizar(p);
	    
		this.iPersonaJpaService.eliminar(3);
	}

}
