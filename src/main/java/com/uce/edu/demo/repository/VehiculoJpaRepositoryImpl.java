package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoJpaRepositoryImpl implements IVehiculoJpaRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Vehiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		
		// TODO Auto-generated method stub
		
		this.entityManager.merge(vehiculo);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Vehiculo v=this.buscar(id);
		this.entityManager.remove(v);;
	}
}
