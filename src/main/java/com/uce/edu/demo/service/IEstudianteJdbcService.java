package com.uce.edu.demo.service;

import com.uce.edu.demo.to.Estudiante;

public interface IEstudianteJdbcService {
	public Estudiante buscar(String cedula);
	 public void insertar(Estudiante estudiante);
	 public void actualizar(Estudiante estudiante);
	 public void eliminar(String cedula);
}
