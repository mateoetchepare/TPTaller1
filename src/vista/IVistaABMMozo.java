package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modelo.Mozo;
import modelo.Operario;

public interface IVistaABMMozo {
		void addActionListener(ActionListener listener);
		void actualizarLista();
		String getNombre();
		String getApellido();
		int getCantHijos();
		String getFechaNacimiento();
		Mozo getMozo();
		void muestraError(String msg);
		DefaultListModel<Mozo> getModeloListaMozos();
		JList<Mozo> getListMozos();
		
	}
