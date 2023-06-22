package project404.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project404.modelo.ComentariosDAO;
import project404.modelo.bs.DatosBS;

/**
 * Servlet implementation class servletJuego
 */
@WebServlet("/servletJuego")
public class servletJuego extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletJuego() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String accion = request.getParameter("accion");
		String id_juego = request.getParameter("id_juego");
		
    	if(accion != null) {
			if(accion.equals("jugar")) {
				session.setAttribute("id_juego", id_juego);
				int id_user = (int)session.getAttribute("id_user");
				System.out.println(id_user);
				request.getRequestDispatcher("juego.jsp").forward(request, response);
			}
			
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tiempo = request.getParameter("tiempo");
		String fecha = request.getParameter("fecha");
		String puntos = request.getParameter("puntos");
		String accion = request.getParameter("accion");
		String id_juego_gusta = request.getParameter("id");
		String id_user_gusta = request.getParameter("id_user_gusta");
	    String gusta = request.getParameter("gusta");
	    String noGusta = request.getParameter("noGusta");
	    String id_juego_fav = request.getParameter("id");
	    String fav = request.getParameter("fav");
		HttpSession session = request.getSession();
        
		 if(id_juego_fav!=null && fav!=null) {
			 int id_user = (int)session.getAttribute("id_user");
		    	try {
					DatosBS.juegoFav(id_user , Integer.parseInt(id_juego_fav), Boolean.parseBoolean(fav));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("error.jsp").forward(request, response);e.printStackTrace();
					
				}
		    }
		if(id_juego_gusta!=null && id_user_gusta!=null) {
	    	try {
				DatosBS.gusta(Integer.parseInt(id_user_gusta), Integer.parseInt(id_juego_gusta), Boolean.parseBoolean(gusta), Boolean.parseBoolean(noGusta));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("error.jsp").forward(request, response);
				
			}
	    	   			
	    	try {
				DatosBS.likeYdislike(Integer.parseInt(id_juego_gusta));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
	    	
	    }
        
         if(tiempo!=null ) {
	    	int id_user = (int)session.getAttribute("id_user");
	    	String id_juego = (String)session.getAttribute("id_juego");

	    	try {
				DatosBS.tiempoJuego(id_user, Integer.parseInt(id_juego), tiempo, fecha, Integer.parseInt(puntos));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("error.jsp").forward(request, response);
				
			}
	    }
         ComentariosDAO c = new ComentariosDAO();
	    if(accion != null) {
			if(accion.equals("comentario")) {
				String mensaje = request.getParameter("mensaje");
				int id_user = (int)session.getAttribute("id_user");
		    	String id_juego = (String)session.getAttribute("id_juego");
		    c.insertComentarios(mensaje, id_user, Integer.parseInt(id_juego));
				request.getRequestDispatcher("juego.jsp").forward(request, response);
			}
			
			}
	    
		doGet(request, response);
	}

}