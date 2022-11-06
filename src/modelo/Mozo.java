package modelo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.GregorianCalendar;
import java.util.Iterator;


public class Mozo implements Serializable{
	private transient ArrayList<Mesa> mesas = new ArrayList<Mesa>(); //no se persiste
	private String nombreYApellido;
	private transient String estado; // 0 (activo), 1(de franco), 2 (ausente) //no se persiste
	private int hijos;
	private LocalDate nacimiento;
	
	public Mozo(String nombreYApellido, int hijos, LocalDate nacimiento) {
		this.nombreYApellido = nombreYApellido;
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
	
	public void agregarMesa(Mesa mesa) {
		boolean yaAsignada=false;
		
		Iterator<Mozo> itMozo= Sistema.getInstancia().getMozos().iterator();
		while(itMozo.hasNext() && !yaAsignada) {
			if(itMozo.next().getMesas().contains(mesa)) {//algun mozo ya tiene esta mesa asignada
				yaAsignada=true;
			}
		}
		if(yaAsignada) {
			System.out.println("La mesa ya esta asignada a un mozo");//hacer exception
		}
		else {
			this.mesas.add(mesa);
			System.out.println("Se agrego la mesa al mozo");
		}
		
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
