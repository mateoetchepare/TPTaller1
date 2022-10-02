package excepciones;

public class ContraseniaLongitudInvalidaException extends UsuarioNuevoInvalidoException {
	public ContraseniaLongitudInvalidaException() {
		super("La contrasenia tiene que tener entre 6 y 12 digitos");
	}
}
