package com.uce.edu.demo.repository;

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

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		// black friday se inserta
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {

		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {

		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {

		Persona persona = this.buscarPorId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		// SELECT *FROM persona WHERE pers_cedula='1723026900'

		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Persona) jpqlQuery.getSingleResult();

	}

	@Override
	public Persona buscarPorCedulaTyped(String cedula) {

		TypedQuery<Persona> miTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula", Persona.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {

		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {

		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT *FROM persona  WHERE pers_cedula = :datoCedula",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		// SELECT p FROM Persona p WHERE p.cedula = :datoCedula
		// creamos una instancia de la interfaz CriteriaBuilder Fabrica para cosntruir
		// el SQL
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		// Especificamos el retorno de mi SQL
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);

		// Aqui empezamos a construir el SQL
		// Root FROM
		Root<Persona> personaFrom = myQuery.from(Persona.class); // FROM Persona
		// myQuery.select(personaFrom);//Select p From Persona
		// Las condiciones where en criteria API se los conoce como predicados
		Predicate p1 = myBuilder.equal(personaFrom.get("cedula"), cedula);// p.cedula = :datoCedula

		// CriteriaQuery<Persona> myQueryCompleto=myQuery.select(personaFrom).where(p1);
		myQuery.select(personaFrom).where(p1);
		// Finalizado mi query completo

		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

		Root<Persona> myTabla = myQuery.from(Persona.class);

		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);

		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);

		Predicate miPredicadoFinal = null;

		if (genero.equals("M")) {
			// pers_nombre='Diana' and pers_apellido='Muñoz'
			miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
		} else {
			// pers_nombre='Diana' or pers_apellido='Muñoz'
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
		}

		myQuery.select(myTabla).where(miPredicadoFinal);
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public Persona buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);

		Root<Persona> myTabla = myQuery.from(Persona.class);

		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);

		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);

		Predicate predicadoGenero = myCriteria.equal(myTabla.get("genero"), genero);
		Predicate miPredicadoFinal = null;
		// FROM public.persona where (pers_apellido='Velez' or pers_nombre='Daniel') and
		// pers_genero='F';
		if (genero.equals("M")) {

			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
			miPredicadoFinal = myCriteria.and(miPredicadoFinal, predicadoGenero);
		} else {

			miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
			miPredicadoFinal = myCriteria.or(miPredicadoFinal, predicadoGenero);
		}

		myQuery.select(myTabla).where(miPredicadoFinal);
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :datoGenero");
		myQuery.setParameter("datoGenero", genero);

		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);

		return myQuery.getResultList();
	}

	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<PersonaSencilla> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaSencilla(p.nombre,p.apellido) FROM Persona p WHERE p.apellido=:apellido   ",
				PersonaSencilla.class);
		myQuery.setParameter("apellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		// TODO Auto-generated method stub
		// select pers_genero, count(pers_genero) from persona GROUP BY pers_genero
		// SELECT p.genero, COUNT(p.genero) FROM Persona p GROUP BY p.genero
		// SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero,
		// COUNT(p.genero)) FROM Persona p GROUP BY p.genero
		TypedQuery<PersonaContadorGenero> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero, COUNT(p.genero)) FROM Persona p GROUP BY p.genero",
				PersonaContadorGenero.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido",
				Persona.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);

		return myQuery.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// update persona set pers_genero='H' where pers_apellido='Cayambe'
		Query myQuery = this.entityManager
				.createQuery("UPDATE Persona p SET p.genero= :datoGenero  WHERE p.apellido= :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();

	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		// delete from persona where pers_apellido='Cayambe'
		Query myQuery = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero= :genero  ");
		myQuery.setParameter("genero", genero);
		return myQuery.executeUpdate();

	}

}
