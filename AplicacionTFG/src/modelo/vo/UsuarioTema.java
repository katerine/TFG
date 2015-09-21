package modelo.vo;

public class UsuarioTema {
	
	private Integer IdTemaUsuario;
	UsuarioVo idusuario;
	Categorias idCategoria;
	
	
	public Integer getIdTemaUsuario() {
		return IdTemaUsuario;
	}
	public void setIdTemaUsuario(Integer idTemaUsuario) {
		IdTemaUsuario = idTemaUsuario;
	}
	
	public UsuarioVo getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(UsuarioVo idusuario) {
		this.idusuario = idusuario;
	}
	public Categorias getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Categorias idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	
	

}
