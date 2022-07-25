package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Factura;
@Service
public class FacturaServiceImpl implements IFacturaService{
	@Autowired
	private IFacturaRepository facturaRepo;
	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepo.insertar(factura);
	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscar(id);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepo.actualizar(factura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.facturaRepo.eliminar(id);
	}

}
