
$(document).ready(function(){
	// Inicializo
	//document.getElementById("formulario_login").addEventListener('submit', validarLogin, false);
});


function validarLogin () {
	var nombre = document.getElementById("nickname").value;
	var pass = document.getElementById("password").value;
	
	if(nombre == "") {
		alert("No has introducido un nombre de usuario");
	} else if (pass == "") {
		alert("No has introducido la contraseña");
	} else {
		consultaBBDD(nombre, pass);
		alert(document.getElementById("boton_acceso").Text);
	}
}


function consultaBBDD (nombre, pass) {
	// Se consulta a la base de datos
	var nickname = document.getElementById("nickname").value;
	var pass = document.getElementById("password").value;
	
	$.ajax({
        type:"POST",
        url:"http://localhost/EDHospi/php/accesoUsuario.php",
        async:"true",
        data:{'user': nickname},
        dataType:"json",
        success:function(resp) {
			console.log(resp);
        },
        error:function(xhr,status, a3){
            console.log(status);
            console.log(a3);
            alert("Error. No se ha podido." + xhr);
        }
    });
}