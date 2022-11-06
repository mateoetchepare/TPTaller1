package prueba;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import controlador.ControladorLogin;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Sistema;
import persistencia.Persistir;
import vista.VentanaLogin;

public class PruebaHardcodeo {
	public static void main(String[] args) {
		/////////////////////// MESAS ///////////////////////////////////////
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();
		

		mesas.add(new Mesa(0, 1));
		mesas.add(new Mesa(1, 2));
		mesas.add(new Mesa(2, 4));
		mesas.add(new Mesa(3, 4));
		mesas.add(new Mesa(4, 6));
		////////////////////////////////////////////////////////////////////////
		
		////////////////////////  PRODUCTOS   ////////////////////////////////
		ArrayList<Producto> productos=new ArrayList<Producto>();
		
		productos.add(new Producto(1,"Milanesa",200,500,20));
		productos.add(new Producto(2,"Tortilla",200,500,20));
		productos.add(new Producto(3,"Tacos",200,500,20));
		productos.add(new Producto(4,"Arepas",200,500,20));
		productos.add(new Producto(5,"Tempura de hongos",200,500,20));
		///////////////////////////////////////////////////////////////////////

		/////////////////////// OPERARIOS ///////////////////////////////////////
		ArrayList<Operario> operarios = new ArrayList<Operario>();

		operarios.add(new Operario("Usuario 1", "contrasenia1", "Joaco Acu�a"));
		operarios.add(new Operario("Usuario 2", "contrasenia2", "Ramiro Lopez"));
		operarios.add(new Operario("Usuario 3", "contrasenia3", "Julian Gonzales"));
		/////////////////////////////////////////////////////////////////////////////

		/////////////////////// MOZOS ///////////////////////////////////////
		ArrayList<Mozo> mozos = new ArrayList<Mozo>();

		Mozo mozo=new Mozo(0,LocalDate.of(1998,07,04));
		mozo.setNombreYApellido("Malena");
		mozos.add(mozo);
		
		mozo=new Mozo(0,LocalDate.of(1998,9,12));
		mozo.setNombreYApellido("Manu");
		mozos.add(mozo);
		
		mozo=new Mozo(0,LocalDate.of(2000,9,12));
		mozo.setNombreYApellido("More");
		mozos.add(mozo);
		
		/////////////////////////////////////////////////////////////////////////////

		Sistema.getInstancia().setNombre("Bohr");
		Sistema.getInstancia().setMesas(mesas);
		Sistema.getInstancia().setOperarios(operarios);
		Sistema.getInstancia().setMozos(mozos);
		Sistema.getInstancia().setProductos(productos);
		
		System.out.println("Hay "+Sistema.getInstancia().getMesas().size()+" mesas");
		System.out.println("Hay "+Sistema.getInstancia().getOperarios().size()+" operarios");
		System.out.println("Hay "+Sistema.getInstancia().getMozos().size()+" mozos");
		System.out.println("Hay "+Sistema.getInstancia().getProductos().size()+" productos");
		
		////////////////////////////////////////////////////////////////////////////////
		
		VentanaLogin ventanaLogin = new VentanaLogin();
		ControladorLogin controladorLogin=new ControladorLogin(ventanaLogin);
		ventanaLogin.setVisible(true);
		
		
		//HACER PERSISTENCIA EN CONTROLADOR OPERARIO CUANDO CIERRA SESION
		//Persistir.escribirSistema();
		
	}

}
