package modelo;

import java.util.ArrayList;

public class Comanda {
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private String estado;
	private int numero;
	
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
