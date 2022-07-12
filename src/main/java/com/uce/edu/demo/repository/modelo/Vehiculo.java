package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

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
@Table(name="vehiculo")
@NamedQueries({@NamedQuery(name = "Vehiculo.buscarPorPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa=:placa"),
@NamedQuery(name = "Vehiculo.buscarPorMarcaPlaca", query = "SELECT v FROM Vehiculo v WHERE v.marca=:marca AND v.placa=:placa")})
public class Vehiculo {
	@Id
	@Column(name="id_vehi")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="name_generator")
	@SequenceGenerator(name="name_generator",sequenceName="vehi_id_seq",allocationSize = 1)

	private Integer id;
	@Column(name="marca_vehi")

	private String marca;
	@Column(name="placa_vehi")
	private String placa;
	@Column(name="tipo_vehi")

	private String tipo;
	@Column(name="precio_vehi")

	private BigDecimal precio;
	//set y get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", placa=" + placa + ", tipo=" + tipo + ", precio=" + precio
				+ "]";
	}
	
}
