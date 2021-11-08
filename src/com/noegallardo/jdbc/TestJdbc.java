package com.noegallardo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:oracle:thin:hbstudent/hbstudent@localhost:51521/hb_student_tracker";
		//String user = "hbstudent";
		//String pass = "hbstudent";
		
		try {
			
			System.out.println("Connection with database "+jdbcUrl);	
			Connection myConnn = DriverManager.getConnection(jdbcUrl);
			
			System.out.println("Connectios Successfully!!!");
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
