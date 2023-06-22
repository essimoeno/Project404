
$(document).ready(function () {
	$("#form_editar").hide();
	 $("#but_editar").click(function(){ 
		$("#form_editar").slideToggle();
	
         
     });
     
     $("#enviarCambios").click(function() {
                 // Actualiza la página
                alert('Cambio realizado con exito');
            });
            
            
});

function validarCamposIguales() {
    var campo1 = $("#pswperfil").val();
    var campo2 = $("#pswperfil_r").val();
if(campo1 != "" && campo2!=""){
	

    if (campo1 != campo2) {
        $("#pswperfil_r").removeClass("is-valid").addClass("is-invalid");
        $('#enviarCambios').prop('disabled', true);
        
    } else {
        $("#pswperfil_r").removeClass("is-invalid").addClass("is-valid");
        $('#enviarCambios').prop('disabled', false);
    }
  }
}

function valMail(){
	var mail = $("#mailperfil").val();
    var comp = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/;
    if (comp.test(mail) == false) {
    	$("#mailperfil").removeClass("is-valid").addClass("is-invalid");
    }else{
		$("#mailperfil").removeClass("is-invalid").addClass("is-valid");
	}
}

function comprobarUsername(){
	var username = $("#userperfil").val();
	$.ajax({
			type: "POST",
			url: "servletPerfil",
			data: {
				username: username
			},
			success: function(response) {
				if(response=="false"){
					
					$("#userperfil").removeClass("is-invalid").addClass("is-valid");
					$('#enviarCambios').prop('disabled', false);
				}else if(response=="empty"){
					$("#userperfil").removeClass("is-invalid");
					$('#enviarCambios').prop('disabled', false);
					$("#userperfil").removeClass("is-valid");
				}else{
					$("#userperfil").removeClass("is-valid").addClass("is-invalid");
					$('#enviarCambios').prop('disabled', true);
				}
				
			},
			error: function(xhr, status, error) {
				
			}
		});
}
        