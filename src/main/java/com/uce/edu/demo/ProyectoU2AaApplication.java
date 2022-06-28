package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.to.Estudiante;
@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner{
	@Autowired
	private IEstudianteJdbcService estudianteService;
	private static Logger LOG=LogManager.getLogger(ProyectoU2AaApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estudiante estudiante=new Estudiante();
		estudiante.setCedula("1725776650");
		estudiante.setNombre("Antony");
		estudiante.setApellido("Arguello");
		estudiante.setEdad("23");
		estudiante.setQuintil("primer");
		
		Estudiante estudiante2=new Estudiante();
		estudiante2.setCedula("1725876451");
		estudiante2.setNombre("Jhonyy");
		estudiante2.setApellido("Bravo");
		estudiante2.setEdad("20");
		estudiante2.setQuintil("quinto");
		
		Estudiante estudiante3=new Estudiante();
		estudiante3.setCedula("0201578432");
		estudiante3.setNombre("Jose");
		estudiante3.setApellido("Zambrano");
		estudiante3.setEdad("19");
		estudiante3.setQuintil("segundo");
		
		Estudiante estudiante4=new Estudiante();
		estudiante4.setCedula("0254789744");
		estudiante4.setNombre("Melany");
		estudiante4.setApellido("Rodriguez");
		estudiante4.setEdad("21");
		estudiante4.setQuintil("primer");
		
		this.estudianteService.insertar(estudiante);
		this.estudianteService.insertar(estudiante2);
		this.estudianteService.insertar(estudiante3);
		this.estudianteService.insertar(estudiante4);
		
		estudiante4.setEdad("22");
		this.estudianteService.actualizar(estudiante4);
		
		this.estudianteService.buscar("1725776650");
		
		this.estudianteService.eliminar("0254789744");
	}

}
