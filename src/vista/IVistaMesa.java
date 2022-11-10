package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modelo.Pedido;
import modelo.Producto;

public interface IVistaMesa {
	void addActionListener(ActionListener listener);
	String getCantidad();
	void emergenteCantidadInvalida();
	DefaultListModel<Pedido> getModeloListaComanda();
	DefaultListModel<Producto> getModeloListaProductos();
	
	void emergentePedidoNoSeleccionado();
	JList<Producto> getListProductos();
	JList<Pedido>getListComanda();
	
	void emergenteStockInsuficiente(int cant,int stock);
	void emergenteProductoNoSeleccionado();
	
	void completarTitulo(int numeroMesa,String estado);
	void actualizaBotones();
	void actualizaCampos();
}
