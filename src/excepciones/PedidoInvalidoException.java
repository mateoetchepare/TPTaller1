package excepciones;

public class PedidoInvalidoException extends Exception {
	private int stock;
	private int pedido;
	
	public PedidoInvalidoException(int pedido,int stock) {
		super("El pedido no se puede hacer, hay menos stock del que necesita el usuario");
		this.stock=stock;
		this.pedido=pedido;
	}

	public int getStock() {
		return stock;
	}

	public int getPedido() {
		return pedido;
	}
	
}
