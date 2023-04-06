package svl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import bean.usuario;
import dao.RegisterDAO;


public class svlRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public svlRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	response.setContentType("text/html;charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
		
    	String nombre = request.getParameter("name");
	    String lastname = request.getParameter("lastname");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    usuario usu = new usuario(nombre, lastname, email, password);
	    usu.setName(nombre);
	    usu.setApellidos(lastname);
	    usu.setEmail(email);
	    usu.setPassword(password);

	    try {
	        RegisterDAO.registerUser(usu);
	        request.setAttribute("mensaje", "El e-mail y contraseña fueron guardadas de forma exitosa en el sistema");
	        response.sendRedirect("Login.jsp");
	    } catch (SQLException e) {
	        request.setAttribute("mensaje", "Los datos ingresados no se almacenaron en la base de datos");
	        e.printStackTrace();
	        RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
	        rd.forward(request, response);
	    }
	}
	
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
