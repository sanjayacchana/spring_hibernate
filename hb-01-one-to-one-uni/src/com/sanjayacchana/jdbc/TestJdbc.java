package com.sanjayacchana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcurl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to DB: "+jdbcurl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcurl,user,password);
			
			System.out.println("Connection is Successfull: "+myConn);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
