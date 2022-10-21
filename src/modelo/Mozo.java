package modelo;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import excepciones.MesaInvalidaException;


public class Mozo {
	private transient ArrayList<Mesa> mesas = new ArrayList<Mesa>(); //no se persiste
	private String nombreYApellido;
	private transient String estado; // 0 (activo), 1(de franco), 2 (ausente) //no se persiste
	private int hijos;
	private GregorianCalendar nacimiento;
	
	public Mozo(int hijos, GregorianCalendar nacimiento) {
		this.hijos = hijos;
		this.nacimiento = nacimiento; // chequear >18
	}

	public Mozo() {}
	
	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public int getHijos() {
		return hijos;
	}

	public void setHijos(int hijos) {
		this.hijos = hijos;
	}

	public GregorianCalendar getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(GregorianCalendar nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
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
