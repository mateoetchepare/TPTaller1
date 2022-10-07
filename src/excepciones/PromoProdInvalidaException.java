package excepciones;

public class PromoProdInvalidaException extends Exception {
	public PromoProdInvalidaException() {
		super("Usted no puede hacer que ambos tipos de aplica promo sea falso, ya que no habria promo de esa forma");
	}
}
