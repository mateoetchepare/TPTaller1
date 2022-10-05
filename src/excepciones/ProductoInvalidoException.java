package excepciones;

public class ProductoInvalidoException extends Exception {
	public ProductoInvalidoException() {
		super("Usted pidio un producto que no existe");
	}
}
