package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;
import modelo.Sistema;
import vista.IVistaMesa;
import vista.IVistaOperario;

public class ControladorMesa implements ActionListener{
	private IVistaMesa vista=null;
	private Mesa mesa=null;
	private IVistaOperario vistaOperario=null;
	
	public ControladorMesa(IVistaMesa vista,Mesa mesa,IVistaOperario vistaOperario) {
		this.mesa=mesa;
		this.vista=vista;
		this.vistaOperario=vistaOperario;
		this.vista.addActionListener(this);
		this.vistaOperario.setVisible(false);
		
		this.actualizarListas();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Agregar")||e.getActionCommand().equals("Modificar")) {
			int cantidad=0;
			boolean esNumero=false;
			try {
				cantidad=Integer.parseInt(this.vista.getCantidad());
				esNumero=true;
				System.out.println("Numero correcto");
			}
			catch(NumberFormatException exception) {
				this.vista.emergenteCantidadInvalida();
			}
			
		}
		
	}
	
	public void actualizarListas() {
		this.vista.getModeloListaProductos().clear();
		for(Producto producto:Sistema.getInstancia().getProductos()) {
			this.vista.getModeloListaProductos().addElement(producto);
		}
		
		this.vista.getModeloListaComanda().clear();
		for(Pedido pedido: this.mesa.getComanda().getPedidos()) { 
			this.vista.getModeloListaComanda().addElement(pedido);
		}
		
	}
}
