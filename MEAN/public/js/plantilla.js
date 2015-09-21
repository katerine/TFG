
$(document).ready(function(){
	// Inicializo
	
});


function funcionCreada () {
	
}


function consultaBBDD () {
	// Se consulta a la base de datos
	$.ajax({
        type:"POST",
        url:"http://tivitygroup.es/PROVITAO/sacarPesos.php",
        async:"true",
        data:{'id_usuario': localStorage.id_usuario},
        dataType:"json",
        success:function(resp) {
			
        },
        error:function(xhr,status, a3){
            console.log(status);
            console.log(a3);
            alert("Error. No se ha podido." + xhr);
        }
    });
}