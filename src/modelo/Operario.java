package modelo;

import java.io.Serializable;

import excepciones.ContraseniaLongitudInvalidaException;
import excepciones.ContraseniaReqNoCumplidosException;
import excepciones.EstadoInvalidoMozoException;
import excepciones.MesaDeshabilitadaException;
import excepciones.MesaInvalidaException;
import excepciones.ProductoEnComandaException;

public class Operario implements Serializable{
	private boolean activo;
	private String nombreUsuario;
	private String password;
	private String nombreYApellido;
	
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
	
	public void setPassword(String password) throws ContraseniaReqNoCumplidosException, ContraseniaLongitudInvalidaException { 
		char ch;
		int i = 0;
		boolean mayus = false, numero = false;
		if (password.length() >= 6 && password.length() <= 12) {
			while (i < password.length() && (mayus != true || numero != true)) {
				ch = password.charAt(i);
				if( Character.isDigit(ch)) {
					numero = true;
				}
				else if (Character.isUpperCase(ch)) {
					mayus = true;
				}
				i++;
			}
			if (mayus && numero)
				this.password = password;
			else
				throw new ContraseniaReqNoCumplidosException();
		} else
			throw new ContraseniaLongitudInvalidaException();
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
	
	/* CAMBIO EL METODO ABAJO, LO DEJO COMENTADO POR LAS DUDAS
	 * public void asignaMesas(Mozo mozo, int numeroMesa) throws MesaInvalidaException{
		mozo.agregaMesa(numeroMesa);
	}*/
	
	public void asignarMesa(Mozo mozo,Mesa mesa) {
		mozo.agregarMesa(mesa);//falta la exception
	}
	
	public void habilitarMesa(Mesa mesa) {
		mesa.habilitar();
	}
	public void deshabilitarMesa(Mesa mesa) throws MesaDeshabilitadaException {
		mesa.deshabilitar();
	}
	public void ocuparMesa(Mesa mesa) {
		mesa.ocuparMesa();
	}

	@Override
	public String toString() {
		return "Usuario: "+ nombreUsuario + ", nombreYApellido=" + nombreYApellido ;
	}
	
}
