package modelo;

import excepciones.PrecioUnitarioInvalidoException;
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
	
	
	//SACO LA EXCEPTION PORUE POR VENTANA NO PUEDE TENER AMBOS FALSOS NI AMBOS VERDADEROS
	//SINO EN LA CREACION DE LA PROMOCION NO PUEDO SETEARLE EL TIPO
	/**
	 * @param aplicaDosPorUno
	 * @throws PromoProdInvalidaException se lanza si se quiere desactivar que la promocion sea por cantidad si ya NO es de dos por uno o VICEVERSA
	 */
	public void setAplicaDosPorUno(boolean aplicaDosPorUno)/* throws PromoProdInvalidaException*/{
		/*if (this.isAplicaDtoPorCantidad() == false && aplicaDosPorUno == false) {
			throw new PromoProdInvalidaException();
		} else*/
			this.aplicaDosPorUno = aplicaDosPorUno;
	}

	/**
	 * @param aplicaDtoPorCantidad
	 * @throws PromoProdInvalidaException se lanza si se quiere desactivar que la promocion sea por cantidad si ya NO es de dos por uno o VICEVERSA
	 */
	public void setAplicaDtoPorCantidad(boolean aplicaDtoPorCantidad)/* throws PromoProdInvalidaException*/{
		/*if (this.isAplicaDosPorUno() == false && aplicaDtoPorCantidad == false) {
			throw new PromoProdInvalidaException();
		} else*/
			this.aplicaDtoPorCantidad = aplicaDtoPorCantidad;
	}

	
	
	public void setDtoPorCantidad_CantMinima(int dtoPorCantidad_CantMinima) {
		this.dtoPorCantidad_CantMinima = dtoPorCantidad_CantMinima;
	}

	public void setDtoPorCantidad_PrecioUnitario(int dtoPorCantidad_PrecioUnitario) throws PrecioUnitarioInvalidoException{
		if (dtoPorCantidad_PrecioUnitario < this.producto.getPrecioVenta() && dtoPorCantidad_PrecioUnitario > this.producto.getPrecioCosto())
			this.dtoPorCantidad_PrecioUnitario = dtoPorCantidad_PrecioUnitario;
		else
			throw new PrecioUnitarioInvalidoException();
	}
	
	@Override
	public String toString() {
		String dias="";
		for(String dia:this.getDiasDePromo()) {
			dias+="-"+dia+" ";
		}
		//if(this.aplicaDosPorUno)
			return  "2x1 "/*, dias= "+dias*/;
	}
	
}
