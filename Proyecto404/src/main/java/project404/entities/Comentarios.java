package project404.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentarios {

	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Juego juego;
    
    private String comentario;
    
    public Comentarios() {

	}
    
	

	public Comentarios(int id, Usuario usuario, Juego juego, String comentario) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.juego = juego;
		this.comentario = comentario;
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



	public String getComentario() {
		return comentario;
	}



	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", usuario=" + usuario + ", juego=" + juego + ", comentario=" + comentario
				+ "]";
	}


   
}