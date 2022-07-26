package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner {
	private static Logger LOG = LogManager.getLogger(ProyectoU2AaApplication.class.getName());
	@Autowired
	private ILibroService libroService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Autor a=new Autor();
		a.setNombre("Marco");
		
		Autor a2=new Autor();
		a2.setNombre("Jose");
		Set<Autor>autores=new HashSet<>();
		autores.add(a);
		autores.add(a2);

		
		Libro l=new Libro();
		l.setTitulo("Pricipito");
		l.setCantidadPaginas(150);
		
		Set<Libro>libros=new HashSet<>();
		//a.setLibros(null);
		l.setAutores(autores);
		
	this.libroService.insertar(l);
		
		
	}

}
