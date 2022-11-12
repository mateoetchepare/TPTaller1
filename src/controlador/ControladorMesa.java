package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.PedidoInvalidoException;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;
import modelo.Sistema;
import vista.IVistaMesa;
import vista.IVistaOperario;
import vista.VentanaMesa;

public class ControladorMesa implements ActionListener {
	private IVistaMesa vista = null;
	private Mesa mesa = null;
	private IVistaOperario vistaOperario = null;

	public ControladorMesa(IVistaMesa vista, Mesa mesa, IVistaOperario vistaOperario) {
		this.mesa = mesa;
		this.vista = vista;
		this.vistaOperario = vistaOperario;
		this.vista.addActionListener(this);
		this.vistaOperario.setVisible(false);

		this.actualizarListas();
		this.vista.completarTitulo(mesa.getNumeroMesa(),mesa.getEstado());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Agregar") || e.getActionCommand().equals("Modificar")) {
			int cantidad = 0;
			boolean esNumero = false;
			try {
				cantidad = Integer.parseInt(this.vista.getCantidad());
				esNumero = true;
				//System.out.println("Numero correcto");
				if (e.getActionCommand().equals("Agregar")) {// agrego pedido a comanda
					if (this.vista.getListProductos().getSelectedValue() != null) {
						try {
							this.mesa.getComanda().agregaPedido(this.vista.getListProductos().getSelectedValue(),
									cantidad);
						} catch (PedidoInvalidoException e1) {
							this.vista.emergenteStockInsuficiente(cantidad, e1.getStock());
						}
					}
					else {
						this.vista.emergenteProductoNoSeleccionado();
					}
				} else if (e.getActionCommand().equals("Modificar")) {// modifica cantidad del pedido
					if(this.vista.getListComanda().getSelectedValue()!=null) {
						this.vista.getListComanda().getSelectedValue().setCantidad(cantidad);
					}
					else {
						this.vista.emergentePedidoNoSeleccionado();
					}
				}
				
				
			} catch (NumberFormatException exception) {
				this.vista.emergenteCantidadInvalida();
			}
			vista.actualizaBotones();
			vista.actualizaCampos();
		}else if (e.getActionCommand().equals("Sacar")) {
			if(this.vista.getListComanda().getSelectedValue()!=null) {
				this.mesa.getComanda().sacarPedido(this.vista.getListComanda().getSelectedValue());
			}
			else {
				this.vista.emergentePedidoNoSeleccionado();
			}
			vista.actualizaBotones();
			vista.actualizaCampos();
		}else if (e.getActionCommand().equals("Listo")) {
			this.vistaOperario.actualizarListas();
			VentanaMesa v = (VentanaMesa) this.vista;
			v.setVisible(false);
			this.vistaOperario.setVisible(true);
			
		}else if (e.getActionCommand().equals("Cerrar Mesa")) {
			//cerrar mesa tiene ue generar la factura de la comanda
			//establecer esta de la mesa como libre
			//volver a vista operario
			
			this.mesa.setEstado("libre");// no usar este metodo, es para probar funcionalidad
			this.vistaOperario.actualizarListas();
			VentanaMesa v = (VentanaMesa) this.vista;
			v.setVisible(false);
			this.vistaOperario.setVisible(true);
		}
		
		this.actualizarListas();
	}

	public void actualizarListas() {
		this.vista.getModeloListaProductos().clear();
		for (Producto producto : Sistema.getInstancia().getProductos()) {
			this.vista.getModeloListaProductos().addElement(producto);
		}

		this.vista.getModeloListaComanda().clear();
		
		for (Pedido pedido : this.mesa.getComanda().getPedidos()) {
			this.vista.getModeloListaComanda().addElement(pedido);
		}

	}
}
