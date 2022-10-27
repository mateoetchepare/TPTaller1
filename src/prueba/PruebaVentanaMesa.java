package prueba;

import controlador.ControladorMesa;
import vista.VentanaMesa;

public class PruebaVentanaMesa {

	public static void main(String[] args) {

		VentanaMesa vista=new VentanaMesa();
		ControladorMesa controlador=new ControladorMesa(vista,null,null);
		vista.setVisible(true);

	}

}
