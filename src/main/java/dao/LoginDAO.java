package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.usuario;
import db.dbConexion;

public class LoginDAO {
	

	public usuario logueo(String email, String password) {
		usuario usuario = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
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
	
	
	public static void changePass(String email, String password) throws SQLException {
        Connection con = dbConexion.getConexion();
        PreparedStatement st = con.prepareStatement("UPDATE Usuario SET password=? WHERE email=?");
        st.setString(1, password);
        st.setString(2, email);
        st.executeUpdate();
        con.close();
    }
	
}
	