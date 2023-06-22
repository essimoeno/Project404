
$(document).ready(function() {
	
	$('.boton_sonido').click(function() {
		var elem = $('#iconoVol');
		if (elem.hasClass('bi bi-volume-up-fill')) {
			elem.removeClass('bi bi-volume-up-fill').addClass('bi bi-volume-mute');
			$("#audio_pag")[0].pause();
		} else {
			elem.removeClass('bi bi-volume-mute').addClass('bi bi-volume-up-fill');
			$("#audio_pag")[0].play();
		}
	});
	$('#busquedas').click(function() {
		$('#busquedas').slideUp();
	});
	$("#audio_pag")[0].prop("volume", 0.8);

});


//jess


function favorito(id) {
	 var favelem= $("." + id); 
	var fav = favelem.attr("value");

	if (fav == 'false') {
		favelem.html("<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart-fill' viewBox='0 0 16 16'><path fill-rule='evenodd' d='M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z'/></svg>");
   	 	favelem.attr("value", true);
		fav = true;
	} else {
		favelem.html("<svg xmlns='http://www.w3.org/2000/svg' width='25' height='25' fill='currentColor' class='bi bi-heart' viewBox='0 0 16 16'><path d='m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z'/></svg>");
    	favelem.attr("value", false);
		fav = false;
	}
	$.ajax({
		type: "POST",
		url: "servletHome",
		data: {
			id: id,
			fav: fav
		},
		success: function(response) {
			console.log("Solicitud enviada con éxito");
		},
		error: function(xhr, status, error) {
			console.error("Error al enviar la solicitud: " + error);
		}
	});

}

//jess
function buscar(busqueda) {
	if (busqueda != "") {
		$.ajax({
			type: "POST",
			url: "servletHome",
			data: {
				busqueda: busqueda
			},
			success: function(response) {
				console.log("Solicitud enviada con éxito");
				$("#busquedas").html(response);
				$('#busquedas').slideDown();
			},
			error: function(xhr, status, error) {
				console.error("Error al enviar la solicitud: " + error);
			}
		});
	}

}
