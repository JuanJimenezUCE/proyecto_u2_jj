package com.uce.edu.demo;

import java.util.List;

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
	//private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Estudiante e = new Estudiante();
	 
	    e.setNombre("Domenica");
	    e.setApellido("Lopez");
	    e.setGenero("F");
	    e.setEdad("31");
	    //Guardar
		//this.iEstudianteJpaService.guardar(e);

	    //1 TypedQuery
	    LOG.info("TypedQuery : ");
	    List<Estudiante> listaEstTyped = this.iEstudianteJpaService.buscarPorEdadTyped("26");
	    for(Estudiante item: listaEstTyped) {
		    LOG.info("Estudiante : "+item);
	    }

	    List<Estudiante> listaEstTyped2 = this.iEstudianteJpaService.buscarPorNombreEdadTyped("Juan", "26");
	    for(Estudiante item: listaEstTyped2) {
		    LOG.info("Estudiante : "+item);
	    }
	    
	    //2 NamedQuery
	    LOG.info("NamedQuery : ");
	    List<Estudiante> listaEstNamed = this.iEstudianteJpaService.buscarPorGeneroNamed("F");
	    for(Estudiante item: listaEstNamed) {
		    LOG.info("Estudiante : "+item);
	    }
	    
	    List<Estudiante> listaEstNamed2 = this.iEstudianteJpaService.buscarPorEdadNamed("31");
	    for(Estudiante item: listaEstNamed2) {
		    LOG.info("Estudiante : "+item);
	    }
	    
	    
	    //3 TypedQuery y NamedQuery
	    LOG.info("TypedQuery y NamedQuery: ");
	    List<Estudiante> listaEstudiante = this.iEstudianteJpaService.buscarPorNombreApellido("Luis", "Jimenez");
	    for(Estudiante item: listaEstudiante) {
		    LOG.info("Estudiante : "+item);
	    }
		 
	    List<Estudiante> listaEstudiante2 = this.iEstudianteJpaService.buscarPorApellidoGenero("Jimenez", "M");
	    for(Estudiante item: listaEstudiante2) {
		    LOG.info("Estudiante : "+item);
	    }
	}

}
