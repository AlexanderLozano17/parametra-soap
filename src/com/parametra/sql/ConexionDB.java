package com.parametra.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

	private Connection conexion;
	private String urlDriverDB = "jdbc:mysql://localhost/";
	private String nombreDB = "parametra_soap";
	private String userDB = "root";
	private String passUserDB = null;
	
	public ConexionDB() {
		
	}
	
	public Connection getConexion() throws SQLException {
		conexion = DriverManager.getConnection(urlDriverDB+nombreDB, userDB, passUserDB);
		return conexion;
	}
	
}
