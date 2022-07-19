package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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

	@Override
	public Persona buscarTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarTyped(cedula);
	}

	@Override
	public Persona buscarNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarNamed(cedula);
	}

	@Override
	public Persona buscarNamedTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarNamedTyped(cedula);
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public Persona buscarNative(String cedula) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarNative(cedula);
	}

	@Override
	public Persona buscarNamedNative(String cedula) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarNamedNative(cedula);
	}

	@Override
	public Persona bucarCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		return this.personaRepo.bucarCriteriaApi(cedula);
	}

	@Override
	public Persona buscarDinamica(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarDinamica(nombre, apellido, genero);
	}

	@Override
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarPorApellidoSencillo(apellido);
	}

	@Override
	public List<PersonaContadorGenero> contarGenero() {
		// TODO Auto-generated method stub
		return this.personaRepo.contarGenero();
	}

}
