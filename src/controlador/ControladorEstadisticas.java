package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.MozoSinVentasException;
import excepciones.NoHayFacturasException;
import modelo.Mozo;
import modelo.Sistema;
import vista.IVistaEstadisticas;
import vista.IVistaOperario;
import vista.VentanaEstadisticas;

public class ControladorEstadisticas implements ActionListener{
	IVistaEstadisticas vista=null;
	IVistaOperario vistaOperario=null;
	
	public ControladorEstadisticas(IVistaEstadisticas vista,IVistaOperario vistaOperario) {
		this.vista=vista;
		this.vistaOperario=vistaOperario;
		this.vista.addActionListener(this);
		actualizarLista();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Listo")) {
			System.out.println("BOTON LISTO");
			VentanaEstadisticas v=(VentanaEstadisticas) this.vista;
			v.setVisible(false);
			this.vistaOperario.setVisible(true);
		}
		else if(e.getActionCommand().equals("Verificar")){
			System.out.println("BOTON VERIFICAR");
			try {
				if(this.vista.getListMozos().getSelectedValue()!=null)
					this.vista.escribirEstadistica(Sistema.getInstancia().estadisticas(this.vista.getListMozos().getSelectedValue()));
				else
					this.vista.emergenteSinSeleccion();
			} catch (MozoSinVentasException e1) {
				// TODO Auto-generated catch block
				this.vista.emergenteMozoSinFacturas();
			}
		}
		else if(e.getActionCommand().equals("Mayor/Menor venta")) {
			try {
				this.vista.escribirEstadistica(Sistema.getInstancia().mayorMenorVenta());			
			} catch (NoHayFacturasException e1) {
				// TODO Auto-generated catch block
				this.vista.emergenteSinFacturas();
			}
		}
		
	}
	
	public void actualizarLista() {
		this.vista.getModeloListaMozos().clear();
		for (Mozo mozo : Sistema.getInstancia().getMozos()) {
			this.vista.getModeloListaMozos().addElement(mozo);
		}
	}

}
