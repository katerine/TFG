package controlador;

import modelo.Logica;
import vista.VentanaModifCategoria;
import vista.VentanaRegistroCategoria;
import vista.VentanaIngreso;
import vista.VentanaModif;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;
import vista.VentanaRegistroUT;

public class Principal {
	
	Logica miLogica;
	VentanaPrincipal miVentanaPrincipal;
	VentanaModif miVentanaModif;
	VentanaRegistro miVentanaRegistro;
	VentanaIngreso miVentanaIngreso;
	VentanaRegistroCategoria miVentanaDatos;
	VentanaRegistroUT miVentanaX;
	VentanaModifCategoria miVentanaCate;
	Controlador controla;

	
	public static void main(String[] args) {
		Principal miPrincipal=new Principal();
		miPrincipal.iniciar();
	}

	
	private void iniciar() {

		miVentanaPrincipal=new VentanaPrincipal();
		miVentanaRegistro=new VentanaRegistro();
		miVentanaModif= new VentanaModif();
		miVentanaIngreso = new VentanaIngreso();
		miVentanaDatos = new VentanaRegistroCategoria();
		miVentanaX = new VentanaRegistroUT();
		miVentanaCate = new VentanaModifCategoria();
		miLogica=new Logica();
		controla= new Controlador();
		
		miVentanaPrincipal.setControlador(controla);
		miVentanaRegistro.setControlador(controla);
		miVentanaModif.setControlador(controla);
		miVentanaIngreso.setControlador(controla);
		miVentanaDatos.setControlador(controla);
		miVentanaX.setControlador(controla);
		miVentanaCate.setControlador(controla);
		miLogica.setControlador(controla);
		
		controla.setMiVentanaPrincipal(miVentanaPrincipal);
		controla.setMiVentanaRegistro(miVentanaRegistro);
		controla.setMiVentanaModif(miVentanaModif);
		controla.setMiVentanaIngreso(miVentanaIngreso);
		controla.setMiVentanaDatos(miVentanaDatos);
		controla.setMiVentanaX(miVentanaX);
		controla.setVentanaCate(miVentanaCate);
		controla.setMiLogica(miLogica);
				
		miVentanaPrincipal.setVisible(true);
	}

}
