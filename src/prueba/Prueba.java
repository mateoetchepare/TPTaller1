package prueba;

import controlador.ControladorEstadisticas;
import controlador.ControladorLogin;
import modelo.Sistema;
import persistencia.Persistir;
import vista.VentanaEstadisticas;
import vista.VentanaLogin;
import vista.VentanaOperario;

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
		//lanzarSistema();
		Persistir.leerSistema();
		VentanaEstadisticas ventanaEstadisticas=new VentanaEstadisticas();
		ControladorEstadisticas controladorEstadisticas=new ControladorEstadisticas(ventanaEstadisticas,new VentanaOperario());
		ventanaEstadisticas.setVisible(true);
		
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
