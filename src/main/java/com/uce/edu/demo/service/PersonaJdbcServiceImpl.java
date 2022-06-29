package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.PersonaTo;

@Service
public class PersonaJdbcServiceImpl implements IPersonaJdbcService{
	@Autowired
	private IPersonaJdbcRepository personaRepo;
	@Override
	public PersonaTo buscar(int id) {
		// TODO Auto-generated method stub
		return this.personaRepo.buscar(id);
	}

	@Override
	public void guardar(PersonaTo persona) {
		// TODO Auto-generated method stub
		this.personaRepo.insertar(persona);
	}

	@Override
	public void actualizar(PersonaTo persona) {
		// TODO Auto-generated method stub
		this.personaRepo.actualizar(persona);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.personaRepo.eliminar(id);
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.personaRepo.buscarTodos();
	}

}
