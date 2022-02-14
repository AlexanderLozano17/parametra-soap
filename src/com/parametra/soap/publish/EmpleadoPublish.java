package com.parametra.soap.publish;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.ws.Endpoint;

import com.parametra.entity.EmpleadoEntity;
import com.parametra.impl.EmpleadoImpl;

public class EmpleadoPublish {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:1515/ws/empleado", new EmpleadoImpl());		
	}
}


