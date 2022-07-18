package com.uce.edu.demo.estudiante.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.estudiante.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.buscarPorId(id);
		this.entityManager.remove(estudiante);
	}

	// Typed
	@Override
	public List<Estudiante> buscarPorEdadTyped(String edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.edad = :edad", Estudiante.class);
		myQuery.setParameter("edad", edad);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorNombreEdadTyped(String nombre, String edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery(
				"SELECT e FROM Estudiante e WHERE e.nombre = :nombre  AND e.edad= :edad", Estudiante.class);
		myQuery.setParameter("nombre", nombre);
		myQuery.setParameter("edad", edad);
		return myQuery.getResultList();
	}

	// Named
	@Override
	public List<Estudiante> buscarPorGeneroNamed(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorGeneroNamed");
		myQuery.setParameter("genero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadNamed(String edad) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdadNamed");
		myQuery.setParameter("edad", edad);
		return myQuery.getResultList();
	}

	// Typed y Named
	@Override
	public List<Estudiante> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreApellido",
				Estudiante.class);
		myQuery.setParameter("nombre", nombre);
		myQuery.setParameter("apellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoGenero(String apellido, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoGenero",
				Estudiante.class);
		myQuery.setParameter("apellido", apellido);
		myQuery.setParameter("genero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPoredadGeneroNative(String edad, String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT *FROM estudiante  WHERE estu_edad = :edad AND estu_genero=:genero",
				Estudiante.class);
		myQuery.setParameter("edad", edad);
		myQuery.setParameter("genero", genero);
		return  myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoEdadNative(String apellido, String edad) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT *FROM estudiante  WHERE estu_apellido = :apellido AND estu_edad=:edad",
				Estudiante.class);
		myQuery.setParameter("apellido", apellido);
		myQuery.setParameter("edad", edad);
		return  myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdadNamedNative(String edad) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdadNative",Estudiante.class);
		myQuery.setParameter("edad", edad);
		return  myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellidoNamedNative(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoNative",Estudiante.class);
		myQuery.setParameter("apellido", apellido);
		return  myQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorIdGeneroCriteriaApi(String id,String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();
		
		
		CriteriaQuery<Estudiante> myQuery= myBuilder.createQuery(Estudiante.class);
	
		Root<Estudiante> estudianteFrom= myQuery.from(Estudiante.class); 
	
		Predicate p1=myBuilder.equal(estudianteFrom.get("id"), id);//p.cedula = :datoCedula
		Predicate p2=myBuilder.equal(estudianteFrom.get("genero"), genero);
		
		Predicate pFinal=myBuilder.and(p1,p2);
		//CriteriaQuery<Persona> myQueryCompleto=myQuery.select(personaFrom).where(p1);
		myQuery.select(estudianteFrom).where(pFinal);
		
		TypedQuery<Estudiante> myQueryFinal= this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarDinamicamente(String genero, String apellido, String edad) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery= myCriteria.createQuery(Estudiante.class);
		
		Root<Estudiante> myTabla=myQuery.from(Estudiante.class);
	
		
		Predicate predicadoGenero=myCriteria.equal(myTabla.get("genero"),genero);
		Predicate predicadoApellido=myCriteria.equal(myTabla.get("apellido"),apellido);
		Predicate predicadoEdad=myCriteria.equal(myTabla.get("edad"),edad);
	
		Predicate miPredicadoFinal=null;
			
		if(genero.equals("F")) {
			
			miPredicadoFinal=myCriteria.or(predicadoApellido,predicadoEdad);
			miPredicadoFinal=myCriteria.and(miPredicadoFinal,predicadoGenero);
		
		}else {
			
			miPredicadoFinal=myCriteria.and(predicadoApellido,predicadoEdad);
			miPredicadoFinal=myCriteria.or(miPredicadoFinal,predicadoGenero);
		}
		
		myQuery.select(myTabla).where(miPredicadoFinal);
		TypedQuery<Estudiante> myQueryFinal= this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}





}
