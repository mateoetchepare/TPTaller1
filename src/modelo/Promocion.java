package modelo;

import java.io.Serializable;

public class Promocion implements Serializable{
	private boolean activo;
	private String diasDePromo;
	
	public Promocion() {}
	

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getDiasDePromo() {
		return diasDePromo;
	}

	public void setDiasDePromo(String diasDePromo) {
		this.diasDePromo = diasDePromo;
	}


}	
