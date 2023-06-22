package project404.modelo;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import project404.entities.Comentarios;
import project404.modelo.interfaces.DAO;

public class ComentariosDAO implements DAO<Comentarios, Integer>{

	
	public ComentariosDAO() {
		// TODO Auto-generated constructor stub
	}
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	
	public static void abrirConexion(){
		
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
	}

	@Override
	public boolean create(Comentarios obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comentarios read(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Comentarios obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Comentarios obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Comentarios> getValues() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentarios getValuesById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
				return null;
	}

	public List<Comentarios> getComentariosByJuego(Integer id) throws SQLException {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL mostrarComentarios(:id_juego)").addEntity(Comentarios.class)
        		.setParameter("id_juego", id);
        		
        List<Comentarios> comen=(List<Comentarios>)query.list();
        sesion.close();
        return comen;
	}
	
	public void insertComentarios(String mensaje, Integer id_us,Integer id_ju){
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL insertComentario(:id_juego, :id_us, :comen)";
		Query query = sesion.createSQLQuery(sql)
		    .setParameter("id_juego", id_ju)
		    .setParameter("id_us", id_us)
		    .setParameter("comen", mensaje);
		query.executeUpdate();
		t.commit();
		 sesion.close();
	}
	
	public void delComentarios (Integer id_us) {
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL delComentario(:id_us)";
		Query query = sesion.createSQLQuery(sql)		   
		    .setParameter("id_us", id_us);
		    
		query.executeUpdate();
		t.commit();
		 sesion.close();
	}
	
	public void delComentariosByJuego (Integer id_ju) {
		abrirConexion();
		Session sesion=sf.openSession();
		Transaction t=sesion.beginTransaction();
		String sql = "CALL delComentarioByJuego(:id_ju)";
		Query query = sesion.createSQLQuery(sql)		   
		    .setParameter("id_ju", id_ju);
		    
		query.executeUpdate();
		t.commit();
		 sesion.close();
	} 
	
}