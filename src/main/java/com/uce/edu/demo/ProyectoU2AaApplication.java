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
		
		

		
		LOG.info(this.vehiculoService.buscaDinamicaMarca("Mazda"));
		LOG.info(this.vehiculoService.buscarDinamicaPlaca("PBA-155"));
	}

}
