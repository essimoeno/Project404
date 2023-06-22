package project404.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import project404.modelo.interfaces.DAO;
import project404.entities.Juego;

public class JuegoDAO implements DAO<Juego, Integer>{
	

	public JuegoDAO(ServletConfig servletConfig) {
		// TODO Auto-generated constructor stub
	}
	public JuegoDAO() {
		// TODO Auto-generated constructor stub
	}
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	
	public static void abrirConexion(){
		
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
	}

	@Override
	public boolean create(Juego obj) throws SQLException {
		// TODO Auto-generated method stub
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t= sesion.beginTransaction();
		sesion.save(obj);
		t.commit();
		sesion.close();
		return false;
	}

	@Override
	public Juego read(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Juego obj) throws SQLException {
		
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t= sesion.beginTransaction();
		sesion.delete(obj);
		t.commit();
		sesion.close();
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Juego obj) throws SQLException {
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t= sesion.beginTransaction();
		sesion.update(obj);
		t.commit();
		sesion.close();
	// TODO Auto-generated method stub
	return false;
	}

	@Override
	public List<Juego> getValues() throws SQLException {
		// TODO Auto-generated method stub
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL mostrarJuegos").addEntity(Juego.class);
        List<Juego> juegos=(List<Juego>)query.list();
        sesion.close();
        return juegos;
	}

	@Override
	public Juego getValuesById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL juegoById(:id)").addEntity(Juego.class).setParameter("id", id);
        Juego juego=(Juego)query.getSingleResult();
        sesion.close();
        return juego;
	}
	//jess
	public List<Juego> buscarJuegos(String busqueda)throws SQLException{
		abrirConexion();
		 Session sesion=sf.openSession();
	     Query query = sesion.createSQLQuery("CALL buscarJuegos(:busqueda)").addEntity(Juego.class).setParameter("busqueda", busqueda);
	     List<Juego> juegos=(List<Juego>)query.list();
	     sesion.close();
		return juegos;
		
	}
	
	public List<Juego> getRecientes(Integer id_us) {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL juegosRecientes(:id_us)").addEntity(Juego.class)
        		.setParameter("id_us", id_us);
        		
        List<Juego> juegos=(List<Juego>)query.list();
        sesion.close();
        return juegos;
		
	}
	
	public List<Juego> getFavoritos(Integer id_us) {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL getJuegosFav(:id_us)").addEntity(Juego.class)
        		.setParameter("id_us", id_us);
        		
        List<Juego> juegos=(List<Juego>)query.list();
        sesion.close();
        return juegos;
		
	}

}
