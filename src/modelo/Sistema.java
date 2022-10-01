package modelo;

import java.util.ArrayList;

import excepciones.MesaInvalidaException;

public class Sistema {
	private ArrayList<Operario> operarios = new ArrayList<Operario>();
	private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	private String nombre;
	private Sueldo sueldo; // sueldo que paga a mesero
	private static Sistema instancia = null;
	
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
}
