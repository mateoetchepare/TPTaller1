package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Comanda {
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private String estado;
	private LocalDate fecha;
	private Mesa mesa;
	
	public Comanda(Mesa mesa) {
		this.fecha = LocalDate.now();
		this.estado = "abierta";
		this.pedidos = null;
		this.mesa = mesa;
	}
	
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
