package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Operario;
import vista.IVistaOperario;

public class ControladorOperario implements ActionListener {
	private IVistaOperario vista=null;
	private Operario operario=null;
	
	public ControladorOperario(IVistaOperario vista,Operario operario) {
		this.vista=vista;
		this.operario=operario;
		this.vista.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
