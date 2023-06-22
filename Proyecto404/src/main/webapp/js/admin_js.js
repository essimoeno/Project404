$(document).ready(function () {

     $("#form_registro").submit(function() {
	
    var check = $("#esAdmin");
    
    if (check.is(":checked")) {
      check.val("admin");
    } else {
      check.val("");
    }
  });
})


function destacado(id) {
	var des = $("#" + id).attr("value");

	if (des == 'false') {
		$("#" + id).html("<i class=\"bi bi-star-fill\" style='color:yellow'></i>");
		$("#" + id).attr("value", true);
		des = true;
	} else {
		$("#" + id).html("<i class=\"bi bi-star-fill\" style='color:pink'></i>");
		$("#" + id).attr("value", false);
		des = false;
	}
	$.ajax({
		type: "POST",
		url: "servletAdmin",
		data: {
			id: id,
			des: des
		},
		success: function(response) {
			console.log("Solicitud enviada con éxito");
		},
		error: function(xhr, status, error) {
			console.error("Error al enviar la solicitud: " + error);
		}
	});

}/**
 * 
 */