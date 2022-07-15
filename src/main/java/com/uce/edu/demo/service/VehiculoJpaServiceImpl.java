package com.uce.edu.demo.service;

import java.util.List;

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

	@Override
	public List<Vehiculo> buscarTyped(String marca) {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.buscarTyped(marca);
	}

	@Override
	public Vehiculo buscarNamed(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.buscarNamed(placa);
	}

	@Override
	public Vehiculo buscarNamedTyped(String marca, String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.buscarNamedTyped(marca, placa);
	}

	@Override
	public Vehiculo buscarNativePlaca(String placa) {
		// TODO Auto-generated method stub
		return this.buscarNativePlaca(placa);
	}

	@Override
	public List<Vehiculo> buscarNativeTipo(String tipo) {
		// TODO Auto-generated method stub
		return this.buscarNativeTipo(tipo);
	}

	@Override
	public Vehiculo buscarNamedNativePlaca(String placa) {
		// TODO Auto-generated method stub
		return this.buscarNamedNativePlaca(placa);
	}

	@Override
	public List<Vehiculo> buscarNamedNativeMarca(String placa) {
		// TODO Auto-generated method stub
		return this.buscarNamedNativeMarca(placa);
	}

}
