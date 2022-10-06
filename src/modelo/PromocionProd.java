package modelo;

public class PromocionProd extends Promocion {
	private int idPromocion;
	private Producto producto;
	private boolean aplicaDosPorUno;
	private boolean aplicaDtoPorCantidad;
	private int dtoPorCantidad_CantMinima;
	private int dtoPorCantidad_PrecioUnitario;
}
