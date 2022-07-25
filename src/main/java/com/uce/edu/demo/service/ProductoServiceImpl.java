package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	@Autowired
	private IProductoRepository productoRepo;
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.insertar(producto);
	}

	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscar(id);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.actualizar(producto);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.productoRepo.eliminar(id);
	}

}
