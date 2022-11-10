package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.ContraseniaLongitudInvalidaException;
import excepciones.ContraseniaReqNoCumplidosException;
import excepciones.UsuarioNuevoInvalidoException;
import modelo.Operario;
import modelo.Sistema;
import vista.IVistaABMOperario;
import vista.IVistaOperario;
import vista.VentanaABMOperario;

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
			} catch (ContraseniaReqNoCumplidosException e1) {
				vista.muestraError(e1.getMessage());
			} catch (ContraseniaLongitudInvalidaException e2) {
				vista.muestraError(e2.getMessage());
			} catch (UsuarioNuevoInvalidoException e3) {
				vista.muestraError(e3.getMessage());
			}
			vista.actualizaBotones();
			vista.actualizaCampos();
		}

		else if(e.getActionCommand().equals("Sacar")) {
			if(this.vista.getListOperarios().getSelectedValue()!=null) {
				Sistema.getInstancia().getOperarios().remove(this.vista.getListOperarios().getSelectedValue());

			}
			vista.actualizaBotones();
			vista.actualizaCampos();
		}
		else if(e.getActionCommand().equals("Modificar")) {
			if(this.vista.getListOperarios().getSelectedValue()!=null) {//ver ue exceptions se lanzan y generar emergente
				try {
					this.vista.getListOperarios().getSelectedValue().setPassword(this.vista.getPassword());
				} catch (ContraseniaReqNoCumplidosException e1) {
					vista.muestraError(e1.getMessage());
				} catch (ContraseniaLongitudInvalidaException e2) {
					vista.muestraError(e2.getMessage());
				}
			}
			vista.actualizaBotones();
			vista.actualizaCampos();
		}
		else if(e.getActionCommand().equals("Listo")) {
			System.out.println("SE PRESIONA BOTON LISTO");
			this.vistaOperario.actualizarListas();

			VentanaABMOperario v = (VentanaABMOperario) this.vista;
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
