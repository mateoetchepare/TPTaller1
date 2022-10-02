package modelo;

public class Mesa {
	private int numeroMesa;
	private int comensales;
	private String estado;
	private Comanda comanda;
	
	public Mesa(int numeroMesa, int comensales) {
		this.numeroMesa = numeroMesa;
		this.comensales = comensales;
		this.estado = "libre";
	}

	public int getNumeroMesa() {
		return this.numeroMesa;
	}
	
	public int getComensales() {
		return this.comensales;
	}
	
	
}
