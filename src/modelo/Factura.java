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
	
	public Factura(Mesa mesa, ArrayList<Producto> productos, ArrayList<Promocion> promos, double total, String formaDePago) {
		this.fecha = LocalDate.now();
		this.mesa = mesa;
		this.productos = (ArrayList<Producto>) productos.clone();
		this.promocionesAplicadas = (ArrayList<Promocion>) promos.clone();
		this.total = total;
		this.formaDePago = formaDePago;
	}
}
