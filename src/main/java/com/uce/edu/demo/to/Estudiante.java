package com.uce.edu.demo.to;

public class Estudiante {
private String cedula;
private String nombre;
private String apellido;
private String edad;
private String quintil;
//Constructor por defecto
public Estudiante() {
	
}
public Estudiante(String cedula, String nombre, String apellido, String edad, String quintil) {
	super();
	this.cedula = cedula;
	this.nombre = nombre;
	this.apellido = apellido;
	this.edad = edad;
	this.quintil = quintil;
}
//set y get
public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
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
public String getEdad() {
	return edad;
}
public void setEdad(String edad) {
	this.edad = edad;
}
public String getQuintil() {
	return quintil;
}
public void setQuintil(String quintil) {
	this.quintil = quintil;
}
@Override
public String toString() {
	return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
			+ ", quintil=" + quintil + "]";
}


}