package modelo;
import java.time.LocalDate;


public class Pedido implements Cloneable{
	private Producto producto;
	private int cantidad;
	private LocalDate fecha;
	
	@Override
	public Object clone() {
		Pedido p = null;
		try {
			p.producto = (Producto) producto.clone();
			p.cantidad = (int) super.clone();
			p.fecha = (LocalDate) producto.clone();
			return p;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
	
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
