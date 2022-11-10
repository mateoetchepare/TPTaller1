package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Promocion implements Serializable{
	private boolean activo;
	private ArrayList<String> diasDePromo=new ArrayList<String>();
	
	public Promocion() {}
	

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public ArrayList<String> getDiasDePromo() {
		return diasDePromo;
	}

	public void setDiasDePromo(ArrayList<String> diasDePromo) {
		this.diasDePromo = diasDePromo;
	}
	
	public void agregarDiaPromo(String dia) {
		this.diasDePromo.add(dia); //revisar ue sea un dia valido y no repetido
	}
	public void sacarDiaPromo(String dia) {
		this.diasDePromo.remove(dia);
	}

	public boolean contieneDiaDePromo(String dia) {
		if (diasDePromo.contains(dia)) {
			return true;
		}
		else
			return false;
	}
	
}	
