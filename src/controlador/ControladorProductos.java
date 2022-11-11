package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Producto;
import vista.VentanaProducto;

public class ControladorProductos implements ActionListener{
	VentanaProducto vista;
	
	public ControladorProductos() {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		if (e.getActionCommand().equals("Agregar")) {
			try {
				Producto p = new Producto(Integer.parseInt(vista.getTextFieldID()), vista.getTextFieldNombreProducto(),
						Double.parseDouble(vista.getTextFieldPrecioCompra()), 
						Double.parseDouble(vista.getTextFieldPrecioVenta()), Integer.parseInt(vista.getTextFieldStock()));
			} catch ()
		}
		*/
		
	}
	
	
	
}
