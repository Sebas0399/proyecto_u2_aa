package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Factura;

public interface IFacturaService {
	public void insertar(Factura factura);
	public Factura buscar(Integer id);
	public void actualizar(Factura factura);
	public void eliminar(Integer id);
}
