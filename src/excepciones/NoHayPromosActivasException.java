package excepciones;

public class NoHayPromosActivasException extends Exception {
	public NoHayPromosActivasException() {
		super("Para abrir una mesa debe haber activas, por lo menos, 2 promociones de productos");
	}
}
