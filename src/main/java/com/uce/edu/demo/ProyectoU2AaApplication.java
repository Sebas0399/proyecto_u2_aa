package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
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
	
//		Persona persNamed=this.personaService.buscarNamed("0201114022");
//		LOG.info("Persona Named: "+persNamed);
//
//		Persona persTyped=this.personaService.buscarTyped("0201114022");
//		LOG.info("Persona Typed: "+persTyped);
//		Persona persTypedNamed=this.personaService.buscarNamedTyped("0201114022");
//		LOG.info("Persona NamedTyped: "+persTypedNamed);
		
//		List<Persona> listaPers=this.personaService.buscarPorNombreApellido("Zambrano", "Zambrano");
//		for(Persona p: listaPers) {
//			LOG.info(p);
//		}
		//LOG.info(listaPers);
		Persona p=personaService.buscarDinamica("Pedro","Juan","M");
		LOG.info(p);

	}

}
