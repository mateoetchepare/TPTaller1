package prueba;

import controlador.ControladorLogin;
import excepciones.UsuarioNuevoInvalidoException;
import modelo.Operario;
import modelo.Sistema;
import persistencia.Persistir;
import vista.VentanaLogin;

public class Prueba {

	public static void main(String[] args) {
/*
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
		
		Persistir.escribirSistema();*/
		lanzarSistema();
	}
	
	private static void lanzarSistema() {
		Persistir.leerSistema();
		System.out.println(Sistema.getInstancia().getOperarios().size());
		
		if(Sistema.getInstancia().getMozos().get(0).getMesas()==null)
			System.out.println("Array mesas es null");
		
		if(Sistema.getInstancia().getOperarios().isEmpty()) {
			//creacion total del sistema
		}
		else {
			//el sistema ya existe, se lanza ventana login
			VentanaLogin ventanaLogin = new VentanaLogin();
			ControladorLogin controladorLogin=new ControladorLogin(ventanaLogin);
			ventanaLogin.setVisible(true);
		}
	}
	

}
