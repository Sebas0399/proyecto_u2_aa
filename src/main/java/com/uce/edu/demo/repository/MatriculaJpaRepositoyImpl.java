package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Matricula;
@Repository
@Transactional

public class MatriculaJpaRepositoyImpl implements IMatriculaJpaRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Matricula buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Matricula.class, id);
	}

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.merge(matricula);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Matricula m=this.buscar(id);
		this.entityManager.remove(m);
		
	}
	

}
