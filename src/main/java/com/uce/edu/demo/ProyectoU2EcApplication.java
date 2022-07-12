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

	//private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Persona p = new Persona();
	 
	    p.setNombre("Daniel");
	    p.setApellido("Velez");
	    p.setGenero("M");
	    p.setCedula("1785965842");
	    //Guardar
		//this.iPersonaJpaService.guardar(p);

	    //1 TypedQuery
	    Persona perTyped =this.iPersonaJpaService.buscarPorCedulaTyped("175685256");
	    LOG.info("Persona Typed: "+perTyped);
	    //2 NamedQuery
	    Persona perNamed =this.iPersonaJpaService.buscarPorCedulaNamed("175685256");
	    LOG.info("Persona Named: "+perNamed);
	    //3 TypedQuery y NamedQuery
	    Persona perTypedNamed =this.iPersonaJpaService.buscarPorCedulaTypedNamed("175685256");
	    LOG.info("Persona TypedNamed: "+perTypedNamed);
	    //4 Varios namedQuery
	    
	    List<Persona>listaPersona=this.iPersonaJpaService.buscarPorNombreApellido("Daniel", "Velez");
	    for(Persona item: listaPersona) {
		    LOG.info("Persona : "+item);
	    }
	    
	    
	}

}
