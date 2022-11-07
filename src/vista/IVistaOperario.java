package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;

import modelo.Mesa;
import modelo.Mozo;

public interface IVistaOperario {
	void addActionListener(ActionListener listener);
	void actualizarListas();
	DefaultListModel<Mozo> getModeloListaMozos();
	DefaultListModel<Mesa> getModeloListaMesas();
	JList<Mesa> getListMesas();
	JList<Mozo> getListMozos();
	
	boolean getSeleccionado();
	JButton getBtnVerMesa();
	
	void emergenteNoHaySeleccion();
	void setVisible(boolean res);
	
	void emergenteMesaDeshabilitada();
	void emergenteMesaOcupada();
	
	void vistaAdmin(boolean admin);
	
	JRadioButton getEstadoMozo();
	
}
