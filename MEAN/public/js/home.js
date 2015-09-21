

$(document).ready(function(){
	// Inicializo los datos del los gráficos a vacío
	var datos_linea = {
		labels : ['',''],
		datasets : [
			{
				label: "Mi peso actual",
				fillColor : "rgba(220,220,220,0.2)",
				strokeColor : "rgba(23,193,55,1)",
				pointColor : "rgba(220,220,220,1)",
				pointStrokeColor : "#fff",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(220,220,220,1)",
				data: [60,60]
			},
			{
				label: "Mi peso estimado",
				fillColor : "rgba(151,187,205,0.2)",
				strokeColor : "rgba(151,187,205,1)",
				pointColor : "rgba(151,187,205,1)",
				pointStrokeColor : "#fff",
				pointHighlightFill : "#fff",
				pointHighlightStroke : "rgba(151,187,205,1)",
				data: [60,60]
			}
		]
	}
	
	var datos_polar = [
		{
			value: 80,
			color:"#46BFBD",
			highlight: "#5AD3D1",
			label: "Retos"
		},
		{
			value: 50,
			color: "#F7464A",
			highlight: "#FF5A5E",
			label: "Actividades Físicas"
		},
		{
			value: 100,
			color: "#FDB45C",
			highlight: "#FFC870",
			label: "Cuestionarios"
		}	
	];
	
	// Preparación del objeto Canvas
	var donut = document.getElementById("grafico_donut").getContext("2d");
	var linea = document.getElementById("grafico_linea").getContext("2d");
	
	// Inicializacion de los gráficos
	window.donut = new Chart(donut).PolarArea(datos_polar, {
		responsive: true
	});
	window.linea = new Chart(linea).Line(datos_linea, {
		responsive: true
	});
	
	// Funcion para cambiar de rol en el testeo
	$("#cambiar_perfil").change(function() {
		localStorage.rol = $("#cambiar_perfil").val();
		location.reload();
		
	});
	
	// 	
	actualizarDatosLinea();
	//obtenerDatosLinea();
});


function obtenerDatosDonut () {
	
	
	return datos_polar;
}


function actualizarDatosLinea () {
	// Se consulta a la base de datos para extraer la lista de pesos registrados
	$.ajax({
        type:"POST",
        url:"http://tivitygroup.es/PROVITAO/sacarPesos.php",
        async:"true",
        data:{'id_usuario': localStorage.id_usuario},
        dataType:"json",
        success:function(resp) {
			var tmp = new Array();
			var pesos_registrados = new Array();
			var pesos_tendencia = new Array(12);
			var array_meses = new Array('Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre');
			var meses = new Array(12);
			var media = 0;
			var j = 0;
			var mes_de_inicio;
			
			// Si hemos recibido algún dato de peso...
			if(resp) {
				// Covnertimos el objeto en formato array para trabajar mejor con las posiciones.
				for(var i in resp) {
					tmp.push(resp[i].peso_registrado);
				}
				
				// Si el número de meses registrados es inferior a un año...
				if(tmp.length < 12) {
					// Se cactualiza el vector con los pesos obtenidos
					for(var i = 0; i < tmp.length; i++) {
						pesos_registrados.push(tmp[i]);
						media += parseFloat(pesos_registrados[i]);
					}
					
					mes_de_inicio = resp[0].fecha_registro;
				} else {
					// Se cargan en los vectores de datos tan solo los 12 ultimos meses
					for(var i = (tmp.length - 12); i < tmp.length; i++) {
						pesos_registrados[j] = tmp[i];
						media += parseFloat(pesos_registrados[j]);
						j++;
					}
					mes_de_inicio = resp[(resp.length-12)].fecha_registro;
				}
			}
			
			
			
			// Se calcula el vector de datos estimados
			pesos_tendencia[0] = pesos_registrados[0];//(media/pesos_registrados.length).toFixed(2);
			for(var i = 1; i < 12; i++) {
				if(pesos_registrados[i-1] > 0) {
					pesos_tendencia[i] = (pesos_registrados[i-1] - (pesos_registrados[i-1]*0.005)).toFixed(2);
				} else {
					pesos_tendencia[i] = (pesos_tendencia[i-1] - (pesos_tendencia[i-1]*0.005)).toFixed(2);
				}
			}
			
			// Se calculan el vector de meses para un año partiendo desde el mes inicial
			mes_de_inicio = parseInt(mes_de_inicio[5] + mes_de_inicio[6]);
			for(var i = 0; i < 12; i++) {
				meses[i] = array_meses[mes_de_inicio-1];
				if(mes_de_inicio == 12)
					mes_de_inicio = 1;
				else
					mes_de_inicio++;
			}
			
			
			
			// Se estructura y se lanza
			for(var i = 0; i < 12; i++) {
				console.log([pesos_registrados[i], pesos_tendencia[i]], meses[i]);
				if(pesos_registrados[i]) {
					window.linea.addData([pesos_registrados[i], pesos_tendencia[i]], meses[i]);
				} else {
					window.linea.addData([null, pesos_tendencia[i]], meses[i]);
				}
			}
			
			// Llamamos dos veces a esta funcion para eliminar los dos puntos fijos necesarios para que el chart funcione debido a su Bug
			window.linea.removeData();
			window.linea.removeData();
        },
        error:function(xhr,status, a3){
            console.log(status);
            console.log(a3);
            alert("Error. No se ha podido obtener los pesos del usuario." + xhr);
        }
    });
}


function contactarAmigo(amigo) {
	localStorage.amigo_contactado = amigo;
	moverA('panel_contacto.html');	
}