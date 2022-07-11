package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Matricula;

public interface IMatriculaJpaRepository {
	public Matricula buscar(Integer id);
	
	 public void insertar(Matricula matricula);
	 public void actualizar(Matricula matricula);
	 public void eliminar(Integer id);
}
