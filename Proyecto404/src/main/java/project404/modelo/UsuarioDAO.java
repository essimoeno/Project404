package project404.modelo;
import project404.modelo.interfaces.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import project404.entities.Datos;
import project404.entities.Usuario;

public class UsuarioDAO implements DAO<Usuario, Integer>{

	public UsuarioDAO(ServletConfig servletConfig) {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	
	public static void abrirConexion(){
		
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
	}
	
	

	@Override
	public boolean create(Usuario obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario read(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Usuario obj) throws SQLException {
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
	public boolean update(Usuario obj) throws SQLException {
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
	public List<Usuario> getValues () throws SQLException{
		// TODO Auto-generated method stub
		abrirConexion();

	    Session sesion=sf.openSession();
	    Query query = sesion.createSQLQuery("CALL  recuperarUsuarios").addEntity(Usuario.class);
	        List<Usuario> usuarios=query.list();
	        sesion.close();
	        return usuarios;
	}

	@Override
	public Usuario getValuesById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL usuarioById(:id)")
        		.addEntity(Usuario.class)
        		.setParameter("id", id);
        Usuario user=(Usuario)query.getSingleResult();
        sesion.close();
        return user;
	}
	
	public Usuario getValuesByName(String nom) throws Exception{
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL usuarioByName(:nom)")
        		.addEntity(Usuario.class)
        		.setParameter("nom", nom);
        Usuario user=(Usuario)query.getSingleResult();
        sesion.close();
        return user;
		
	}
	public static String cogerpsw(String user) {
		abrirConexion();
        String psw=null;
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL cogerpsw(:usuario_e)")
                  .addEntity(Usuario.class)
                  .setParameter("usuario_e", user);
        if(query.list().size()!=0) {
            Usuario usuario=(Usuario)query.getSingleResult();
            psw=usuario.getPass_usuario();
            sesion.close();
        }

        return psw;
	}
	
	//----REGISTRO----
	
	public static void insertUsuario(String usuario,String correo, String pswd,String rol) {
		abrirConexion();
		Usuario usu = new Usuario();
		if(rol!=null&&rol.equals("admin")) {
			usu.setRol(rol);
		}
		usu.setNombre_usuario(usuario);
		usu.setCorreo_usuario(correo);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		usu.setPass_usuario(passwordEncoder.encode(pswd));
		 Session sesion=sf.openSession();
		 Transaction t=sesion.beginTransaction();
		 sesion.save(usu);
		 t.commit();
		 sesion.close();
	}
	
	
	// ----login------
	public static boolean loginUsuario(String user, String psw) throws Exception{
		abrirConexion();
        boolean ok=true;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String otra_psw = cogerpsw(user);
        if(otra_psw==null) {
            ok=false;
        }else {
            boolean comp=passwordEncoder.matches(psw, otra_psw);
            if(comp==false) {
                ok=false;
            }
        }
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL loginUsuario(:user, :psw)")
                .addEntity(Usuario.class)
                .setParameter("user", user)
                .setParameter("psw", psw);
        //JPQL: form Entidad
        if(query.list().size()!=0) {
            ok=false;
        }

        sesion.close();
        return ok;
	}
	
	//-----------Perfil---------------------
	
	
	
	public Usuario getUserByMail(String mail)  {
		try {
		abrirConexion();
        Session sesion=sf.openSession();
        Query query = sesion.createSQLQuery("CALL userByMail(:mail)")
        		.addEntity(Usuario.class)
        		.setParameter("mail", mail);
        Usuario user=(Usuario)query.getSingleResult();
        sesion.close();
        return user;
        }catch (NoResultException e) {
        	return null;
        }
		
	}

}
