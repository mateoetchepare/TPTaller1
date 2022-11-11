package prueba;

import java.util.ArrayList;

import controlador.Controlador;
import controlador.ControladorEstadisticas;
import excepciones.MozoSinVentasException;
import excepciones.NoHayFacturasException;
import modelo.Factura;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Sistema;
import vista.VentanaEstadisticas;
import vista.VentanaOperario;

public class PruebaEstadisticas {

	public static void main(String[] args) {
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();
		

		mesas.add(new Mesa(0, 1));
		mesas.get(0).setNombreMozo("joaco");
		mesas.add(new Mesa(1, 2));
		mesas.get(1).setNombreMozo("joaco");
		mesas.add(new Mesa(2, 4));
		mesas.get(2).setNombreMozo("pepe");
		mesas.add(new Mesa(3, 4));
		mesas.get(3).setNombreMozo("pepe");
		
		ArrayList<Factura> facturas=new ArrayList<Factura>();
		facturas.add(new Factura());
		facturas.get(0).setMesa(mesas.get(0));
		facturas.get(0).setTotal(5000);
		
		facturas.add(new Factura());
		facturas.get(1).setMesa(mesas.get(0));
		facturas.get(1).setTotal(5000);
		
		facturas.add(new Factura());
		facturas.get(2).setMesa(mesas.get(2));
		facturas.get(2).setTotal(15000);
		
		facturas.add(new Factura());
		facturas.get(3).setMesa(mesas.get(3));
		facturas.get(3).setTotal(15000);
		
		Sistema.getInstancia().setFacturas(facturas);
		try {
			System.out.println(Sistema.getInstancia().mayorMenorVenta());
		} catch (NoHayFacturasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mozo mozo=new Mozo("joaco");
		try {
			System.out.println(Sistema.getInstancia().estadisticas(mozo));
		} catch (MozoSinVentasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VentanaEstadisticas ventana= new VentanaEstadisticas();
		ControladorEstadisticas controlador=new ControladorEstadisticas(ventana,new VentanaOperario());
		ventana.setVisible(true);
	}
	
	
}
