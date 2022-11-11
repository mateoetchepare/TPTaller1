package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Producto;
import modelo.Sistema;
import vista.IVistaPromocion;

public class ControladorPromocion implements ActionListener{
	IVistaPromocion vista=null;
	
	
	public ControladorPromocion() {
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarListas(){
		this.vista.getModeloListaProductos().clear();
		for (Producto producto : Sistema.getInstancia().getProductos()) {
			this.vista.getModeloListaProductos().addElement(producto);
		}
	}

}
