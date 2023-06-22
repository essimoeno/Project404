<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="img/alien_negro.png">
<meta charset="ISO-8859-1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">    <link href="https://fonts.cdnfonts.com/css/arcade-classic" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link href="./style/home_style.css" rel="stylesheet">
    
<link href="./style/perfil_style.css" rel="stylesheet">
<link href="./style/admin_style.css" rel="stylesheet">
<title>Project 404 games</title>
</head>
<body>
<script src="./js/jquery.js"></script>
	<script src="./js/jquery.js"></script>
	<script src="./js/perfil_js.js"></script>
	<script src="./js/admin_js.js"></script>
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
	<div id="titulito" class="d-flex justify-content-center">
	<h1 >Bienvenido Administrador/a!<i class="bi bi-gear"></i></h1>
	
	</div>
	<div id="accordion">
  <div class="card">
    <div class="card-header d-flex justify-content-between" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-dark" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
         <i class="bi bi-person-fill"></i> Usuarios
        </button>
      </h5>
      <h5 class="mb-0">
        <button class="btn btn-dark" data-bs-toggle="collapse" data-bs-target="#addUser" aria-expanded="false" aria-controls="addUser">
         <i class="bi bi-person-plus"></i>
        </button>
      </h5>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body">
      	<table class="table table-striped table-dark">
		<tr >
			<th>Id</th>
			<th>Nombre</th>
			<th>Correo</th>
			<th><i class="bi bi-person-x-fill"></i></th>
		</tr>
		<%String tabla_user = (String)session.getAttribute("tabla_us"); 
				out.print(tabla_user);%>
			</table>
      </div>
    </div>
    <!-- Añadir usuario -->
    <div id="addUser" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body form_perfil">
<form method="post"  action="servletAdmin?accion=addUser"
							class="form-horizontal"  role="form">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationServerUsername">Username</label>
      <div class="input-group">
        <input type="text" class="form-control"  name="username" id="username" placeholder="Username" aria-describedby="inputGroupPrepend3" required>
        <div class="invalid-feedback">
          Please choose a username.
        </div>
      </div>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationServer03">E-mail</label>
      <input type="email" class="form-control" name="usermail" id="usermail" placeholder="mail@mail.dot" required>
      <div class="invalid-feedback">
        Please provide a valid city.
      </div>
    </div>
    <div class="col-md-3 mb-3">
      <label for="validationServer04">Password</label>
      <input type="password" class="form-control" name="userpsw" id="userpsw" placeholder="password..." required>
    </div>
  </div>
  <div class="form-group">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="" id="esAdmin" name="esAdmin">
      <label class="form-check-label" for="invalidCheck3">
        Administrador
      </label>
    </div>
  </div>
  <button class="btn btn-primary" type="submit">Submit form</button>
</form>
      </div>
    </div>
     <!-- Fin Añadir usuario -->
  </div>
 <div class="card adminjuegos">
    <div class="card-header d-flex justify-content-between" id="headingTwo">
      <h5 class="mb-0">
        <button class="btn btn-dark collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          <i class="bi bi-joystick"></i> Juegos
        </button>
      </h5>
      <h5 class="mb-0">
        <button class="btn btn-dark" data-bs-toggle="collapse" data-bs-target="#addJuego" aria-expanded="false" aria-controls="addJuego">
         <i class="bi bi-plus"></i>
        </button>
      </h5>
    </div>
    <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="table-responsive">
      <table class="table table-striped table-dark table-hover">
		<tr >
			<th>Id</th>
			<th>Nombre</th>
			<th>Categoría</th>
			<th>Imagen</th>
			<th><i class="bi bi-code-slash"></i></th>
			<th><i class="bi bi-trash"></i></th>
			<th><i class="bi bi-star"></i></th>
		</tr>
		<%String tabla_juegos = (String)session.getAttribute("tabla_ju"); 
				out.print(tabla_juegos);%>
			</table>
        </div>
    </div>
    <div id="addJuego" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body jueguito">
<form method="post"  action="servletAdmin?accion=addJuego"
							class="form-horizontal"  role="form">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationServerUsername">Nombre</label>
      <div class="input-group">
        <input type="text" class="form-control"  name="juname" id="username" placeholder="Nombre..." aria-describedby="inputGroupPrepend3" required>
      </div>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationServer03">Descripción</label>
      <input type="text" class="form-control" name="descripcion" id="usermail" placeholder="Descripción..." required>
      <div class="invalid-feedback">
        Please provide a valid city.
      </div>
    </div>
    <div class="col-md-3 mb-3">
      <label for="validationServer04">Tipo</label>
      <input type="text" class="form-control" name="jutipo" id="userpsw" placeholder="Categoria..." required>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationServerUsername">IFrame</label>
      <div class="input-group">
        <input type="text" class="form-control"  name="juimg" id="username" placeholder="IFrame..." aria-describedby="inputGroupPrepend3" required>
      </div>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationServerUsername">Imagen</label>
      <div class="input-group">
        <input type="text" class="form-control"  name="juiframe" id="username" placeholder="Imagen..." aria-describedby="inputGroupPrepend3" required>
      </div>
    </div>
  </div>
  <button class="btn btn-primary" type="submit">Submit form</button>
</form>
      </div>
    </div>
  </div>
</div>
<footer>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-twitter"></i></a>

        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-instagram"></i>
        </a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-github"></i></a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-facebook"></i>
        </a>
        <button class="btn btn-light" data-bs-toggle="collapse" data-bs-target="#contactUs" aria-expanded="false" aria-controls="contactUs" style="color:black">
            Contact
        </button>
         <div id="contactUs" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
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

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>