package modelo;
import java.util.GregorianCalendar;


public class Pedido {
	private Producto producto;
	private int cantidad;
	private GregorianCalendar fecha;
	
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
