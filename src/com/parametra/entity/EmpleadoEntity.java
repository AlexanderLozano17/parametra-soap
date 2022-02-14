package com.parametra.entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class EmpleadoEntity {

	private int id;
	private String nombres;
	private String apellidos;
	private String tipo_documento;
	private Date fecha_nacimineto;
	private Date fecha_vinculacion_emp;
	private String cargo;
	private double salario;   
	private String tiempo_vinculacion;
	private String edad;
	
	public EmpleadoEntity() {
		
	}
	
	public EmpleadoEntity(Date fecha_nacimineto, Date fecha_vinculacion_emp) {
		super();
		this.fecha_nacimineto = fecha_nacimineto;
		this.fecha_vinculacion_emp = fecha_vinculacion_emp;
	}
	
	public EmpleadoEntity(int id, String nombres, String apellidos, String tipo_documento, Date fecha_nacimineto,
			Date fecha_vinculacion_emp, String cargo, Double salario) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipo_documento = tipo_documento;
		this.fecha_nacimineto = fecha_nacimineto;
		this.fecha_vinculacion_emp = fecha_vinculacion_emp;
		this.cargo = cargo;
		this.salario = salario;
	}
		
	public EmpleadoEntity(String nombres, String apellidos, String tipo_documento, Date fecha_nacimineto,
			Date fecha_vinculacion_emp, String cargo, Double salario) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipo_documento = tipo_documento;
		this.fecha_nacimineto = fecha_nacimineto;
		this.fecha_vinculacion_emp = fecha_vinculacion_emp;
		this.cargo = cargo;
		this.salario = salario;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public Date getFecha_nacimineto() {
		return fecha_nacimineto;
	}

	public void setFecha_nacimineto(Date fecha_nacimineto) throws ParseException {		
		this.fecha_nacimineto = fecha_nacimineto;
	}

	public Date getFecha_vinculacion_emp() {
		return fecha_vinculacion_emp;
	}

	public void setFecha_vinculacion_emp(Date fecha_vinculacion_emp) throws ParseException {
		this.fecha_vinculacion_emp = fecha_vinculacion_emp;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public void setEdad() {
		
		LocalDate fechaNacto = Instant.ofEpochMilli(getFecha_nacimineto().getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
		
		Period edad = operacionEdad(fechaNacto);	
		this.edad = edad.getYears() + " años, " + edad.getMonths() + " meses " + edad.getDays() + " días";			
	}
	
	public String getEdad() {
		return edad;
	}
	
	public void setTiempo_viculacion() {
		
		LocalDate fechaVicu = Instant.ofEpochMilli(getFecha_vinculacion_emp().getTime())
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		LocalDate fechaAtual = LocalDate.now();
		Period vinculacion = Period.between(fechaVicu, fechaAtual);
		
		this.tiempo_vinculacion = vinculacion.getYears() + " años " + vinculacion.getMonths() + " meses " + vinculacion.getDays() + " días";
	}
	
	public String getTiempo_viculacion() {
		return tiempo_vinculacion;
	}
	
	public Boolean validarEdadMinima() {
		
		LocalDate fechaNacito = Instant.ofEpochMilli(getFecha_nacimineto().getTime())
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		Period edadValida = operacionEdad(fechaNacito);
		
		if (edadValida.getYears() >= 18) {
			return true;
		} 
		return false;	
	}
	
	public static Period operacionEdad(LocalDate fechaNacto) {
		LocalDate fechaAtual = LocalDate.now();
		Period edad = Period.between(fechaNacto, fechaAtual);
		return edad;
	}

	@Override
	public String toString() {
		return "EmpledoEntity [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", tipo_documento="
				+ tipo_documento + ", fecha_nacimineto=" + fecha_nacimineto + ", fecha_vinculacion=" + fecha_vinculacion_emp
				+ ", cargo=" + cargo + ", saladrio=" + salario + "]";
	}
	
}