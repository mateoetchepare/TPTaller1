package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import excepciones.UsuarioNuevoInvalidoException;
import modelo.Operario;
import modelo.Sistema;
import vista.IVistaABMOperario;
import vista.IVistaOperario;
import vista.VentanaMesa;

public class ControladorABMOperario implements ActionListener{
	IVistaABMOperario vista=null;
	Operario admin=null;
	IVistaOperario vistaOperario=null;
	
	public ControladorABMOperario(IVistaABMOperario vista,Operario admin,IVistaOperario vistaOperario) {
		this.vista=vista;
		this.admin=admin;
		this.vistaOperario = vistaOperario;
		this.vista.addActionListener(this);
		this.actualizarListas();
		
		this.vistaOperario.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Agregar")) {
			
			Operario operario = new Operario(this.vista.getUsername(),this.vista.getPassword(),this.vista.getNombre() + this.vista.getApellido());
			try {
				Sistema.getInstancia().agregaOperario(operario);
			} catch (UsuarioNuevoInvalidoException e1) { //ver ue exceptions se lanzan y generar emergente
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getActionCommand().equals("Sacar")) {
			if(this.vista.getListOperarios().getSelectedValue()!=null) {
				Sistema.getInstancia().getOperarios().remove(this.vista.getListOperarios().getSelectedValue());
				
			}
			else
				;//emergente no se selecciono operario a sacar
		}
		else if(e.getActionCommand().equals("Modificar")) {
			if(this.vista.getListOperarios().getSelectedValue()!=null) {//ver ue exceptions se lanzan y generar emergente
				this.vista.getListOperarios().getSelectedValue().setPassword(this.vista.getPassword());
			}
			else
				;//emergente no se selecciono operario a sacar
		}
		else if(e.getActionCommand().equals("Listo")) {
			this.vistaOperario.actualizarListas();
			VentanaMesa v = (VentanaMesa) this.vista;
			v.setVisible(false);
			this.vistaOperario.setVisible(true);
		}
		this.actualizarListas();
		
	}
	
	public void actualizarListas() {
		this.vista.getModeloListaOperarios().clear();
		for (Operario operario : Sistema.getInstancia().getOperarios()) {
			if(!operario.equals(Sistema.getInstancia().getOperarios().get(0)))
				this.vista.getModeloListaOperarios().addElement(operario);
		}
		

	}

}
