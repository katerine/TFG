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
import modelo.vo.UsuarioTema;
import modelo.vo.UsuarioVo;
import controlador.Controlador;

public class VentanaRegistroUT extends JFrame implements ActionListener {
	private Controlador miControla; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JLabel labelTitulo;
	private JTextField textId,textIdUsuario,textTema;
	private JLabel Id,idUsuario,Tema;
	private JButton botonOk,botonCancelar,botonModificar,botonEliminar;
	private JLabel label;
	private JButton botonAgregar, btnGuarda;
	

	public VentanaRegistroUT() {
		
		getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));

		botonOk = new JButton();
		botonOk.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonOk.setBounds(170, 119, 53, 25);
		botonOk.setText("Ok");
		
		botonCancelar = new JButton();
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonCancelar.setBounds(134, 256, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonAgregar = new JButton();
		botonAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonAgregar.setBounds(280, 256, 105, 25);
		botonAgregar.setText("Recomendar");
		
		btnGuarda = new JButton();
		btnGuarda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuarda.setBounds(35, 257, 89, 23);
		btnGuarda.setText("Guardar");
						
		labelTitulo = new JLabel();
		labelTitulo.setText("Configurar Usuarios");
		labelTitulo.setBounds(20, 42, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		Id=new JLabel();
		Id.setFont(new Font("Tahoma", Font.BOLD, 11));
		Id.setText("ID");
		Id.setBounds(20, 119, 80, 25);
		getContentPane().add(Id);
		
		idUsuario=new JLabel();
		idUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		idUsuario.setText("IdUsuario");
		idUsuario.setBounds(10, 155, 80, 25);
		getContentPane().add(idUsuario);
		
		Tema=new JLabel();
		Tema.setFont(new Font("Tahoma", Font.BOLD, 11));
		Tema.setText("IdTema");
		Tema.setBounds(10, 191, 80, 25);
		getContentPane().add(Tema);
		
		textId=new JTextField();
		textId.setBounds(80, 119, 80, 25);
		getContentPane().add(textId);
		
		textIdUsuario=new JTextField();
		textIdUsuario.setBounds(80, 155, 190, 25);
		getContentPane().add(textIdUsuario);
		
		textTema=new JTextField();
		textTema.setBounds(80, 191, 80, 25);
		getContentPane().add(textTema);
		botonOk.addActionListener(this);
		botonCancelar.addActionListener(this);
		botonAgregar.addActionListener(this);
		btnGuarda.addActionListener(this);
		
		getContentPane().add(botonAgregar);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonOk);

		getContentPane().add(btnGuarda);
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
		if (e.getSource()==botonOk)
		{
			UsuarioVo miPersona=miControla.buscarUsuario(textIdUsuario.getText());
			Categorias cat = miControla.buscarCategoria(textTema.getText());
			if (miPersona!=null)
			{
			////	muestraUsuario(miPersona);
			}
			else if(Logica.consultaUsuario==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}

			if(cat!= null)
			{
				//	muestraTema(cat);
			}else if(Logica.consultaUsuario==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==btnGuarda)
		{
			UsuarioTema user = new UsuarioTema();
			user.setIdTemaUsuario(Integer.parseInt(textId.getText()));
			textIdUsuario.setText(user.getIdusuario().getIdUsuario()+"");
			textTema.setText(user.getIdCategoria().getIdTema()+"");
//			user.getIdusuario().getIdUsuario();
//			user.getIdCategoria().getIdTema();
			
			muestraUsuario(user);
			muestraTema(user);
			
		}
		
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	
}
	private void limpiar() 
	{
		textId.setText("");
		textIdUsuario.setText("");
		textTema.setText("");
	}
	
	private void muestraUsuario(UsuarioTema user) {
		textIdUsuario.setText(user.getIdusuario()+"");
	}
	
	private void muestraTema(UsuarioTema user) {
		textTema.setText(user.getIdCategoria()+"");
	}
}
