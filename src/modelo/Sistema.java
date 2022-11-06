package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.CambioObligatorioContraseniaException;
import excepciones.ContraseniaIncorrectaException;
import excepciones.ContraseniaLongitudInvalidaException;
import excepciones.ContraseniaReqNoCumplidosException;
import excepciones.LoginIncorrectoException;
import excepciones.MesaInvalidaException;
import excepciones.ProductoEnComandaException;
import excepciones.ProductoExistenteException;
import excepciones.ProductoPreciosInvalidosException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioIncorrectoException;
import excepciones.UsuarioNuevoInvalidoException;

public class Sistema {
	private ArrayList<Operario> operarios = new ArrayList<Operario>(); //puede XML
	private ArrayList<Mozo> mozos = new ArrayList<Mozo>(); //puede XML
	private ArrayList<Producto> productos = new ArrayList<Producto>(); //puede XML
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>(); //puede XML
	private ArrayList<Promocion> promociones = new ArrayList<Promocion>(); //puede XML
	private ArrayList<Comanda> comandas = new ArrayList<Comanda>(); //puede XML
	private ArrayList<Factura> facturas = new ArrayList<Factura>(); //puede XML
	private String nombre;
	private Sueldo sueldo; // sueldo que paga a mesero  //puede XML
	private static Sistema instancia = null;
	private transient LocalDate fecha;
	private transient String diaActual;

	//persistencia XML constructor vacio y todos los geter y seters
	//Agregue todas las cosas necesarias para hacer persistencia XML y termine usando bin
	public Sistema() {
		
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

	public void setOperarios(ArrayList<Operario> operarios) {
		this.operarios = operarios;
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
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public static Sistema getInstancia() {
		if (instancia == null)
			instancia = new Sistema();
		return instancia;
	}
	
	public ArrayList<Operario> getOperarios() {
		return operarios;
	}	
	
	/**
	 *	Metodo encargado de crear una mesa nueva para el restaurant
	 *  
	 * <b>PostCond:</b> Devuelve una mesa valida nueva en caso de que el numero ingresado no este usado previamente <br>
	 * por otra mesa y que la combinacion de numero de comensales y numero de mesa sea valido
	 *
	 */

	public void agregaMesa(Mesa mesa) throws MesaInvalidaException{
		int i = 0, j;

		if ((mesa.getNumeroMesa() >= 1 && mesa.getComensales() >= 2) || (mesa.getNumeroMesa() == 0 && mesa.getComensales() == 1)) {
			j = this.mesas.size();

			while(i < j && (this.mesas.get(i).getNumeroMesa() != mesa.getNumeroMesa())) {
				i++;
			}
			if (i < j) {
				throw new MesaInvalidaException("El numero de mesa ya esta usado");
			} else {
				mesas.add(mesa);
			}
		} else
			throw new MesaInvalidaException("La combinacion de comensales - numero de mesa es invalido");
	}
	
	/**
	 * 
	 * <b>PreCond:</b> numeroMesa debe ser mayor a 0. <br>
	 * <b>PostCond:</b> debe devolver una mesa, si el numero ingresado corresponde a una mesa valida
	 *
	 */
	
	public Mesa retornaMesa(int numeroMesa) throws MesaInvalidaException{
		int i=0, j;
		j = mesas.size();
		while (i<j && mesas.get(i).getNumeroMesa() != numeroMesa) {
			i++;
		}
		if (i<j) 
			return mesas.get(i);
		else
			throw new MesaInvalidaException("La mesa no existe");
	}

	public void agregaOperario(Operario operario) throws ContraseniaReqNoCumplidosException, ContraseniaLongitudInvalidaException{ 
		int i = 0;
		boolean mayus = false, numero = false;
		String contrasenia = operario.getPassword();
		char ch;
		if (contrasenia.length() >= 6 && contrasenia.length() <= 12) {
			while (i < contrasenia.length() && (mayus != true && numero != true)) {
				ch = contrasenia.charAt(i);
				if( Character.isDigit(ch)) {
					numero = true;
				}
				else if (Character.isUpperCase(ch)) {
					mayus = true;
				}
				i++;
			}
			if (mayus == numero == true) {
				operarios.add(operario);
			} else
				throw new ContraseniaReqNoCumplidosException();
		} else
			throw new ContraseniaLongitudInvalidaException();
	} 
	

	
	//cambio el login, ue no se pase un operario, sino nombre de usuario y contrasenia
	
	/**
	 * 
	 *
	 * <b>PostCond:</b> devuelve el operario logueado, si no hay ningun error en el tipeo de datos
	 *
	 */
	
	
	public Operario loginOperario(String usuario,String contrasenia) throws LoginIncorrectoException, CambioObligatorioContraseniaException{
		int j, i =0;


		j = operarios.size();
		while (i < j && (!operarios.get(i).getNombreUsuario().equals(usuario) )){
			
			i++;
		}
		if (i == j) {
			
			throw new UsuarioIncorrectoException();
		} else
			if (operarios.get(i).getNombreUsuario().equals(usuario) && !operarios.get(i).getPassword().equals(contrasenia)) {
				
				throw new ContraseniaIncorrectaException();
			}
			else
				if (operarios.get(i).isActivo() == false) 
					throw new UsuarioInactivoException();
				else
					return operarios.get(i);
	}

	public boolean unSoloOperario() {
		return operarios.size() == 1;
	}
	
	/**
	 * 
	 * <b>PreCond:</b> cantComensales debe ser mayor a 0 <br>
	 * <b>PostCond:</b> devuelve una mesa si en efecto habia una libre para ocuparse
	 *
	 */
/*
	public Mesa condicionesUsoDeMesa(int cantComensales) throws MesaInvalidaException{
		int i = 0, j, h = 0, k;
		boolean mozoActivo = false;
		j = mesas.size();
		k = mozos.size();
		if (j == 0) {
			throw new MesaInvalidaException("No hay mesas habilitadas");
		} else
			if (productos.size() == 0) {
				throw new MesaInvalidaException("No hay productos en stock");
				// else si no hay promos vigentes
			}
		while (!mozoActivo) {
			while (i<j && (mesas.get(i).getComensales() >= cantComensales || mesas.get(i).getEstado() != "libre")) 
				i++;
			if (i<j) {
				while (h < k && (mozos.get(i).getEstado()!="activo" && mozos.get(i).mesaACargo(mesas.get(i)) != false)) // hay algun mozo a cargo de la mesa y q este libre?
					h++;
				if (mozos.get(i).getEstado()!="activo" && mozos.get(i).mesaACargo(mesas.get(i)) != false) // si el mozo esta libre y tiene la mesa a cargo
					mozoActivo = true;
			}
		}
		if (mozoActivo) {
			return mesas.get(i);
		} else
			throw new MesaInvalidaException("No se encontro un mozo libre a cargo de la mesa o no habia una mesa libre con esas caracteristicas");
	} 
	*/
	
	/* public Mozo retornaMozo(Mozo mozo) throws MozoInvalidoException {
		if (mozos.contains(mozo)) {
			int indice = mozos.indexOf(mozo);
			return mozos.get(indice);
		} else
			throw new MozoInvalidoException();	
	}
	*/ // estp crep q lo hice al pedo ( ahora aclaro en discord ) 
	
	public int retornaStock(Producto  producto){ // 
			int indice = productos.indexOf(producto);
				return productos.get(indice).getStock();
	}
	
	//Revisar, agregar una nueva comanda cuando estado de mesa pasa a ocupada
	/*public void agregaComanda (Comanda comanda) { // esto se va a poder llamar si se valida condicionesUsoDeMesa
		comandas.add(comanda);
		comanda.getMesa().setEstado("ocupada");
	}*/
	
	public void eliminaProducto(Producto producto) throws ProductoEnComandaException{ // usar un try en el controlador
		boolean alMenosUnaComanda = false;
		int i = 0, j;
		j = comandas.size(); // NO VALIDO SI CONTIENE PORQUE SE VA A PICKEAR DESDE UNA LISTA
		while (i<j && alMenosUnaComanda == false) {
			if (comandas.get(i).contieneProducto(producto))
				alMenosUnaComanda = true;
			else
				i++;
		}
		if (alMenosUnaComanda) {
			throw new ProductoEnComandaException();
		} else
			productos.remove(producto);
	}
	
	
	
	public void nuevoProducto(Producto producto) throws ProductoExistenteException, ProductoPreciosInvalidosException{
		if (!productos.contains(producto))
			if (producto.getPrecioCosto() <= producto.getPrecioVenta() && producto.getPrecioCosto() > 0 && producto.getPrecioVenta() > 0 )
				productos.add(producto);
			else
				throw new ProductoPreciosInvalidosException();
		else
			throw new ProductoExistenteException();
	}
	
	public void diaActualAlEspanol() {
		switch (fecha.getDayOfWeek()) {
		case SUNDAY:
			this.diaActual = "domingo";
			break;
		case MONDAY:
			this.diaActual = "lunes";
			break;
		case TUESDAY:
			this.diaActual = "martes";
			break;
		case WEDNESDAY:
			this.diaActual = "miercoles";
			break;
		case THURSDAY:
			this.diaActual = "jueves";
			break;
		case FRIDAY:
			this.diaActual = "viernes";
			break;
		case SATURDAY:
			this.diaActual = "sabado";
			break;
		}
	}
		
	
	/**
	 * Genera la factura de la comanda luego de cerrarse la comanda
	 * <b>PreCond:</b> la formaDePago debe ser una formaDePago valida. <br>
	 * <b>PostCond:</b> debe crearse la factura correctamente y guardarse en sistema
	 *
	 */
	public void facturarComanda(Comanda comanda, String formaDePago) {
		double auxTotal=0, total=0;
		int i=0, j, h=0, k;;
		ArrayList<Pedido> pedidos = clonoArrayList(comanda.getPedidos());// aca voy a dejar los pedidos que NO tengan promo
		ArrayList<Promocion> promosAplicadas = new ArrayList<Promocion>();
		boolean acumulable = false, hayPromoTemp=false;
		double porcDesc=0;

		j = promociones.size();
		while (i<j) {
			if (promociones.get(i).isActivo() && promociones.get(i).getDiasDePromo() == this.diaActual) { //  && promociones.get(i).getDiasDePromo()) ///////COMO MIER... ME FIJO SI EL DIA ACTUAL ES IGUAL AL DIA DE LA PROMO?
				if (promociones.get(i) instanceof PromocionProd) {
					PromocionProd aux = (PromocionProd) promociones.get(i);
					if (comanda.contieneProducto(aux.getProducto())) {
						if (aux.isAplicaDosPorUno()) {
							auxTotal += Math.ceil(comanda.cantidadDelProducto(aux.getProducto()) * aux.getProducto().getPrecioVenta() / 2);
						} else
							if (aux.isAplicaDtoPorCantidad() && (aux.getDtoPorCantidad_CantMinima() > comanda.cantidadDelProducto(aux.getProducto())))
								auxTotal += aux.getDtoPorCantidad_PrecioUnitario() * aux.getProducto().getPrecioVenta();

						k = pedidos.size();
						while (h < k) { // elimino de la lista de productos que no tienen promo
							if (aux.getProducto().getId() == pedidos.get(h).getProducto().getId()) 
								pedidos.remove(h);
							h++;
						}
						promosAplicadas.add(aux);
					}
				} else {
					PromocionTemp auxT = (PromocionTemp) promociones.get(i);
					if (auxT.getFormaPago() == formaDePago) {
						acumulable = auxT.isEsAcumulable();
						porcDesc = auxT.getPorcentajeDescuento();
						hayPromoTemp = true;
						promosAplicadas.add(auxT);
					}
				}
			}
			i++;
		}
		
		k = pedidos.size();
		h = 0;

		while (h < k) {
			total += pedidos.get(h).getCantidad() * pedidos.get(h).getProducto().getPrecioVenta();
		}
		if (hayPromoTemp) {
			if (acumulable) {
				auxTotal *= porcDesc;
			}
			total = (total*porcDesc) + auxTotal;
		} else {
			total = total + auxTotal;
		}


		/// AGREGO///
		Mesa mesa=null;
		int aux=0;
		
		while(i<this.mesas.size() && mesa==null) {
			if(comanda.getNumeroMesa()==this.mesas.get(aux).getNumeroMesa())
				mesa=this.mesas.get(aux);
		}//en teoria mesa no puede ser null porue la comanda se crea en una mesa, asegurando ue la encuentra
		///////////////
		Factura factura = new Factura(/*comanda.getMesa()*/mesa, comanda.getPedidos(), total, formaDePago, promosAplicadas);
		//comanda.getMesa().setEstado("libre"); //Se pone en estado libre desde la ventana solo cuando se 
		//cierra la mesa
		comandas.remove(comanda);
	}
	
	public ArrayList<Pedido> clonoArrayList(ArrayList<Pedido> pedidos) {
		ArrayList<Pedido> pedidosClonados = new ArrayList<Pedido>();
		for (Pedido p : pedidos) {
			pedidosClonados.add((Pedido) p.clone());
		}
		return pedidosClonados;
	}
	
}




