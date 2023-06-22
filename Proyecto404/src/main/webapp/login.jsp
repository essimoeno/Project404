<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList"%>
            <%@page import="project404.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project 404 games</title>
<link rel="shortcut icon" href="img/alien_negro.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
 <link href="https://fonts.cdnfonts.com/css/arcade-classic" rel="stylesheet">
 
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
 <link href="./style/login_style.css" rel="stylesheet" >
 <script src="./js/jquery.js"></script>
 <script src="./js/login_js.js"></script>
</head>
<body>
<div class="portada">
        <div class="texto_portada">
            <h1 class="letra_retro">Project 404</h1>
            <h3 class="letra_retro">La mejor pagina de minijuegos retro</h3><br>
            <div class="presentation-content">
                <div class="top-button-group">
                  <button class="video-game-button" id="boton_login" ><a href="#form_login">Iniciar Sesion</a></button><button class="video-game-button2" id = "registro"><a href="#form_registro">Registrarse</a></button>
                </div>
              </div>  
         </div>
     <div id = "form_registro">
         <div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card signup">
			<div class="card-header">
			<h1><i class="bi bi-person-plus" style="color:white"></i></h1>
				<h1 class="letra_retro">Sign-Up</h1>
			</div>
			<div class="card-body">
				<form method="POST" action="servletLogin?accion=registrar">
						<label style="width:100%">
							<i class="bi bi-person-fill" style="color:white" ></i>
						</label>
						<input type="text" class="form-control" name="usuario_registro" placeholder="Username">
						<label style="width:100%">
							<i class="bi bi-envelope" style="color:white"></i>
						</label>
						<input type="email" class="form-control" name="email_registro" placeholder="E-Mail">
						<label>
							<i class="bi bi-key-fill" style="color:white"></i>
						</label>
						<input type="password" class="form-control" name="password_registro" placeholder="Password">
						<input type="submit" value="new user" class="start-btn letra_retro" >
				</form>
			</div>
		</div>
	</div>
</div>
	</div> 
	
	<div id="form_login">
	<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card signin h-100">
			<div class="card-header">
				<h1><i class="bi bi-person-circle" style="color:white" ></i></h1>
				<h1 class="letra_retro">Sign-In</h1>
			</div>
			<div class="card-body">
				<form method="POST" action="servletLogin?accion=login" id="formlogin">
						<label style="width:100%">
							<i class="bi bi-person-fill" style="color:white" ></i>
						</label>
						<input type="text" id="nombrelogin" class="form-control" name="nombrelogin" placeholder="Username">
					
						<label>
							<i class="bi bi-key-fill" style="color:white"></i>
						</label>
						<input type="password" class="form-control"id="passlogin" name="passlogin" placeholder="Password">
						<input type="submit" value="Login" class="start-btn letra_retro" >
				</form>
			</div>
			<div class="card-footer">
				<div id="form_psw">
					 <form class="contact100-form validate-form " id="formu_psw" action="" method="POST">

				        <div class="wrap-input100 validate-input" data-validate="Please enter your email...">
				        <label><i class="bi bi-envelope"  style="color:white"></i></label><input class="input100" type="text" name="email" placeholder="E-mail" onchange="sendMail(this.value)">
				        <span class="focus-input100"></span>
				        </div>
				        <div class="wrap-input100 validate-input mensaje" data-validate="Please enter your message">
				        <i class="bi bi-chat-square-text-fill" style="color:white"></i></br><textarea class="input100 msg" name="message" placeholder="Your Message"></textarea>
				        <span class="focus-input100"></span>
				        </div>
				        <div class="container-contact100-form-btn">
				        </div>
				      	<input type="submit" id="envio_psw" onclick="sendMail(this.value)">
				        <input type="hidden" name="_next" value="http://localhost:8080/bibliotecaHBT/login.jsp">
				         <input type="hidden" name="_capcha" value="false">
        			</form>
				</div>
				<div class="justify-content-center d-flex">
					<a href="#f_passw" id="f_passw">Forgot your password?</a>
					
				</div>
				
				
			</div>
			
		</div>
	</div>
</div>
	</div>
	<audio id="audio_boton">
    	<source src="./sound/click_boton.wav" type="audio/wav">
	</audio>
	<audio id="audio_nologin">
    	<source src="./sound/login_no.wav" type="audio/wav">
	</audio>   
</div>



<footer>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-twitter"></i></a>

        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://twitter.com/" role="button" data-mdb-ripple-color="dark"><i class="bi bi-instagram"></i>
        </a>
        <a class="btn btn-link btn-floating btn-lg text-light m-1" href="https://github.com/essimoeno/Project404.git" role="button" data-mdb-ripple-color="dark"><i class="bi bi-github"></i></a>
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
        <input type="hidden" name="_next" value="http://localhost:8080/bibliotecaHBT/login.jsp">
         <input type="hidden" name="_capcha" value="false">
        </form>
        </div>
    </div>
       
    </footer>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>

</body>
</html>

<%
	ArrayList<String> respuesta_registro =(ArrayList<String>)request.getAttribute("respuesta_registro");
	
	String respuesta_login = (String)request.getAttribute("respuesta_login");
	if(respuesta_login !=null){
		out.print("<script> $('#audio_nologin')[0].play(); </script>");
	}
%>