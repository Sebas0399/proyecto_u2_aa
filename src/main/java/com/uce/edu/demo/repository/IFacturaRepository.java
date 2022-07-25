package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Factura;

public interface IFacturaRepository {
	public void insertar(Factura factura);
	public Factura buscar(Integer id);
	public void actualizar(Factura factura);
	public void eliminar(Integer id);
}
