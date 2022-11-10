package excepciones;

public class ProductoExistenteException extends Exception {
	public ProductoExistenteException() {
		super("Usted quiere agregar un nuevo producto ya existente");
	}
}
