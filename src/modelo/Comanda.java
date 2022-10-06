package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.CierreComandaException;
import excepciones.PedidoInvalidoException;
import excepciones.ProductoExistenteException;


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
	
	public void setEstado(String estado) throws CierreComandaException{
		if (this.estado == "cerrada "&& estado == "cerrada") 
			throw new CierreComandaException();
		else {
			this.estado = estado;
			this.mesa.setEstado("libre");
		}
	}
	
	
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
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
	
