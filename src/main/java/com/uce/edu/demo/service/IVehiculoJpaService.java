package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.repository.modelo.VehiculoMarcaEnumerar;
import com.uce.edu.demo.repository.modelo.VehiculoSencillo;

public interface IVehiculoJpaService {
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
	 
	 public List<Vehiculo>buscaDinamicaMarca(String marca);
	 public Vehiculo buscarDinamicaPlaca(String placa);
	 
	 public List<VehiculoSencillo>buscarPorMarcaSencillo(String marca);
	 public List<VehiculoMarcaEnumerar>enumerarMarcas();
}
