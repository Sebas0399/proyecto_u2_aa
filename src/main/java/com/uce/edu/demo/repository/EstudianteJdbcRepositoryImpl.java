package com.uce.edu.demo.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2AaApplication;
import com.uce.edu.demo.to.Estudiante;
@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {
	private static Logger LOG=LogManager.getLogger(ProyectoU2AaApplication.class.getName());


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Estudiante buscar(String cedula) {
		// TODO Auto-generated method stub
		LOG.info("Estudiante con cedula: "+cedula+" encontrado");
		return this.jdbcTemplate.queryForObject("select * from estudiante where cedula=?", new Object[] { cedula },
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));

	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		LOG.info("Estudiante insertado"+estudiante);
		this.jdbcTemplate.update("insert into estudiante(cedula,nombre,apellido,edad,quintil) values(?,?,?,?,?)",
				new Object[] { estudiante.getCedula(), estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getEdad(), estudiante.getQuintil() });
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		LOG.info("Estudiante actualizado"+estudiante);
		this.jdbcTemplate.update("update estudiante set nombre=?,apellido=?,edad=?,quintil=? where cedula=?",
				new Object[] { estudiante.getNombre(), estudiante.getApellido(), estudiante.getEdad(),
						estudiante.getQuintil(), estudiante.getCedula() });

	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		LOG.info("Estudiante con cedula: "+cedula+" eliminado");
		this.jdbcTemplate.update("delete from estudiante where cedula=?", new Object[] { cedula });

	}

}
