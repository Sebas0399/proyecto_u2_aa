package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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
	
		PersonaSencilla ps=new PersonaSencilla();
		//LOG.info(this.personaService.buscarPorApellidoSencillo("Zambrano"));
		Ciudadano ciu1=new Ciudadano();
		ciu1.setNombre("Jose");
		ciu1.setApellido("Zambramo");
		Empleado empl1=new Empleado();
		empl1.setCodigoIess("578954");
		empl1.setSalario(new BigDecimal(200));
		empl1.setCiudadano(ciu1);
		ciu1.setEmpleado(empl1);
		this.ciudadanoService.insertar(ciu1);
		
		//insertar empleado xd
		
	}

}
