package modelo;

public class Operario {
	private boolean activo;
	private String nombreUsuario;
	private String password;
	private String nombreYApellido;
	
	public Operario(String nombreUsuario, String password, String nombreYApellido) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreYApellido = nombreYApellido;
		this.activo = true; // asumimos que cuando se agrega operario, se agrega como activo
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
