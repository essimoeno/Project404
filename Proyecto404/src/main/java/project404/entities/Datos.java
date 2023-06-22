package project404.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
	@Table(name="datos")
public class Datos {
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @ManyToOne
	    private Usuario usuario;
	    
	    @ManyToOne
	    private Juego juego;
	    
	    private boolean favorito;
	    
	    private String tiempo;
	    
	    private String fecha;
	    
	    private Integer puntos;
	    
		@Column(nullable = false, columnDefinition = "integer(11) default 0")
		private boolean gusta=false;
		@Column(nullable = false, columnDefinition = "integer(11) default 0")
		private boolean nogusta=false;
	public Datos() {
		// TODO Auto-generated constructor stub
	}
	

	public Datos(int id, Usuario usuario, Juego juego, boolean favorito, String tiempo, String fecha, Integer puntos,
			boolean gusta, boolean nogusta) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.juego = juego;
		this.favorito = favorito;
		this.tiempo = tiempo;
		this.fecha = fecha;
		this.puntos = puntos;
		this.gusta = gusta;
		this.nogusta = nogusta;
	}
	


	public boolean isGusta() {
		return gusta;
	}


	public void setGusta(boolean gusta) {
		this.gusta = gusta;
	}


	public boolean isNogusta() {
		return nogusta;
	}


	public void setNogusta(boolean nogusta) {
		this.nogusta = nogusta;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Juego getJuego() {
		return juego;
	}
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	public boolean isFavorito() {
		return favorito;
	}
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	
	@Override
	public String toString() {
		return "Datos [id=" + id + ", usuario=" + usuario + ", juego=" + juego + ", favorito=" + favorito + ", tiempo="
				+ tiempo + ", fecha=" + fecha + ", puntos=" + puntos + ", gusta=" + gusta + ", nogusta=" + nogusta
				+ "]";
	}

	

}