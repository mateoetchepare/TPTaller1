package excepciones;

public class UsuarioIncorrectoException extends LoginIncorrectoException {
	public UsuarioIncorrectoException() {
		super("Usuario no encontrado");
	}
}
