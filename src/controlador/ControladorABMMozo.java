package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

import modelo.Mozo;
import modelo.Operario;
import modelo.Sistema;
import vista.IVistaABMMozo;
import vista.IVistaOperario;
import vista.VentanaABMMozo;
import vista.VentanaABMOperario;

public class ControladorABMMozo implements ActionListener{
	private IVistaABMMozo vista = null;
	private IVistaOperario vistaOperario=null;
	

	public ControladorABMMozo(IVistaABMMozo vista,IVistaOperario vistaOperario) {
		this.vista = vista;
		this.vistaOperario=vistaOperario;
		this.vistaOperario.setVisible(false);
		this.vista.addActionListener(this);
		this.actualizarListas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LocalDate fechaNac = null;
		if(e.getActionCommand().equals("Agregar")) {
			System.out.println("BOTON AGREGAR");
			String fecha = vista.getFechaNacimiento();
			if(fecha.length()==10) {
				if(fecha.charAt(2)=='/' && fecha.charAt(5)=='/') {
					int dia,mes,anio;
					dia= Integer.parseInt(fecha.substring(0, 2));
					mes= Integer.parseInt(fecha.substring(3, 5));
					anio= Integer.parseInt(fecha.substring(6, 10));
					if(dia>0 && dia<=31 && mes>0 && mes<=12 && anio>0 && anio<=9999) {
						fechaNac = LocalDate.of(dia, mes, anio);
					}
				}
			}
			if (fechaNac != null && vista.getCantHijos()>=0 && vista.getCantHijos()<12) {
				if (Period.between(fechaNac, LocalDate.now()).getYears() >= 18) {
					Mozo mozo = new Mozo(vista.getNombre() + vista.getApellido(), vista.getCantHijos(), fechaNac);
				} else
					vista.muestraError("El mozo debe ser mayor a 18");
			} else
				vista.muestraError("Ingrese una cantidad de hijos valida y una fecha de nacimiento valida");
			vista.actualizaBotones();
			vista.actualizaCampos();
		} else 
			if (e.getActionCommand().equals("Sacar")) {
				System.out.println("BOTON SACAR");
				Sistema.getInstancia().borrarMozo(vista.getMozo());
				vista.actualizaBotones();
				vista.actualizaCampos();
		} else 
			if (e.getActionCommand().equals("Modificar")) { // esto solo va a poder ser presionado cambiandole la cantidad de hijos
				System.out.println("BOTON MODIFICAR");
				Mozo m = vista.getMozo();
				if (vista.getCantHijos() >= 0)
					m.setHijos(vista.getCantHijos());
				else
					vista.muestraError("No es posible modificar por un numero de hijos negativo");
				vista.actualizaCampos();
				vista.actualizaBotones();
			} else
				if (e.getActionCommand().equals("Listo")) {
					this.vista.actualizarLista();
					VentanaABMMozo v = (VentanaABMMozo) this.vista;
					v.setVisible(false);
					this.vistaOperario.setVisible(true);
				}
		actualizarListas();
	}
	
	public void actualizarListas() {
		this.vista.getModeloListaMozos().clear();
		for (Mozo mozo : Sistema.getInstancia().getMozos()) {
			
				this.vista.getModeloListaMozos().addElement(mozo);
		}
		

	}
}
