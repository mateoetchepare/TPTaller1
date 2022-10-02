package excepciones;

public class ContraseniaIncorrectaException extends LoginIncorrectoException{
	public ContraseniaIncorrectaException() {
		super("Contrasenia Incorrecta");
	}
}
