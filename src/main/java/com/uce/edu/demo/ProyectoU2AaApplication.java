package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner {
	@Autowired
	private IPersonaJpaService personaService;
	private static Logger LOG = LogManager.getLogger(ProyectoU2AaApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Actualizar con JPQL
		int resultado = this.personaService.eliminarPorGenero("FE");
		//LOG.info("Cantidad de registros actualizados: " + resultado);
		LOG.info("Cantidad de registros eliminados: "+resultado);

	}

}
