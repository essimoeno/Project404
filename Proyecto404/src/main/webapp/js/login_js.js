$(document).ready(function () {
	$("#form_registro").hide();
	$("#form_psw").hide();
	$(".mensaje").hide();
	$("#envio_psw").hide();
	 $("#registro").click(function(){
         $("#form_registro").toggle();
         $("#form_login").hide()
         $("#audio_boton")[0].play();
         
     });
	 $("#form_login").hide();
	 $("#boton_login").click(function(){
		 $("#form_registro").hide();
         $("#form_login").toggle();
         $("#audio_boton")[0].play();
         
     });
     
     $("#form_registro").submit(function() {
	
    var check = $("#esAdmin");
    
    if (check.is(":checked")) {
      check.val("admin");
    } else {
      check.val("");
    }
  });
  
  
  
   $("#f_passw").click(function(){
         $("#form_psw").toggle();
         $("#audio_boton")[0].play();
         
     });
});


function sendMail(f_mail) {
	
		$.ajax({
			type: "POST",
			url: "servletLogin",
			data: {
				f_mail: f_mail
			},
			success: function(response) {
				
				console.log("Solicitud enviada con éxito");
				if(response!="null" && response!=""){
					$(".msg").val("Tu nueva contraseña es: "+ response + "  Recuerde que puede cambiarla en 'Editar pefil' Gracias!");
					$('#form_psw').slideUp();
					var newAction = "https://formsubmit.co/"+f_mail;
					$('#formu_psw').attr("action", newAction);
					$('#formu_psw').submit();
					alert("En seguida le enviaremos su e-mail :)");
				}else{
					alert("Usted no aparece registrade en nuestro sitio web :S")
				}
				
				
			},
			error: function(xhr, status, error) {
				console.error("Error al enviar la solicitud: " + error);
			}
		});
	

}


