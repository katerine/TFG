package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controlador.Controlador;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private Controlador Controla; //objeto controla que permite la relacion entre esta clase y la clase controlador
	private JLabel labelTitulo, labelSeleccion;
	private JButton botonUsSinRegistrar,botonUsuRegis;
	

	private JLabel label;

	public VentanaPrincipal() {
		getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		botonUsSinRegistrar = new JButton();
		botonUsSinRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonUsSinRegistrar.setBounds(20, 286, 169, 25);
		botonUsSinRegistrar.setText("Usuario sin Registrar");
		
		botonUsuRegis = new JButton();
		botonUsuRegis.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonUsuRegis.setBounds(242, 286, 169, 25);
		botonUsuRegis.setText("Usuario Registrado");

		labelTitulo = new JLabel();
		labelTitulo.setText("SIST.  RECOMENDADOR DE CONTENIDOS DOCENTES");
		labelTitulo.setBounds(20, 23, 454, 38);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja que operacion desea realizar");
		labelSeleccion.setBounds(30, 250, 250, 25);

		botonUsSinRegistrar.addActionListener(this);
		botonUsuRegis.addActionListener(this);
		getContentPane().add(botonUsuRegis);
		getContentPane().add(botonUsSinRegistrar);
		getContentPane().add(labelSeleccion);
		getContentPane().add(labelTitulo);
	
		setSize(480, 350);
		setTitle("Sistema Recomendador");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\nana\\Desktop\\workSpace\\PatronMVC\\imagenes\\main.png"));
		label.setBounds(20, 59, 441, 192);
		getContentPane().add(label);

	}


	public void setControlador(Controlador controla) {
		this.Controla=controla;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonUsSinRegistrar) {
			Controla.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonUsuRegis) {
			Controla.mostrarVetanaIngreso();		
		}
	}
}
