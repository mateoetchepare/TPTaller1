package modelo;

import excepciones.PromoProdInvalidaException;

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

	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setAplicaDosPorUno(boolean aplicaDosPorUno) throws PromoProdInvalidaException{
		if (this.isAplicaDtoPorCantidad() == false && aplicaDosPorUno == false) {
			throw new PromoProdInvalidaException();
		} else
			this.aplicaDosPorUno = aplicaDosPorUno;
	}

	public void setAplicaDtoPorCantidad(boolean aplicaDtoPorCantidad) throws PromoProdInvalidaException{
		if (this.isAplicaDosPorUno() == false && aplicaDtoPorCantidad == false) {
			throw new PromoProdInvalidaException();
		} else
			this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
	}

	public void setDtoPorCantidad_CantMinima(int dtoPorCantidad_CantMinima) {
		this.dtoPorCantidad_CantMinima = dtoPorCantidad_CantMinima;
	}

	public void setDtoPorCantidad_PrecioUnitario(int dtoPorCantidad_PrecioUnitario) {
		this.dtoPorCantidad_PrecioUnitario = dtoPorCantidad_PrecioUnitario;
	}
	
	
	
}
