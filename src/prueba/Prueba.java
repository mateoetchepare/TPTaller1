package prueba;

import controlador.ControladorLogin;
import excepciones.UsuarioNuevoInvalidoException;
import modelo.Operario;
import modelo.Sistema;
import vista.VentanaLogin;

public class Prueba {

	public static void main(String[] args) {

		//se lanza la ventana login
		VentanaLogin ventanaLogin = new VentanaLogin();
		ControladorLogin controladorLogin=new ControladorLogin(ventanaLogin);
		ventanaLogin.setVisible(true);
		///////////////////////////////////////////
		
		try {
			Sistema.getInstancia().agregaOperario(new Operario("User1","contrasenia","NombreApellido"));
		} catch (UsuarioNuevoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
