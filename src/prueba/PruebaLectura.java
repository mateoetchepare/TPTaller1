package prueba;

import modelo.Sistema;
import persistencia.Persistir;

public class PruebaLectura {
	
	public static void main(String[] args) {
		Persistir.leerSistema();
		
		System.out.println(Sistema.getInstancia().getOperarios().isEmpty());
		System.out.println(Sistema.getInstancia().getOperarios().get(0).getNombreUsuario());
	}
}
