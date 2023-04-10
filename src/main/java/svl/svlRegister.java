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
	    String apellido = request.getParameter("apellido");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    if (nombre == null || nombre.isEmpty() || 
	    	apellido == null || apellido.isEmpty() || 
	    	email == null || email.isEmpty() || 
	    	password == null || password.isEmpty()) {
	    	
	        // Redirigir al usuario a la página de registro con mensaje de error
	        request.setAttribute("mensaje", "Todos los campos son obligatorios");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
	        dispatcher.forward(request, response);
	        return;
	    }

	    usuario usu = new usuario(nombre, apellido, email, password);
	    usu.setName(nombre);
	    usu.setApellidos(apellido);
	    usu.setEmail(email);
	    usu.setPassword(password);

	    try {
	        RegisterDAO.registerUser(usu);
	        request.setAttribute("mensaje", "Tus datos fueron alamacenados exitosamente");
	        request.setAttribute("registroExitoso", true);
	        response.sendRedirect("Register.jsp");
	    } catch (SQLException e) {
	        request.setAttribute("mensaje", "Los datos ingresados no se almacenaron dentro de la base de datos");
	        e.printStackTrace();
	        request.setAttribute("registroFallido", true);
	        response.sendRedirect("Register.jsp");
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
