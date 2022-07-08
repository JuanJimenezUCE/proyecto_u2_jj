package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
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

		//LOG.info("Datos con JPA: "+this.iPersonaJpaService.buscarPorId(4));
	    Persona p = new Persona();
	    //p.setId(9);
	    p.setNombre("Pepitop");
	    p.setApellido("Cayambep");
	    p.setGenero("M");
	    p.setCedula("1723029900");
	    //Guardar
		//this.iPersonaJpaService.guardar(p);
	    Persona p1 = new Persona();
	    p1.setId(4);
	    p1.setNombre("AndreaA");
	    p1.setApellido("SolisA");
	    //Actualizacion
		//this.iPersonaJpaService.actualizar(p1);

		//this.iPersonaJpaService.eliminar(7);
	    //Buscar por cedula
	    Persona per =this.iPersonaJpaService.buscarPorCedula("1723026900");
	    LOG.info("Persona encontrada: "+per);
	    //Buscar por apellido
	    
	    List<Persona> listaPersona =this.iPersonaJpaService.buscarPorApellido("Cayambe");
	    
	    for(Persona item :listaPersona) {
	    	
	    	LOG.info("Persona : "+item);
	    }
	    
	    List<Persona> listaPersona1 =this.iPersonaJpaService.buscarPorGenero("M");
	    
	    for(Persona item :listaPersona1) {
	    	
	    	LOG.info("Persona : "+item);
	    }
	    
	    List<Persona> listaPersona2 =this.iPersonaJpaService.buscarPorNombre("Pepito");
	    
	    for(Persona item :listaPersona2) {
	    	
	    	LOG.info("Persona : "+item);
	    }
	}

}
