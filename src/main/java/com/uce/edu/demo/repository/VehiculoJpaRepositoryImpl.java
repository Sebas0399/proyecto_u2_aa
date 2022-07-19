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

import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.repository.modelo.VehiculoMarcaEnumerar;
import com.uce.edu.demo.repository.modelo.VehiculoSencillo;

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

	@Override
	public List<Vehiculo> buscaDinamicaMarca(String marca) {
		// TODO Auto-generated method stub
		//Select v from Vehiculo Where v.marca:=marca
		CriteriaBuilder builder=this.entityManager.getCriteriaBuilder();
		//Especificamos el tipo de retorno
		CriteriaQuery< Vehiculo> myQuery=builder.createQuery(Vehiculo.class);
		//Construimos el sql
		Root<Vehiculo>vehiculoRoot=myQuery.from(Vehiculo.class);//From persona
		myQuery.select(vehiculoRoot);//select Vehiculo
		
		Predicate p=builder.equal(vehiculoRoot.get("marca"),marca );//where v.marca=marca
		CriteriaQuery<Vehiculo> myQueryCompleto=myQuery.select(vehiculoRoot).where(p);
		TypedQuery<Vehiculo> myFinal=this.entityManager.createQuery(myQueryCompleto);
		
		return myFinal.getResultList();
	}

	@Override
	public Vehiculo buscarDinamicaPlaca(String placa) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//Select v from Vehiculo Where v.marca:=marca
		CriteriaBuilder builder=this.entityManager.getCriteriaBuilder();
		//Especificamos el tipo de retorno
		CriteriaQuery< Vehiculo> myQuery=builder.createQuery(Vehiculo.class);
		//Construimos el sql
		Root<Vehiculo>vehiculoRoot=myQuery.from(Vehiculo.class);//From persona
		myQuery.select(vehiculoRoot);//select Vehiculo
		
		Predicate p=builder.equal(vehiculoRoot.get("placa"),placa );//where v.marca=marca
		CriteriaQuery<Vehiculo> myQueryCompleto=myQuery.select(vehiculoRoot).where(p);
		TypedQuery<Vehiculo> myFinal=this.entityManager.createQuery(myQueryCompleto);
		
		return myFinal.getSingleResult();
		
	}

	@Override
	public List<VehiculoSencillo> buscarPorMarcaSencillo(String marca) {
		// TODO Auto-generated method stub
		TypedQuery<VehiculoSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.VehiculoSencillo(v.marca,v.tipo) FROM Vehiculo v WHERE v.marca=:marca",
				VehiculoSencillo.class);
		myQuery.setParameter("marca", marca);
		return myQuery.getResultList();
		
	}

	@Override
	public List<VehiculoMarcaEnumerar> enumerarMarcas() {
		// TODO Auto-generated method stub
		TypedQuery<VehiculoMarcaEnumerar> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.VehiculoMarcaEnumerar(v.marca,COUNT(v.marca)) FROM Vehiculo v GROUP BY v.marca",
				VehiculoMarcaEnumerar.class);
		
		return myQuery.getResultList();
	}
}
