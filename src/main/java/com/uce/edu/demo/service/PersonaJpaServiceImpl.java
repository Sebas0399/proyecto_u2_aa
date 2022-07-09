package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;
@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService{
	
	
	@Autowired
	private IPersonaJpaRepository personaRepo;
	@Override
	public Persona buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscar(id);
	}

	@Override
	public void insertar(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepo.insertar(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepo.actualizar(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.personaRepo.eliminar(id);
	}

	@Override
	public Persona buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscar(cedula);
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarPorApellido(apellido);
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarPorGenero(genero);
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarPorNombre(nombre);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		return this.personaRepo.actualizarPorApellido(genero, apellido);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.personaRepo.eliminarPorGenero(genero);
	}

}
