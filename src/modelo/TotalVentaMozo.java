package modelo;

public class TotalVentaMozo {
	private String nombreMozo;
	private double total;
	
	public TotalVentaMozo(String nombre) {
		this.nombreMozo=nombre;
		this.total=0;
	}

	public String getNombreMozo() {
		return nombreMozo;
	}

	public double getTotal() {
		return total;
	}
	
	/**
	 * @<b> PreCond: </b> el total debe ser mayor a 0
	 */
	public void sumarVenta(double total) {
		this.total+=total;
	}

	@Override
	public String toString() {
		return "nombreMozo=" + nombreMozo + ", total=" + total ;
	}
	
	
}
