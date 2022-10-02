package modelo;

import java.util.ArrayList;

import excepciones.ContraseniaIncorrectaException;
import excepciones.LoginIncorrectoException;
import excepciones.MesaInvalidaException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioIncorrectoException;

public class Sistema {
	private ArrayList<Operario> operarios = new ArrayList<Operario>();
	private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	private String nombre;
	private Sueldo sueldo; // sueldo que paga a mesero
	private static Sistema instancia = null;

	public Sistema() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Sueldo getSueldo() {
		return sueldo;
	}

	public void setSueldo(Sueldo sueldo) {
		this.sueldo = sueldo;
	}

	public static Sistema getInstancia() {
		if (instancia == null)
			instancia = new Sistema();
		return instancia;
	}

	public void loginOperario() {

	}

	public void agregaMesa(Mesa mesa) throws MesaInvalidaException{
		int i = 0, j;

		if ((mesa.getNumeroMesa() >= 1 && mesa.getComensales() >= 2) || (mesa.getNumeroMesa() == 0 && mesa.getComensales() == 1)) {
			j = this.mesas.size();

			while(i < j && !(this.mesas.get(i).getNumeroMesa() != mesa.getNumeroMesa())) {
				i++;
			}
			if (i == j) {
				throw new MesaInvalidaException("El numero de mesa ya esta usado");
			} else {
				mesas.add(mesa);
			}
		} else
			throw new MesaInvalidaException("La combinacion de comensales - numero de mesa es invalido");
	}

	public Operario agregaOperario(Operario operario) {
		int i = 0;
		boolean mayus = false, numero = false;
		String contrasenia = operario.getPassword();
		char ch;
		if (contrasenia.length() >= 6 && contrasenia.length() <= 12) {
			while (i < contrasenia.length() && (mayus != true && numero != true)) {
				ch = contrasenia.charAt(i);
				if( Character.isDigit(ch)) {
					numero = true;
				}
				else if (Character.isUpperCase(ch)) {
					mayus = true;
					i++;
				}
			}
		}
		return operario;
			//throw new N
	}

	public Operario loginOperario(Operario operario) throws LoginIncorrectoException {
		int j, i =0;


		j = operarios.size();
		while (i < j && (operarios.get(i).getNombreUsuario() != operario.getNombreUsuario() && operarios.get(i).getPassword() != operario.getPassword())) {
			i++;
		}
		if (i == j) {
			throw new UsuarioIncorrectoException();
		} else
			if (operarios.get(i).getNombreUsuario() == operario.getNombreUsuario() && operarios.get(i).getPassword() != operario.getPassword())
				throw new ContraseniaIncorrectaException();
			else
				if (operarios.get(i).isActivo() == false) 
					throw new UsuarioInactivoException();
				else
					return operarios.get(i);
	}

}


