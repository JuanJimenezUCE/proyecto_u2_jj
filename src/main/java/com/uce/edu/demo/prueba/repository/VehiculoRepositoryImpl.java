package com.uce.edu.demo.prueba.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.prueba.modelo.Vehiculo;
@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.entityManager.persist(v);
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.entityManager.merge(v);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		
		
		return this.entityManager.find(Vehiculo.class, placa);
			
	}

	@Override
	public int eliminarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("DELETE FROM Vehiculo v WHERE v.placa= :placa  ");
		myQuery.setParameter("placa", placa);
		return myQuery.executeUpdate();
	}

}
