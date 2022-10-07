package modelo;

public class PromocionProd extends Promocion {
	private int idPromocion;
	private Producto producto;
	private boolean aplicaDosPorUno;
	private boolean aplicaDtoPorCantidad;
	private int dtoPorCantidad_CantMinima;
	private int dtoPorCantidad_PrecioUnitario;
	
	public int getIdPromocion() {
		return idPromocion;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public boolean isAplicaDosPorUno() {
		return aplicaDosPorUno;
	}
	
	public boolean isAplicaDtoPorCantidad() {
		return aplicaDtoPorCantidad;
	}
	
	public int getDtoPorCantidad_CantMinima() {
		return dtoPorCantidad_CantMinima;
	}
	
	public int getDtoPorCantidad_PrecioUnitario() {
		return dtoPorCantidad_PrecioUnitario;
	}
	
	
	
}
