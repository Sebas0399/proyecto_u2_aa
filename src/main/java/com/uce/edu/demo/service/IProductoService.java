package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Producto;

public interface IProductoService {
	public void insertar(Producto producto);
	public Producto buscar(Integer id);
	public void actualizar(Producto producto);
	public void eliminar(Integer id);
}
