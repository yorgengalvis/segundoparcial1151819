package ufps.edu.co.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ufps.edu.co.dao.TiendaDAO;

/**
 * Servlet implementation class Tienda
 */
@WebServlet("/Tienda/*")
public class Tienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tienda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		switch(action) {
		case "registrar": 
			String nombre=request.getParameter("inputNombre");
			String lema=request.getParameter("inputLema");
			String descripcion=request.getParameter("inputDescripcion");
			String email=request.getParameter("inputEmail");
			String clave=request.getParameter("inputPassword");
			String dueño=request.getParameter("inputPropietario");
			String facebook=request.getParameter("inputFacebook");
			String web=request.getParameter("inputWeb");
			String imagen=request.getParameter("inputImagen");
			ufps.edu.co.model.Tienda t=new ufps.edu.co.model.Tienda(nombre,lema,descripcion,email,clave,dueño,facebook,web,imagen);
			TiendaDAO tdo=new TiendaDAO();
			tdo.insert(t);
			request.getRequestDispatcher("vistas/login.jsp").forward(request, response);
			break;
		}
		
		doGet(request, response);
	}

}
