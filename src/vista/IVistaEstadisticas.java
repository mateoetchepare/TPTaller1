package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modelo.Mozo;

public interface IVistaEstadisticas {
	void addActionListener(ActionListener listener);
	DefaultListModel<Mozo> getModeloListaMozos();
	JList<Mozo> getListMozos();
	void escribirEstadistica(String estadistica);
	
	void emergenteSinFacturas();
	void emergenteMozoSinFacturas();
	void emergenteSinSeleccion();
}
