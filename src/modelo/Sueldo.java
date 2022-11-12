package modelo;

import java.io.Serializable;

public class Sueldo implements Serializable {
	private double basico;

	
	/**
	 * <b> PreCond: </b> el basico debe ser mayor a 0
	 */
	public Sueldo(double basico) {
		this.basico = basico;
	}
	
	/**
	 * <b> PreCond: </b> la cantHijos debe ser mayor a 0
	 */
	public double calculaTotal(int cantHijos) {
		return this.basico + (1.05*cantHijos);
	}

	public double getBasico() {
		return basico;
	}

	public void setBasico(double basico) {
		this.basico = basico;
	}
	
}
