package vista;

import java.awt.event.ActionListener;

public interface IVistaInicial {
	void addActionListener(ActionListener listener);
	String getContrasenia();
	String getContrasenia2();
	String getNombre();
	int getSueldo();
	double getPorcentaje();
}
