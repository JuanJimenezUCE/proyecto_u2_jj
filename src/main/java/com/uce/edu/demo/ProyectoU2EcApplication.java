package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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
		
		
		List<PersonaSencilla> listaPersona=this.iPersonaJpaService.buscarPorApellidoSencillo("Ayala");
		
		for (PersonaSencilla perItem : listaPersona) {
			LOG.info("PersonaSencilla : " + perItem);
		}
	
	List<PersonaContadorGenero> miListaPersonaGenero=this.iPersonaJpaService.consultarCantidadPorGenero();
		
		for (PersonaContadorGenero perItem : miListaPersonaGenero) {
			LOG.info("Genero :  " + perItem);
		}
		
	}

}
