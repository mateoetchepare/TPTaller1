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
	JList<PromocionProd> getListPromProd();
	JList<PromocionTemp> getListPromTemp();
	
	//PROMOCIONES POR PRODUCTO
	ArrayList<JRadioButton> getDias();
	JRadioButton getTipo();
	String getCantidadMin();
	String getPrecioUnitario();
	
	//PROMOCIONES TEMPORALES
	String getNombre();
	JRadioButton getAcumulable();
	String getDescuento();
	JRadioButton getFormaPago();
	
	//EMERGENTE
	void emergenteNoHaySeleccionPromocion();
	void emergenteNoHayDiasSeleccionados();
	void emergenteNoTieneTipo();
	void emergenteNoEsNumero();
	void emergenteCamposPromProdIncompletos();
	void emergenteNoHaySeleccionTipo();
	void emergenteNoHayProductoSeleccionado();
	void emergenteNoHayPromProdSelecionado();
	void emergenteNoEsNumeroValido();
	void emergenteNoHayFormaPago();
	void emergenteCampoNombreVacio();
	void emergenteCampoDescuentoVacio();
	void emergenteNoHayPromTempSelecionado();
	void emergentePrecioUnitario(String msg);
}
