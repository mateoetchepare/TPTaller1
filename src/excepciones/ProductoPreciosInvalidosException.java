package excepciones;

public class ProductoPreciosInvalidosException extends Exception {
	public ProductoPreciosInvalidosException() {
		super("Usted ingreso precios erroneos, o precioCosto>PrecioVenta o PrecioCosto o PrecioVenta menores a 0");
	}
}
