package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVehiculoJpaRepository;
import com.uce.edu.demo.repository.modelo.Vehiculo;

@Service
public class VehiculoJpaServiceImpl implements IVehiculoJpaService{
	@Autowired
	private IVehiculoJpaRepository vehiculoRepo;
	@Override
	public Vehiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.buscar(id);
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.insertar(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.actualizar(vehiculo);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.eliminar(id);
	}

}
