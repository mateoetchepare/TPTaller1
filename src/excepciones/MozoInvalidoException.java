package excepciones;

public class MozoInvalidoException extends Exception {
	public MozoInvalidoException() {
		super("No puede asignar un mozo que este ausente o de franco a una mesa");
	}
}
