package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2Autor2;
import com.uce.edu.demo.service.IAutor2Service;
import com.uce.edu.demo.service.ILibro2Autor2Service;
import com.uce.edu.demo.service.ILibro2Service;

@SpringBootApplication
public class ProyectoU2EcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU2EcApplication.class);

	@Autowired
	private ILibro2Service iLibro2Service;

	@Autowired
	private IAutor2Service iAutor2Service;

	@Autowired
	private ILibro2Autor2Service iLibro2Autor2Service;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		//1 libro que tiene dos autores
		LOG.info("1 libro que tiene dos autores");
		Autor2 aut1 = new Autor2();
		aut1.setNombre("William Shakespear2");
		
		this.iAutor2Service.insertar(aut1);
		LOG.info("Autor 1: "+aut1);
		Autor2 aut2 = new Autor2();
		aut2.setNombre("Juan Jimenez2");
		
		this.iAutor2Service.insertar(aut2);
		
		LOG.info("Autor 2: "+aut2);
		Libro2 lib1 =new Libro2();
		lib1.setTitulo("Hamlet2");
		lib1.setCantidadPaginas(123);
		
		this.iLibro2Service.insertar(lib1);
		LOG.info("Libro : "+lib1);
		
		Libro2Autor2 liau = new Libro2Autor2();
		liau.setAutor2(aut1);
		liau.setLibro2(lib1);
		this.iLibro2Autor2Service.insertar(liau);
		
		LOG.info("LibroAuto: "+liau);
		
		Libro2Autor2 liau2 = new Libro2Autor2();
		liau2.setAutor2(aut2);
		liau2.setLibro2(lib1);
		this.iLibro2Autor2Service.insertar(liau2);
		LOG.info("LibroAuto: "+liau2);
		//1 autor que escribio  2 libros
		LOG.info("1 autor escribio 2 libros");
		
		
		Libro2 lib2 =new Libro2();
		lib2.setTitulo("Poemas de amor");
		lib2.setCantidadPaginas(533);
		
		this.iLibro2Service.insertar(lib2);
		LOG.info("Libro 1: "+lib2);
		Libro2 lib3 =new Libro2();
		lib3.setTitulo("Odas elementales");
		lib3.setCantidadPaginas(1000);
		
		this.iLibro2Service.insertar(lib3);
		LOG.info("Libro 2: "+lib3);
		Autor2 aut3 = new Autor2();
		aut3.setNombre("Pablo Neruda");
		
	
		this.iAutor2Service.insertar(aut3);
		LOG.info("Autor : "+aut3);
	
		
		Libro2Autor2 liau3 = new Libro2Autor2();
		liau3.setAutor2(aut3);
		liau3.setLibro2(lib2);
		this.iLibro2Autor2Service.insertar(liau3);
		
		LOG.info("LibroAuto: "+liau3);
		
		Libro2Autor2 liau4 = new Libro2Autor2();
		liau4.setAutor2(aut3);
		liau4.setLibro2(lib3);
		this.iLibro2Autor2Service.insertar(liau4);
		LOG.info("LibroAuto: "+liau4);
		
	}

}
