package modelo;
import java.io.Serializable;
import java.time.LocalDate;


public class Pedido implements Cloneable, Serializable{
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
	
	public Pedido() {}
	
	public Pedido(Producto producto,int cant) {
		this.producto=producto;
		this.cantidad=cant;
		this.fecha=LocalDate.now();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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

	@Override
	public String toString() {
		return  producto + ", cantidad=" + cantidad  ;
	}
	
	
	
}
