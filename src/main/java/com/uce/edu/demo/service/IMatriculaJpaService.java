package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Matricula;

public interface IMatriculaJpaService {
	public Matricula buscar(Integer id);
	
	 public void insertar(Matricula matricula);
	 public void actualizar(Matricula matricula);
	 public void eliminar(Integer id);
}
