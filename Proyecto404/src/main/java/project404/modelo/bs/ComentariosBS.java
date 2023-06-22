package project404.modelo.bs;

import java.util.List;

import project404.entities.Comentarios;
import project404.modelo.ComentariosDAO;

public class ComentariosBS {

	public ComentariosBS() {
		// TODO Auto-generated constructor stub
	}
	
	public static String pintarComentarios(int id_juego) throws Exception{
		ComentariosDAO comenDAO = new ComentariosDAO();

		List<Comentarios> comen = comenDAO.getComentariosByJuego(id_juego);
		String tabla= "";
		tabla += "<h2 class=\"titulo\">Comentarios</h2>\r\n"
				+ "            <div class=\"comment-box\"> \r\n"
				+ "               <form method='post' action='servletJuego?accion=comentario'> \r\n"
				+ "               <input  type='text' name='mensaje'> \r\n"
				+ "               <input type='submit'> \r\n"
				+ "               </form><hr>";
	
		
			if(comen!=null){
				for (int i = 0; i < comen.size(); i++) {
					
				String mensaje = comen.get(i).getComentario();		
				String user = comen.get(i).getUsuario().getNombre_usuario();
				String avatar = comen.get(i).getUsuario().getImagen();
				tabla += "<div class=\"comment\">\r\n"
						+ "                 <div class=\"comment-avatar\"> \r\n"
						+ "                  <img src='"+avatar+"' alt=\"\">\r\n"
						+ "                </div> \r\n"
						+ "                 <div class=\"comment-content\"> \r\n"
						+ "                 <h4>"+user+"</h4> \r\n"
						+ "                 <p>"+mensaje+"</p> \r\n"
						+ "                 </div> \r\n"
						+ "             </div>";
				
				}
				
		}
			tabla+= "</div>";

		return tabla;
	}
}