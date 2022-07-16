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

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.persist(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona persona = this.buscar(id);
		this.entityManager.remove(persona);
	}

	@Override
	public Persona buscar(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula=:cedula");
		jpqlQuery.setParameter("cedula", cedula);

		return (Persona) jpqlQuery.getSingleResult();
	}

	public Persona buscarTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> miTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula=:cedula", Persona.class);
		miTypedQuery.setParameter("cedula", cedula);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public Persona buscarNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("cedula", cedula);

		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarNamedTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> miTypedQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula",
				Persona.class);

		miTypedQuery.setParameter("cedula", cedula);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido=:apellido");
		jpqlQuery.setParameter("apellido", apellido);

		return jpqlQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero=:genero");
		jpqlQuery.setParameter("genero", genero);

		return jpqlQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre=:nombre");
		jpqlQuery.setParameter("nombre", nombre);

		return jpqlQuery.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Persona p SET  p.genero=:datoGenero WHERE p.apellido=:datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();

	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> miTypedQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido",
				Persona.class);

		miTypedQuery.setParameter("nombre", nombre);
		miTypedQuery.setParameter("apellido", apellido);

		return miTypedQuery.getResultList();
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("DELETE from Persona p WHERE p.genero=:datoGenero");
		myQuery.setParameter("datoGenero", genero);
		return myQuery.executeUpdate();
	}

	@Override
	public Persona buscarNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula=:cedula",
				Persona.class);
		myQuery.setParameter("cedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative",
				Persona.class);
		myQuery.setParameter("cedula", cedula);

		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona bucarCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		// SELECT p FROM Persona p WHERE p.cedula=:cedula
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		// Espicificamos el tipo de retorno
		CriteriaQuery<Persona> myQuery = builder.createQuery(Persona.class);
		// Root FROM
		// Construimos el sql
		Root<Persona> personaRoot = myQuery.from(Persona.class);// From Persona
		myQuery.select(personaRoot); // Select p FROM Persona

		Predicate p1 = builder.equal(personaRoot.get("cedula"), cedula);// p.cedula=:cedula
		CriteriaQuery<Persona> myQueryCompleto = myQuery.select(personaRoot).where(p1);
		// Finalizado mi query completo
		TypedQuery<Persona> myFinal = this.entityManager.createQuery(myQueryCompleto);
		return myFinal.getSingleResult();
	}

	@Override
	public Persona buscarDinamica(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona>myQuery=myCriteria.createQuery(Persona.class);
		Root<Persona>myTabla=myQuery.from(Persona.class);
		Predicate pNombre=myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate pApellido=myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate pFinal;
		
		if(genero.equals("M")) {
			pFinal=myCriteria.and(pNombre,pApellido);
		}
		else {
			 pFinal=myCriteria.or(pNombre,pApellido);
		}
		myQuery.select(myTabla).where(pFinal);
		
		TypedQuery<Persona> myFinal = this.entityManager.createQuery(myQuery);
		return myFinal.getSingleResult();
	}
	
	public Persona buscarDinamica2(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona>myQuery=myCriteria.createQuery(Persona.class);
		Root<Persona>myTabla=myQuery.from(Persona.class);
		Predicate pNombre=myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate pApellido=myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate pGenero=myCriteria.equal(myTabla.get("genero"), genero);
		Predicate pFinal;
		
		if(genero.equals("M")) {
			pFinal=myCriteria.or(pNombre,pApellido);
			pFinal=myCriteria.and(pFinal,pGenero);
		}
		else {
			 pFinal=myCriteria.and(pNombre,pApellido);
			 pFinal=myCriteria.or(pFinal,pGenero);
		}
		myQuery.select(myTabla).where(pFinal);
		
		TypedQuery<Persona> myFinal = this.entityManager.createQuery(myQuery);
		return myFinal.getSingleResult();
	}


}
