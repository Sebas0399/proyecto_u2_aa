package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="matricula")
public class Matricula {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="name_generator")
	@SequenceGenerator(name="name_generator",sequenceName="matr_id_seq",allocationSize = 1)
	private Integer id;
	@Column(name="fecha_Matricula")
	private LocalDateTime fechaMatricula;
	@Column(name="valor_Matricula")
	private BigDecimal valorMatricula;
//	@Column(name="propietario")
//	private Propietario propietario;
//	@Column(name="vehiculo")
//	private Vehiculo vehiculo;
	//set y get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}
	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}
	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}
//	public Propietario getPropietario() {
//		return propietario;
//	}
//	public void setPropietario(Propietario propietario) {
//		this.propietario = propietario;
//	}
//	public Vehiculo getVehiculo() {
//		return vehiculo;
//	}
//	public void setVehiculo(Vehiculo vehiculo) {
//		this.vehiculo = vehiculo;
//	}
//	@Override
//	public String toString() {
//		return "Matricula [id=" + id + ", fechaMatricula=" + fechaMatricula + ", valorMatricula=" + valorMatricula
//				+ ", propietario=" + propietario + ", vehiculo=" + vehiculo + "]";
//	}
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaMatricula=" + fechaMatricula + ", valorMatricula=" + valorMatricula
				+ "]";
	}
	
	
}
