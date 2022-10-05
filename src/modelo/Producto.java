package modelo;

public class Producto {
	private int id;
	private String nombre;
	private double precio;
	private double precioVenta;
	private int stock;
	
	
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void agregarStock(int cant) {
		this.stock += cant;
	}
	
	
}
