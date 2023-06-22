package project404.modelo;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import project404.entities.Datos;
import project404.entities.Usuario;
import project404.modelo.interfaces.DAO;

public class DatosDAO implements DAO<Datos, Integer>{

	public DatosDAO() {
		// TODO Auto-generated constructor stub
	}
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	
	public static void abrirConexion(){
		
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
	}

	@Override
	public boolean create(Datos obj) throws SQLException {
		
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Datos read(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Datos obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Datos obj) throws SQLException {
		// TODO Auto-generated method stub
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t= sesion.beginTransaction();
		sesion.update(obj);
		t.commit();
		sesion.close();
		return false;
	}

	@Override
	public List<Datos> getValues() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Datos getValuesById(Integer id_us) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public boolean datosByIds(Integer id_us , Integer id_ju) throws SQLException{
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL datosByIds(:id_us, :id_ju)").addEntity(Datos.class)
        		.setParameter("id_us", id_us)
        		.setParameter("id_ju", id_ju);
        if(query.list().size()!=0) {
            sesion.close();
            return true;
        }else {
        	return false;
        }
        
	}
	
	public Datos getValuesByIds(Integer id_us , Integer id_ju) {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL datosByIds(:id_us, :id_ju)").addEntity(Datos.class)
        		.setParameter("id_us", id_us)
        		.setParameter("id_ju", id_ju);
        Datos datos=(Datos)query.uniqueResult();
        sesion.close();
        return datos;
		
	}
	
	
	
	public void updateFav(Integer id_us,Integer id_ju, Boolean fav) {
		abrirConexion();
		Datos dat = new Datos();
		JuegoDAO ju = new JuegoDAO();
		dat.setFavorito(fav);
		
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL updateFav(:id_us, :id_ju, :fav)";
		Query query = sesion.createSQLQuery(sql)
		    .setParameter("id_us", id_us)
		    .setParameter("id_ju", id_ju)
		    .setParameter("fav", fav);
		query.executeUpdate();
		t.commit();
		sesion.close();
	}
	
	
	public void insertDatos(Integer id_us,Integer id_ju, Boolean fav, String tiempo, String fecha, Integer puntos){
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL insertDatos(:id_us, :id_ju, :fav, :tiempo, :date, :points)";
		Query query = sesion.createSQLQuery(sql)
		    .setParameter("id_us", id_us)
		    .setParameter("id_ju", id_ju)
		    .setParameter("fav", fav)
			.setParameter("tiempo",tiempo)
			.setParameter("date",fecha)
		.setParameter("points",puntos);
		query.executeUpdate();
		t.commit();
		 sesion.close();
	}
	
	public void updateDatos(Integer id_us,Integer id_ju, String tiempo, String fecha, Integer puntos) {
		abrirConexion();
		Datos dat = new Datos();
		JuegoDAO ju = new JuegoDAO();
		dat.setTiempo(tiempo);
		String tiempoParaAñadir = calculoTiempoTotal(id_us, id_ju, tiempo);
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL updateTiempo(:id_us, :id_ju, :tiempo, :date, :points)";
		Query query = sesion.createSQLQuery(sql)
		    .setParameter("id_us", id_us)
		    .setParameter("id_ju", id_ju)
		    .setParameter("tiempo", tiempoParaAñadir)
			.setParameter("date", fecha)
		.setParameter("points",puntos);
		query.executeUpdate();
		t.commit();
		sesion.close();
	}
	
	public String calculoTiempoTotal(Integer id_us,Integer id_ju, String tiempo) {
		String tiempo_total = "";
		Datos datos = getValuesByIds(id_us, id_ju);
		String tiempo_base = datos.getTiempo();
		
		//separamos los dos string para poder sumar los valores de forma individual
		String[] parts = tiempo_base.split(":");
		String horas_base = parts[0]; // horas
		String minutos_base = parts[1]; // minutos
		String segundos_base = parts[2]; // segundos
		System.out.println(segundos_base);
		String[] parts2 = tiempo.split(":");
		String horas_nuevo = parts2[0]; // horas
		String minutos_nuevo = parts2[1]; // minutos
		String segundos_nuevo = parts2[2]; // segundos
		System.out.println(segundos_nuevo);
		
		
		//sumamos los valores
		Integer horas_total = Integer.parseInt(horas_base) + Integer.parseInt(horas_nuevo);
		Integer minutos_total = Integer.parseInt(minutos_base) + Integer.parseInt(minutos_nuevo);
		Integer segundos_total = Integer.parseInt(segundos_base) + Integer.parseInt(segundos_nuevo);
		System.out.println(segundos_total);
		
		//ajustamos los valores mayores a 60
		
		while (segundos_total >=60 || minutos_total >= 60) {
			 if (segundos_total>=60){minutos_total= minutos_total + 1;segundos_total=segundos_total-60;}
			    if (minutos_total>=60){horas_total= horas_total+1;minutos_total=minutos_total-60;}
			    
			
		}
		//reconstruimos el string para añadirlo a la base de datos
		tiempo_total = horas_total + ":" + minutos_total + ":" + segundos_total;

		return tiempo_total;
				
	}
	
	
	
	
	public List<Datos> getFavsById(Integer id_us) {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL getFavsByIds(:id_us)").addEntity(Datos.class)
        		.setParameter("id_us", id_us);
        List<Datos> datos=(List<Datos>)query.list();
        sesion.close();
        return datos;
		
	}
	
	public List<Datos> getJugadosById(Integer id_us) {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL jugadosByUser(:id_us)").addEntity(Datos.class)
        		.setParameter("id_us", id_us);
        List<Datos> datos=(List<Datos>)query.list();
        sesion.close();
        return datos;
		
	}
	
	public void updateGusta(Integer id_us,Integer id_ju, Boolean like) {
		abrirConexion();
		Datos dat = new Datos();
		JuegoDAO ju = new JuegoDAO();
		dat.setGusta(like);
		
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL updateGusta(:id_us, :id_ju, :gusta)";
		Query query = sesion.createSQLQuery(sql)
		    .setParameter("id_us", id_us)
		    .setParameter("id_ju", id_ju)
		    .setParameter("gusta", like);
		query.executeUpdate();
		t.commit();
		sesion.close();
	}
	
	public void updateNoGusta(Integer id_us,Integer id_ju, Boolean like) {
		abrirConexion();
		Datos dat = new Datos();
		JuegoDAO ju = new JuegoDAO();
		dat.setNogusta(like);
		
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL updateNoGusta(:id_us, :id_ju, :gusta)";
		Query query = sesion.createSQLQuery(sql)
		    .setParameter("id_us", id_us)
		    .setParameter("id_ju", id_ju)
		    .setParameter("gusta", like);
		query.executeUpdate();
		t.commit();
		sesion.close();
	}
	
	public List<Datos> datosByIdJuego(Integer id_ju) {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL datosByIdJuego(:id_juego)").addEntity(Datos.class)
        		.setParameter("id_juego", id_ju);
        List<Datos> datos=(List<Datos>)query.list();
        sesion.close();
        return datos;
		
	}
	
	public List<Datos> getPuntuaciones(Integer id_ju) {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL getPuntuaciones(:id_juego)").addEntity(Datos.class)
        		.setParameter("id_juego", id_ju);
        List<Datos> datos=(List<Datos>)query.list();
        sesion.close();
        return datos;
		
	}
	
	public String getLastGame(Integer id_us) {
		try {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL lastPlayed(:id_us)")
        		.setParameter("id_us", id_us);
        String juego=(String)query.getSingleResult();
        sesion.close();
        return juego;
		}catch (NoResultException e)  {
			return null;
		}
        
		
	}
	
	public String getMostPlayed(Integer id_us) {
		try {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL mostPlayed(:id_us)")
        		.setParameter("id_us", id_us);
        String juego=(String)query.getSingleResult();
        sesion.close();
        return juego;
		}catch (NoResultException e)  {
			return null;
		}
        
		
	}
	
	public void delDatos (Integer id_us) {
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL delDatos(:id_us)";
		Query query = sesion.createSQLQuery(sql)		   
		    .setParameter("id_us", id_us);
		    
		query.executeUpdate();
		t.commit();
		 sesion.close();
	}

	public void delDatosByJuego (Integer id_ju) {
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL 	delDatosByJuego(:id_ju)";
		Query query = sesion.createSQLQuery(sql)		   
		    .setParameter("id_ju", id_ju);
		    
		query.executeUpdate();
		t.commit();
		 sesion.close();
	}

}