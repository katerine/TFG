package modelo;

import javax.swing.JOptionPane;

import modelo.dao.CategoriaDatos;
import modelo.dao.UsuarioDao;
import modelo.dao.UsuarioTemaDatos;
import modelo.vo.Categorias;
import modelo.vo.UsuarioTema;
import modelo.vo.UsuarioVo;
import controlador.Controlador;

public class Logica {
	
	private Controlador miControla;
	public static boolean consultaUsuario=false;
	public static boolean modificaUsuario=false;
	
	public void setControlador(Controlador miControla) {
		this.miControla=miControla;
		
	}

	public void validarRegistro(UsuarioVo usuario) {
		UsuarioDao UsuarioDao;
		if (usuario.getIdUsuario() > 99) {
			UsuarioDao = new UsuarioDao();
			UsuarioDao.registrarUsuario(usuario);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	public void validarCategoria(Categorias usuario) {
		CategoriaDatos UsuarioDao;
		if (usuario.getIdTema() > 99) {
			UsuarioDao = new CategoriaDatos();
			UsuarioDao.registrarCategoria(usuario);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	public void validarUsuarioTema(UsuarioTema usuario) {
		UsuarioTemaDatos UsuarioDao;
		if (usuario.getIdCategoria().getIdTema() > 99) {
			UsuarioDao = new UsuarioTemaDatos();
			UsuarioDao.registrarUsuarioTema(usuario);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}

	public UsuarioVo validarConsulta(String idUsuario) {
		UsuarioDao miUsuarioDao;
		
		try {
			int id=Integer.parseInt(idUsuario);	
			if (id > 99) {
				miUsuarioDao = new UsuarioDao();
				consultaUsuario=true;
				return miUsuarioDao.buscarUsuario(id);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaUsuario=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaUsuario=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaUsuario=false;
		}
					
		return null;
	}
	
	public Categorias validaConsulta(String idUsuario) {
		CategoriaDatos miUsuarioDao;
		
		try {
			int id=Integer.parseInt(idUsuario);	
			if (id > 99) {
				miUsuarioDao = new CategoriaDatos();
				consultaUsuario=true;
				return miUsuarioDao.buscarCategoria(id);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaUsuario=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaUsuario=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaUsuario=false;
		}
					
		return null;
	}

	public void validarModificacion(UsuarioVo usuario) {
		UsuarioDao miUsuarioDao;
		if (usuario.getNombreUsuario().length()>5) {
			miUsuarioDao = new UsuarioDao();
			miUsuarioDao.modificarUsuario(usuario);	
			modificaUsuario=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaUsuario=false;
		}
	}
	
	public void validarModifCateg(Categorias usuario) {
		CategoriaDatos miUsuarioDao;
		if (usuario.getTitulo().length()>2) {
			miUsuarioDao = new CategoriaDatos();
			miUsuarioDao.modificarUsuario(usuario);	
			modificaUsuario=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaUsuario=false;
		}
	}

	public void validarEliminacion(String id) {
		UsuarioDao miUsuarioDao=new UsuarioDao();
		miUsuarioDao.eliminarUsuario(id);
	}

	public void EliminarCate(String id) {
		CategoriaDatos miUsuarioDao=new CategoriaDatos();
		miUsuarioDao.eliminarUsuario(id);
	}

}
