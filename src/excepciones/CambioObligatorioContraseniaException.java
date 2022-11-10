package excepciones;

public class CambioObligatorioContraseniaException extends Exception {
	public CambioObligatorioContraseniaException() {
		super("Es la primera vez que se loguea como administrador, debe cambiar la contrasenia antes de loguearse");
	}
}
