package vista;

import java.awt.event.ActionListener;

import modelo.Mozo;

public interface IVistaABMMozo {
		void addActionListener(ActionListener listener);
		void actualizarLista();
		String getNombre();
		String getApellido();
		int getCantHijos();
		String getFechaNacimiento();
		Mozo getMozo();
		void muestraError(String msg);
		
	}
