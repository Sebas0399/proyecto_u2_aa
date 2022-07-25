package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Factura;
import com.uce.edu.demo.repository.modelo.onetomany.Producto;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IProductoService;

@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner {
	private static Logger LOG = LogManager.getLogger(ProyectoU2AaApplication.class.getName());
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IProductoService productoService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Factura f1=new Factura();
		f1.setFecha(LocalDateTime.now());
		this.facturaService.insertar(f1);
		
		Producto p1=new Producto();
		p1.setNombre("Galleta");
		p1.setTipo("Comestibles");
		p1.setPrecio(new BigDecimal(1));
		p1.setFactura(f1);
		this.productoService.insertar(p1);
		Producto p2=new Producto();
		p2.setNombre("Lava");
		p2.setTipo("Limpieza");
		p2.setPrecio(new BigDecimal(2));
		p2.setFactura(f1);
		this.productoService.insertar(p2);
		Producto p3=new Producto();
		p3.setNombre("Teclado");
		p3.setTipo("Tecnologia");
		p3.setPrecio(new BigDecimal(10));
		p3.setFactura(f1);
		this.productoService.insertar(p3);
		
		
		//buscar
		this.facturaService.buscar(1);
		
		//actualizar
		f1.setFecha(LocalDateTime.now());
		this.facturaService.actualizar(f1);
		//eliminar
		this.facturaService.eliminar(1);
		
		
	}

}
