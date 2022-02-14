package com.parametra.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.jws.WebService;

import com.parametra.entity.EmpleadoEntity;
import com.parametra.entity.Tiempos;
import com.parametra.repositorio.EmpleadoRepositorio;
import com.parametra.service.IEmpleadoService;

@WebService(endpointInterface = "com.parametra.service.IEmpleadoService")
public class EmpleadoImpl implements IEmpleadoService {

	private EmpleadoRepositorio empleadoRepositorio = new EmpleadoRepositorio();;
		
	@Override
	public List<EmpleadoEntity> findAll() throws Exception {
		return empleadoRepositorio.findAll();  
	}

	@Override
	public EmpleadoEntity findById(int id) throws Exception {
		return empleadoRepositorio.findById(id);
	}

	@Override
	public EmpleadoEntity update(int id, EmpleadoEntity empleado) throws Exception {
		return null;
	}

	@Override
	public Boolean delete(int id) throws Exception {
		return empleadoRepositorio.delete(id);
	}

	@Override
	public Tiempos add(String nombres, String apellidos, String tipo_documento, String fecha_nacimineto,
			String fecha_vinculacion_emp, String cargo, double salario) throws Exception {
		
		EmpleadoEntity empleado = new EmpleadoEntity(stringADateSQL(fecha_nacimineto), stringADateSQL(fecha_vinculacion_emp));
		empleado.setTiempo_viculacion();
		empleado.setEdad();
		
		if (empleado.validarEdadMinima()) {
			Boolean empleadoCreado = empleadoRepositorio.add(nombres, apellidos, tipo_documento, fecha_nacimineto, fecha_vinculacion_emp, cargo, salario);
			if (empleadoCreado) {		
							
				return new Tiempos(empleado.getEdad(), empleado.getTiempo_viculacion(), "SI");
			}
		} else {
			return new Tiempos(empleado.getEdad(), "NO, la edad debe ser igual o mayor a 18 años");
		}	
		return null;
	}
	

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date stringADateSQL(String date) {	 
		
		try {
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			java.sql.Date dateSQL = new java.sql.Date(utilDate.getTime());
			return dateSQL;  			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}  
	   return null;		
	}

}
