package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Label;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JButton;

import controlador.Controlador;

public class VentanaIngreso extends JFrame implements ActionListener {
	private Controlador Controla; //objeto controla que permite la relacion entre esta clase y la clase controlador
	private JLabel labelTitulo, labelSeleccion;
	private JButton botonModif,botonPerfil, BotonCategoria,botonModifCa;
	

	private JLabel label;

	public VentanaIngreso() {
		

		botonModif = new JButton();
		botonModif.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonModif.setBounds(20, 286, 169, 25);
		botonModif.setText("Modificar Usuario");
		
		botonPerfil = new JButton();
		botonPerfil.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonPerfil.setBounds(242, 286, 169, 25);
		botonPerfil.setText("crear perfil de Usuario");
		
		BotonCategoria = new JButton();
		BotonCategoria.setFont(new Font("Tahoma", Font.BOLD, 13));
		BotonCategoria.setBounds(58, 204, 177, 25);
		BotonCategoria.setText("crear Categoria");
		
		botonModifCa = new JButton();
		botonModifCa.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonModifCa.setBounds(58, 240, 160, 23);
		botonModifCa.setText("Modif Categ");
		
		
		getContentPane().add(botonModifCa);

		labelTitulo = new JLabel();
		labelTitulo.setText("recoger especificaciones");
		labelTitulo.setBounds(20, 23, 454, 38);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

	
		
		botonModif.addActionListener(this);
		botonPerfil.addActionListener(this);
		BotonCategoria.addActionListener(this);
		botonModifCa.addActionListener(this);
		getContentPane().add(botonPerfil);
		getContentPane().add(botonModif);
		getContentPane().add(BotonCategoria);
		getContentPane().add(botonModifCa);
		getContentPane().add(labelTitulo);
	
		setSize(480, 350);
		setTitle("Sistema Recomendador");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JTextPane txtpnSeRecogeraLa = new JTextPane();
		txtpnSeRecogeraLa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnSeRecogeraLa.setText("Se recogera la informacion de interes de los usuarios si se escoge la opcion Crear perfil de usuario, por el contrario si se escoge la opcion Modificar usuario podra cambiar datos del registro de usuario");
		txtpnSeRecogeraLa.setBounds(79, 96, 336, 97);
		getContentPane().add(txtpnSeRecogeraLa);
		
		
	}


	public void setControlador(Controlador controla) {
		this.Controla=controla;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonModif) {
			Controla.mostrarVentanaModif();			
		}
		if (e.getSource()==botonPerfil) {
			Controla.mostrarVentanaUT();	
		}
		
		if (e.getSource()== BotonCategoria){
			Controla.mostrarVetanaCategoria();
		}
		
		if (e.getSource()== botonModifCa) {
			Controla.mostrarModifCategoria();
		}
	}
}
