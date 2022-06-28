package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;
@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner{
	@Autowired
	private IPersonaJdbcService personaService;
	private static Logger LOG=LogManager.getLogger(ProyectoU2AaApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Persona persona=new Persona();
		persona.setId(0);
		persona.setNombre("Sebastian");
		persona.setApellido("Arguello");
//		this.personaService.actualizar(persona);
		System.out.println(this.personaService.buscar(1));
	}

}
