package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.modelo.Matricula;
import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IFachadaMatriculaService;
import com.uce.edu.demo.prueba.service.IPropietarioService;
import com.uce.edu.demo.prueba.service.IVehiculoService;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2EcApplication.class);

	@Autowired
	private IPropietarioService iPropietarioService;
	
	
	@Autowired
	private IFachadaMatriculaService iFachadaMatriculaService;
	@Autowired
	private IVehiculoService iVehiculoService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Propietario p = new Propietario();
		p.setNombre("Jorge");
		p.setApellido("Jimenez");
		p.setCedula("1723026911");
		p.setFecha(LocalDateTime.now());

		this.iPropietarioService.ingresar(p);

		LOG.info("se ingreso el propietario: " + p);

		Vehiculo v =new Vehiculo();
		v.setMarca("Hyundai");
		v.setTipo("L");
		v.setPlaca("PDM1487");
		v.setPrecio(new BigDecimal(30000));

		this.iVehiculoService.ingresar(v);

	
		LOG.info("se ingreso el vehiculo: " + v);
		
		this.iFachadaMatriculaService.generar("1723026900", "PDM1485");
		
		
	}

}
