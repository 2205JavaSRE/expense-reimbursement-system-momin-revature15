package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static String URL ="jdbc:postgresql://database-2.cybxradz0p9n.us-east-1.rds.amazonaws.com:5432/postgres";
	private static String USERNAME = "java_login";
	private static String PASSWORD = "khan1515";
	
	private static Connection connection;

	public static Connection getConnection() {

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return connection;
	}

}