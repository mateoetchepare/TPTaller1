package modelo;

import java.io.Serializable;

public class Mesa implements Serializable{
	private int numeroMesa;
	private int comensales;
	private String estado;
	private transient boolean habilitado; //agrego para poder habilitar o desabilitar mesa mas alla 
	//de si esta ocupada o no 
	
	public Mesa() {}
	
	public Mesa(int numeroMesa, int comensales) {
		this.numeroMesa = numeroMesa;
		this.comensales = comensales;
		this.estado = "libre";
		this.habilitado=false;
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

	public void habilitar() {
		this.habilitado=true;
	}
	
	public void deshabilitar() {
		this.habilitado=false;
	}
	public boolean getHabilitado() {
		return this.habilitado;
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
