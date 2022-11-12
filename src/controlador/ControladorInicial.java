package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import excepciones.ContraseniaLongitudInvalidaException;
import excepciones.ContraseniaReqNoCumplidosException;
import excepciones.UsuarioNuevoInvalidoException;
import modelo.Mesa;
import modelo.Operario;
import modelo.Sistema;
import modelo.Sueldo;
import vista.IVistaInicial;
import vista.VentanaInicial;
import vista.VentanaLogin;

public class ControladorInicial implements ActionListener {
	private IVistaInicial vista = null;

	public ControladorInicial(IVistaInicial vista) {
		this.vista = vista;
		this.vista.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Confirmar")) {
			if (this.vista.getContrasenia().equals(this.vista.getContrasenia2())) {
				try {
					if (Double.parseDouble(vista.getSueldo()) > 0) {
						Sueldo sueldo = (Sueldo) new Sueldo(Double.parseDouble(vista.getSueldo()));
						Sistema.getInstancia().setSueldo(sueldo);
						try {
							Operario op = new Operario("ADMIN1234", vista.getContrasenia(), vista.getNombre());
							Sistema.getInstancia().agregaOperario(op);
							VentanaLogin ventanaLogin = new VentanaLogin();
							cargaMesas();
							ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
							ventanaLogin.setVisible(true);
							VentanaInicial v = (VentanaInicial) this.vista;
							v.setVisible(false);
						} catch (ContraseniaReqNoCumplidosException e1) {
							vista.muestraError(e1.getMessage());
						} catch (ContraseniaLongitudInvalidaException e2) {
							vista.muestraError(e2.getMessage());
						} catch (UsuarioNuevoInvalidoException e3) {
							vista.muestraError(e3.getMessage());
						}
					} else
						vista.muestraError("Ingrese un sueldo mayor a 0");
					// vista.actualizaBotones();
					// vista.actualizaCampos();
				} catch (NumberFormatException e4) {
					vista.muestraError("Sueldo mal ingresado");
				}
			}
			else
				vista.muestraError("Las contraseñas no coinciden");
		}
		
	}
	
	public void cargaMesas() {
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();
		

		mesas.add(new Mesa(0, 1));
		mesas.add(new Mesa(1, 2));
		mesas.add(new Mesa(2, 4));
		mesas.add(new Mesa(3, 4));
		mesas.add(new Mesa(4, 6));
		
		Sistema.getInstancia().setMesas(mesas);
	}

}
