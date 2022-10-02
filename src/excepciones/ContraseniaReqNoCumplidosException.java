package excepciones;

public class ContraseniaReqNoCumplidosException extends UsuarioNuevoInvalidoException {
	public ContraseniaReqNoCumplidosException() {
		super("La contrasenia tiene que tener al menos 1 numero y al menos 1 digito numerico");
	}
}
