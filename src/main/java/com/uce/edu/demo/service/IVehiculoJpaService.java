package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Vehiculo;

public interface IVehiculoJpaService {
	public Vehiculo buscar(Integer id);
	
	 public void insertar(Vehiculo vehiculo);
	 public void actualizar(Vehiculo vehiculo);
	 public void eliminar(Integer id);
}
