package project404.modelo.bs;

import java.sql.SQLException;
import java.util.List;

import project404.entities.Datos;
import project404.entities.Juego;
import project404.entities.Usuario;
import project404.modelo.ComentariosDAO;
import project404.modelo.DatosDAO;
import project404.modelo.JuegoDAO;
import project404.modelo.UsuarioDAO;

public class JuegoBS {

	public JuegoBS() {
		// TODO Auto-generated constructor stub
	}
	

	public static String pintarJuegos(int id_user) throws Exception{
		JuegoDAO ju = new JuegoDAO();
		DatosDAO dat = new DatosDAO();
		
		
		List<Juego> juegos = ju.getValues();
		String tabla="<div class='row row-cols-1 row-cols-md-3 row-cols-xl-4 ' >";
			if(juegos!=null){
				for (int i = 0; i < juegos.size(); i++) {
					
					String nombre =juegos.get(i).getNombre();
					String imagen = juegos.get(i).getImagen();
					String descripcion = juegos.get(i).getDescripcion();
					Boolean fav = false;
					Integer id = juegos.get(i).getId();
					Datos datos = dat.getValuesByIds(id_user, id);
					String cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart' viewBox='0 0 16 16'><path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/></svg>";
					if(datos!=null) {
						fav = datos.isFavorito();
					}
					if(fav) {
						cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart-fill' viewBox='0 0 16 16'><path fill-rule='evenodd' d='M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z'/></svg>";
					}
					tabla+= "<div class='col'>";
					tabla+= "<div class='card h-100 caja_juego'>";
					tabla+=  "<img src='"+imagen+"' class='card-img-top imagenes' alt='...''>";
					tabla+=   "<a class='fav "+id+"' id='"+id+"' onclick='favorito("+id+")' value="+fav+">"+cora;
					tabla+=   "<path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/>";
					tabla+=   "</svg></a>";
					tabla+=   "<div class='card-body' style='width: 70%; margin: auto; text-align: center;'>";
					tabla+=     "<h3 class='card-title'>"+nombre+"</h3>";
					tabla+=     "<a href='servletJuego?accion=jugar&id_juego="+id+"' class='btn btn-primary boton_jugar'>Jugar</a>";
					tabla+=   "</div>";
					tabla+= "</div>";
					tabla+= "</div>";
				}
				
		}
			tabla+= "</div>";
		return tabla;
	}
	
	
	public static String pintarPaginaJuego(Integer id, Integer id_user) throws Exception{ 
		DatosDAO dat = new DatosDAO();
		String pagina = "";
		JuegoDAO ju = new JuegoDAO();
		Juego juego = ju.getValuesById(id);
		Boolean gusta = false;
		Boolean noGusta = false;
		Boolean fav = false;
        String cora = " <svg xmlns='http://www.w3.org/2000/svg' fill='currentColor' class='bi bi-heart logo' viewBox='0 0 16 16'> \\r\\n\"\r\n"
		+ "				+ \"				          <path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/> \\r\\n\"\r\n"
		+ "				+ \"				        </svg> ";
		String manoArriba = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-hand-thumbs-up logo2\" viewBox=\"0 0 16 16\">\r\n"
				+ "  <path d=\"M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2.144 2.144 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a9.84 9.84 0 0 0-.443.05 9.365 9.365 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111L8.864.046zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a8.908 8.908 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.224 2.224 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.866.866 0 0 1-.121.416c-.165.288-.503.56-1.066.56z\"/>\r\n"
				+ "</svg>";
		String manoAbajo = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-hand-thumbs-down logo2\" viewBox=\"0 0 16 16\">\r\n"
				+ "  <path d=\"M8.864 15.674c-.956.24-1.843-.484-1.908-1.42-.072-1.05-.23-2.015-.428-2.59-.125-.36-.479-1.012-1.04-1.638-.557-.624-1.282-1.179-2.131-1.41C2.685 8.432 2 7.85 2 7V3c0-.845.682-1.464 1.448-1.546 1.07-.113 1.564-.415 2.068-.723l.048-.029c.272-.166.578-.349.97-.484C6.931.08 7.395 0 8 0h3.5c.937 0 1.599.478 1.934 1.064.164.287.254.607.254.913 0 .152-.023.312-.077.464.201.262.38.577.488.9.11.33.172.762.004 1.15.069.13.12.268.159.403.077.27.113.567.113.856 0 .289-.036.586-.113.856-.035.12-.08.244-.138.363.394.571.418 1.2.234 1.733-.206.592-.682 1.1-1.2 1.272-.847.283-1.803.276-2.516.211a9.877 9.877 0 0 1-.443-.05 9.364 9.364 0 0 1-.062 4.51c-.138.508-.55.848-1.012.964l-.261.065zM11.5 1H8c-.51 0-.863.068-1.14.163-.281.097-.506.229-.776.393l-.04.025c-.555.338-1.198.73-2.49.868-.333.035-.554.29-.554.55V7c0 .255.226.543.62.65 1.095.3 1.977.997 2.614 1.709.635.71 1.064 1.475 1.238 1.977.243.7.407 1.768.482 2.85.025.362.36.595.667.518l.262-.065c.16-.04.258-.144.288-.255a8.34 8.34 0 0 0-.145-4.726.5.5 0 0 1 .595-.643h.003l.014.004.058.013a8.912 8.912 0 0 0 1.036.157c.663.06 1.457.054 2.11-.163.175-.059.45-.301.57-.651.107-.308.087-.67-.266-1.021L12.793 7l.353-.354c.043-.042.105-.14.154-.315.048-.167.075-.37.075-.581 0-.211-.027-.414-.075-.581-.05-.174-.111-.273-.154-.315l-.353-.354.353-.354c.047-.047.109-.176.005-.488a2.224 2.224 0 0 0-.505-.804l-.353-.354.353-.354c.006-.005.041-.05.041-.17a.866.866 0 0 0-.121-.415C12.4 1.272 12.063 1 11.5 1z\"/>\r\n"
				+ "</svg>";
		Datos datos = dat.getValuesByIds(id_user, id);
		if(datos!=null) {
			gusta = datos.isGusta();
			noGusta = datos.isNogusta();
			fav = datos.isFavorito();
		}
		if(gusta) {
			manoArriba = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-hand-thumbs-up-fill logo2\" viewBox=\"0 0 16 16\">\r\n"
					+ "  <path d=\"M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a9.84 9.84 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733.058.119.103.242.138.363.077.27.113.567.113.856 0 .289-.036.586-.113.856-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.163 3.163 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.82 4.82 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z\"/>\r\n"
					+ "</svg>";
		}
		if(noGusta) {
			manoAbajo = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-hand-thumbs-down-fill logo2\" viewBox=\"0 0 16 16\">\r\n"
					+ "  <path d=\"M6.956 14.534c.065.936.952 1.659 1.908 1.42l.261-.065a1.378 1.378 0 0 0 1.012-.965c.22-.816.533-2.512.062-4.51.136.02.285.037.443.051.713.065 1.669.071 2.516-.211.518-.173.994-.68 1.2-1.272a1.896 1.896 0 0 0-.234-1.734c.058-.118.103-.242.138-.362.077-.27.113-.568.113-.856 0-.29-.036-.586-.113-.857a2.094 2.094 0 0 0-.16-.403c.169-.387.107-.82-.003-1.149a3.162 3.162 0 0 0-.488-.9c.054-.153.076-.313.076-.465a1.86 1.86 0 0 0-.253-.912C13.1.757 12.437.28 11.5.28H8c-.605 0-1.07.08-1.466.217a4.823 4.823 0 0 0-.97.485l-.048.029c-.504.308-.999.61-2.068.723C2.682 1.815 2 2.434 2 3.279v4c0 .851.685 1.433 1.357 1.616.849.232 1.574.787 2.132 1.41.56.626.914 1.28 1.039 1.638.199.575.356 1.54.428 2.591z\"/>\r\n"
					+ "</svg>";
		}
		if(fav) {
			cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart-fill logo' viewBox='0 0 16 16'><path fill-rule='evenodd' d='M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z'/></svg>";
		}
		pagina = pagina + "<title>"+juego.getNombre()+"</title>";
		pagina = pagina + " <h1 class='titulo'>"+juego.getNombre()+"</h1>\r\n"
				+ "       <div class='main-container'> \r\n"
				+ "       \r\n"
				+ "				     <iframe src='"+juego.getIframe()+"' frameborder='0' class='iframe'></iframe> \r\n"
				+ "        \r\n"
				+ "				     <div class='sidebar-container'> \r\n"
				+ "             \r\n"
				+ "             <div id=\"stats\">"
				+ "				      <p> <a  id='"+id+"' onclick='favorito("+id+")' value="+fav+">"+cora+"</a>"
				+ "				      </p> \r\n"
				+ "				      <p class='logo-paragraph'> \r\n"
				+ "				        <svg xmlns='http://www.w3.org/2000/svg' fill='currentColor' class='bi bi-stopwatch-fill logo' viewBox='0 0 16 16'> \r\n"
				+ "				          <path d='M6.5 0a.5.5 0 0 0 0 1H7v1.07A7.001 7.001 0 0 0 8 16a7 7 0 0 0 5.29-11.584.531.531 0 0 0 .013-.012l.354-.354.353.354a.5.5 0 1 0 .707-.707l-1.414-1.415a.5.5 0 1 0-.707.707l.354.354-.354.354a.717.717 0 0 0-.012.012A6.973 6.973 0 0 0 9 2.071V1h.5a.5.5 0 0 0 0-1h-3zm2 5.6V9a.5.5 0 0 1-.5.5H4.5a.5.5 0 0 1 0-1h3V5.6a.5.5 0 1 1 1 0z'/> \r\n"
				+ "				        </svg> \r\n"
				+ "				        <span id='hms' class='logo-text'></span> \r\n"
				+ "				      </p> \r\n"
				+ "				      <p class='logo-paragraph'> \r\n"
				+ "				        <svg xmlns='http://www.w3.org/2000/svg'  fill='currentColor' class='bi bi-dpad-fill logo' viewBox='0 0 16 16'> \r\n"
				+ "				          <path d='M6.5 0A1.5 1.5 0 0 0 5 1.5v3a.5.5 0 0 1-.5.5h-3A1.5 1.5 0 0 0 0 6.5v3A1.5 1.5 0 0 0 1.5 11h3a.5.5 0 0 1 .5.5v3A1.5 1.5 0 0 0 6.5 16h3a1.5 1.5 0 0 0 1.5-1.5v-3a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 0 16 9.5v-3A1.5 1.5 0 0 0 14.5 5h-3a.5.5 0 0 1-.5-.5v-3A1.5 1.5 0 0 0 9.5 0h-3Zm1.288 2.34a.25.25 0 0 1 .424 0l.799 1.278A.25.25 0 0 1 8.799 4H7.201a.25.25 0 0 1-.212-.382l.799-1.279Zm0 11.32-.799-1.277A.25.25 0 0 1 7.201 12H8.8a.25.25 0 0 1 .212.383l-.799 1.278a.25.25 0 0 1-.424 0Zm-4.17-4.65-1.279-.798a.25.25 0 0 1 0-.424l1.279-.799A.25.25 0 0 1 4 7.201V8.8a.25.25 0 0 1-.382.212Zm10.043-.798-1.278.799A.25.25 0 0 1 12 8.799V7.2a.25.25 0 0 1 .383-.212l1.278.799a.25.25 0 0 1 0 .424Z'/> \r\n"
				+ "				        </svg> \r\n"
				+ "				        <span id='punt' class='logo-text'></span> \r\n"
				+ "				      </p> \r\n"
				+ "				    </div> \r\n"
				+ "				   <div id=\"tabla\">"+pintarPuntuaciones(id)
				+ "				    </div>"
				+ "				     <button id=\"verTabla\" class=\"btn btn-outline-light\">Tabla de puntuaciones</button>	"
				+ "				    </div> \r\n"
				+ "				    </div> \r\n"
				+ "				   \r\n"
				+ "				    <div class='row bottom-banner'> \r\n"
				+ "				      <div class='col-8 descripcion'>"+juego.getDescripcion()+"</div> \r\n"
				+ "				      <div class='col-4'> \r\n"
				+ "				       <a id='gusta' onclick='gusta("+id+","+id_user+")' value="+gusta+"> "+manoArriba+"</a><span id='likes'>"+juego.getGusta()+"</span> \r\n"
				+ "				        <a id='noGusta' onclick='noGusta("+id+","+id_user+")' value="+noGusta+">"+manoAbajo+"</a><span id='dislikes'>"+juego.getNogusta()+"</span> \r\n"
				+ "				        <svg xmlns='http://www.w3.org/2000/svg' fill='currentColor' class='bi bi-code logo2' viewBox='0 0 16 16' onclick=\"copyText()\"> \r\n"
				+ "				          <path d='M5.854 4.854a.5.5 0 1 0-.708-.708l-3.5 3.5a.5.5 0 0 0 0 .708l3.5 3.5a.5.5 0 0 0 .708-.708L2.707 8l3.147-3.146zm4.292 0a.5.5 0 0 1 .708-.708l3.5 3.5a.5.5 0 0 1 0 .708l-3.5 3.5a.5.5 0 0 1-.708-.708L13.293 8l-3.147-3.146z'/> \r\n"
				+ "				        </svg> <p style=\"display: none;\" id=\"textoAcopiar\">"+juego.getIframe()+"</p>"
				+ "				      </div> \r\n"
				+ "				    </div> ";
	
		return pagina;
	}
	//jess
	
	public static String mostrarBusqueda(String busqueda) throws SQLException {
		JuegoDAO ju = new JuegoDAO();
		
		List<Juego> juegos = ju.buscarJuegos(busqueda);
		String tabla = "<div class='row row-cols-1 row-cols-md-3 row-cols-xl-4'>";
		if(juegos!=null){
			for (int i = 0; i < juegos.size(); i++) {
				
				String nombre =juegos.get(i).getNombre();
				String imagen = juegos.get(i).getImagen();
				Integer id = juegos.get(i).getId();
				
				tabla+= "<div class='col'>";
				tabla+= "<div class='card caja_juego'>";
				tabla+=  "<img src='"+imagen+"' class='card-img-top imagenes' alt='...''>";
				tabla+=   "<div class='d-flex card-body' style='margin: auto; text-align: center;'>";
				tabla+=     "<h3 class='card-title'>"+nombre+"</h3>";
				tabla+=     "<a href='servletJuego?accion=jugar&id_juego="+id+"' class='btn btn-primary boton_jugar'>Jugar</a>";
				tabla+=   "</div>";
				tabla+= "</div>";
				tabla+= "</div>";
			}
			
	}
		tabla+= "</div>";
	return tabla;
		
	}
	
	public static String pintarRecientes(Integer id_user) throws Exception{
		JuegoDAO ju = new JuegoDAO();
		DatosDAO dat = new DatosDAO();
		
		String tabla="";
		List<Juego> juegos = ju.getRecientes(id_user);
		if(juegos!=null && juegos.size()!=0){
			tabla="<div class=\"marcador\" id=\"tusRecientes\">\r\n"
					+ "        <h3><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"32\" height=\"32\" fill=\"currentColor\" class=\"bi bi-hourglass-bottom\" viewBox=\"0 0 16 16\">\r\n"
					+ "                <path d=\"M2 1.5a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-1v1a4.5 4.5 0 0 1-2.557 4.06c-.29.139-.443.377-.443.59v.7c0 .213.154.451.443.59A4.5 4.5 0 0 1 12.5 13v1h1a.5.5 0 0 1 0 1h-11a.5.5 0 1 1 0-1h1v-1a4.5 4.5 0 0 1 2.557-4.06c.29-.139.443-.377.443-.59v-.7c0-.213-.154-.451-.443-.59A4.5 4.5 0 0 1 3.5 3V2h-1a.5.5 0 0 1-.5-.5zm2.5.5v1a3.5 3.5 0 0 0 1.989 3.158c.533.256 1.011.791 1.011 1.491v.702s.18.149.5.149.5-.15.5-.15v-.7c0-.701.478-1.236 1.011-1.492A3.5 3.5 0 0 0 11.5 3V2h-7z\" />\r\n"
					+ "            </svg>Ultimos jugados</h3>\r\n"
					+ "    </div>\r\n"
					+ "    <div id=\"ultimos\"><div class='row row-cols-1 row-cols-md-3 row-cols-xl-4 ' >";
				
				for (int i = 0; i < juegos.size(); i++) {
					
					String nombre =juegos.get(i).getNombre();
					String imagen = juegos.get(i).getImagen();
					String descripcion = juegos.get(i).getDescripcion();
					Boolean fav = false;
					Integer id = juegos.get(i).getId();
					Datos datos = dat.getValuesByIds(id_user, id);
					String cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart' viewBox='0 0 16 16'><path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/></svg>";
					if(datos!=null) {
						fav = datos.isFavorito();
					}
					if(fav) {
						cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart-fill' viewBox='0 0 16 16'><path fill-rule='evenodd' d='M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z'/></svg>";
					}
					tabla+= "<div class='col'>";
					tabla+= "<div class='card h-100 caja_juego'>";
					tabla+=  "<img src='"+imagen+"' class='card-img-top imagenes' alt='...''>";
					tabla+=   "<a class='fav "+id+"' id='"+id+"' onclick='favorito("+id+")' value="+fav+">"+cora;
					tabla+=   "<path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/>";
					tabla+=   "</svg></a>";
					tabla+=   "<div class='card-body' style='width: 70%; margin: auto; text-align: center;'>";
					tabla+=     "<h3 class='card-title'>"+nombre+"</h3>";
					tabla+=     "<a href='servletJuego?accion=jugar&id_juego="+id+"' class='btn btn-primary boton_jugar'>Jugar</a>";
					tabla+=   "</div>";
					tabla+= "</div>";
					tabla+= "</div>";
				}
				
				tabla+= "</div></div>";	
		}
			
		return tabla;
	}
	
	public static String pintarFavoritos(Integer id_user) throws Exception{
		JuegoDAO ju = new JuegoDAO();
		DatosDAO dat = new DatosDAO();
		
		String tabla="";
		List<Juego> juegos = ju.getFavoritos(id_user);
		if(juegos!=null && juegos.size()!=0){
			tabla=" <div class=\"marcador\" id=\"tusFavoritos\">\r\n"
					+ "        <h3><i class=\"bi bi-heart\"  width=\"32\" height=\"32\"></i>Juegos Favoritos</h3>\r\n"
					+ "    </div>\r\n"
					+ "    <div id=\"ultimos\"><div class='row row-cols-1 row-cols-md-3 row-cols-xl-4 ' >";
				
				for (int i = 0; i < juegos.size(); i++) {
					
					String nombre =juegos.get(i).getNombre();
					String imagen = juegos.get(i).getImagen();
					String descripcion = juegos.get(i).getDescripcion();
					Boolean fav = false;
					Integer id = juegos.get(i).getId();
					Datos datos = dat.getValuesByIds(id_user, id);
					String cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart' viewBox='0 0 16 16'><path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/></svg>";
					if(datos!=null) {
						fav = datos.isFavorito();
					}
					if(fav) {
						cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart-fill' viewBox='0 0 16 16'><path fill-rule='evenodd' d='M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z'/></svg>";
					}
					tabla+= "<div class='col'>";
					tabla+= "<div class='card h-100 caja_juego'>";
					tabla+=  "<img src='"+imagen+"' class='card-img-top imagenes' alt='...''>";
					tabla+=   "<a class='fav "+id+"' id='"+id+"' onclick='favorito("+id+")' value="+fav+">"+cora;
					tabla+=   "<path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/>";
					tabla+=   "</svg></a>";
					tabla+=   "<div class='card-body' style='width: 70%; margin: auto; text-align: center;'>";
					tabla+=     "<h3 class='card-title'>"+nombre+"</h3>";
					tabla+=     "<a href='servletJuego?accion=jugar&id_juego="+id+"' class='btn btn-primary boton_jugar'>Jugar</a>";
					tabla+=   "</div>";
					tabla+= "</div>";
					tabla+= "</div>";
				}
				
		}
			tabla+= "</div></div>";
		return tabla;
	}
	
	public static String pintarTabla() throws SQLException {
		JuegoDAO jdao = new JuegoDAO();
		List<Juego> ju= jdao.getValues();
		String tabla="";
		String estrella = "";
			if(ju!=null){
			
				for(int i=0;i<ju.size();i++){
					if(ju.get(i).getDestacado()==false) {
						estrella = "<i class=\"bi bi-star-fill\" style='color:pink'></i>";
					}else {
						estrella ="<i class=\"bi bi-star-fill\" style='color:yellow'></i>";
					}
					tabla+="<tr><td>"+ju.get(i).getId()+"</td>";
					tabla+="<td>"+ju.get(i).getNombre()+"</td>";
					tabla+="<td>"+ju.get(i).getTipo()+"</td>";
					tabla+="<td>"+ju.get(i).getImagen()+"</td>";
					tabla+="<td>"+ju.get(i).getIframe()+"</td>";
					tabla+="<td><a href='servletAdmin?accion=borrarjuego&iddel="+ju.get(i).getId()+"'><i class='bi bi-trash-fill' style='color:rgb(245, 71, 119)' ></i></a></td>";
					tabla+="<td><a class='destacado' id='"+ju.get(i).getId()+"' onclick='destacado("+ju.get(i).getId()+")' value="+ju.get(i).getDestacado()+">"+estrella+"</a></td></tr>";
				}
		}
		return tabla;
		
	}
	
	public static void delJuego(Integer id_ju) throws SQLException {
		JuegoDAO jdao = new JuegoDAO();
		ComentariosDAO c = new ComentariosDAO();
		DatosDAO d = new DatosDAO();
		Juego ju = jdao.getValuesById(id_ju);
		jdao.delete(ju);
		c.delComentariosByJuego(id_ju);
		d.delDatosByJuego(id_ju);
	}
	
	public static void addJuego(String nom, String desc, String tipo, String iframe, String img) throws SQLException {
		Juego ju = new Juego();
		ju.setNombre(nom);
		ju.setDescripcion(desc);
		ju.setTipo(tipo);
		ju.setIframe(iframe);
		ju.setImagen(img);
		JuegoDAO jdao = new JuegoDAO();
		jdao.create(ju);
	}
	
	
	
	public static String pintarEstadisticas(Integer id_user) throws Exception{
		JuegoDAO ju = new JuegoDAO();
		DatosDAO dat = new DatosDAO();
		Datos d = new Datos();
		List<Datos> lista = dat.getJugadosById(id_user);
	
		String tabla="<div class='row row-cols-1 row-cols-md-2 row-cols-xl-3 ' >";
			if(lista!=null){
				for (int i = 0; i < lista.size(); i++) {
					Juego juegos = ju.getValuesById(lista.get(i).getJuego().getId());
					String nombre =juegos.getNombre();
					String imagen = juegos.getImagen();
					String estado = "No";
					Datos datos = dat.getValuesByIds(id_user, lista.get(i).getJuego().getId());
					Boolean fav = false;
					fav = d.isFavorito();
					if(datos!=null) {
						fav = datos.isFavorito();
					}
					if(fav) {
						estado = "Si";
					}
					tabla+= "<div class='col'>\r\n"
							+ "        <div class=\"card mb-3 caja_juego\" style=\"max-width: 500px;\">\r\n"
							+ "          <div class=\"row g-0\">\r\n"
							+ "            <div class=\"col-md-5\">\r\n"
							+ "              <img class=\"img-fluid rounded-start imagenes\" src='"+imagen+"' alt=\"...\">\r\n"
							+ "            </div>\r\n"
							+ "            <div class=\"col-md-7\">\r\n"
							+ "              <div class=\"card-body\">\r\n"
							+ "                <h3 class='card-title titulo_card'>"+nombre+"</h3>\r\n"
							+ "                <p class='card-text'>Tiempo: "+lista.get(i).getTiempo()+"</p>\r\n"
							+ "                <p class='card-text'>Puntos: "+lista.get(i).getPuntos()+"</p>\r\n"
							+ "                <p class='card-text'>Favorito: "+estado+"</p>\r\n"
							+ "                <p class='card-text'>Ultima vez jugado: "+lista.get(i).getFecha()+"</p>\r\n"
							+ "    \r\n"
							+ "              </div>\r\n"
							+ "            </div>\r\n"
							+ "          </div>\r\n"
							+ "        </div>\r\n"
							+ "      </div>";
				}
				
		}
			tabla+= "</div>";
		return tabla;
	}
	
	
	
	
	
	public static void juegoDestacado(Integer id_juego,boolean destacado) throws SQLException {
		
		JuegoDAO jdao = new JuegoDAO();
		Juego ju = jdao.getValuesById(id_juego);
		ju.setDestacado(destacado);
		jdao.update(ju);
		
	}
	
	
	
	public static String pintarDestacados() throws SQLException {
		JuegoDAO jdao = new JuegoDAO();
		List<Juego> juegos= jdao.getValues();
		String tab = "";
		for(Juego juego:juegos) {
			
			if(juego.getDestacado()==true) {
				
				tab += "<div class='carousel-item' style='background-image: url(\""+juego.getImagen()+"\")'>";
                tab+="<div class='carousel-caption'>";
                tab+=" <h5>"+juego.getNombre()+"</h5>";
                tab+="<p>"+juego.getDescripcion()+"</p>";
                tab+="<a href='servletJuego?accion=jugar&id_juego="+juego.getId()+"' class='btn btn-primary boton_jugar'>Jugar</a> </div></div>";
  
			}
		}
		return tab;
		
	}
	
	
	public static void Like(Integer id_juego, boolean gusta) throws SQLException {
		JuegoDAO jdao = new JuegoDAO();
		Juego ju = jdao.getValuesById(id_juego);
		int likes = ju.getGusta();
		int like_totales = 0;
		if(gusta) {
			like_totales = likes+1;
			ju.setGusta(like_totales);
			
		}else {
			like_totales = likes-1;
			ju.setGusta(like_totales);
		}
		jdao.update(ju);
	}
	
	public static void disLike(Integer id_juego, boolean gusta) throws SQLException {
		JuegoDAO jdao = new JuegoDAO();
		Juego ju = jdao.getValuesById(id_juego);
		int likes = ju.getNogusta();
		int like_totales = 0;
		if(gusta) {
			like_totales = likes+1;
			ju.setNogusta(like_totales);
			
		}else {
			like_totales = likes-1;
			ju.setNogusta(like_totales);
		}
		jdao.update(ju);
	}
	
	public static String pintarPuntuaciones(Integer id_ju) throws SQLException {
		DatosDAO d = new DatosDAO();
		UsuarioDAO u = new UsuarioDAO();
		List<Datos> ju= d.getPuntuaciones(id_ju);
		String tabla=" <table class=\"table table-dark table-sm puntuaciones\">\r\n"
				+ "            <thead>\r\n"
				+ "              <tr>\r\n"
				+ "                <th scope=\"col\">#</th>\r\n"
				+ "                <th scope=\"col\">Usuario</th>\r\n"
				+ "                <th scope=\"col\">Puntos</th>\r\n"
				+ "              \r\n"
				+ "              </tr>\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody class=\"table-group-divider\">";
			if(ju!=null){
			
				for(int i=0;i<ju.size();i++){
					String nombre = ju.get(i).getUsuario().getNombre_usuario();
					tabla+="<tr>\r\n"
							+ "                <th scope=\"row\">"+(i+1)+"</th>\r\n"
							+ "                <td>"+nombre+"</td>\r\n"
							+ "                <td>"+ju.get(i).getPuntos()+"</td>              \r\n"
							+ "              </tr>";
					
				}
		}
			tabla = tabla + "</tbody>\r\n"
					+ "          </table>";
		return tabla;
		
	}
	
	
	//categorías
	
	public static String pintarBubble(Integer id_user) throws Exception{
		JuegoDAO ju = new JuegoDAO();
		DatosDAO dat = new DatosDAO();
		
		String tabla="";
		List<Juego> juegos = ju.getValues();
		if(juegos!=null && juegos.size()!=0){
			tabla=" <div class=\"marcador\" id=\"bubble\">\r\n"
					+ "        <h3><i class=\"bi bi-balloon\"  width=\"32\" height=\"32\"></i>Bubble</h3>\r\n"
					+ "    </div>\r\n"
					+ "    <div id=\"ultimos\"><div class='row row-cols-1 row-cols-md-3 row-cols-xl-4 ' >";
				
				for (int i = 0; i < juegos.size(); i++) {
					if(juegos.get(i).getTipo().equals("bubble")) {
					String nombre =juegos.get(i).getNombre();
					String imagen = juegos.get(i).getImagen();
					String descripcion = juegos.get(i).getDescripcion();
					Boolean fav = false;
					Integer id = juegos.get(i).getId();
					Datos datos = dat.getValuesByIds(id_user, id);
					String cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart' viewBox='0 0 16 16'><path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/></svg>";
					if(datos!=null) {
						fav = datos.isFavorito();
					}
					if(fav) {
						cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart-fill' viewBox='0 0 16 16'><path fill-rule='evenodd' d='M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z'/></svg>";
					}
					tabla+= "<div class='col'>";
					tabla+= "<div class='card h-100 caja_juego'>";
					tabla+=  "<img src='"+imagen+"' class='card-img-top imagenes' alt='...''>";
					tabla+=   "<a class='fav "+id+"' id='"+id+"' onclick='favorito("+id+")' value="+fav+">"+cora;
					tabla+=   "<path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/>";
					tabla+=   "</svg></a>";
					tabla+=   "<div class='card-body' style='width: 70%; margin: auto; text-align: center;'>";
					tabla+=     "<h3 class='card-title'>"+nombre+"</h3>";
					tabla+=     "<a href='servletJuego?accion=jugar&id_juego="+id+"' class='btn btn-primary boton_jugar'>Jugar</a>";
					tabla+=   "</div>";
					tabla+= "</div>";
					tabla+= "</div>";
				}
				}
				
		}
			tabla+= "</div></div>";
		return tabla;
	}
	
	public static String pintarFight(Integer id_user) throws Exception{
		JuegoDAO ju = new JuegoDAO();
		DatosDAO dat = new DatosDAO();
		
		String tabla="";
		List<Juego> juegos = ju.getValues();
		if(juegos!=null && juegos.size()!=0){
			tabla=" <div class=\"marcador\" id=\"fight\">\r\n"
					+ "        <h3><i class=\"bi bi-fire\"  width=\"32\" height=\"32\"></i>Fight</h3>\r\n"
					+ "    </div>\r\n"
					+ "    <div id=\"ultimos\"><div class='row row-cols-1 row-cols-md-3 row-cols-xl-4 ' >";
				
				for (int i = 0; i < juegos.size(); i++) {
					if(juegos.get(i).getTipo().equals("fight")) {
					String nombre =juegos.get(i).getNombre();
					String imagen = juegos.get(i).getImagen();
					String descripcion = juegos.get(i).getDescripcion();
					Boolean fav = false;
					Integer id = juegos.get(i).getId();
					Datos datos = dat.getValuesByIds(id_user, id);
					String cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart' viewBox='0 0 16 16'><path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/></svg>";
					if(datos!=null) {
						fav = datos.isFavorito();
					}
					if(fav) {
						cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart-fill' viewBox='0 0 16 16'><path fill-rule='evenodd' d='M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z'/></svg>";
					}
					tabla+= "<div class='col'>";
					tabla+= "<div class='card h-100 caja_juego'>";
					tabla+=  "<img src='"+imagen+"' class='card-img-top imagenes' alt='...''>";
					tabla+=   "<a class='fav "+id+"' id='"+id+"' onclick='favorito("+id+")' value="+fav+">"+cora;
					tabla+=   "<path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/>";
					tabla+=   "</svg></a>";
					tabla+=   "<div class='card-body' style='width: 70%; margin: auto; text-align: center;'>";
					tabla+=     "<h3 class='card-title'>"+nombre+"</h3>";
					tabla+=     "<a href='servletJuego?accion=jugar&id_juego="+id+"' class='btn btn-primary boton_jugar'>Jugar</a>";
					tabla+=   "</div>";
					tabla+= "</div>";
					tabla+= "</div>";
				}
				}
				
		}
			tabla+= "</div></div>";
		return tabla;
	}
	
	public static String pintarPlataformas(Integer id_user) throws Exception{
		JuegoDAO ju = new JuegoDAO();
		DatosDAO dat = new DatosDAO();
		
		String tabla="";
		List<Juego> juegos = ju.getValues();
		if(juegos!=null && juegos.size()!=0){
			tabla=" <div class=\"marcador\" id=\"plataformas\">\r\n"
					+ "        <h3><i class=\"bi bi-cloud-fill\"  width=\"32\" height=\"32\"></i>Plataformas</h3>\r\n"
					+ "    </div>\r\n"
					+ "    <div id=\"ultimos\"><div class='row row-cols-1 row-cols-md-3 row-cols-xl-4 ' >";
				
				for (int i = 0; i < juegos.size(); i++) {
					if(juegos.get(i).getTipo().equals("plataformas")) {
					String nombre =juegos.get(i).getNombre();
					String imagen = juegos.get(i).getImagen();
					String descripcion = juegos.get(i).getDescripcion();
					Boolean fav = false;
					Integer id = juegos.get(i).getId();
					Datos datos = dat.getValuesByIds(id_user, id);
					String cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart' viewBox='0 0 16 16'><path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/></svg>";
					if(datos!=null) {
						fav = datos.isFavorito();
					}
					if(fav) {
						cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart-fill' viewBox='0 0 16 16'><path fill-rule='evenodd' d='M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z'/></svg>";
					}
					tabla+= "<div class='col'>";
					tabla+= "<div class='card h-100 caja_juego'>";
					tabla+=  "<img src='"+imagen+"' class='card-img-top imagenes' alt='...''>";
					tabla+=   "<a class='fav "+id+"' id='"+id+"' onclick='favorito("+id+")' value="+fav+">"+cora;
					tabla+=   "<path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/>";
					tabla+=   "</svg></a>";
					tabla+=   "<div class='card-body' style='width: 70%; margin: auto; text-align: center;'>";
					tabla+=     "<h3 class='card-title'>"+nombre+"</h3>";
					tabla+=     "<a href='servletJuego?accion=jugar&id_juego="+id+"' class='btn btn-primary boton_jugar'>Jugar</a>";
					tabla+=   "</div>";
					tabla+= "</div>";
					tabla+= "</div>";
				}
				}
				
		}
			tabla+= "</div></div>";
		return tabla;
	}
	
	public static String pintarStrategy(Integer id_user) throws Exception{
		JuegoDAO ju = new JuegoDAO();
		DatosDAO dat = new DatosDAO();
		
		String tabla="";
		List<Juego> juegos = ju.getValues();
		if(juegos!=null && juegos.size()!=0){
			tabla=" <div class=\"marcador\" id=\"strategy\">\r\n"
					+ "        <h3><i class=\"bi bi-boxes\"  width=\"32\" height=\"32\"></i>Strategy</h3>\r\n"
					+ "    </div>\r\n"
					+ "    <div id=\"ultimos\"><div class='row row-cols-1 row-cols-md-3 row-cols-xl-4 ' >";
				
				for (int i = 0; i < juegos.size(); i++) {
					if(juegos.get(i).getTipo().equals("strategy")) {
					String nombre =juegos.get(i).getNombre();
					String imagen = juegos.get(i).getImagen();
					String descripcion = juegos.get(i).getDescripcion();
					Boolean fav = false;
					Integer id = juegos.get(i).getId();
					Datos datos = dat.getValuesByIds(id_user, id);
					String cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart' viewBox='0 0 16 16'><path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/></svg>";
					if(datos!=null) {
						fav = datos.isFavorito();
					}
					if(fav) {
						cora = "<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart-fill' viewBox='0 0 16 16'><path fill-rule='evenodd' d='M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z'/></svg>";
					}
					tabla+= "<div class='col'>";
					tabla+= "<div class='card h-100 caja_juego'>";
					tabla+=  "<img src='"+imagen+"' class='card-img-top imagenes' alt='...''>";
					tabla+=   "<a class='fav "+id+"' id='"+id+"' onclick='favorito("+id+")' value="+fav+">"+cora;
					tabla+=   "<path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/>";
					tabla+=   "</svg></a>";
					tabla+=   "<div class='card-body' style='width: 70%; margin: auto; text-align: center;'>";
					tabla+=     "<h3 class='card-title'>"+nombre+"</h3>";
					tabla+=     "<a href='servletJuego?accion=jugar&id_juego="+id+"' class='btn btn-primary boton_jugar'>Jugar</a>";
					tabla+=   "</div>";
					tabla+= "</div>";
					tabla+= "</div>";
				}
				}
				
		}
			tabla+= "</div></div>";
		return tabla;
	}
}
