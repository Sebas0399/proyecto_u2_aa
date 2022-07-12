package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="propietario")
@NamedQueries({@NamedQuery(name = "Propietario.buscarPorCedula", query = "SELECT p FROM Propietario p WHERE p.cedula=:cedula"),
@NamedQuery(name = "Propietario.buscarPorNombreApellido", query = "SELECT p FROM Propietario p WHERE p.nombre=:nombre AND p.apellido=:apellido")})
public class Propietario {
	@Id
	@Column(name="id_prop")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="name_generator")
	@SequenceGenerator(name="name_generator",sequenceName="prop_id_seq",allocationSize = 1)
	private Integer id;
	@Column(name="nombre_prop")
	private String nombre;
	@Column(name="apellido_prop")
	private String apellido;
	@Column(name="cedula")
	private String cedula;
	@Column(name="fecha_Nacimiento_prop")
	private LocalDateTime fechaNacimiento;
	//set y get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public String toString() {
		return "Propietario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
}
