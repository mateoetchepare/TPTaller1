package modelo;

public class PromocionTemp extends Promocion {
	private String nombre;
	private String formaPago;
	private int porcentajeDescuento;
	private boolean esAcumulable;
	
	public String getNombre() {
		return nombre;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	public boolean isEsAcumulable() {
		return esAcumulable;
	}
	
	
}
