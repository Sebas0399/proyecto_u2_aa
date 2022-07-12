package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		
//		// Propietario
//		Propietario p=new Propietario();
//		p.setNombre("Antony");
//		p.setApellido("Sebastian");
//		p.setCedula("0201114022");
//		p.setFechaNacimiento(LocalDateTime.now());
//		this.propietarioService.insertar(p);
//		//Vehiculp
//		Vehiculo v=new Vehiculo();
//		v.setMarca("Mazda");
//		v.setPlaca("PBA-155");
//		v.setPrecio(new BigDecimal("25000"));
//		v.setTipo("L");
//		this.vehiculoService.insertar(v);
//		//Matricula
//		Matricula m=new Matricula();
//		m.setFechaMatricula(LocalDateTime.now());
//		m.setValorMatricula(new BigDecimal("100"));
//		this.matriculaService.insertar(m);
		this.propietarioService.buscarNamed("1725776650");
		this.propietarioService.buscarTyped("0201114022");
		this.propietarioService.buscarNamedTyped("Antony","Arguello");
		
		this.vehiculoService.buscarNamed("PBA-145");
		List<Vehiculo> listaV=this.vehiculoService.buscarTyped("Mazda");
		for( Vehiculo v:listaV) {
			LOG.info(v);
		}
		this.vehiculoService.buscarNamedTyped("Mazda", "PBA-155");
	}

}
