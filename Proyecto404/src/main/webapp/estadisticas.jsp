<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="project404.*"%>
<%@page import="project404.modelo.bs.DatosBS"%>
<%@page import="project404.modelo.bs.JuegoBS"%>
<!DOCTYPE html>
<html>
<head>
<title>Project 404 games</title>
<link rel="shortcut icon" href="img/alien_negro.png">
<meta charset="ISO-8859-1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://fonts.cdnfonts.com/css/arcade-classic" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="./style/estadisticas_style.css" rel="stylesheet">
    <title>Mis estadisticas</title>
</head>

<body>
 <script src="./js/jquery.js"></script>
 
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
 
              <div class="marcador" style="  margin-top: 2%;">
          <h3><svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-person-circle " viewBox="0 0 16 16">
            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
            <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
          </svg>Estadisticas generales</h3>
      </div>
      <div class="container text-center" style="margin-top: 3%; margin-bottom: 3%;" >
        <div class="row align-items-start" >
          
          <div class="col mini-caja">
           <div class="logo-container">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="#29A3A4" class="bi bi-joystick logo" viewBox="0 0 16 16">
                  <path d="M10 2a2 2 0 0 1-1.5 1.937v5.087c.863.083 1.5.377 1.5.726 0 .414-.895.75-2 .75s-2-.336-2-.75c0-.35.637-.643 1.5-.726V3.937A2 2 0 1 1 10 2z"/>
                  <path d="M0 9.665v1.717a1 1 0 0 0 .553.894l6.553 3.277a2 2 0 0 0 1.788 0l6.553-3.277a1 1 0 0 0 .553-.894V9.665c0-.1-.06-.19-.152-.23L9.5 6.715v.993l5.227 2.178a.125.125 0 0 1 .001.23l-5.94 2.546a2 2 0 0 1-1.576 0l-5.94-2.546a.125.125 0 0 1 .001-.23L6.5 7.708l-.013-.988L.152 9.435a.25.25 0 0 0-.152.23z"/>
                </svg>
              </div>
           <div class="text-container">
                <h5>Juegos jugados</h5>
                <h5>- <%out.print(DatosBS.numJugados((int)session.getAttribute("id_user"))); %> -</h5>
              </div>
          </div>
          
          <div class="col mini-caja">
            <div class="logo-container">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="#F5AA85" class="bi bi-heart-fill logo" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
            </svg>
          </div>
          <div class="text-container">
            <h5>Juegos favoritos</h5>
            <h5>- <%out.print(DatosBS.numFavs((int)session.getAttribute("id_user"))); %> -</h5>
          </div>
          </div>


          <div class="col mini-caja">
            <div class="logo-container">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="#32C292" class="bi bi-clock-fill logo" viewBox="0 0 16 16">
              <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"/>
            </svg>
          </div>
          <div class="text-container">
          <h5>Tiepo acumulado</h5>
          <h5>- <%out.print(DatosBS.tiempoTotal((int)session.getAttribute("id_user"))); %> -</h5>
          </div>
          </div>


          <div class="col mini-caja">
            <div class="logo-container">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="#F87B8F" class="bi bi-dpad-fill logo" viewBox="0 0 16 16">
              <path d="M6.5 0A1.5 1.5 0 0 0 5 1.5v3a.5.5 0 0 1-.5.5h-3A1.5 1.5 0 0 0 0 6.5v3A1.5 1.5 0 0 0 1.5 11h3a.5.5 0 0 1 .5.5v3A1.5 1.5 0 0 0 6.5 16h3a1.5 1.5 0 0 0 1.5-1.5v-3a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 0 16 9.5v-3A1.5 1.5 0 0 0 14.5 5h-3a.5.5 0 0 1-.5-.5v-3A1.5 1.5 0 0 0 9.5 0h-3Zm1.288 2.34a.25.25 0 0 1 .424 0l.799 1.278A.25.25 0 0 1 8.799 4H7.201a.25.25 0 0 1-.212-.382l.799-1.279Zm0 11.32-.799-1.277A.25.25 0 0 1 7.201 12H8.8a.25.25 0 0 1 .212.383l-.799 1.278a.25.25 0 0 1-.424 0Zm-4.17-4.65-1.279-.798a.25.25 0 0 1 0-.424l1.279-.799A.25.25 0 0 1 4 7.201V8.8a.25.25 0 0 1-.382.212Zm10.043-.798-1.278.799A.25.25 0 0 1 12 8.799V7.2a.25.25 0 0 1 .383-.212l1.278.799a.25.25 0 0 1 0 .424Z"/>
            </svg>
          </div>
          <div class="text-container">
           <h5>Puntos acumulados</h5>
          <h5>- <%out.print(DatosBS.puntosTotales((int)session.getAttribute("id_user"))); %> -</h5>
          </div>
          </div>


        </div>
      </div>
      
      <div class="marcador">
        <h3><svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
          <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
          <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
        </svg>Estadisricas de los juegos a los que has jugado</h3>
    </div> 
    <% out.print(JuegoBS.pintarEstadisticas((int)session.getAttribute("id_user"))); %>
    
     <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
   
        </body>
</html>