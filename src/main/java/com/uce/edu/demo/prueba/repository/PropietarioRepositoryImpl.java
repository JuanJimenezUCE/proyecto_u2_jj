package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.modelo.Propietario;
@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void crear(Propietario p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}


	@Override
	public Propietario consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
	
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula = :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Propietario)myQuery.getSingleResult();
	}

	@Override
	public int eliminarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("DELETE FROM Propietario p WHERE p.cedula= :datoCedula  ");
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.executeUpdate();
	}

}
