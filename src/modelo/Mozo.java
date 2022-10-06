package modelo;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import excepciones.MesaInvalidaException;


public class Mozo {
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	private String nombreYApellido;
	private int estado; // 0 (activo), 1(de franco), 2 (ausente)
	private int hijos;
	private GregorianCalendar nacimiento;
	
	public Mozo(int hijos, GregorianCalendar nacimiento) {
		this.hijos = hijos;
		this.nacimiento = nacimiento; // chequear >18
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public void agregaMesa(int numeroMesa) throws MesaInvalidaException{
		int i=0, j;
		j = mesas.size();
		while (i<j && mesas.get(i).getNumeroMesa() != numeroMesa) {
			i++;
		}
		if (i<j) 
			mesas.add(Sistema.getInstancia().retornaMesa(numeroMesa));
		else
			throw new MesaInvalidaException("La mesa ya pertenece al mozo");
	}
	
	public boolean mesaACargo(Mesa mesa) {
		if (mesas.contains(mesa))
			return true;
		else
			return false;
	}
	
	
}
