package com.uce.edu.demo.repository.modelo;

public class VehiculoMarcaEnumerar {
	private Long cantidad;
	private String marca;
	public VehiculoMarcaEnumerar() {
		
	}
	
	public VehiculoMarcaEnumerar(String marca,Long cantidad) {
		
		this.cantidad = cantidad;
		this.marca = marca;
	}
	//set y get
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "VehiculoMarcaEnumerar [cantidad=" + cantidad + ", marca=" + marca + "]";
	}
	
}
