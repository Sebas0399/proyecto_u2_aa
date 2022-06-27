package com.uce.edu.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.*;
@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner{
	private static Logger log=LogManager.getLogger(ProyectoU2AaApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Log exitoso");
		log.error("Log error");
		log.debug("Debug app");
		//System.out.println("Hola munod");
	}

}
