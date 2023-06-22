package project404.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="usuario")
public class Usuario {
	private String nombre_usuario;
	private String pass_usuario;
	private String correo_usuario;
	@Column(nullable = false, columnDefinition = "varchar(100) default 'user'")
	private String rol="user";
	
	@Column(nullable = false, columnDefinition = "varchar(255) default 'img/maquina.png'")
	private String imagen = "img/maquina.png";
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_usuario;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	

	public Usuario(String nombre_usuario, String pass_usuario, String correo_usuario, String rol, String imagen,
			int id_usuario) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.pass_usuario = pass_usuario;
		this.correo_usuario = correo_usuario;
		this.rol = rol;
		this.imagen = imagen;
		this.id_usuario = id_usuario;
	}



	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPass_usuario() {
		return pass_usuario;
	}
	public void setPass_usuario(String pass_usuario) {
		this.pass_usuario = pass_usuario;
	}
	public String getCorreo_usuario() {
		return correo_usuario;
	}
	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	@Override
	public String toString() {
		return "Usuario [nombre_usuario=" + nombre_usuario + ", pass_usuario=" + pass_usuario + ", correo_usuario="
				+ correo_usuario + ", rol=" + rol + ", imagen=" + imagen + ", id_usuario=" + id_usuario + "]";
	}





	


}
