package ufps.edu.co.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ufps.edu.co.dao.SeguirPkDAO;
import ufps.edu.co.dao.TiendaDAO;
import ufps.edu.co.model.SeguirPK;

/**
 * Servlet implementation class Servicios
 */
@WebServlet("/Servicios/*")
public class Servicios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servicios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String userid=request.getParameter("userid");
		SeguirPkDAO seguir=new SeguirPkDAO();
		List<SeguirPK> lista=seguir.list();
		for(SeguirPK sp:lista) {
			if(sp.getCliente()==Integer.parseInt(userid)) {
				TiendaDAO t=new TiendaDAO();
				request.getRequestDispatcher("vistas/servicios.jsp?tiendaid="+t.find(sp.getTienda()).getId()).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
