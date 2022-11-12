package excepciones;

public class PrecioUnitarioInvalidoException extends Exception {
	public PrecioUnitarioInvalidoException() {
		super("usted ingreso un precio unitario supuestamente en descuento que es mayor al precio de venta del producto");
	}
}	
