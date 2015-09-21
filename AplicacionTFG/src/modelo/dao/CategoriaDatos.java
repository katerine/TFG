package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.Categorias;
import modelo.vo.UsuarioVo;

public class CategoriaDatos {
	
	public void registrarCategoria(Categorias miUsuario)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement sql = conex.getConnection().createStatement();
			sql.executeUpdate("INSERT INTO tema VALUES ('"+miUsuario.getIdTema()+"', '"
					+miUsuario.getTitulo()+"', '"+miUsuario.getTema()+"')");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			sql.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public Categorias buscarCategoria(int id) 
	{
		Conexion conex= new Conexion();
		Categorias usuario= new Categorias();
		boolean existe=false;
		try {
			
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM tema where Id_Tema = ? ");
			consulta.setInt(1, id);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				usuario.setIdTema(Integer.parseInt(res.getString("Id_Tema")));
				usuario.setTitulo(res.getString("titulo"));
				usuario.setTema(res.getString("Asigantura"));
			}
			res.close();
			conex.desconectar();
					
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return usuario;
			}
			else return null;				
	}

	public void modificarUsuario(Categorias usuario) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE tema SET id= ? ,titulo = ? , Asignatura=? WHERE Id_Tema= ? ";
			PreparedStatement sql = conex.getConnection().prepareStatement(consulta);
			
            sql.setInt(1, usuario.getIdTema());
            sql.setString(2, usuario.getTitulo());
            sql.setString(3, usuario.getTema());
            sql.setInt(4, usuario.getIdTema());
            sql.executeUpdate();

          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarUsuario(String id)
	{
		Conexion conex= new Conexion();
		try {
			Statement sql = conex.getConnection().createStatement();
			sql.executeUpdate("DELETE FROM tema WHERE Id_Tema='"+id+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
			sql.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}


}
