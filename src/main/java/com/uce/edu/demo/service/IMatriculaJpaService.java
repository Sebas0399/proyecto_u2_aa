package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.modelo.Matricula;

public interface IMatriculaJpaService {
	public Matricula buscar(Integer id);
	
	 public void insertar(Matricula matricula);
	 public void actualizar(Matricula matricula);
	 public void eliminar(Integer id);
	 public BigDecimal calcular(BigDecimal precio);
}
