package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IMatriculaJpaRepository;
import com.uce.edu.demo.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.repository.IVehiculoJpaRepository;
import com.uce.edu.demo.repository.modelo.Matricula;
import com.uce.edu.demo.repository.modelo.Propietario;
import com.uce.edu.demo.repository.modelo.Vehiculo;


@Service
public class MatriculaGestorImpl implements IMatriculaGestorService{
	
	@Autowired
	private IPropietarioJpaRepository propietarioRepo;
	@Autowired
	private IVehiculoJpaRepository vehiculoRepo;
	@Autowired
	private IMatriculaJpaRepository matriculaRepo;
	@Autowired
	@Qualifier("pesado")
	private IMatriculaJpaService pesadoService;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaJpaService livianoService;
	@Override
	public void generarMatricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario pro=this.propietarioRepo.buscar(cedula);
		Vehiculo veh=this.vehiculoRepo.buscar(placa);
		BigDecimal valorMatricula;
		if(veh.getTipo().equalsIgnoreCase("pesado")){
			valorMatricula=this.pesadoService.calcular(veh.getPrecio());
		}
		else {
			valorMatricula=this.livianoService.calcular(veh.getPrecio());
		}
		if(valorMatricula.compareTo(new BigDecimal(2000))>0) {
			BigDecimal valorDescuento=valorMatricula.multiply(new BigDecimal(0.07));
			valorMatricula=valorMatricula.subtract(valorDescuento);
		}
		Matricula matricula=new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setPropietario(pro);
		matricula.setValorMatricula(valorMatricula);
		matricula.setVehiculo(veh);
		this.matriculaRepo.insertar(matricula);
	}

}