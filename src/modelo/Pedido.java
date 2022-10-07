package modelo;
import java.time.LocalDate;


public class Pedido {
	private Producto producto;
	private int cantidad;
	private LocalDate fecha;
	
	
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
