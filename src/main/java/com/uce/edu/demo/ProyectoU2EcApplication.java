package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.estudiante.modelo.EstudianteContadorEdad;
import com.uce.edu.demo.estudiante.modelo.EstudianteSencillo;
import com.uce.edu.demo.estudiante.service.IEstudianteJpaService;
import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IPersonaJpaService;

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
		ciud1.setApellido("David");
		ciud1.setNombre("Masabanda");
		
		Empleado empl1 = new Empleado();
		empl1.setCodigoIess("45656");
		empl1.setSalario(new BigDecimal(50));
		empl1.setCiudadano(ciud1);
				
		ciud1.setEmpleado(empl1);
		this.iCiudadanoService.insertar(ciud1);
		
		Ciudadano ciud2= new Ciudadano();
		ciud2.setApellido("David2");
		ciud2.setNombre("Masabanda2");
		
		Empleado empl2 = new Empleado();
		empl2.setCodigoIess("456562");
		empl2.setSalario(new BigDecimal(502));
		empl2.setCiudadano(ciud2);
		
		//this.iCiudadanoService.insertar(empl2);
	
	}

}
