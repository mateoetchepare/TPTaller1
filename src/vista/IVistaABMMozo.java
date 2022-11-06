package vista;

import java.awt.event.ActionListener;

public interface IVistaABMMozo {
		void addActionListener(ActionListener listener);
		void actualizarLista();
		String getNombre();
		String getApellido();
		int getCantHijos();
		String getFechaNacimiento();
	}
