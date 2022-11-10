package excepciones;

public class MesaYaAsignadaException extends Exception {
	public MesaYaAsignadaException() {
		super("La mesa ya fue asignada a otro mozo");
	}
}
