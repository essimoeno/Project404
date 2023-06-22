<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="project404.modelo.bs.JuegoBS"%>
    <%@page import="project404.modelo.bs.ComentariosBS"%>
<!DOCTYPE html>
<html>
<head>
<title>Project 404 games</title>
<link rel="shortcut icon" href="img/alien_negro.png">
<meta charset="ISO-8859-1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://fonts.cdnfonts.com/css/arcade-classic" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="./style/juego_style.css" rel="stylesheet">
</head>


<body onbeforeunload="return myFunction()">
 <script src="./js/jquery.js"></script>
  <script src="./js/juego_js.js"></script>
    <nav class="navbar navbar-expand-md" id="barra">

        <!--------------------LOGO-------------------------->

        <div class="container-fluid" id="barra">
            <a class="navbar-brand" href="#">
                <img src="img/alien_negro.png" alt="..." height="50" id="alien_logo">
            </a>
            <a class="navbar-brand" href="servletHome?accion=home" id="logo_nombre"> Project 404</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon "></span>
            </button>
            <!--------------------PERFIL------------------------->

            <div class="collapse navbar-collapse" id="navbarResponsive">
                <div style="text-align:center; flex:content ; margin-left:85%">
                <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                    <img src="<%=session.getAttribute("img_user")%>" width="50" height="50" class="rounded-circle">
                </a>
                <a style="color:white"><%=session.getAttribute("nom_user")%></a>
				<div class="dropdown">
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
        </div>
    </nav>
    <!--------------- CATEGORAS--------------------------- -->

   

<% String id_juego = (String)session.getAttribute("id_juego");%>
<% int id_user = (int)session.getAttribute("id_user");%>

<% out.print(JuegoBS.pintarPaginaJuego(Integer.parseInt(id_juego), id_user)); %>

<% out.print(ComentariosBS.pintarComentarios(Integer.parseInt(id_juego))); %>


  <footer>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-twitter"></i></a>

        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-whatsapp"></i></a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-instagram"></i>
        </a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-github"></i></a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-facebook"></i>
        </a>
        <button class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">
            Contact
        </button>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
        
    </footer>
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>

</body>
</html>