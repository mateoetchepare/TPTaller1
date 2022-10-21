package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Factura {
	private LocalDate fecha;
	private Mesa mesa;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private ArrayList<Promocion> promocionesAplicadas = new ArrayList<Promocion>();
	private double total;
	private String formaDePago;
	
	public Factura() {}
	
	public Factura(Mesa mesa, ArrayList<Pedido> pedidos, double total, String formaDePago, ArrayList<Promocion> promos) {
		this.fecha = LocalDate.now();
		this.mesa = mesa;
		this.productos = (ArrayList<Producto>) productos.clone();
		this.promocionesAplicadas = (ArrayList<Promocion>) promos.clone();
		this.total = total;
		this.formaDePago = formaDePago;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Promocion> getPromocionesAplicadas() {
		return promocionesAplicadas;
	}

	public void setPromocionesAplicadas(ArrayList<Promocion> promocionesAplicadas) {
		this.promocionesAplicadas = promocionesAplicadas;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	
}
