package modelo;

import java.io.Serializable;

import excepciones.ProductoPreciosInvalidosException;

public class Producto implements Cloneable, Serializable{
	private int id;
	private String nombre;
	private double precioCosto;
	private double precioVenta;
	private int stock;
	
	public Producto() {}
	
	public Producto(int id, String nombre, double precioCosto,double precioVenta,int stock) {
		this.id=id;
		this.nombre=nombre;
		this.precioCosto=precioCosto;
		this.precioVenta=precioVenta;
		this.stock=stock;
	}
	
	@Override
	public Object clone() {
		Producto p = null;
		try {
			p = (Producto)super.clone();
			return p;
		} catch (CloneNotSupportedException e){
			System.out.println("Esto no deberia pasar");
		}
		return p;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void agregarStock(int cant) {
		this.stock += cant;
	}
	
	public void restarStock(int cant) { // se chequea antes si se puede restar el stock. desde "comanda".
		this.stock -= cant;
	}

	public double getPrecioCosto() {
		return precioCosto;
	}


	public double getPrecioVenta() {
		return precioVenta;
	}
	
	/**
	 * @param precioCompra
	 * @param precioVenta
	 * @throws ProductoPreciosInvalidosException se lanza si alguno de los precios ingresados son menores a 0 o el precio de compra es mayor al de venta
	 */
	public void setPrecios(double precioCompra, double precioVenta) throws ProductoPreciosInvalidosException{
		if (precioCompra > 0 && precioVenta > 0 && precioCompra <= precioVenta) {
			this.precioCosto = precioCompra; 
			this.precioVenta = precioVenta;
		} else {
			throw new ProductoPreciosInvalidosException();
		}
	}

	@Override
	public String toString() {
		return "id producto=" + id + ", nombre=" + nombre + ", precio=" + precioVenta +" stock= "+ stock;
	}
	
	
	
}
