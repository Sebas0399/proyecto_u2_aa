package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner {
	private static Logger LOG = LogManager.getLogger(ProyectoU2AaApplication.class.getName());
	@Autowired
	private ICiudadanoService ciudadanoService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
//	
		Ciudadano ciu1=new Ciudadano();
		ciu1.setNombre("Jose");
		ciu1.setApellido("Zambramo");
		ciu1.setCedula("0201759572");
		ciu1.setFechaNacimiento(null);
		
		Pasaporte p=new Pasaporte();
		p.setNumero("154796");
		p.setFechaCaducidad(null);
		p.setFechaEmision(null);
	p.setCiudadano(ciu1);
				ciu1.setPasaporte(p);
//		
//		
		Ciudadano ciu2=new Ciudadano();
		ciu2.setNombre("Antony");
		ciu2.setApellido("Arguello");
		ciu2.setCedula("1725776650");
		ciu2.setFechaNacimiento(null);
		
		Pasaporte p2=new Pasaporte();
		p2.setNumero("154796");
		p2.setFechaCaducidad(null);
		p2.setFechaEmision(null);
		p2.setCiudadano(ciu2);
		
		ciu2.setPasaporte(p2);
		
		//this.ciudadanoService.insertar(ciu1);
		//this.ciudadanoService.insertar(ciu2);
		
		LOG.info(this.ciudadanoService.buscar(3));
		
		ciu1.setApellido("Zambrano");;
		this.ciudadanoService.actualizar(ciu1);
		
		this.ciudadanoService.eliminar(4);
		
		
	}

}
