package com.parametra.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.parametra.entity.EmpleadoEntity;
import com.parametra.entity.Tiempos;

@WebService
public interface IEmpleadoService {
	
	@WebMethod
	public List<EmpleadoEntity> findAll() throws Exception;
	
	@WebMethod
	public EmpleadoEntity findById(@WebParam(name = "id") int id) throws Exception;
	
	@WebMethod
	public EmpleadoEntity update(@WebParam(name = "id") int id, EmpleadoEntity empleado) throws Exception;
	
	@WebMethod
	public Boolean delete(@WebParam(name = "id") int id) throws Exception;
	
	@WebMethod
	public Tiempos add(@WebParam(name = "nombres") String nombres,
						@WebParam(name = "apellidos") String apellidos, 
						@WebParam(name = "tipo_documento") String tipo_documento, 
						@WebParam(name = "fecha_nacimineto") String fecha_nacimineto,
						@WebParam(name = "fecha_vinculacion_emp") String fecha_vinculacion_emp, 
						@WebParam(name = "cargo") String cargo,
						@WebParam(name = "salario") double salario) throws Exception;
	
}
