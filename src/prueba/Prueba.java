package prueba;

import controlador.ControladorInicial;
import controlador.ControladorLogin;
import modelo.Sistema;
import persistencia.Persistir;
import vista.VentanaInicial;
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
		/*
		Persistir.leerSistema();
		VentanaEstadisticas ventanaEstadisticas=new VentanaEstadisticas();
		ControladorEstadisticas controladorEstadisticas=new ControladorEstadisticas(ventanaEstadisticas,new VentanaOperario());
		ventanaEstadisticas.setVisible(true);
		*/
	}
	
	private static void lanzarSistema() {
		Persistir.leerSistema();
		System.out.println(Sistema.getInstancia().getOperarios().size());
		
		
		if(Sistema.getInstancia().getOperarios().isEmpty()) {
			//creacion total del sistema
			VentanaInicial ventanaInicial=new VentanaInicial();
			ControladorInicial controladorInicial=new ControladorInicial(ventanaInicial);
			ventanaInicial.setVisible(true);
		}
		else {
			//el sistema ya existe, se lanza ventana login
			VentanaLogin ventanaLogin = new VentanaLogin();
			ControladorLogin controladorLogin=new ControladorLogin(ventanaLogin);
			ventanaLogin.setVisible(true);
		}
	}
	

}
