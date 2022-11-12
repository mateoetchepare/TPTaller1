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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	public void setEsAcumulable(boolean esAcumulable) {
		this.esAcumulable = esAcumulable;
	}
	@Override
	public String toString() {
		String dias="";
		for(String dia:this.getDiasDePromo()) {
			dias+="-"+dia+" ";
		}
		if(dias=="") 
		return   nombre + ", formaPago=" + formaPago + ", Descuento="
				+ porcentajeDescuento + "% Activa= "+this.isActivo()+ ", sin dias asosiados";
		else
			return  nombre + ", formaPago=" + formaPago + ", porcentajeDescuento="
			+ porcentajeDescuento + ", esAcumulable=" + esAcumulable +
			"% Activa= "+this.isActivo()+", dias= "+dias;
	}
	
	
}
