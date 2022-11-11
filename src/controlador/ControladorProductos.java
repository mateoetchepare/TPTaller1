package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.ProductoEnComandaException;
import excepciones.ProductoExistenteException;
import excepciones.ProductoPreciosInvalidosException;
import modelo.Producto;
import modelo.Sistema;
import vista.VentanaProducto;

public class ControladorProductos implements ActionListener{
	VentanaProducto vista;
	
	public ControladorProductos() {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Agregar")) {
			try {
				int id = Integer.parseInt(vista.getTextFieldID());
				double precioCompra = Double.parseDouble(vista.getTextFieldPrecioCompra());
				double precioVenta = Double.parseDouble(vista.getTextFieldPrecioVenta());
				int stock = Integer.parseInt(vista.getTextFieldStock());
				Producto p = new Producto(id, vista.getTextFieldNombreProducto(), precioCompra, precioVenta, stock);
				Sistema.getInstancia().nuevoProducto(p);
			} catch (NumberFormatException e1) {
				vista.muestraError("Ingrese solo numeros en los campos id, precioCompra, precioVenta");
			} catch (ProductoExistenteException e2) {
				vista.muestraError(e2.getMessage());
			} catch (ProductoPreciosInvalidosException e3) {
				vista.muestraError(e3.getMessage());
			}

		} else
			if (e.getActionCommand().equals("Sacar")) {
				try {
					Sistema.getInstancia().eliminaProducto(vista.getProducto());
				} catch (ProductoEnComandaException e1) {
					vista.muestraError(e1.getMessage());
				}
			} else
				if (e.getActionCommand().equals("Modificar")) {
					if (vista.getTextFieldStock().length() > 0) {
						try {
							int stock = Integer.parseInt(vista.getTextFieldStock());
							vista.getProducto().setStock(stock);
						} catch (NumberFormatException e1) {
							vista.muestraError("ingrese un stock valido");
						}
					}
					if (vista.getTextFieldPrecioCompra().length() > 0 && 
							vista.getTextFieldPrecioVenta().length() > 0) {
						try {
							double precioCompra = Double.parseDouble(vista.getTextFieldPrecioCompra());
							double precioVenta = Double.parseDouble(vista.getTextFieldPrecioVenta());
							vista.getProducto().setPrecios(precioCompra, precioVenta); 
						} catch (NumberFormatException e1) {
							vista.muestraError("Usted ingreso letras en campos numericos");
						} catch (ProductoPreciosInvalidosException e2) {
							vista.muestraError(e2.getMessage());
						}
					}
				}
	}
}

