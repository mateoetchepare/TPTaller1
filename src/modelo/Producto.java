package modelo;

import excepciones.ProductoPreciosInvalidosException;

public class Producto implements Cloneable{
	private int id;
	private String nombre;
	private double precioCosto;
	private double precioVenta;
	private int stock;
	
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

	public void setPrecioCosto(double precioCosto) throws ProductoPreciosInvalidosException{
		if (precioCosto<=this.precioVenta) {
			this.precioCosto = precioCosto;
		} else
			throw new ProductoPreciosInvalidosException();
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) throws ProductoPreciosInvalidosException{
		if (precioVenta>=this.precioCosto) {
			this.precioVenta = precioVenta;
		} else
			throw new ProductoPreciosInvalidosException();
	}
	
	
	
}
