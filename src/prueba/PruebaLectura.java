package prueba;

import modelo.Sistema;
import persistencia.Persistir;

public class PruebaLectura {
	
	public static void main(String[] args) {
		Persistir.leerSistema();
		
		System.out.println(Sistema.getInstancia().getNombre());
		System.out.println("Hay "+Sistema.getInstancia().getMesas().size()+" mesas");
		System.out.println("Hay "+Sistema.getInstancia().getOperarios().size()+" operarios");
		System.out.println("Hay "+Sistema.getInstancia().getMozos().size()+" mozos");
		System.out.println("Hay "+Sistema.getInstancia().getProductos().size()+" productos");
	}
}
