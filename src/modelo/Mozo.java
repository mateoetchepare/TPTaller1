package modelo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.GregorianCalendar;
import java.util.Iterator;

import excepciones.MesaDeshabilitadaException;
import excepciones.MesaYaAsignadaException;
import excepciones.MozoInvalidoException;


public class Mozo implements Serializable{
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>(); //no se persiste
	private String nombreYApellido;
	private transient String estado; // 0 (activo), 1(de franco), 2 (ausente) //no se persiste
	private int hijos;
	private LocalDate nacimiento;
	
	public Mozo(String nombreYApellido, int hijos, LocalDate nacimiento) {
		this.nombreYApellido = nombreYApellido;
		this.hijos = hijos;
		this.nacimiento = nacimiento; // chequear >18
	}
	
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

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	/* CAMBIO EL METODO ABAJO, LO DEJO COMENTADO POR LAS DUDAS
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
	}*/
	
	/**
	 * @param mesa
	 * @throws MozoInvalidoException se lanza si el mozo no esta en estado activo
	 * @throws MesaDeshabilitadaException se lanza si 
	 * @throws MesaYaAsignadaException se lanza si la mesa ya habia sido asignada previamente al mozo
	 */
	public void agregarMesa(Mesa mesa) throws MozoInvalidoException,MesaDeshabilitadaException, MesaYaAsignadaException{
		boolean yaAsignada=false;
		
		if (this.getEstado() == "Activo") {
			Iterator<Mozo> itMozo= Sistema.getInstancia().getMozos().iterator();
			while(itMozo.hasNext() && !yaAsignada) {
				if(itMozo.next().getMesas().contains(mesa)) {//algun mozo ya tiene esta mesa asignada
					yaAsignada=true;
				}
			}
			if(yaAsignada) {
				throw new MesaYaAsignadaException();
			}
			else {
				if (mesa.getHabilitado() == true) {
					mesa.setNombreMozo(nombreYApellido);
					this.mesas.add(mesa);
				}
				else
					throw new MesaDeshabilitadaException("La mesa esta deshabilitada");
				System.out.println("Se agrego la mesa al mozo");
			}
		} else
			throw new MozoInvalidoException();
	}

	public boolean mesaACargo(Mesa mesa) {
		if (mesas.contains(mesa))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		String salida=null;
		if(this.estado==null)
			salida= nombreYApellido+ ", estado= s/asignar" ;
		else
			salida= nombreYApellido + ", estado=" + estado ;
		
		return salida;
	}
	
	
}
