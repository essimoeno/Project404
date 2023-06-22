package project404.modelo.bs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import project404.entities.Usuario;
import project404.modelo.ComentariosDAO;
import project404.modelo.DatosDAO;
import project404.modelo.UsuarioDAO;

public class UsuarioBS {

	public UsuarioBS() {
		// TODO Auto-generated constructor stub
	}
	public static Usuario valuesByName(String nom) throws Exception {
		if(nom!=null) {
			UsuarioDAO us = new UsuarioDAO();
			Usuario user = us.getValuesByName(nom);
			return user;
		}else {
			return null;
		}
		
	}
	
	public static Usuario valuesById(int id_us) throws SQLException {
		UsuarioDAO us = new UsuarioDAO();
		Usuario u =us.getValuesById(id_us);
		return u;
		
	}
	
	public void updateUsername(String nom, int id_us) throws SQLException {
		if(nom!=null) {
			UsuarioDAO us = new UsuarioDAO();
			Usuario u = us.getValuesById(id_us);
			u.setNombre_usuario(nom);
			us.update(u);
		}
		
	}
	
	public void updateImg(String img, int id_us) {
		if(img!=null) {
			UsuarioDAO us = new UsuarioDAO();
			try {
				Usuario u = us.getValuesById(id_us);
				u.setImagen(img);
				us.update(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void updatePsw(String psw, int id_us) throws SQLException {
		if(psw!=null) {
			UsuarioDAO us = new UsuarioDAO();
			Usuario u = us.getValuesById(id_us);
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			u.setPass_usuario(passwordEncoder.encode(psw));
			us.update(u);
		}
		
	}
	public void updateMail(String mail, int id_us) throws SQLException {
		if(mail!=null) {
			UsuarioDAO us = new UsuarioDAO();
			Usuario u = us.getValuesById(id_us);
			u.setCorreo_usuario(mail);
			us.update(u);
		}
		
	}
	
	public static ArrayList<String> comprobarUserMail(String mail, String user, String psw, String rol) throws SQLException {
		UsuarioDAO us = new UsuarioDAO();
		List<Usuario> usuarios= us.getValues();
		ArrayList<String> respuesta = new ArrayList<String>();
		Boolean salir = false;
		Integer pos = 0;
		do {
			
			if(pos < usuarios.size()) {
				if (usuarios.get(pos).getCorreo_usuario().equals(mail)) {
					respuesta.add("Ya hay un usuario registrado con ese correo");
					salir = true;
				}else if(usuarios.get(pos).getNombre_usuario().equals(user)) {
					respuesta.add("Nombre de usuario no disponible") ;
					salir = true;
				}
				pos++;
			}else {
				UsuarioDAO.insertUsuario(user, mail, psw,rol);
				
				respuesta.add("Usuario registrado !!");
				salir = true;
			}
		
		}while(salir == false);
		
		return respuesta;
		
	}
	
	public boolean comprobarUser(String user) throws SQLException {
		UsuarioDAO us = new UsuarioDAO();
		List<Usuario> usuarios= us.getValues();
		Boolean ok = true;
		Boolean salir = true;
		Integer pos = 0;
		do {
			if(pos < usuarios.size()) {
				if(usuarios.get(pos).getNombre_usuario().equals(user)) {
					ok = false;
					salir=false;
				}
				pos++;
			}else {
				ok=true;
				salir=false;
				
			}
		
		}while(salir == true);
		
		return ok;
		
	}
	
	public static boolean loginUsuario(String user, String psw) throws Exception {
		
		if(UsuarioDAO.loginUsuario(user, psw)==true) {
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
	
	public static String pintarTabla() throws SQLException {
		UsuarioDAO udao = new UsuarioDAO();
		List<Usuario> us= udao.getValues();
		String tabla="";
			if(us!=null){
			
				for(int i=0;i<us.size();i++){
					
					tabla+="<tr><td>"+us.get(i).getId_usuario()+"</td>";
					tabla+="<td>"+us.get(i).getNombre_usuario()+"</td>";
					tabla+="<td>"+us.get(i).getCorreo_usuario()+"</td>";
					tabla+="<td><a href='servletAdmin?accion=borrar&iddel="+us.get(i).getId_usuario()+"'><i class=\"bi bi-person-x-fill\" style='color:rgb(245, 71, 119)'></i></a></td></tr>";
				}
		}
		return tabla;
	}
	
	public static void delUsuario(Integer id_us) throws SQLException {
		UsuarioDAO us = new UsuarioDAO();
		ComentariosDAO c = new ComentariosDAO();
		DatosDAO d = new DatosDAO();
		Usuario user = us.getValuesById(id_us);
		us.delete(user);
		c.delComentarios(id_us);
		d.delDatos(id_us);
	}
	
	public static String  pswByMail(String mail) throws SQLException{
		UsuarioDAO usdao = new UsuarioDAO();
		Usuario us = usdao.getUserByMail(mail);
		
		if(us!=null) {
			
			String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        Random random = new Random();
	        int longitud = random.nextInt(6) + 5; // Genera una longitud aleatoria entre 5 y 10
	        StringBuilder resultado = new StringBuilder();
	        for (int i = 0; i < longitud; i++) {
	            int indice = random.nextInt(caracteres.length());
	            resultado.append(caracteres.charAt(indice));
	        }
	        String codificado = resultado.toString();
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			us.setPass_usuario(passwordEncoder.encode(codificado.toString()));
			usdao.update(us);
			
			return resultado.toString();
		}else {
			return "";
		}
		  
		
		
	}

}
