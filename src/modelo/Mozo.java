package modelo;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Mozo {
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
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
	
	
	
	
}
