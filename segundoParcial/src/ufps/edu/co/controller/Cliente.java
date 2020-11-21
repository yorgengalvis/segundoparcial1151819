package ufps.edu.co.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import ufps.edu.co.dao.ClienteDAO;

/**
 * Servlet implementation class Cliente
 */
@WebServlet("/Cliente/*")
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		//response.getWriter().append("Hola mama"+action).append(request.getContextPath());
		switch(action) {
		case "login": request.getRequestDispatcher("vistas/login.jsp").forward(request, response);
			break;
		case "registro": request.getRequestDispatcher("vistas/registro.jsp").forward(request, response);
		break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch(action) {
		case "ingresar": 
			String email=request.getParameter("inputEmail");
			String password=request.getParameter("inputPassword");
			ClienteDAO cliented=new ClienteDAO();
			List<ufps.edu.co.model.Cliente> lista=cliented.list();
			for(ufps.edu.co.model.Cliente c:lista) {
				if(c.getEmail().equals(email) && c.getClave().equals(password)) {
					request.getRequestDispatcher("vistas/servicios.jsp?userid="+c.getId()).forward(request, response);
				}
			}
		break;
		}
		doGet(request, response);
	}

}
