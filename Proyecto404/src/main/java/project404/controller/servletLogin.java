package project404.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project404.entities.Usuario;
import project404.modelo.bs.DatosBS;
import project404.modelo.bs.UsuarioBS;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String accion = request.getParameter("accion");
		String nomlogin = request.getParameter("nombrelogin");
		String passlogin = request.getParameter("passlogin");
		String rol_registro = "user";
		if (accion != null) {
			if (accion.equals("registrar")) {
				
				String email_registro = request.getParameter("email_registro");
				String usuario_registro = request.getParameter("usuario_registro");
				String password_registro = request.getParameter("password_registro");
				ArrayList<String> resp;
				try {

					resp = UsuarioBS.comprobarUserMail(email_registro, usuario_registro, password_registro,
							rol_registro);
					request.setAttribute("respuesta_registro", resp);
					request.getRequestDispatcher("login.jsp").forward(request, response);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}

			}
			if (accion.equals("login")) {
				try {
					if (UsuarioBS.loginUsuario(nomlogin, passlogin) == true) {
						Usuario us;
						try {
							us = UsuarioBS.valuesByName(nomlogin);
							session.setAttribute("id_user", us.getId_usuario());
						session.setAttribute("nom_user", us.getNombre_usuario());
						session.setAttribute("img_user", us.getImagen());
						session.setAttribute("mail_user", us.getCorreo_usuario());
						session.setAttribute("rol_user", us.getRol());
						request.getRequestDispatcher("home.jsp").forward(request, response);

						} catch (Exception e) {
							// TODO Auto-generated catch block
							request.getRequestDispatcher("error.jsp").forward(request, response);
							
						}
						
						// request.getRequestDispatcher("error.jsp").forward(request, response);
					} else {
						request.setAttribute("respuesta_login", "no");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
		}
		
	}    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String accion = request.getParameter("accion");
		String nomlogin = request.getParameter("nombrelogin");
		String passlogin = request.getParameter("passlogin");
		String email = request.getParameter("f_mail");
		if(email!=null) {
			try {
				String resultado =UsuarioBS.pswByMail(email);
				PrintWriter out = response.getWriter();
				out.print(resultado);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
			
		}
		
		doGet(request, response);
	}

}
