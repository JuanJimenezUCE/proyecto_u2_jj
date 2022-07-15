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
import com.uce.edu.demo.repository.modelo.Persona;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2EcApplication.class);

	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOG.info("NativeQuery : ");

		List<Estudiante> listaEstNative = this.iEstudianteJpaService.buscarPoredadGeneroNative("26", "M");

		for (Estudiante item : listaEstNative) {
			LOG.info("Estudiante : " + item);
		}
		List<Estudiante> listaEstNative2 = this.iEstudianteJpaService.buscarPorApellidoEdadNative("Jimenez", "26");

		for (Estudiante item : listaEstNative2) {
			LOG.info("Estudiante : " + item);
		}

		LOG.info("NamedNativeQuery : ");
		List<Estudiante> estNamedNative = this.iEstudianteJpaService.buscarPorEdadNamedNative("30");

		for (Estudiante item : estNamedNative) {
			LOG.info("Estudiante : " + item);
		}
		List<Estudiante> estNamedNative2 = this.iEstudianteJpaService.buscarPorApellidoNamedNative("Lopez");

		for (Estudiante item : estNamedNative2) {
			LOG.info("Estudiante : " + item);
		}
	}

}
