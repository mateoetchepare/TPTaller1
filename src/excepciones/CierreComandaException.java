package excepciones;

public class CierreComandaException extends Exception {
	public CierreComandaException() {
		super("La comanda ya ha sido cerrada previamente")
	}
}
