package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Factura;
@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Factura factura=this.buscar(id);
		this.entityManager.remove(factura);
	}

}
