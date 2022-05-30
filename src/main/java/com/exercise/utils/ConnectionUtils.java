package com.exercise.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
 	private static final String DB_URL = "jdbc:mysql://localhost:3306/javasql42022";
 	private static final String USER = "root";
 	private static final String PASS = "0915404712Nam";
 	
 	public static Connection getConnection() throws SQLException {
 		Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
 		return conn;
 	}

}
