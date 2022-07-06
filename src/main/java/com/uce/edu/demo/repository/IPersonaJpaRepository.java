package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {
	 public Persona buscar(Integer id);
	 public Persona buscar(String cedula);
	 public List<Persona> buscarPorApellido(String apellido);
	 public List<Persona> buscarPorGenero(String genero);
	 public void insertar(Persona persona);
	 public void actualizar(Persona persona);
	 public void eliminar(Integer id);
}
