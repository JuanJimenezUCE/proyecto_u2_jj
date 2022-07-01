package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner{
	
	private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2EcApplication.class);
	
	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		LOG.info("Datos con JPA: "+this.iEstudianteJpaService.buscarPorId(4));
		
		Estudiante e= new Estudiante();
		e.setId(2);
		e.setNombre("Juan");
		e.setApellido("Valasquez");
		e.setEdad("26");
		e.setGenero("M");
		//Guardar
		this.iEstudianteJpaService.guardar(e);
		Estudiante e1= new Estudiante();
		e1.setId(1);
		e1.setNombre("Juan");
		e1.setApellido("Jimenez");
		e1.setEdad("25");
		e1.setGenero("M");
		//Actualizacion
	    this.iEstudianteJpaService.actualizar(e);
	    
	    //Eliminar
	    this.iEstudianteJpaService.eliminar(4);
	
	}

}
