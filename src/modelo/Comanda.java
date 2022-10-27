package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.CierreComandaException;
import excepciones.PedidoInvalidoException;
import excepciones.ProductoExistenteException;


public class Comanda implements Serializable{
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private String estado;
	private LocalDate fecha;
	private int numeroMesa;
	
	public Comanda() {}
	
	public Comanda(int num) {
		this.fecha = LocalDate.now();
		this.estado = "abierta";
		this.pedidos = null;
		this.numeroMesa = num;
	}
	
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public String getEstado() {
		return estado;
	}
	
	//revisar y poner el setEstado de mesa en otro lado
	public void setEstado(String estado) throws CierreComandaException{
		if (this.estado == "cerrada "&& estado == "cerrada") 
			throw new CierreComandaException();
		else {
			this.estado = estado;
			//this.mesa.setEstado("libre");
		}
	}
	
	
	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int num) {
		this.numeroMesa = num;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public boolean contieneProducto(Producto producto) {
		int i=0, j;
		j = pedidos.size();
		
		while (i<j && producto != pedidos.get(i).getProducto()) {
			i++;
		}
		return i==j;
	}
	
	public int cantidadDelProducto(Producto producto) {
		int i=0, j;
		int aux=0;
		j = pedidos.size();
		
		for (i=0 ; i<j ; i++) {
			if (pedidos.get(i).getProducto() == producto) {
				aux += pedidos.get(i).getCantidad();
			}
		}
		return aux;
	}
	
	public void agregaPedido(Pedido pedido) throws PedidoInvalidoException{
		int stock;
			stock = Sistema.getInstancia().retornaStock(pedido.getProducto());
			if (stock >= pedido.getCantidad()) {
				pedidos.add(pedido);
				pedido.getProducto().restarStock(pedido.getCantidad());
			}
			else
				throw new PedidoInvalidoException();
		}
	}
	
