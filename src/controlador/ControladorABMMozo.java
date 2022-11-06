package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import modelo.Mozo;
import vista.IVistaABMMozo;

public class ControladorABMMozo implements ActionListener{
	private IVistaABMMozo vista = null;
	
	public ControladorABMMozo(IVistaABMMozo vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Agregar")) {
			String fecha = vista.getFechaNacimiento();
			boolean correcta=false;
			if(fecha.length()==10) {
				if(fecha.charAt(2)=='/' && fecha.charAt(5)=='/') {
					int dia,mes,anio;
					dia= Integer.parseInt(fecha.substring(0, 2));
					mes= Integer.parseInt(fecha.substring(3, 5));
					anio= Integer.parseInt(fecha.substring(6, 10));
					if(dia>0 && dia<=31 && mes>0 && mes<=12 && anio>0 && anio<=9999) {
						correcta=true;
						LocalDate fechaNac = LocalDate.of(dia, mes, anio);
					}
				}
		    }
			if (correcta && vista.getCantHijos()>=0 && vista.getCantHijos<12) {
				Mozo mozo = new Mozo(vista.getNombre() + vista.getApellido(), vista.getCantHijos(), vista.getFechaNacimiento());
			}
		}
		
	}

}
