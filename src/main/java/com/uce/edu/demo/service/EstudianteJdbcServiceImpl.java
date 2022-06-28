package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.to.Estudiante;
@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService{
	@Autowired
	private IEstudianteJdbcRepository estudianteRepo;
	@Override
	public Estudiante buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscar(cedula);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.actualizar(estudiante);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.estudianteRepo.eliminar(cedula);
	}

}
