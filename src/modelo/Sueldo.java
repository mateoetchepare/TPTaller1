package modelo;

public class Sueldo {
	private double basico;

	
	public Sueldo(double basico) {
		this.basico = basico;
	}
	
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
