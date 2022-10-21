package modelo;

import excepciones.EstadoInvalidoMozoException;
import excepciones.MesaInvalidaException;
import excepciones.ProductoEnComandaException;

public class Operario {
	private boolean activo;
	private String nombreUsuario;
	private String password;
	private String nombreYApellido;
	
	public Operario() {}
	
	public Operario(String nombreUsuario, String password, String nombreYApellido) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreYApellido = nombreYApellido;
		this.activo = true; // asumimos que cuando se agrega operario, se agrega como activo
	}
	
	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void seteaEstadoMozo(Mozo mozo, String estado) throws EstadoInvalidoMozoException {
		mozo.setEstado(estado);
	}
	
	public void asignaMesas(Mozo mozo, int numeroMesa) throws MesaInvalidaException{
		mozo.agregaMesa(numeroMesa);
	}
	
}
