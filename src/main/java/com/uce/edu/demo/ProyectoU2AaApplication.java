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
import com.uce.edu.demo.repository.modelo.manytomany.Autor2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2Autor2;
import com.uce.edu.demo.service.IAutor2Service;
import com.uce.edu.demo.service.ILibro2Autor2Service;
import com.uce.edu.demo.service.ILibro2Service;

@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner {
	private static Logger LOG = LogManager.getLogger(ProyectoU2AaApplication.class.getName());
	@Autowired
	private ILibro2Service iLibro2Service;

	@Autowired
	private IAutor2Service iAutor2Service;

	@Autowired
	private ILibro2Autor2Service iLibro2Autor2Service;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Autor2 a=new Autor2();
		a.setNombre("Sebas");
		
		this.iAutor2Service.insertar(a);
		
		Autor2 a2=new Autor2();
		a2.setNombre("Antony");
		this.iAutor2Service.insertar(a2);
		
		Libro2 l=new Libro2();
		l.setTitulo("Pedro Paramo");
		l.setCantidadPaginas(200);
		this.iLibro2Service.insertar(l);
		
		Libro2 l2=new Libro2();
		l2.setTitulo("Principito");
		l2.setCantidadPaginas(150);
		this.iLibro2Service.insertar(l2);
		
		Libro2Autor2 li2au2=new Libro2Autor2();
		li2au2.setAutor2(a);
		li2au2.setLibro2(l);
		this.iLibro2Autor2Service.insertar(li2au2);
		
		Libro2Autor2 li2au22=new Libro2Autor2();
		li2au22.setAutor2(a2);
		li2au22.setLibro2(l2);
		this.iLibro2Autor2Service.insertar(li2au22);
	}

}
