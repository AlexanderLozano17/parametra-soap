package com.parametra.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.parametra.entity.EmpleadoEntity;
import com.parametra.sql.ConexionDB;

public class EmpleadoRepositorio {
	
	ConexionDB conexion = new ConexionDB();	
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	/**
	 * 
	 * @return
	 */
	public List<EmpleadoEntity> findAll() {
		
		try {						
			Connection conexionEmpleado = conexion.getConexion();
			preparedStatement = conexionEmpleado.prepareStatement("select * from empleados");
			resultSet = preparedStatement.executeQuery();
			
			List<EmpleadoEntity> listEmpleados = new ArrayList<EmpleadoEntity>();
			
			while (resultSet.next()) {
				listEmpleados.add(new EmpleadoEntity(resultSet.getInt("id"),
													resultSet.getString("nombres"), 
													resultSet.getString("apellidos"), 
													resultSet.getString("tipo_documento"), 
													resultSet.getDate("fecha_nacimiento"), 
													resultSet.getDate("fecha_vinculacion_emp"), 
													resultSet.getString("cargo"), 
													resultSet.getDouble("salario")));
			}		
			conexionEmpleado.close();
			return listEmpleados;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}	
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ParseException
	 */
	public EmpleadoEntity findById(int id) throws ParseException {			
		try {
			Connection conexionEmpleado = conexion.getConexion();
			preparedStatement = conexionEmpleado.prepareStatement("select * from empleados where id=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			EmpleadoEntity empleado = new EmpleadoEntity();
			
			while (resultSet.next()) {
				empleado.setId(resultSet.getInt("id"));
				empleado.setNombres(resultSet.getString("nombres"));
				empleado.setApellidos(resultSet.getString("apellidos"));
				empleado.setTipo_documento(resultSet.getString("tipo_documento"));
				empleado.setFecha_nacimineto(resultSet.getDate("fecha_nacimiento"));
				empleado.setFecha_vinculacion_emp(resultSet.getDate("fecha_vinculacion_emp"));
				empleado.setCargo(resultSet.getString("cargo"));
				empleado.setSalario(resultSet.getDouble("salario"));
			}	
			conexionEmpleado.close();
			return empleado;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}		
		return null;
	}
	
	/**
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param tipo_documento
	 * @param fecha_nacimineto
	 * @param fecha_vinculacion_emp
	 * @param cargo
	 * @param salario
	 * @return
	 * @throws ParseException
	 */
	public Boolean add(String nombres, String apellidos, String tipo_documento, String fecha_nacimineto, 
			String fecha_vinculacion_emp, String cargo, Double salario) throws ParseException {	
				
		try {
			Connection conexionEmpleado = conexion.getConexion();
			preparedStatement = conexionEmpleado.prepareStatement("insert into empleados (nombres, apellidos, tipo_documento, fecha_nacimiento, fecha_vinculacion_emp, cargo, salario) values (?,?,?,?,?,?,?)");
			preparedStatement.setString(1, nombres);
			preparedStatement.setString(2, apellidos);		
			preparedStatement.setString(3, tipo_documento);
			preparedStatement.setString(4, fecha_nacimineto);
			preparedStatement.setString(5, fecha_vinculacion_emp);
			preparedStatement.setString(6, cargo);
			preparedStatement.setDouble(7, salario);
			preparedStatement.execute();

			return true;			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Boolean delete(int id) {
		
		try {
			Connection conexionEmpleado = conexion.getConexion();
			preparedStatement = conexionEmpleado.prepareStatement("delete from empleados where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			conexionEmpleado.close();
			return true;			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
	
}
