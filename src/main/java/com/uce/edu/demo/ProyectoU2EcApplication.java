package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.service.IEstudianteJdbcService;
import com.uce.edu.demo.estudiante.to.Estudiante;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner{
	
	private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2EcApplication.class);
	@Autowired
	private IEstudianteJdbcService iEstudianteJdbcService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Estudiante e = new Estudiante();
		e.setId(4);
		e.setNombre("Maria");
		e.setApellido("Delgado");
		e.setEdad("40");
		e.setGenero("F");
		//Insertar
		this.iEstudianteJdbcService.guardar(e);
		LOG.info("Se guardo:"+e);
		Estudiante e1 = new Estudiante();
		e1.setId(4);
		e1.setNombre("Evelyn");
		e1.setApellido("Jimenez");
		e1.setEdad("36");
		e1.setGenero("F");
		//Actualizar
		this.iEstudianteJdbcService.actualizar(e1);
		LOG.info("Se Actualizo:"+e1);
		//Eliminar
		this.iEstudianteJdbcService.eliminar(3);
	
		
		//Buscar
		LOG.info(this.iEstudianteJdbcService.buscar(4).toString());
	
	}

}
