package project404.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project404.modelo.bs.JuegoBS;
import project404.modelo.bs.UsuarioBS;

@WebServlet("/servletAdmin")
public class servletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		HttpSession session = request.getSession();
		String idDel = request.getParameter("iddel");
		if(accion!=null) {
			if (accion.equals("borrar")) {
				
				try {
					UsuarioBS.delUsuario(Integer.parseInt(idDel));
					String tablaUs = UsuarioBS.pintarTabla();
					session.setAttribute("tabla_us", tablaUs);
				} catch (NumberFormatException e) {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				} catch (SQLException e) {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else if(accion.equals("borrarjuego")) {
				try {
					JuegoBS.delJuego(Integer.parseInt(idDel));
					String tablaJu = JuegoBS.pintarTabla();
					session.setAttribute("tabla_ju", tablaJu);
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
			
			
		}
		

		request.getRequestDispatcher("administrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accion = request.getParameter("accion");
		String username = request.getParameter("username");
		String usermail = request.getParameter("usermail");
		String userpsw = request.getParameter("userpsw");
		String useradmin = request.getParameter("esAdmin");
		
		String juname = request.getParameter("juname");
		String descripcion = request.getParameter("descripcion");
		String jutipo = request.getParameter("jutipo");
		String juimg = request.getParameter("juimg");
		String juiframe = request.getParameter("juiframe");
		ArrayList<String> resp;
		
		
		String id_des = request.getParameter("id");
		String des = request.getParameter("des");
		
		if(id_des!=null && des!=null) {
			try {
				JuegoBS.juegoDestacado(Integer.parseInt(id_des), Boolean.parseBoolean(des));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}

		if (accion != null) {
			if (accion.equals("addUser")) {
				try {

					resp = UsuarioBS.comprobarUserMail(usermail, username, userpsw, useradmin);
					request.setAttribute("respuesta_adduser", resp);
					String tablaUs = UsuarioBS.pintarTabla();
					session.setAttribute("tabla_us", tablaUs);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}else if(accion.equals("addJuego")) {
				try {

					JuegoBS.addJuego(juname, descripcion, jutipo, juimg, juiframe);
					String tablaJu = JuegoBS.pintarTabla();
					session.setAttribute("tabla_ju", tablaJu);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
		}
		doGet(request, response);
	}
}
