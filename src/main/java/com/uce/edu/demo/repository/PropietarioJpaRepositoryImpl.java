package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Propietario;
@Repository
@Transactional
public class PropietarioJpaRepositoryImpl implements IPropietarioJpaRepository{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Propietario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	public List<Propietario> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.apellido_prop:=apellido");
		jpqlQuery.setParameter("apellido", apellido);
		return jpqlQuery.getResultList();
	}

	@Override
	public List<Propietario> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.nombre_prop:=nombre");
		jpqlQuery.setParameter("nombre", nombre);
		return jpqlQuery.getResultList();
	}

	@Override
	public List<Propietario> buscarPorNacimiento(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.fecha_Nacimiento_prop:=fecha");
		jpqlQuery.setParameter("fecha", fecha);
		return jpqlQuery.getResultList();
	}

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(propietario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Propietario p=this.buscar(id);
		this.entityManager.remove(p);
	}

	@Override
	public int actualizarPorApellido(LocalDateTime fecha, String apellido) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("UPDATE Propietario p SET p.apellido_prop:=apellido WHERE p.fecha_Nacimiento_prop=:fecha");
		myQuery.setParameter("fecha",fecha);
		myQuery.setParameter("apellido",apellido);

		return myQuery.executeUpdate();
	}

	@Override
	public int eliminarPorNacimiento(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("DELETE from Propietario p WHERE p.fecha_Nacimiento_Pers:=fecha");
		myQuery.setParameter("fecha", fecha);
		return myQuery.executeUpdate();
	}

}
