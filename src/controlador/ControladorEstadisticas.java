package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		}
		else if(e.getActionCommand().equals("Mayor/Menor venta")) {
			
		}
		
	}
	
	public void actualizarLista() {
		this.vista.getModeloListaMozos().clear();
		for (Mozo mozo : Sistema.getInstancia().getMozos()) {
			this.vista.getModeloListaMozos().addElement(mozo);
		}
	}

}
