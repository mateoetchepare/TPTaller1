package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.EstadoInvalidoMozoException;
import excepciones.MesaDeshabilitadaException;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Sistema;
import vista.IVistaOperario;
import vista.VentanaABMOperario;
import vista.VentanaLogin;
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
				
			}else if (e.getActionCommand().equals("Productos / Promociones")) {
				System.out.println("BOTON PRODUCTO/PROMOCION");
				
			}else if (e.getActionCommand().equals("Operario ")) {
				System.out.println("BOTON OPERARIOS");
				VentanaABMOperario ventanaABMOperario=new VentanaABMOperario();
				ControladorABMOperario controladorABMOperario=new ControladorABMOperario(ventanaABMOperario,this.operario,this.vista);
				ventanaABMOperario.setVisible(true);
			}else if (e.getActionCommand().equals("Mozos")) {
				System.out.println("BOTON MOZOS");
				
			}else if (e.getActionCommand().equals("Estadisticas")) {
				System.out.println("BOTON ESTADISTICAS");
				
			}else if (e.getActionCommand().equals("Cerrar Sesion")) {
				System.out.println("BOTON CERRAR SESION");
				
				//ocultar esta vista y volver a ventana login
				this.vista.setVisible(false);
				VentanaLogin ventanaLogin=new VentanaLogin();
				ControladorLogin controladorLogin=new ControladorLogin(ventanaLogin);
				ventanaLogin.setVisible(true);
				//DEBERIA PERSISTIR????
				
				
			}else if (e.getActionCommand().equals("Modificar")) {
				System.out.println("BOTON MODIFICAR");
				//toma elemento de la lista mozo y el radio button seleccionado y le cambia estado
				try {
					this.operario.seteaEstadoMozo(this.vista.getListMozos().getSelectedValue(), this.vista.getEstadoMozo().getText());
				} catch (EstadoInvalidoMozoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace(); //no deberia lanzar nunca esta exception
				}
				this.actualizarListas();	
				
				
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
