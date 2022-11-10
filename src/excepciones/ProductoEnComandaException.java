package excepciones;

public class ProductoEnComandaException extends Exception {
	public ProductoEnComandaException() {
		super("Usted esta tratando de elminar un producto que se encuentra en una comanda");
	}
}
