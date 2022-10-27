package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Sistema;
import vista.IVistaOperario;
import vista.VentanaMesa;

public class ControladorOperario implements ActionListener {
	private IVistaOperario vista = null;
	private Operario operario = null;

	public ControladorOperario(IVistaOperario vista, Operario operario) {
		this.vista = vista;
		this.operario = operario;
		this.vista.addActionListener(this);
		this.actualizarListas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// this.actualizarListas();
	
	
			if (e.getActionCommand().equals("Habilitar")) {
				this.operario.habilitarMesa(this.vista.getListMesas().getSelectedValue());
				this.actualizarListas();

			} else if (e.getActionCommand().equals("Deshabilitar")) {
				this.operario.deshabilitarMesa(this.vista.getListMesas().getSelectedValue());
				this.actualizarListas();
			} else if (e.getActionCommand().equals("Ver Mesa")) {
				// lanzar ventana y ocntrolador de mesa
				if(this.vista.getListMesas().getSelectedValue()==null)
					this.vista.emergenteNoHaySeleccion();
				else if(this.vista.getListMesas().getSelectedValue().getHabilitado()) {
					this.operario.ocuparMesa(this.vista.getListMesas().getSelectedValue());
					VentanaMesa vistaMesa=new VentanaMesa();
					ControladorMesa controladorMesa=new ControladorMesa(vistaMesa,this.vista.getListMesas().getSelectedValue(),this.vista);
					vistaMesa.setVisible(true);
				}
				else
					System.out.println("mesa no habilitada para verla");
			}
		

	}

	private void actualizarListas() {
		this.vista.getModeloListaMozos().clear();
		for (Mozo mozo : Sistema.getInstancia().getMozos()) {
			this.vista.getModeloListaMozos().addElement(mozo);
		}
		this.vista.getModeloListaMesas().clear();
		for (Mesa mesa : Sistema.getInstancia().getMesas()) {
			this.vista.getModeloListaMesas().addElement(mesa);
		}
		this.vista.actualizarListas();
		

	}

}
