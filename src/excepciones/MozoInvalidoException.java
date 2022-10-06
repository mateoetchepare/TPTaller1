package excepciones;

public class MozoInvalidoException extends Exception {
	public MozoInvalidoException() {
		super("Ingrese un mozo valido");
	}
}
