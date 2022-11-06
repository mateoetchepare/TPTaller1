package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.ContraseniaLongitudInvalidaException;
import excepciones.ContraseniaReqNoCumplidosException;
import excepciones.UsuarioNuevoInvalidoException;
import modelo.Operario;
import modelo.Sistema;
import modelo.Sueldo;
import vista.IVistaInicial;

public class ControladorInicial implements ActionListener{
	private IVistaInicial vista = null;
	
	public ControladorInicial(IVistaInicial vista) {
		this.vista = vista;
		this.vista.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Confirmar")) {
			if (Double.parseDouble(vista.getSueldo()) > 0) {
				Sueldo sueldo = (Sueldo) new Sueldo(Double.parseDouble(vista.getSueldo()));
				Sistema.getInstancia().setSueldo(sueldo);
				try {
					Operario op = new Operario(vista.getNombre(), vista.getContrasenia(), vista.getNombre());
					Sistema.getInstancia().agregaOperario(op);
				} catch (ContraseniaReqNoCumplidosException e1) {
					vista.muestraError(e1.getMessage());
				} catch (ContraseniaLongitudInvalidaException e2) {
					vista.muestraError(e2.getMessage());
				}
			} else
				vista.muestraError("Ingrese un sueldo mayor a 0");
		}
	}

}
