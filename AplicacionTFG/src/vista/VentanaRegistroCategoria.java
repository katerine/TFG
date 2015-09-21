package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import modelo.Logica;
import modelo.vo.Categorias;
import controlador.Controlador;

public class VentanaRegistroCategoria extends JFrame implements ActionListener {
	private Controlador miControla; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JLabel labelTitulo;
	private JTextField textId,textNombre,textTema;
	private JLabel Id,nombre,Tema;
	private JButton botonGuardar,botonCancelar,botonModificar,botonEliminar;
	private JLabel label;
	private JButton botonBuscar;
	

	public VentanaRegistroCategoria() {
		
		getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));

		botonGuardar = new JButton();
		botonGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonGuardar.setBounds(48, 256, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonCancelar.setBounds(190, 256, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonBuscar.setBounds(360, 256, 78, 25);
		botonBuscar.setText("Buscar");
				
		labelTitulo = new JLabel();
		labelTitulo.setText("Registrar Categoria");
		labelTitulo.setBounds(20, 42, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		Id=new JLabel();
		Id.setFont(new Font("Tahoma", Font.BOLD, 11));
		Id.setText("ID");
		Id.setBounds(20, 119, 80, 25);
		getContentPane().add(Id);
		
		nombre=new JLabel();
		nombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombre.setText("Nombre");
		nombre.setBounds(10, 155, 80, 25);
		getContentPane().add(nombre);
		
		Tema=new JLabel();
		Tema.setFont(new Font("Tahoma", Font.BOLD, 11));
		Tema.setText("Tema");
		Tema.setBounds(10, 191, 80, 25);
		getContentPane().add(Tema);
		
		textId=new JTextField();
		textId.setBounds(80, 119, 80, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 155, 190, 25);
		getContentPane().add(textNombre);
		
		textTema=new JTextField();
		textTema.setBounds(80, 191, 80, 25);
		getContentPane().add(textTema);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		botonBuscar.addActionListener(this);
		
		getContentPane().add(botonBuscar);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
				
		setSize(480, 320);
		setTitle("Configurar Usuario");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\nana\\Desktop\\workSpace\\PatronMVC\\imagenes\\images.jpg"));
		label.setBounds(242, 11, 222, 133);
		getContentPane().add(label);
		

	}


	public void setControlador(Controlador miControla) {
		this.miControla=miControla;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Categorias usuario=new Categorias();
				usuario.setIdTema(Integer.parseInt(textId.getText()));
				usuario.setTitulo(textNombre.getText());
				usuario.setTema(textTema.getText());
				
				miControla.registrarCategoria(usuario);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
		
		if (e.getSource()== botonBuscar){

	Categorias cat = miControla.buscarCategoria(textId.getText());
			if(cat!= null)
			{
					muestraTema(cat);
			}else if(Logica.consultaUsuario==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	private void limpiar() 
	{
		textId.setText("");
		textNombre.setText("");
		textTema.setText("");
	}

	private void muestraTema(Categorias usuario) {
		textNombre.setText(usuario.getTitulo());
		textTema.setText(usuario.getTema());
		
	}
}
