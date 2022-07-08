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
		//buscar
		//LOG.info(this.personaService.buscar(2));
		//guardar
		Persona p=new Persona();
//		p.setId(7);
		p.setNombre("Pedro");
		p.setApellido("Jimenez");
		p.setGenero("M");
		p.setCedula("0201114033");
//        this.personaService.insertar(p);
		//actualizar
		Persona p2=new Persona();
//		p2.setId(4);
		p2.setNombre("Juan");
		p2.setApellido("Jimenez");
		//this.personaService.actualizar(p2);
		//eliminar
		//this.personaService.eliminar(2);
		List<Persona>listaPersonas=this.personaService.buscarPorGenero("M");
		for(Persona persona:listaPersonas) {
			LOG.info(persona);
		}
		
	}

}
