package controlador;

import modelo.Logica;
import modelo.dao.UsuarioDao;
import modelo.vo.Categorias;
import modelo.vo.UsuarioTema;
import modelo.vo.UsuarioVo;
import vista.VentanaModifCategoria;
import vista.VentanaRegistroCategoria;
import vista.VentanaIngreso;
import vista.VentanaModif;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;
import vista.VentanaRegistroUT;


public class Controlador {

	private Logica miLogica;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistro miVentanaRegistro;
	private VentanaModif miVentanaModif;
	private VentanaIngreso miVentanaIngreso;
	private VentanaRegistroCategoria miVentanaDatos;
	private VentanaModifCategoria miVentanaCate;
	private VentanaRegistroUT miVentanaX;

	public VentanaModifCategoria getVentanaCate() {
		return miVentanaCate;
	}
	public void setVentanaCate(VentanaModifCategoria ventanaCate) {
		this.miVentanaCate = ventanaCate;
	}
	public VentanaRegistroUT getMiVentanaX() {
		return miVentanaX;
	}
	public void setMiVentanaX(VentanaRegistroUT miVentanaX) {
		this.miVentanaX = miVentanaX;
	}
	public VentanaRegistroCategoria getMiVentanaDatos() {
		return miVentanaDatos;
	}
	public void setMiVentanaDatos(VentanaRegistroCategoria miVentanaDatos) {
		this.miVentanaDatos = miVentanaDatos;
	}
	public VentanaIngreso getMiVentanaIngreso() {
		return miVentanaIngreso;
	}
	public void setMiVentanaIngreso(VentanaIngreso miVentanaIngreso) {
		this.miVentanaIngreso = miVentanaIngreso;
	}
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistro getMiVentanaRegistro() {
		return miVentanaRegistro;
	}
	public void setMiVentanaRegistro(VentanaRegistro miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}
	public VentanaModif getMiVentanaModif() {
		return miVentanaModif;
	}
	public void setMiVentanaModif(VentanaModif miVentanaModif) {
		this.miVentanaModif = miVentanaModif;
	}
	public Logica getMiLogica() {
		return miLogica;
	}
	public void setMiLogica(Logica miLogica) {
		this.miLogica = miLogica;
	}
	

	
	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}
	public void mostrarVentanaModif() {
		miVentanaModif.setVisible(true);
	}
	public void mostrarVetanaIngreso(){
		miVentanaIngreso.setVisible(true);
	}
	
	public void mostrarVetanaCategoria(){
		miVentanaDatos.setVisible(true);
	}
	
	public void mostrarVentanaUT(){
		miVentanaX.setVisible(true);
	}
		
	public void mostrarModifCategoria(){
		miVentanaCate.setVisible(true);
	}
	public void registrarUsuario(UsuarioVo usuario) {
		miLogica.validarRegistro(usuario);
	}
	
	public void registrarCategoria(Categorias usuario) {
		miLogica.validarCategoria(usuario);
	}
	
	public void registrarUsuarioTema(UsuarioTema usuario) {
		miLogica.validarUsuarioTema(usuario);
	}
	
	public UsuarioVo buscarUsuario(String idUsuario) {
		return miLogica.validarConsulta(idUsuario);
	}
	
	public Categorias buscarCategoria(String idTema) {
		return miLogica.validaConsulta(idTema);
	}
	
	public void modificarUsuario(UsuarioVo usuario) {
		miLogica.validarModificacion(usuario);
	}
	
	
	public void modificarCategoria(Categorias usuario) {
		miLogica.validarModifCateg(usuario);
	}
	
	public void eliminarUsuario(String id) {
		miLogica.validarEliminacion(id);
	}

	public void eliminarCaetgori(String id) {
		miLogica.EliminarCate(id);
	}
	

}
