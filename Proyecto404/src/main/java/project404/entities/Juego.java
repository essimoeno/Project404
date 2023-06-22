package project404.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
	@Table(name="juegos")
public class Juego {
	private String nombre;
	private String tipo;
	private String iframe;
	private String imagen;
	private String descripcion;
	@Column(nullable = false, columnDefinition = "integer(11) default 0")
	private int gusta=0;
	@Column(nullable = false, columnDefinition = "integer(11) default 0")
	private int nogusta;
	@Column(nullable = false, columnDefinition = "boolean default false")
	private Boolean destacado = false;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	public Juego() {
		// TODO Auto-generated constructor stub
		
	}

	public Juego(String nombre, String tipo, String iframe, String imagen,String descripcion, int id) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.iframe = iframe;
		this.imagen = imagen;
		this.id = id;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIframe() {
		return iframe;
	}

	public void setIframe(String iframe) {
		this.iframe = iframe;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", tipo=" + tipo + ", iframe=" + iframe + ", imagen=" + imagen
				+ ", descripcion=" + descripcion + ", id=" + id + "]";
	}

	public int getGusta() {
		return gusta;
	}

	public void setGusta(int gusta) {
		this.gusta = gusta;
	}

	public int getNogusta() {
		return nogusta;
	}

	public void setNogusta(int nogusta) {
		this.nogusta = nogusta;
	}

	public Boolean getDestacado() {
		return destacado;
	}

	public void setDestacado(Boolean destacado) {
		this.destacado = destacado;
	}

	
	

}