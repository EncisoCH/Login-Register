package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.usuario;
import db.dbConexion;

public class RegisterDAO {
	

	public static void registerUser(usuario us) throws SQLException {
	    String sql = "INSERT INTO Usuario" +
	        "  (nombre, apellido, email, password) VALUES " +
	        " (?, ?, ?, ?);";

	    try (Connection connection = dbConexion.getConexion();
	        // Step 2:Create a statement using connection object
	        PreparedStatement ps = connection.prepareStatement(sql)) {
	    	ps.setString(1, us.getName());
	    	ps.setString(2, us.getApellidos());
	    	ps.setString(3, us.getEmail());
	    	ps.setString(4, us.getPassword());

	        System.out.println(ps);
	        // Step 3: Execute the query or update query
	        int result = ps.executeUpdate();
	        if (result == 0) {
	            throw new SQLException("La inserción de datos en la base de datos falló");
	        }
	    } catch (SQLException e) {
	        // process sql exception
	        printSQLException(e);
	        throw e;
	    }
	}
	
	private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
