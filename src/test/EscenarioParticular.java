package test;

import java.time.LocalDate;

import excepciones.MesaDeshabilitadaException;
import excepciones.MesaYaAsignadaException;
import excepciones.MozoInvalidoException;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Sistema;

public class EscenarioParticular {
	private Mozo mozo;
	private Sistema sistema;
	

	public EscenarioParticular(Sistema sistema) {
		this.sistema = Sistema.getInstancia() ;
	}

	public void asignarOtroMozo(Mesa mesa) {
		LocalDate fecha = LocalDate.parse("2000-04-11");
		mozo = new Mozo("Carlos Perez",5,fecha);
		mozo.setEstado("Activo");
		this.sistema.agregaMozo(mozo);
		
		try {
			mozo.agregarMesa(mesa);
		} catch (MozoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MesaDeshabilitadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MesaYaAsignadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
