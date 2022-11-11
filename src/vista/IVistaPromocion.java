package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JRadioButton;

import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemp;

public interface IVistaPromocion {
	void addActionListener(ActionListener listener);
	
	DefaultListModel<Producto> getModeloListaProductos();
	DefaultListModel<PromocionProd> getModeloListaPromProd();
	DefaultListModel<PromocionTemp> getModeloListaPromTemp();
	
	JList<Producto> getListProductos();
	JList<PromocionProd> getListListaPromProd();
	JList<PromocionTemp> getListPromTemp();
	
	//PROMOCIONES POR PRODUCTO
	ArrayList<JRadioButton> getDias();
	JRadioButton getTipo();
	
	
	//PROMOCIONES TEMPORALES

}
