package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Producto;

public interface IProductoRepository {
	public void insertar(Producto producto);
	public Producto buscar(Integer id);
	public void actualizar(Producto producto);
	public void eliminar(Integer id);
}
