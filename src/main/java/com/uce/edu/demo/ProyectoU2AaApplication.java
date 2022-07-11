package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Matricula;
import com.uce.edu.demo.repository.modelo.Propietario;
import com.uce.edu.demo.repository.modelo.Vehiculo;
import com.uce.edu.demo.service.IMatriculaJpaService;
import com.uce.edu.demo.service.IPropietarioJpaService;
import com.uce.edu.demo.service.IVehiculoJpaService;

@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner {
	@Autowired
	private IPropietarioJpaService propietarioService;
	@Autowired
	private IVehiculoJpaService vehiculoService;
	@Autowired
	private IMatriculaJpaService matriculaService;
	private static Logger LOG = LogManager.getLogger(ProyectoU2AaApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		// Propietario
		Propietario p=new Propietario();
		p.setNombre("Antony");
		p.setApellido("Arguello");
		p.setCedula("1725776650");
		p.setFechaNacimiento(LocalDateTime.now());
		this.propietarioService.insertar(p);
		//Vehiculp
		Vehiculo v=new Vehiculo();
		v.setMarca("Mazda");
		v.setPlaca("PBA-145");
		v.setPrecio(new BigDecimal("15000"));
		v.setTipo("P");
		this.vehiculoService.insertar(v);
		//Matricula
		Matricula m=new Matricula();
		m.setFechaMatricula(LocalDateTime.now());
		m.setValorMatricula(new BigDecimal("100"));
		this.matriculaService.insertar(m);
	}

}
