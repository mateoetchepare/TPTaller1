package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modelo.Operario;

public interface IVistaABMOperario {
	void addActionListener(ActionListener listener);
	DefaultListModel<Operario> getModeloListaOperarios();
	String getUsername();
	String getPassword();
	String getNombre();
	String getApellido();
	JList<Operario> getListOperarios();
	void muestraError(String msg);
	void actualizaBotones();
	void actualizaCampos();
}
