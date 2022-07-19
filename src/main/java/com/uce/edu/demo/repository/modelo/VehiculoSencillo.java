package com.uce.edu.demo.repository.modelo;

public class VehiculoSencillo {
	private String marca;
	private String tipo;
	
	public VehiculoSencillo() {
		
	}
	
	public VehiculoSencillo(String marca, String tipo) {
		
		this.marca = marca;
		this.tipo = tipo;
	}
	//set y get
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "VehiculoSencillo [marca=" + marca + ", tipo=" + tipo + "]";
	}
	
}
