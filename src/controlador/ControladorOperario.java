package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.MesaDeshabilitadaException;
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
		this.vista.vistaAdmin(operario.equals(Sistema.getInstancia().getOperarios().get(0)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// this.actualizarListas();
	
	
			if (e.getActionCommand().equals("Habilitar")) {
				this.operario.habilitarMesa(this.vista.getListMesas().getSelectedValue());
				this.actualizarListas();

			} else if (e.getActionCommand().equals("Deshabilitar")) {
				try {
					this.operario.deshabilitarMesa(this.vista.getListMesas().getSelectedValue());
				} catch (MesaDeshabilitadaException e1) {
					this.vista.emergenteMesaOcupada();
					//e1.printStackTrace();
				}
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
					this.vista.emergenteMesaDeshabilitada();
				
			}else if (e.getActionCommand().equals("Asignar")) {
				System.out.println("Se presiono boton asignar");
				this.operario.asignarMesa(this.vista.getListMozos().getSelectedValue(), this.vista.getListMesas().getSelectedValue());
				
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
