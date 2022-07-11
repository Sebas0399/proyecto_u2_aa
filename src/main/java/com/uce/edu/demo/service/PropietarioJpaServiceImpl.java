package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.repository.modelo.Propietario;
@Service
public class PropietarioJpaServiceImpl implements IPropietarioJpaService{
	
	@Autowired
	private IPropietarioJpaRepository propietarioRepo;
	@Override
	public Propietario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.propietarioRepo.buscar(id);
	}

	@Override
	public List<Propietario> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.propietarioRepo.buscarPorApellido(apellido);
	}

	@Override
	public List<Propietario> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.propietarioRepo.buscarPorNombre(nombre);
	}

	@Override
	public List<Propietario> buscarPorNacimiento(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.propietarioRepo.buscarPorNacimiento(fecha);
	}

	@Override
	public void insertar(Propietario persona) {
		// TODO Auto-generated method stub
		this.propietarioRepo.insertar(persona);
	}

	@Override
	public void actualizar(Propietario persona) {
		// TODO Auto-generated method stub
		this.propietarioRepo.actualizar(persona);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.propietarioRepo.eliminar(id);
	}

	@Override
	public int actualizarPorApellido(LocalDateTime fecha, String apellido) {
		// TODO Auto-generated method stub
		return this.propietarioRepo.actualizarPorApellido(fecha, apellido);
	}

	@Override
	public int eliminarPorNacimiento(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.propietarioRepo.eliminarPorNacimiento(fecha);
	}

}
