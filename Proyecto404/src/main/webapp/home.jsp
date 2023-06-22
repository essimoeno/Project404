<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="project404.modelo.bs.JuegoBS"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="shortcut icon" href="img/alien_negro.png">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://fonts.cdnfonts.com/css/arcade-classic" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link href="./style/home_style.css" rel="stylesheet">
    <title>Project 404 games</title>
   
    
</head>

<body>
    <script src="./js/jquery.js"></script>
    <script src="./js/home_js.js"></script>
    <div>
	<audio id="audio_pag" autoplay loop>
    	<source src="./sound/ef.ogg" type="audio/wav">
	</audio>  
</div>
    <nav class="navbar navbar-expand-md" id="barra">

        <!--------------------LOGO-------------------------->

        <div class="container-fluid" id="barra">
            <a class="navbar-brand" href="#">
                <img src="img/alien_negro.png" alt="..." height="50" id="alien_logo">
            </a>
            <a class="navbar-brand" href="servletHome?accion=home" id="logo_nombre"> Project 404</a>
            
            <!--------------------PERFIL------------------------->

            <div class="collapse navbar-collapse" id="navbarResponsive">
                <div style="text-align:center; flex:content ; margin-left:85%">
                <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                    <img src="<%=session.getAttribute("img_user")%>" width="50" height="50" class="rounded-circle">
                </a>
                <a style="color:white"><%=session.getAttribute("nom_user")%></a>
				<div class="dropdown dropleft">
				  <div class="dropdown-menu menuperfil" aria-labelledby="dropdownMenuButton">
				    <a class="dropdown-item" href="servletHome?accion=perfil">Mi Perfil</a>
				    <a class="dropdown-item" href="servletHome?accion=estadisticas">Estadísticas</a>
				    <a class="dropdown-item" href="servletHome?accion=admin" id="boton_administrar">Administrar<i class="bi bi-gear"></i></a>
				    <div class="dropdown-divider"></div>
				    <!-- jess --><a class="dropdown-item cerrar" href='servletHome?accion=salir'>Cerrar sesión</a>
				  </div>
				</div>
           
        </div>
        </div>
    </nav>
    <!--------------- CATEGORÍAS--------------------------- -->
    <nav class="navbar navbar-expand-md navbar-dark nav-fill">

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#barra_categorias" aria-controls="barra_categorias" aria-expanded="true" aria-label="Toggle navigation">
            <h3 class="navbar-brand" href="#">Categorias<span class="navbar-toggler-icon"></span></h3>
        </button>
        <div class="container-fluid">
            <ul class="navbar-nav collapse navbar-collapse categorias" id="barra_categorias">
                <li class="nav-item  bg-dark col-12 col-sm-auto">
                    <a class="nav-link text-white " href="#strategy"> Estrategia</a>
                </li>
                <li class="nav-item  bgclaro col-12 col-sm-auto ">
                    <a class="nav-link text-white" href="#fight">Fight</a>
                </li>
                <li class="nav-item  bg-dark col-12 col-sm-auto">
                    <a class="nav-link text-white" href="#bubble">Bubble</a>
                </li>
                <li class="nav-item  bgclaro col-12 col-sm-auto">
                    <a class="nav-link text-white" href="#plataformas">Plataformas</a>
                </li>
                <li class="nav-item  bg-dark col-12 col-sm-auto">
                    <a class="nav-link text-white" href="#tusRecientes"> Recientes</a>
                </li>
                <li class="nav-item  bgclaro col-12 col-sm-auto">
                    <a class="nav-link text-white" href="#tusFavoritos">Favoritos</a>
                </li>
            </ul>

        </div>
    </nav>
    <!-------------------SONIDO-------------------------->

    <div id="main">
        <div id="busqueda" class="container-fluid">
            <input type="text" class="navbar-item navbar-collapse form-control buscar" style="width: fit-content;" placeholder="Search" aria-label="Search" aria-describedby="search-addon" oninput="buscar(this.value)" />
            
            <a class="btn btn-link text-light boton_sonido" role="button" data-mdb-ripple-color="dark"><i class="bi bi-volume-up-fill" id="iconoVol"></i></a>
        </div>
		<!-- jess --><div id="busquedas" style="display: block; width: 100%; height: auto;">
            	
            </div>
        <!------------------------CARRUSEL------------------------>

        <div id="carouselExampleCaptions" class="carousel slide contenedor_carousel " data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>

            <!-------SLIDES------->

            <div class="carousel-inner">
                <div class="carousel-item active" style="background-image: url('img/fbs0kys9j5ja1.gif')">
                    <div class="carousel-caption">
                        <h5>¡Juegos destacados!</h5>
                        <p>Recomendaciones de los juegos más destacados de nuestra plataforma!</p>
                    </div>
                </div>
                <% out.print(JuegoBS.pintarDestacados()); %>
              
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>

        </div>

    </div>

        <% out.print(JuegoBS.pintarRecientes((int)session.getAttribute("id_user"))); %>
    
        <% out.print(JuegoBS.pintarFavoritos((int)session.getAttribute("id_user"))); %>
   		
   		  <%out.print(JuegoBS.pintarBubble((int)session.getAttribute("id_user"))); %>
   		  <%out.print(JuegoBS.pintarFight((int)session.getAttribute("id_user"))); %>
   		  <%out.print(JuegoBS.pintarPlataformas((int)session.getAttribute("id_user"))); %>
   		  <%out.print(JuegoBS.pintarStrategy((int)session.getAttribute("id_user"))); %>
    <div class="marcador">
        <h3><svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-controller" viewBox="0 0 20 17">
                <path d="M11.5 6.027a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm-1.5 1.5a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1zm2.5-.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm-1.5 1.5a.5.5 0 1 0 0-1 .5.5 0 0 0 0 1zm-6.5-3h1v1h1v1h-1v1h-1v-1h-1v-1h1v-1z" />
                <path d="M3.051 3.26a.5.5 0 0 1 .354-.613l1.932-.518a.5.5 0 0 1 .62.39c.655-.079 1.35-.117 2.043-.117.72 0 1.443.041 2.12.126a.5.5 0 0 1 .622-.399l1.932.518a.5.5 0 0 1 .306.729c.14.09.266.19.373.297.408.408.78 1.05 1.095 1.772.32.733.599 1.591.805 2.466.206.875.34 1.78.364 2.606.024.816-.059 1.602-.328 2.21a1.42 1.42 0 0 1-1.445.83c-.636-.067-1.115-.394-1.513-.773-.245-.232-.496-.526-.739-.808-.126-.148-.25-.292-.368-.423-.728-.804-1.597-1.527-3.224-1.527-1.627 0-2.496.723-3.224 1.527-.119.131-.242.275-.368.423-.243.282-.494.575-.739.808-.398.38-.877.706-1.513.773a1.42 1.42 0 0 1-1.445-.83c-.27-.608-.352-1.395-.329-2.21.024-.826.16-1.73.365-2.606.206-.875.486-1.733.805-2.466.315-.722.687-1.364 1.094-1.772a2.34 2.34 0 0 1 .433-.335.504.504 0 0 1-.028-.079zm2.036.412c-.877.185-1.469.443-1.733.708-.276.276-.587.783-.885 1.465a13.748 13.748 0 0 0-.748 2.295 12.351 12.351 0 0 0-.339 2.406c-.022.755.062 1.368.243 1.776a.42.42 0 0 0 .426.24c.327-.034.61-.199.929-.502.212-.202.4-.423.615-.674.133-.156.276-.323.44-.504C4.861 9.969 5.978 9.027 8 9.027s3.139.942 3.965 1.855c.164.181.307.348.44.504.214.251.403.472.615.674.318.303.601.468.929.503a.42.42 0 0 0 .426-.241c.18-.408.265-1.02.243-1.776a12.354 12.354 0 0 0-.339-2.406 13.753 13.753 0 0 0-.748-2.295c-.298-.682-.61-1.19-.885-1.465-.264-.265-.856-.523-1.733-.708-.85-.179-1.877-.27-2.913-.27-1.036 0-2.063.091-2.913.27z" />
            </svg>Otros juegos</h3>
    </div>
    <!--  <div id="ultimos">
       <% //out.print(JuegoBS.pintarJuegos((int)session.getAttribute("id_user"))); %>
    </div>-->
    
    <footer>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-twitter"></i></a>

        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-instagram"></i>
        </a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-github"></i></a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-facebook"></i>
        </a>
        <button class="btn btn-light" data-bs-toggle="collapse" data-bs-target="#addUser" aria-expanded="false" aria-controls="addUser">
            Contact
        </button>
         <div id="addUser" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
      <h3 style="color:white">Contacta    con     nosotros</h3>
      <div class="wrap-contact100">
        <form class="contact100-form validate-form contactito" action="https://formsubmit.co/project404arcade@gmail.com" method="POST">
        <div class="wrap-input100 validate-input" data-validate="Please enter your name">
        <label><i class="bi bi-person-lines-fill" style="color:white"></i></label><input class="input100 input_cont" type="text" name="name" placeholder="Full Name" required>
        <span class="focus-input100"></span>
        </div>
        <div class="wrap-input100 validate-input" data-validate="Please enter your email...">
        <label><i class="bi bi-envelope"  style="color:white"></i></label><input class="input100 input_cont" type="text" name="email" placeholder="E-mail">
        <span class="focus-input100"></span>
        </div>
        <div class="wrap-input100 validate-input" data-validate="Please enter your message">
        <i class="bi bi-chat-square-text-fill" style="color:white"></i></br><textarea class="input100 input_cont" name="message" placeholder="Your Message"></textarea>
        <span class="focus-input100"></span>
        </div>
        <div class="container-contact100-form-btn">
        <button type="submit" class="btn btn-light">Send</button>
        </div>
        <input type="hidden" name="_next" value="http://localhost:8080/bibliotecaHBT/home.jsp">
         <input type="hidden" name="_capcha" value="false">
        </form>
        </div>
    </div>
       
    </footer>



 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
</body>

</html>
 <% String rol_usuario = (String)session.getAttribute("rol_user"); %>
	<script>
    $(document).ready(function() {
    	  var variableSesion = "<%= rol_usuario %>";
			
    	  if (variableSesion == "admin") {
    	    $("#boton_administrar").show();
    	  } else {
    	    $("#boton_administrar").hide();
    	  }
    	});
    </script>