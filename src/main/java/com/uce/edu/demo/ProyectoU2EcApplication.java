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
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2EcApplication.class);

	
	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;
	//@Autowired
	//private IPersonaJpaService iPersonaJpaService;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		LOG.info("Criteria API : ");
		Estudiante estTyped = this.iEstudianteJpaService.buscarPorIdGeneroCriteriaApi("1", "M");


		LOG.info("Estudiante : " + estTyped);
		
		List<Estudiante> listaEst = this.iEstudianteJpaService.buscarDinamicamente("F", "Lopez", "30");
		
		for (Estudiante item : listaEst) {
			LOG.info("Estudiante : " + item);
		}

	}

}
