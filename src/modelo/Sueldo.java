package modelo;

public class Sueldo {
	private double basico;
	private double totalSueldo;
	
	public Sueldo(int basico, int cantHijos) {
		this.totalSueldo = basico + (1.05*cantHijos);
	}
	
	public void modificaSueldo(int basico, int cantHijos) {
		this.totalSueldo = basico + (1.05*cantHijos);
	}

	public double getTotalSueldo() {
		return totalSueldo;
	}
	
	public double getBasico() {
		return basico;
	}

	public void setBasico(double basico) {
		this.basico = basico;
	}
	
}
