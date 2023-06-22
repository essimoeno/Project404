package project404.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project404.entities.Usuario;
import project404.modelo.bs.DatosBS;
import project404.modelo.bs.JuegoBS;
import project404.modelo.bs.UsuarioBS;

/**
 * Servlet implementation class servletHome
 */
@WebServlet("/servletHome")
public class servletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String accion = request.getParameter("accion");
		if(accion!=null) {
		    if(accion.equals("salir")) {
		    	request.getRequestDispatcher("login.jsp").forward(request, response);
		    }else if(accion.equals("home")) {
		    	request.getRequestDispatcher("home.jsp").forward(request, response);
		    }else if(accion.equals("perfil")) {
		    	request.getRequestDispatcher("perfil.jsp").forward(request, response);
		    }else if(accion.equals("estadisticas")) {
		    	request.getRequestDispatcher("estadisticas.jsp").forward(request, response);
				   
		    }else if(accion.equals("admin")) {
		    	String tabla_us;
				try {
					tabla_us = UsuarioBS.pintarTabla();
					session.setAttribute("tabla_us", tabla_us);
					String tablaJu = JuegoBS.pintarTabla();
					session.setAttribute("tabla_ju", tablaJu);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
		    	request.getRequestDispatcher("administrar.jsp").forward(request, response);
		    }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String busqueda = request.getParameter("busqueda");
		String id_juego = request.getParameter("id");
	    String fav = request.getParameter("fav");
	    int id_user = (int)session.getAttribute("id_user");
	    
	    if(id_juego!=null && fav!=null) {
	    	
	    	try {
				DatosBS.juegoFav(id_user , Integer.parseInt(id_juego), Boolean.parseBoolean(fav));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("error.jsp").forward(request, response);
				
			}
	    }
	    if(busqueda!=null) {
				try {
					String resultado = JuegoBS.mostrarBusqueda(busqueda);
					if(resultado!=null) {
						 PrintWriter out = response.getWriter();
						out.print(resultado);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
			
	    }
		doGet(request, response);
	}

}
