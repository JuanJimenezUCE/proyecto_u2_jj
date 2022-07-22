package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Ciudadano;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}
	@Override
	public Ciudadano buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}
	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);
	}
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciudadano = this.buscarPorId(id);
		this.entityManager.remove(ciudadano);
		
	}

	
}
