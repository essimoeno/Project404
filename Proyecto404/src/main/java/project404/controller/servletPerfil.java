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

import project404.modelo.bs.DatosBS;
import project404.modelo.bs.UsuarioBS;

/**
 * Servlet implementation class servletPerfil
 */
@WebServlet("/servletPerfil")
public class servletPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String accion = request.getParameter("accion");
		request.getRequestDispatcher("perfil.jsp").forward(request, response);
		if(accion!=null) {
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
		
		}else if(accion.equals("editar")){
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id_user = (int)session.getAttribute("id_user");
		int num_favs = DatosBS.numFavs(id_user);
		String username = request.getParameter("userperfil");
		String accion = request.getParameter("accion");
		String psw = request.getParameter("pswperfil");
		String psw2 = request.getParameter("pswperfil_r");
		String img = request.getParameter("nuevaimagen");
		String mail =request.getParameter("mailperfil"); 
		String user_comp = request.getParameter("username");
		 PrintWriter out = response.getWriter();
		 UsuarioBS us = new UsuarioBS();
		 try {
			 if(user_comp!="") {
				if(us.comprobarUser(user_comp)) {
					out.print("false");
				} 
			 }else {
				 out.print("empty");
			 }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		if(accion!=null) {
			if(accion.equals("editar")) {
				
				if(img!=null && img.equals("")==false) {
					us.updateImg(img, id_user);
					session.setAttribute("img_user", img);
					
				}
				if(username!=null&& username.equals("")==false) {
					try {
						if(us.comprobarUser(user_comp)) {
							us.updateUsername(username, id_user);
							session.setAttribute("nom_user", username);
						}else {
							out.print(false);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
					
					
					
				}
				
				if(psw!=null&& psw.equals("")==false&&psw.equals(psw2)) {
					try {
						us.updatePsw(psw,id_user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
				}
				
				if(mail!=null&& mail.equals("")==false) {
					try {
						us.updateMail(mail,id_user);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						request.getRequestDispatcher("error.jsp").forward(request, response);
				
					}
					session.setAttribute("mail_user", mail);
				}
				request.getRequestDispatcher("perfil.jsp").forward(request, response);
			}
			
		}
		session.setAttribute("num_favs", num_favs);
	}

}
