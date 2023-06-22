<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="project404.*"%>
<%@page import="project404.modelo.bs.DatosBS"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="img/alien_negro.png">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link href="https://fonts.cdnfonts.com/css/arcade-classic"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link href="./style/home_style.css" rel="stylesheet">
<link href="./style/perfil_style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<title>Project 404 games</title>
</head>
<body>
	<script src="./js/jquery.js"></script>
	<script src="./js/perfil_js.js"></script>

	<nav class="navbar navbar-expand-md" id="barra">
		<div class="container-fluid" id="barra">
			<a class="navbar-brand" href="#"> <img src="img/alien_negro.png"
				alt="..." height="50" id="alien_logo">
			</a> <a class="navbar-brand" href="servletHome?accion=home"
				id="logo_nombre"> Project 404</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon "></span>
			</button>
		</div>
	</nav>

	<div class="page-content page-container" id="page-content">
		<div class="padding">
			<div class="row container d-flex justify-content-center">
				<div class="col-xl-8 col-md-12">
					<h1 class="text-right" id="titulin">Profile Settings</h1>
					<div class="card user-card-full">
						<div class="row m-l-0 m-r-0">
							<div class="col-sm-4 bg-c-lite-green user-profile">
								<div class="card-block text-center text-white">
									<div class="m-b-25">
										<img src=<%=session.getAttribute("img_user")%>
											class="rounded-circle" width="150px" height="150px"
											alt="User-Profile-Image">
									</div>
									<h4 class="f-w-600"><%=session.getAttribute("nom_user")%></h4>
									<i
										class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>
									<div class="bg-c-blue counter-block m-t-10 p-20">
										<div class="row">
											<div class="col-4">
												<i class="fa fa-heart"></i>
												<p>
													<%out.print(DatosBS.numFavs((int)session.getAttribute("id_user"))); %>
												</p>
											</div>
											<div class="col-4">
												<i class="bi bi-dpad"></i>
												<p><%out.print(DatosBS.puntosTotales((int)session.getAttribute("id_user"))); %></p>
											</div>
											<div class="col-4">
												<i class="bi bi-joystick"></i>
												<p>
													<%out.print(DatosBS.numJugados((int)session.getAttribute("id_user"))); %>
												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-8">
								<div class="card-block">
									<h6 class="m-b-20 p-b-5 b-b-default f-w-600">Information</h6>
									<div class="row">
										<div class="col-sm-6">
											<p class="m-b-10 f-w-600">Email</p>
											<h6 class="text-muted f-w-400"><%=session.getAttribute("mail_user")%></h6>
										</div>
										<div class="col-sm-6">
											<p class="m-b-10 f-w-600">Username</p>
											<h6 class="text-muted f-w-400"><%=session.getAttribute("nom_user")%></h6>
										</div>
									</div>
									<h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Games</h6>
									<div class="row">
										<div class="col-sm-6">
											<p class="m-b-10 f-w-600">Recent</p>
											<h6 class="text-muted f-w-400"><%out.print(DatosBS.lastPlayed((int)session.getAttribute("id_user"))); %></h6>
										</div>
										<div class="col-sm-6">
											<p class="m-b-10 f-w-600">Most Played</p>
											<h6 class="text-muted f-w-400"><%out.print(DatosBS.mostPlayed((int)session.getAttribute("id_user"))); %></h6>
										</div>
									</div>
									<ul class="social-link list-unstyled m-t-40 m-b-10">
										<li><a href="#!" data-toggle="tooltip"
											data-placement="bottom" title=""
											data-original-title="facebook" data-abc="true"><i
												class="mdi mdi-facebook feather icon-facebook facebook"
												aria-hidden="true"></i></a></li>
										<li><a href="#!" data-toggle="tooltip"
											data-placement="bottom" title=""
											data-original-title="twitter" data-abc="true"><i
												class="mdi mdi-twitter feather icon-twitter twitter"
												aria-hidden="true"></i></a></li>
										<li><a href="#!" data-toggle="tooltip"
											data-placement="bottom" title=""
											data-original-title="instagram" data-abc="true"><i
												class="mdi mdi-instagram feather icon-instagram instagram"
												aria-hidden="true"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<input type='button' class="btn btn-dark" value='Editar'
						id='but_editar'>
					<div class="container bootstrap snippets bootdey" id='form_editar'>
						<h1 class="">Edit Profile</h1>
						<hr>
						<form method="post"  action="servletPerfil?accion=editar"
							class="form-horizontal needs-validation" novalidate role="form">

							<div class="row">
								<!-- left column -->
								<div class="col-md-3">
									<div class="text-center">
										<img src=<%=session.getAttribute("img_user")%>
											class="rounded-circle"width="200px" height="200px" alt="avatar" >
										<h6>Upload a different photo...</h6>

										<input type="text" class="form-control" name="nuevaimagen" placeholder="URL de tu nueva imagen..">
									</div>
								</div>

								<!-- edit form column -->
								<div class="col-md-9 personal-info">
									<h3>Personal info</h3>

									<div class="form-group">
										<label class="col-lg-3 control-label">Username:</label>
										<div class="col-lg-8">
											<input class="form-control" type="text" id="userperfil" name="userperfil" oninput="comprobarUsername()">
										</div>
										<div id="invalidCheck3Feedback" class="invalid-feedback">
									        Ese nombre de usuario ya existe
									      </div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Password:</label>
										<div class="col-lg-8">
											<input class="form-control" type="password" value=""
												name="pswperfil" id="pswperfil">
										</div>
									</div>
									<div class="form-group comprueba">
										<label class="col-lg-3 control-label">Repite Password:</label>
										<div class="col-lg-8">
											<input class="form-control" type="password" value=""
												name="pswperfil_r" id="pswperfil_r" oninput="validarCamposIguales()">
										</div>
										<div id="invalidCheck3Feedback" class="invalid-feedback">
									        Debe coincidir
									      </div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Email:</label>
										<div class="col-lg-8">
											<input class="form-control" type="email"
												placeholder="mail@mail.dot" id="mailperfil" name="mailperfil" oninput="valMail()">
										</div>
										<div id="mailperfil" class="invalid-feedback">
									        El email debe tener este formato: nombre@dominio.ext
									      </div>
									</div>
									<input type='submit' class="btn btn-dark bot_sub" value='Hacer cambios'  id="enviarCambios">

								</div>
							</div>
						</form>
					</div>

					<hr>
				</div>
			</div>
		</div>
	</div>

</body>
 <footer>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-twitter"></i></a>

        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-instagram"></i>
        </a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-github"></i></a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-facebook"></i>
        </a>
        <button class="btn btn-light" data-bs-toggle="collapse" data-bs-target="#conUs" aria-expanded="false" aria-controls="conUs">
            Contact
        </button>
         <div id="conUs" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</html>