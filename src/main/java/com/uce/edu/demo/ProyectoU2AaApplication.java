package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.Detalle;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2AaApplication implements CommandLineRunner {
	private static Logger LOG = LogManager.getLogger(ProyectoU2AaApplication.class.getName());
	@Autowired
	private IFacturaService facturaService;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info(this.facturaService.consultar(1).getFecha());
	
		LOG.info(this.facturaService.consultar(1).getCliente().getCiudadano().getNombre());
List<Detalle>detalles=this.facturaService.consultar(1).getDetalles();
for(Detalle d:detalles) {
	LOG.info("Detalle"+detalles);
}
	}

}
