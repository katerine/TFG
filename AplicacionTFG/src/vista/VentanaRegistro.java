package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.vo.UsuarioVo;

import controlador.Controlador;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.UIManager;


public class VentanaRegistro extends JFrame implements ActionListener{

	private Controlador controla; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JLabel labelTitulo;
	private JTextField textId,textNombre,textEdad,textTelefono,textProfesion;
	private JLabel id,nombre,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar;
	private JLabel label;
	
	
	public VentanaRegistro() {
		getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nana\\Desktop\\workSpace\\PatronMVC\\imagenes\\registro.jpg"));

		botonGuardar = new JButton();
		botonGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonGuardar.setBounds(103, 236, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonCancelar.setBounds(264, 236, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE USUARIOS");
		labelTitulo.setBounds(20, 32, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		id=new JLabel();
		id.setFont(new Font("Tahoma", Font.BOLD, 11));
		id.setText("ID");
		id.setBounds(20, 92, 80, 25);
		getContentPane().add(id);
		
		nombre=new JLabel();
		nombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombre.setText("Nombre");
		nombre.setBounds(20, 141, 80, 25);
		getContentPane().add(nombre);

		telefono=new JLabel();
		telefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		telefono.setText("tel\u00E9fono");
		telefono.setBounds(304, 200, 80, 25);
		getContentPane().add(telefono);
		
		edad=new JLabel();
		edad.setFont(new Font("Tahoma", Font.BOLD, 11));
		edad.setText("Edad");
		edad.setBounds(304, 164, 80, 25);
		getContentPane().add(edad);
		
		profesion=new JLabel();
		profesion.setFont(new Font("Tahoma", Font.BOLD, 11));
		profesion.setText("Profesi\u00F3n");
		profesion.setBounds(20, 187, 80, 25);
		getContentPane().add(profesion);
		
		textId=new JTextField();
		textId.setBounds(80, 92, 80, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 141, 190, 25);
		getContentPane().add(textNombre);

		textTelefono=new JTextField();
		textTelefono.setBounds(363, 200, 80, 25);
		getContentPane().add(textTelefono);
		
		textEdad=new JTextField();
		textEdad.setBounds(363, 164, 80, 25);
		getContentPane().add(textEdad);
		
		textProfesion=new JTextField();
		textProfesion.setBounds(80, 187, 190, 25);
		getContentPane().add(textProfesion);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Registro De usuarios");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\nana\\Desktop\\workSpace\\PatronMVC\\imagenes\\images.jpg"));
		label.setBounds(306, 11, 158, 103);
		getContentPane().add(label);

	}


	private void limpiar() 
	{
		textId.setText("");
		textNombre.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
	}


	public void setControlador(Controlador miControla) {
		this.controla=miControla;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				UsuarioVo usuario=new UsuarioVo();
				usuario.setIdUsuario(Integer.parseInt(textId.getText()));
				usuario.setNombreUsuario(textNombre.getText());
				usuario.setTelefonoUsuario(Integer.parseInt(textTelefono.getText()));
				usuario.setEdadUsuario(Integer.parseInt(textEdad.getText()));
				usuario.setProfesionUsuario(textProfesion.getText());
				
				controla.registrarUsuario(usuario);	
				
			System.out.print(usuario);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
	

}
