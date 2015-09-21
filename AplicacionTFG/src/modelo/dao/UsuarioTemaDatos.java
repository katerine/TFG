package modelo.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.UsuarioTema;
import modelo.vo.UsuarioVo;

public class UsuarioTemaDatos {
	
	
	public void registrarUsuarioTema(UsuarioTema miUsuario)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement sql = conex.getConnection().createStatement();
			sql.executeUpdate("INSERT INTO usuario-tema VALUES ('"+miUsuario.getIdTemaUsuario()+"','"+miUsuario.getIdusuario()+"', '"
					+miUsuario.getIdCategoria()+"')");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			sql.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
		
		
		
	}
	
	
	

	

}
