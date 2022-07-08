package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {
	public Persona buscar(Integer id);
	 public Persona buscar(String cedula);
	 public List<Persona> buscarPorApellido(String apellido);
	 public List<Persona> buscarPorNombre(String nombre);

	 public List<Persona> buscarPorGenero(String genero);
	 public void insertar(Persona persona);
	 public void actualizar(Persona persona);
	 public void eliminar(Integer id);
}

