package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modelo.Mesa;
import modelo.Mozo;

public interface IVistaOperario {
	void addActionListener(ActionListener listener);
	void actualizarListas();
	DefaultListModel<Mozo> getModeloListaMozos();
	DefaultListModel<Mesa> getModeloListaMesas();
	JList<Mesa> getListMesas();
	
	
}
