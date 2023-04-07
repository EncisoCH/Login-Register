package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.usuario;
import db.dbConexion;

public class LoginDAO {
	
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public usuario logueo(String email, String password) {
		usuario usuario = null;
		
		try {
			// Obtener la conexión a la base de datos
			cn = dbConexion.getConexion();
			
			String sql = "SELECT email, password FROM Usuario WHERE email = ? AND password = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				usuario = new usuario();
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (ps != null) {
					ps.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return usuario;
	}
	
	
	public boolean cambiarContraseña(String email, String passwordActual, String newPass) {
		
		boolean resultado = false;
		
	    try {
	        // Obtener la conexión a la base de datos
	        cn = dbConexion.getConexion();

	        // Actualizar la contraseña del usuario
	        String sql = "UPDATE Usuario SET password = ? WHERE email = ?";
	        ps = cn.prepareStatement(sql);
	        ps.setString(1, newPass);
	        ps.setString(2, email);
	        int filasAct = ps.executeUpdate();

	        if (filasAct == 1) {
	            resultado = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }

	            if (cn != null) {
	                cn.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }

	    return resultado;
	}
	
}
	