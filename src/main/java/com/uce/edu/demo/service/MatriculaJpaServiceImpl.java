package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IMatriculaJpaRepository;
import com.uce.edu.demo.repository.modelo.Matricula;
@Service
public class MatriculaJpaServiceImpl implements IMatriculaJpaService{
	@Autowired
	private  IMatriculaJpaRepository matriculaRepo;
	@Override
	public Matricula buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.matriculaRepo.buscar(id);
	}

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepo.insertar(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepo.actualizar(matricula);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.matriculaRepo.eliminar(id);
	}

}
