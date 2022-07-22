package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2EcApplication.class);

	@Autowired
	private ICiudadanoService iCiudadanoService;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Ciudadano ciud1= new Ciudadano();
		ciud1.setApellido("Juan");
		ciud1.setNombre("Jimenez");
		ciud1.setFecha(LocalDateTime.now());
		ciud1.setCedula("1723850");
		
		
		Pasaporte pas1 = new Pasaporte();
		pas1.setNumero("1238");
		pas1.setFechaEmision(LocalDateTime.now());
		pas1.setFechaCaducidad(LocalDateTime.of(2022, 12, 8, 10, 30));
		pas1.setCiudadano(ciud1);	
		ciud1.setPasaporte(pas1);
	    //Isertar
		this.iCiudadanoService.insertar(ciud1);
		
		
		//Buscar
		this.iCiudadanoService.buscarPorId(5);
		//Actualizar
		Ciudadano ciud2= new Ciudadano();
	    ciud2.setId(6);
		ciud2.setApellido("Juan");
		ciud2.setNombre("Jimenez");
		ciud2.setFecha(LocalDateTime.now());
		ciud2.setCedula("172385085");
		this.iCiudadanoService.actualizar(ciud2);
		//Eliminar
		this.iCiudadanoService.eliminar(9);
	}

}
