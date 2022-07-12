package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Propietario;


public interface IPropietarioJpaRepository {
	 public Propietario buscar(Integer id);
	 public List<Propietario> buscarPorApellido(String apellido);
	 public List<Propietario> buscarPorNombre(String nombre);

	 public List<Propietario> buscarPorNacimiento(LocalDateTime fecha);
	 public void insertar(Propietario persona);
	 public void actualizar(Propietario persona);
	 public void eliminar(Integer id);
	 
	 public int actualizarPorApellido(LocalDateTime fecha,String apellido);
	 public int eliminarPorNacimiento(LocalDateTime fecha);
	 
	 public Propietario buscarTyped(String cedula);
	 public Propietario buscarNamed(String cedula);
	 public Propietario buscarNamedTyped(String nombre,String apellido);
}
