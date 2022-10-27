package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import modelo.Pedido;
import modelo.Producto;

public interface IVistaMesa {
	void addActionListener(ActionListener listener);
	String getCantidad();
	void emergenteCantidadInvalida();
	DefaultListModel<Pedido> getModeloListaComanda();
	DefaultListModel<Producto> getModeloListaProductos();
	
}
