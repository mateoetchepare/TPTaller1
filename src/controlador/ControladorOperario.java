package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.MesaDeshabilitadaException;
import excepciones.MesaYaAsignadaException;
import excepciones.MozoInvalidoException;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Sistema;
import persistencia.Persistir;
import vista.IVistaOperario;
import vista.VentanaABMMozo;
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
				try {
					this.operario.asignarMesa(this.vista.getListMozos().getSelectedValue(), this.vista.getListMesas().getSelectedValue());
				} catch (MozoInvalidoException e1) {
					// TODO Auto-generated catch block
					this.vista.emergenteMozoNoActivo();
				} catch (MesaDeshabilitadaException e1) {
					// TODO Auto-generated catch block
					this.vista.emergenteMesaDeshabilitada();
				} catch (MesaYaAsignadaException e3) {
					this.vista.emergenteMesaAsignada(e3.getMessage());
				}
				
			}else if (e.getActionCommand().equals("Productos / Promociones")) {
				System.out.println("BOTON PRODUCTO/PROMOCION");
				
			}else if (e.getActionCommand().equals("Operario ")) {
				System.out.println("BOTON OPERARIOS");
				VentanaABMOperario ventanaABMOperario=new VentanaABMOperario();
				ControladorABMOperario controladorABMOperario=new ControladorABMOperario(ventanaABMOperario,this.operario,this.vista);
				ventanaABMOperario.setVisible(true);
			}else if (e.getActionCommand().equals("Mozos")) {
				System.out.println("BOTON MOZOS");
				VentanaABMMozo ventanaABMMozo=new VentanaABMMozo();
				ControladorABMMozo controladorABMMozo=new ControladorABMMozo(ventanaABMMozo,this.vista);
				ventanaABMMozo.setVisible(true);
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
				Persistir.escribirSistema();
				
				
			}else if (e.getActionCommand().equals("Modificar")) {
				System.out.println("BOTON MODIFICAR");
				//toma elemento de la lista mozo y el radio button seleccionado y le cambia estado
				this.operario.seteaEstadoMozo(this.vista.getListMozos().getSelectedValue(), this.vista.getEstadoMozo().getText());
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
