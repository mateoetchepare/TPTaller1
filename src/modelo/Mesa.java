package modelo;

public class Mesa {
	private int numeroMesa;
	private int comensales;
	private String estado;
	
	public Mesa() {}
	
	public Mesa(int numeroMesa, int comensales) {
		this.numeroMesa = numeroMesa;
		this.comensales = comensales;
		this.estado = "libre";
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	public int getNumeroMesa() {
		return this.numeroMesa;
	}
	
	public int getComensales() {
		return this.comensales;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
