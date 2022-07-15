package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

	@Override
	public List<Vehiculo> buscarTyped(String marca) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> miTypedQuery = this.entityManager
				.createQuery("SELECT v FROM Vehiculo v WHERE v.marca=:marca", Vehiculo.class);
		miTypedQuery.setParameter("marca", marca);
		return miTypedQuery.getResultList();
	}

	@Override
	public Vehiculo buscarNamed(String placa) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("Vehiculo.buscarPorPlaca");
		myQuery.setParameter("placa", placa);
		return (Vehiculo) myQuery.getSingleResult();
	}

	@Override
	public Vehiculo buscarNamedTyped(String marca, String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> miTypedQuery=this.entityManager.createNamedQuery("Vehiculo.buscarPorMarcaPlaca",Vehiculo.class);
		miTypedQuery.setParameter("marca", marca);
		miTypedQuery.setParameter("placa", placa);

		return miTypedQuery.getSingleResult();
	}

	@Override
	public Vehiculo buscarNativePlaca(String placa) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM vehiculo WHERE placa_vehi=:placa",
				Vehiculo.class);
		myQuery.setParameter("placa", placa);
		return (Vehiculo) myQuery.getSingleResult();
		
	}

	@Override
	public List<Vehiculo> buscarNativeTipo(String tipo) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM vehiculo WHERE tipo_vehi=:tipo",
				Vehiculo.class);
		myQuery.setParameter("tipo", tipo);
		return (List<Vehiculo>) myQuery.getResultList();
	}

	@Override
	public Vehiculo buscarNamedNativePlaca(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> miTypedQuery=this.entityManager.createNamedQuery("Vehiculo.buscarPorPlacaNative",Vehiculo.class);
		miTypedQuery.setParameter("placa", placa);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public List<Vehiculo> buscarNamedNativeMarca(String marca) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> miTypedQuery=this.entityManager.createNamedQuery("Vehiculo.buscarPorMarcaNative",Vehiculo.class);
		miTypedQuery.setParameter("marca", marca);
		return miTypedQuery.getResultList();
	}
}
