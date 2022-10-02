package excepciones;

public class UsuarioInactivoException extends LoginIncorrectoException{
	public UsuarioInactivoException() {
		super("El operario NO está activo, no puede ingresar al sistema. Consulte con el administrador");
	}
}
