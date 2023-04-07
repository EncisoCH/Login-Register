package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConexion {

	private static final String _JDBC = "com.mysql.jdbc.Driver";
	private static final String _URL = "jdbc:mysql://localhost:3306/Login";
	private static final String _USER = "root";
	private static final String _PASSWORD = "";

	public static Connection getConexion() {
	    Connection cn = null;
	    
	    try {
	        // Register JDBC driver
	        Class.forName(_JDBC);

	        // Open a connection
	        cn = DriverManager.getConnection(_URL, _USER, _PASSWORD);

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

	    return cn;
	}
}
