package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.Comanda;
import modelo.Factura;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Promocion;
import modelo.Sueldo;

public class SistemaDTO implements Serializable {
	private ArrayList<Operario> operarios = new ArrayList<Operario>(); //puede XML
	private ArrayList<Mozo> mozos = new ArrayList<Mozo>(); //puede XML
	private ArrayList<Producto> productos = new ArrayList<Producto>(); //puede XML
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>(); //puede XML
	private ArrayList<Promocion> promociones = new ArrayList<Promocion>(); //puede XML
	private ArrayList<Comanda> comandas = new ArrayList<Comanda>(); //puede XML
	private ArrayList<Factura> facturas = new ArrayList<Factura>(); //puede XML
	private String nombre;
	private Sueldo sueldo; // sueldo que paga a mesero  //puede XML
	
	public SistemaDTO() {}

	public ArrayList<Operario> getOperarios() {
		return operarios;
	}

	public void setOperarios(ArrayList<Operario> operarios) {
		this.operarios = operarios;
	}

	public ArrayList<Mozo> getMozos() {
		return mozos;
	}

	public void setMozos(ArrayList<Mozo> mozos) {
		this.mozos = mozos;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}

	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}

	public ArrayList<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(ArrayList<Comanda> comandas) {
		this.comandas = comandas;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Sueldo getSueldo() {
		return sueldo;
	}

	public void setSueldo(Sueldo sueldo) {
		this.sueldo = sueldo;
	}
	
	
}
