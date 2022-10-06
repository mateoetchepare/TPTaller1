package excepciones;

public class EstadoInvalidoMozoException extends Exception {
	public EstadoInvalidoMozoException() {
		super("El estado ingresado es invalido, por favor ingrese un numero entre 0 y 2 inclusive");
	}
}
