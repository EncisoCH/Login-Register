package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConexion {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String _URL = "jdbc:mysql://localhost:3306/Login";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection getConexion() {
	    Connection conn = null;
	    
	    try {
	        // Register JDBC driver
	        Class.forName(JDBC_DRIVER);

	        // Open a connection
	        conn = DriverManager.getConnection(_URL, USER, PASSWORD);

	        System.out.println("Connection successful");
	    } catch (SQLException se) {
	        // Handle errors for JDBC
	        System.out.println("SQL Exception: " + se.getMessage());
	        se.printStackTrace();
	    } catch (Exception e) {
	        // Handle errors for Class.forName
	        System.out.println("Exception: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return conn;
	}
}
