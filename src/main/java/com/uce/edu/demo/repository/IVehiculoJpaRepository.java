package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vehiculo;

public interface IVehiculoJpaRepository {
	public Vehiculo buscar(Integer id);
	
	 public void insertar(Vehiculo vehiculo);
	 public void actualizar(Vehiculo vehiculo);
	 public void eliminar(Integer id);
	 
	 public List<Vehiculo> buscarTyped(String marca);
	 public Vehiculo buscarNamed(String placa);
	 public Vehiculo buscarNamedTyped(String marca,String placa);
	 
	 public Vehiculo buscarNativePlaca(String placa);
	 public List<Vehiculo> buscarNativeTipo(String tipo);
	 public Vehiculo buscarNamedNativePlaca(String placa);
	 public List<Vehiculo> buscarNamedNativeMarca(String placa);

	 
}
