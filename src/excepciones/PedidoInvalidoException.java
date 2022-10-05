package excepciones;

public class PedidoInvalidoException extends Exception {
	public PedidoInvalidoException() {
		super("El pedido no se puede hacer, hay menos stock del que necesita el usuario");
	}
}
