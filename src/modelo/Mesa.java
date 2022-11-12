package modelo;

import java.io.Serializable;

import excepciones.MesaDeshabilitadaException;
import excepciones.NoHayPromosActivasException;

public class Mesa implements Serializable{
	private int numeroMesa;
	private int comensales;
	private String estado;
	private transient boolean habilitado; //agrego para poder habilitar o desabilitar mesa mas alla 
	//de si esta ocupada o no 
	Comanda comanda=null;
	private String nombreMozo=null;
	
	
	public Mesa() {}
	
	public Mesa(int numeroMesa, int comensales) {
		this.numeroMesa = numeroMesa;
		this.comensales = comensales;
		this.estado = "libre";
		this.habilitado=false;
	}

	public String getNombreMozo() {
		return nombreMozo;
	}

	public void setNombreMozo(String nombreMozo) {
		this.nombreMozo = nombreMozo;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	public int getNumeroMesa() {
		return this.numeroMesa;
	}
	
	public int getComensales() {
		return this.comensales;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) { //libre u ocupado
		this.estado = estado;
	}

	public void ocuparMesa() {

		if(this.estado.equals("libre")) {
			this.estado="ocupado";
			this.comanda=new Comanda(this.numeroMesa);
		}
		else
			System.out.println(this.estado);//agregar exception
	}
	
	/**
	 * @throws NoHayPromosActivasException se lanza si no hay al menos dos promociones de productos
	 */
	public void habilitar() throws NoHayPromosActivasException{
		if (Sistema.getInstancia().alMenos2PromosProd())
			this.habilitado=true;
		else
			throw new NoHayPromosActivasException();
	}
	
	/**
	 * @throws MesaDeshabilitadaException se lanza si se quiere deshabilitar la mesa y esta ocupada previammente
	 */
	public void deshabilitar() throws MesaDeshabilitadaException{
		if(this.estado.equals("libre"))
			this.habilitado=false;
		else {
			throw new MesaDeshabilitadaException("No se puede deshabilitar mesa porque esta ocupada");
		}
	}
	public boolean getHabilitado() {
		return this.habilitado;
	}
	
	
	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	@Override
	public String toString() {
		String salida=null;
		if(this.habilitado)
			salida="Mesa numero= " + numeroMesa + ", lugares=" + comensales + ", estado=" + estado ;
		else
			salida="Mesa numero= " + numeroMesa + ", lugares=" + comensales + ", estado= deshabilitada" ;
		
		return salida;
	}
	
	
	
}
