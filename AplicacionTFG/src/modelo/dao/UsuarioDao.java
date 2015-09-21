package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Controlador;

import modelo.conexion.Conexion;
import modelo.vo.UsuarioVo;


public class UsuarioDao
{

	public void registrarUsuario(UsuarioVo miUsuario)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement sql = conex.getConnection().createStatement();
			sql.executeUpdate("INSERT INTO persona VALUES ('"+miUsuario.getIdUsuario()+"', '"
					+miUsuario.getNombreUsuario()+"', '"+miUsuario.getEdadUsuario()+"', '"
					+miUsuario.getProfesionUsuario()+"', '"+miUsuario.getTelefonoUsuario()+"')");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			sql.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public UsuarioVo buscarUsuario(int id) 
	{
		Conexion conex= new Conexion();
		UsuarioVo usuario= new UsuarioVo();
		boolean existe=false;
		try {
			
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where id = ? ");
			consulta.setInt(1, id);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				usuario.setIdUsuario(Integer.parseInt(res.getString("id")));
				usuario.setNombreUsuario(res.getString("nombre"));
				usuario.setEdadUsuario(Integer.parseInt(res.getString("edad")));
				usuario.setProfesionUsuario(res.getString("profesion"));
				usuario.setTelefonoUsuario(Integer.parseInt(res.getString("telefono")));
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

	public void modificarUsuario(UsuarioVo usuario) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE persona SET id= ? ,nombre = ? , edad=? , profesion=? , telefono= ? WHERE id= ? ";
			PreparedStatement sql = conex.getConnection().prepareStatement(consulta);
			
            sql.setInt(1, usuario.getIdUsuario());
            sql.setString(2, usuario.getNombreUsuario());
            sql.setInt(3, usuario.getEdadUsuario());
            sql.setString(4, usuario.getProfesionUsuario());
            sql.setInt(5,usuario.getTelefonoUsuario());
            sql.setInt(6, usuario.getIdUsuario());
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
			sql.executeUpdate("DELETE FROM persona WHERE id='"+id+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
			sql.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
