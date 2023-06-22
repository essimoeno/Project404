package project404.modelo.bs;

import java.sql.SQLException;
import java.util.List;

import project404.entities.Datos;
import project404.entities.Juego;
import project404.modelo.DatosDAO;
import project404.modelo.JuegoDAO;
import project404.modelo.UsuarioDAO;

public class DatosBS {

	public DatosBS() {
		// TODO Auto-generated constructor stub
	}
	
	public static void juegoFav(Integer id_user,Integer id_juego, boolean fav) throws SQLException {
			
			DatosDAO d = new DatosDAO();
			
			//AQUÍ PIDO DATOS, SI ES FALSE HACEMOS INSERT, SINO SE HACE UPDATEFAV
			
			if(d.datosByIds(id_user, id_juego) ==false) {
				d.insertDatos(id_user, id_juego, fav, "0:0:0", "Todavía no has jugado a este juego",0);
			}else {
				d.updateFav(id_user, id_juego, fav);
			}
			
		}
		
	public static void tiempoJuego(Integer id_user,Integer id_juego, String tiempo, String fecha, Integer puntos) throws SQLException {
			
			DatosDAO d = new DatosDAO();
			
			//AQUÍ PIDO DATOS, SI ES FALSE HACEMOS INSERT, SINO SE HACE UPDATEFAV
			
			if(d.datosByIds(id_user, id_juego) ==false) {
	
				d.insertDatos(id_user, id_juego, false, tiempo, fecha, puntos);
			}else {
				d.updateDatos(id_user, id_juego, tiempo, fecha, puntos);
			}
			
	}
	
	
	public static int numFavs(Integer id_user) {
		DatosDAO d = new DatosDAO();
		List<Datos> lista = d.getFavsById(id_user);
		Integer num = lista.size();
		return num;
		
	}
	
	public static int numJugados(Integer id_user) {
		DatosDAO d = new DatosDAO();
		List<Datos> lista = d.getJugadosById(id_user);
		Integer num = lista.size();
		return num;
		
	}
	
	public static int puntosTotales(Integer id_user) {
		DatosDAO d = new DatosDAO();
		List<Datos> lista = d.getJugadosById(id_user);
		int num = 0;
		for(int i = 0; i < lista.size();i++) {
			num = num +lista.get(i).getPuntos();
		}
		return num;
		
	}
	
	public static String tiempoTotal(Integer id_user) {
		DatosDAO d = new DatosDAO();
		List<Datos> lista = d.getJugadosById(id_user);
		String tiempoTotal = "";
		Integer h = 0;
		Integer m = 0;
		Integer s = 0;
		for(int i = 0; i < lista.size();i++) {
			String[] parts = lista.get(i).getTiempo().split(":");
			String horas_base = parts[0]; // horas
			String minutos_base = parts[1]; // minutos
			String segundos_base = parts[2]; // segundos
			System.out.println(lista.get(i).getTiempo());
			h = h + Integer.parseInt(horas_base);
			m = m+ Integer.parseInt(minutos_base);
			s = s + Integer.parseInt(segundos_base);

		}
		
		while (s >=60 || m >= 60) {
			 if (s>=60){m= m + 1;s=s-60;}
			    if (m>=60){h= h+1;m=m-60;}
			    
			    
			    
			
		}
		tiempoTotal = h + ":" + m + ":" + s;

		return tiempoTotal;
		
	}
	
	
public static void gusta(Integer id_user,Integer id_juego, boolean gusta, boolean noGusta) throws SQLException {
		
		DatosDAO d = new DatosDAO();
		
		//AQUÍ PIDO DATOS, SI ES FALSE HACEMOS INSERT, SINO SE HACE UPDATEFAV
		
		if(d.datosByIds(id_user, id_juego) ==false) {

			d.insertDatos(id_user, id_juego, false, "0:0:0", "Todavía no has jugado a este juego",0);
		}else {
			d.updateGusta(id_user, id_juego, gusta);
			d.updateNoGusta(id_user, id_juego, noGusta);
		}
				
}
	
	public static void likeYdislike(Integer id_juego) throws SQLException{
		DatosDAO d = new DatosDAO();
		JuegoDAO j = new JuegoDAO();
		List<Datos> lista = d.datosByIdJuego(id_juego);
		int likes = 0;
		int dislikes = 0;
		for(int i = 0; i < lista.size();i++) {
			
			if(lista.get(i).isGusta()) {
				likes = likes + 1;
			}
			if(lista.get(i).isNogusta()) {
				dislikes = dislikes + 1;
			}
		}
		Juego ju = j.getValuesById(id_juego);
		ju.setGusta(likes);
		ju.setNogusta(dislikes);
		j.update(ju);
	}
	
	public static String lastPlayed(Integer id_us) {
		
		DatosDAO dat = new DatosDAO();
		String juego = dat.getLastGame(id_us);
		if(juego!=null && juego!="") {
			return juego;
		}else {
			return "Todavía no has jugado a nada ";
		}
		
		
	}
	
	public static String mostPlayed(Integer id_us) {
		
		DatosDAO dat = new DatosDAO();
		String juego = dat.getMostPlayed(id_us);
		if(juego!=null && juego!="") {
			return juego;
		}else {
			return "No hay datos ";
		}
		
		
	}

}

