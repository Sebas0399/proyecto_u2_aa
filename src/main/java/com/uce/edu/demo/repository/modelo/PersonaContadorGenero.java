package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class PersonaContadorGenero implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long contador;
	private String genero;
	public PersonaContadorGenero() {
		
	}
	
public PersonaContadorGenero(String genero,Long contador) {
		this.genero=genero;
		this.contador=contador;
	}
	//set y get 
	public Long getContador() {
		return contador;
	}
	public void setContador(Long contador) {
		this.contador = contador;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "PersonaContadorGenero [contador=" + contador + ", genero=" + genero + "]";
	}
	
}
