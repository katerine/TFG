package vista;

import java.awt.Font;
import java.awt.Toolkit;
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
import modelo.vo.UsuarioVo;
import controlador.Controlador;

public class VentanaModif  extends JFrame implements ActionListener {

	private Controlador miControla; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JLabel labelTitulo;
	private JTextField textId,textNombre,textEdad,textTelefono,textProfesion;
	private JLabel Id,nombre,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	private JLabel label;
	

	public VentanaModif() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nana\\Desktop\\workSpace\\PatronMVC\\imagenes\\registro.jpg"));
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
		botonBuscar.setBounds(170, 119, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonEliminar.setBounds(330, 256, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonModificar.setBounds(190, 227, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("Configurar Usuarios");
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
		nombre.setBounds(20, 155, 80, 25);
		getContentPane().add(nombre);

		telefono=new JLabel();
		telefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		telefono.setText("telefono");
		telefono.setBounds(290, 191, 80, 25);
		getContentPane().add(telefono);
		
		profesion=new JLabel();
		profesion.setFont(new Font("Tahoma", Font.BOLD, 11));
		profesion.setText("profesion");
		profesion.setBounds(20, 191, 80, 25);
		getContentPane().add(profesion);
		
		edad=new JLabel();
		edad.setFont(new Font("Tahoma", Font.BOLD, 11));
		edad.setText("Edad");
		edad.setBounds(290, 155, 80, 25);
		getContentPane().add(edad);
		
		textId=new JTextField();
		textId.setBounds(80, 119, 80, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 156, 190, 25);
		getContentPane().add(textNombre);

		textTelefono=new JTextField();
		textTelefono.setBounds(340, 191, 80, 25);
		getContentPane().add(textTelefono);
		
		textProfesion=new JTextField();
		textProfesion.setBounds(80, 191, 190, 25);
		getContentPane().add(textProfesion);
		
		textEdad=new JTextField();
		textEdad.setBounds(340, 155, 80, 25);
		getContentPane().add(textEdad);
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		getContentPane().add(botonCancelar);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonModificar);
		getContentPane().add(botonEliminar);
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
				UsuarioVo miUsuario=new UsuarioVo();
				miUsuario.setIdUsuario(Integer.parseInt(textId.getText()));
				miUsuario.setNombreUsuario(textNombre.getText());
				miUsuario.setTelefonoUsuario(Integer.parseInt(textTelefono.getText()));
				miUsuario.setEdadUsuario(Integer.parseInt(textEdad.getText()));
				miUsuario.setProfesionUsuario(textProfesion.getText());

				miControla.modificarUsuario(miUsuario);
				
				if (Logica.modificaUsuario==true) {
					habilita(true, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			UsuarioVo miPersona=miControla.buscarUsuario(textId.getText());
			if (miPersona!=null)
			{
				muestraUsuario(miPersona);
			}
			else if(Logica.consultaUsuario==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"¿Esta seguro de eliminar la Persona?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					miControla.eliminarUsuario(textId.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}


	private void muestraUsuario(UsuarioVo usuario) {
		textNombre.setText(usuario.getNombreUsuario());
		textEdad.setText(usuario.getEdadUsuario()+"");
		textTelefono.setText(usuario.getTelefonoUsuario()+"");
		textProfesion.setText(usuario.getProfesionUsuario());
		habilita(true, false, false, false, false, true, false, true, true);
	}


	
	public void limpiar()
	{
		textId.setText("");
		textNombre.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param Id
	 * @param nombre
	 * @param edad
	 * @param tel
	 * @param profesion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean Id, boolean nombre, boolean edad, boolean tel, boolean profesion,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(Id);
		textNombre.setEditable(nombre);
		textEdad.setEditable(edad);
		textTelefono.setEditable(tel);
		textProfesion.setEditable(profesion);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
