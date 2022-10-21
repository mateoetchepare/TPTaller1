package modelo;

public class Sueldo {
	private double basico;
	private double porcentaje;
	
	public Sueldo() {}
	
	public Sueldo(int basico) {
		//completar solo con basico o agregar tambien el porcentaje por parametro
	}

	public double getBasico() {
		return basico;
	}

	public void setBasico(double basico) {
		this.basico = basico;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
}
