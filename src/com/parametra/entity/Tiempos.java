package com.parametra.entity;

public class Tiempos {
	private String edad;
	private String tiempo_vinculacion;
	private String puede_trabajar;
	
	public Tiempos() {
		
	}
	
	public Tiempos(String edad, String tiempo_vinculacion, String puede_trabajar) {
		super();
		this.edad = edad;
		this.tiempo_vinculacion = tiempo_vinculacion;
		this.puede_trabajar = puede_trabajar;
	}
	
	public Tiempos(String edad, String puede_trabajar) {
		super();
		this.edad = edad;
		this.puede_trabajar = puede_trabajar;
	}
	
	public String getEdad() {
		return edad;
	}
	
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	public String getTiempo_vinculacion() {
		return tiempo_vinculacion;
	}
	
	public void setTiempo_vinculacion(String tiempo_vinculacion) {
		this.tiempo_vinculacion = tiempo_vinculacion;
	}

	public String getPuede_trabajar() {
		return puede_trabajar;
	}

	public void setPuede_trabajar(String puede_trabajar) {
		this.puede_trabajar = puede_trabajar;
	}
	
	
}
