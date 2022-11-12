package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import excepciones.CambioObligatorioContraseniaException;
import excepciones.ContraseniaIncorrectaException;
import excepciones.ContraseniaLongitudInvalidaException;
import excepciones.ContraseniaReqNoCumplidosException;
import excepciones.LoginIncorrectoException;
import excepciones.MesaInvalidaException;
import excepciones.MozoSinVentasException;
import excepciones.NoHayFacturasException;
import excepciones.ProductoEnComandaException;
import excepciones.ProductoExistenteException;
import excepciones.ProductoPreciosInvalidosException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioIncorrectoException;
import excepciones.UsuarioNuevoInvalidoException;

public class Sistema {
	private ArrayList<Operario> operarios = new ArrayList<Operario>(); // puede XML
	private ArrayList<Mozo> mozos = new ArrayList<Mozo>(); // puede XML
	private ArrayList<Producto> productos = new ArrayList<Producto>(); // puede XML
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>(); // puede XML
	private ArrayList<Promocion> promociones = new ArrayList<Promocion>(); // puede XML
	private ArrayList<Comanda> comandas = new ArrayList<Comanda>(); // puede XML
	private ArrayList<Factura> facturas = new ArrayList<Factura>(); // puede XML
	private String nombre;
	private Sueldo sueldo; // sueldo que paga a mesero //puede XML
	private static Sistema instancia = null;
	private transient LocalDate fecha;
	private transient String diaActual;

	// persistencia XML constructor vacio y todos los geter y seters
	// Agregue todas las cosas necesarias para hacer persistencia XML y termine
	// usando bin
	

	public ArrayList<Mozo> getMozos() {
		return mozos;
	}

	public void agregarPromocion(Promocion prom) {
		this.promociones.add(prom);
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
		if (instancia == null) {
			instancia = new Sistema();
			instancia.fecha=LocalDate.now();
		}
		return instancia;
	}

	public ArrayList<Operario> getOperarios() {
		return operarios;
	}

	public boolean alMenos2PromosProd() {
		int i = 0, j, cont = 0;
		diaActualAlEspanol();
		j = promociones.size();
		while (i < j && cont < 2) {
			if (promociones.get(i) instanceof PromocionProd && promociones.get(i).isActivo()
					&& promociones.get(i).contieneDiaDePromo(this.diaActual))
				cont++;
			i++;
		}
		return cont == 2;
	}

	/**
	 * @param mesa
	 * @throws MesaInvalidaException si se quiere ingresar una mesa con numero de
	 *                               mesa ya existente o la combinacion de
	 *                               comensales - nro de mesa es invalido <br>
	 *                               Metodo encargado de crear una mesa nueva para
	 *                               el restaurant <br>
	 * 
	 *                               <b>PostCond:</b> Devuelve una mesa valida nueva
	 *                               en caso de que el numero ingresado no este
	 *                               usado previamente <br>
	 *                               por otra mesa y que la combinacion de numero de
	 *                               comensales y numero de mesa sea valido
	 * 
	 */

	public void agregaMesa(Mesa mesa) throws MesaInvalidaException {
		int i = 0, j;

		if ((mesa.getNumeroMesa() >= 1 && mesa.getComensales() >= 2)
				|| (mesa.getNumeroMesa() == 0 && mesa.getComensales() == 1)) {
			j = this.mesas.size();

			while (i < j && (this.mesas.get(i).getNumeroMesa() != mesa.getNumeroMesa())) {
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

	public void agregaMozo(Mozo mozo) {
		mozos.add(mozo);
	}

	public void borrarMozo(Mozo mozo) {
		mozos.remove(mozo);
	}
	
	/**
	 * @param operario <br>
	 * @throws ContraseniaReqNoCumplidosException   si la contrasenia no contiene al
	 *                                              menos un numero y una mayuscula
	 *                                              <br>
	 * @throws ContraseniaLongitudInvalidaException si la contrasenia no tiene una
	 *                                              longitud entre 6 y 12 caracteres
	 *                                              <br>
	 * @throws UsuarioNuevoInvalidoException        si se quiere agregar un nombre
	 *                                              de usuario que ya existe en el
	 *                                              sistema
	 */
	public void agregaOperario(Operario operario) throws ContraseniaReqNoCumplidosException,
			ContraseniaLongitudInvalidaException, UsuarioNuevoInvalidoException {
		int i = 0, j;
		boolean mayus = false, numero = false;
		String contrasenia = operario.getPassword();
		char ch;
		if (contrasenia.length() >= 6 && contrasenia.length() <= 12) {
			while (i < contrasenia.length() && (mayus != true || numero != true)) {
				ch = contrasenia.charAt(i);
				if (Character.isDigit(ch)) {
					numero = true;
				} else if (Character.isUpperCase(ch)) {
					mayus = true;
				}
				i++;
			}
			if (mayus && numero) {
				i=0;
				j = operarios.size();
				while (i < j && operarios.get(i).getNombreUsuario() != operario.getNombreUsuario()) {
					i++;
				}
				if (i == j)
					operarios.add(operario);
				else
					throw new UsuarioNuevoInvalidoException(
							"El nombre de usuario ya esta en uso, ingrese uno diferente");
			} else
				throw new ContraseniaReqNoCumplidosException();
		} else
			throw new ContraseniaLongitudInvalidaException();
	}

	public void borraOperario(Operario operario) {
		operarios.remove(operario);
	}

	/**
	 * 
	 *
	 * <b>PostCond:</b> devuelve el operario logueado, si no hay ningun error en el
	 * tipeo de datos
	 *
	 */

	public Operario loginOperario(String usuario, String contrasenia)
			throws LoginIncorrectoException, CambioObligatorioContraseniaException {
		int j, i = 0;

		j = operarios.size();
		while (i < j && (!operarios.get(i).getNombreUsuario().equals(usuario))) {

			i++;
		}
		if (i == j) {

			throw new UsuarioIncorrectoException();
		} else if (operarios.get(i).getNombreUsuario().equals(usuario)
				&& !operarios.get(i).getPassword().equals(contrasenia)) {

			throw new ContraseniaIncorrectaException();
		} else if (operarios.get(i).isActivo() == false)
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

	public int retornaStock(Producto producto) { //
		int indice = productos.indexOf(producto);
		return productos.get(indice).getStock();
	}

	// Revisar, agregar una nueva comanda cuando estado de mesa pasa a ocupada
	/*
	 * public void agregaComanda (Comanda comanda) { // esto se va a poder llamar si
	 * se valida condicionesUsoDeMesa comandas.add(comanda);
	 * comanda.getMesa().setEstado("ocupada"); }
	 */

	/**
	 * @param producto <br>
	 * @throws ProductoEnComandaException La excepcion se lanzara si se intenta
	 *                                    eliminar un producto que fue pedido por
	 *                                    alguna comanda que no ha sido cerrada aun
	 */
	public void eliminaProducto(Producto producto) throws ProductoEnComandaException { // usar un try en el controlador
		boolean alMenosUnaComanda = false;
		int i = 0, j;
		j = comandas.size(); 
		while (i < j && alMenosUnaComanda == false) {
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

	/**
	 * @param producto
	 * @throws ProductoExistenteException        si ingresa un producto con un id
	 *                                           que ya es usado previamente <br>
	 * @throws ProductoPreciosInvalidosException si ingresa un producto con un
	 *                                           precio de venta menor al precio de
	 *                                           costo
	 */
	public void nuevoProducto(Producto producto) throws ProductoExistenteException, ProductoPreciosInvalidosException {
		int i = 0, j;
		j = productos.size();
		while (i < j && productos.get(i).getId() != producto.getId())
			i++;
		if (i == j)
			if (producto.getPrecioCosto() <= producto.getPrecioVenta() && producto.getPrecioCosto() > 0
					&& producto.getPrecioVenta() > 0)
				productos.add(producto);
			else
				throw new ProductoPreciosInvalidosException();
		else
			throw new ProductoExistenteException();
	}

	public void diaActualAlEspanol() {
		switch (fecha.getDayOfWeek()) {
		case SUNDAY:
			this.diaActual = "Domingo";
			break;
		case MONDAY:
			this.diaActual = "Lunes";
			break;
		case TUESDAY:
			this.diaActual = "Martes";
			break;
		case WEDNESDAY:
			this.diaActual = "Miercoles";
			break;
		case THURSDAY:
			this.diaActual = "Jueves";
			break;
		case FRIDAY:
			this.diaActual = "Viernes";
			break;
		case SATURDAY:
			this.diaActual = "Sabado";
			break;
		}
	}

	/**
	 * Genera la factura de la comanda luego de cerrarse la comanda <br>
	 * <b>PreCond:</b> la formaDePago debe ser una formaDePago valida. <br>
	 * <b>PostCond:</b> debe crearse la factura correctamente y guardarse en sistema
	 * <br>
	 *
	 */
	public void facturarComanda(Comanda comanda, String formaDePago) {
		double auxTotal = 0, total = 0;
		int i = 0, j, h = 0, k;
		;
		ArrayList<Pedido> pedidos = clonoArrayList(comanda.getPedidos());// aca voy a dejar los pedidos que NO tengan
																			// promo
		ArrayList<Promocion> promosAplicadas = new ArrayList<Promocion>();
		boolean acumulable = false, hayPromoTemp = false;
		double porcDesc = 0;

		diaActualAlEspanol();

		j = promociones.size();
		while (i < j) {
			if (promociones.get(i).isActivo() && promociones.get(i).contieneDiaDePromo(this.diaActual)) { // &&
																											// promociones.get(i).getDiasDePromo())
																											// ///////COMO
																											// MIER...
																											// ME FIJO
																											// SI EL DIA
																											// ACTUAL ES
																											// IGUAL AL
																											// DIA DE LA
																											// PROMO?
				if (promociones.get(i) instanceof PromocionProd) {
					PromocionProd aux = (PromocionProd) promociones.get(i);
					if (comanda.contieneProducto(aux.getProducto())) {
						if (aux.isAplicaDosPorUno()) {
							auxTotal += Math.ceil(comanda.cantidadDelProducto(aux.getProducto())
									* aux.getProducto().getPrecioVenta() / 2);
						} else if (aux.isAplicaDtoPorCantidad() && (aux.getDtoPorCantidad_CantMinima() > comanda
								.cantidadDelProducto(aux.getProducto())))
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
			total = (total * porcDesc) + auxTotal;
		} else {
			total = total + auxTotal;
		}

		Mesa mesa = null;
		int aux = 0;

		while (i < this.mesas.size() && mesa == null) {
			if (comanda.getNumeroMesa() == this.mesas.get(aux).getNumeroMesa())
				mesa = this.mesas.get(aux);
		}
		Factura factura = new Factura(mesa, comanda.getPedidos(), total, formaDePago, promosAplicadas);
		mesa.setEstado("libre");
		comandas.remove(comanda);
	}

	public ArrayList<Pedido> clonoArrayList(ArrayList<Pedido> pedidos) {
		ArrayList<Pedido> pedidosClonados = new ArrayList<Pedido>();
		for (Pedido p : pedidos) {
			pedidosClonados.add((Pedido) p.clone());
		}
		return pedidosClonados;
	}

	public String estadisticas(Mozo mozo) throws MozoSinVentasException{
		String cadena = null;
		int cont=0;
		double total=0;

		for (Factura factura : this.facturas) {
			if (factura.getMesa().getNombreMozo().equals(mozo.getNombreYApellido())) {
				cont++;
				total+=factura.getTotal();
			}
		}
		
		if(cont==0)
			throw new MozoSinVentasException();

		return "El mozo "+mozo.getNombreYApellido()+" realizo "+cont+" ventas, con un total"
				+ " de $"+total+" y un promedio de $"+total/cont+" por venta";
	}

	public String mayorMenorVenta() throws NoHayFacturasException {
		ArrayList<TotalVentaMozo> ventasMozos = new ArrayList<TotalVentaMozo>();
		String mozoDeFactura = null;
		boolean esta;
		TotalVentaMozo aux = null;

		String mozoMayor = null;
		String mozoMenor = null;
		double mayor=0;
		double menor=999999999;

		if (!this.facturas.isEmpty()) {
			for (Factura factura : this.facturas) {
				mozoDeFactura = factura.getMesa().getNombreMozo();
				esta = false;
				Iterator<TotalVentaMozo> it = ventasMozos.iterator();
				while (it.hasNext() && !esta) {
					aux = it.next();
					if (aux.getNombreMozo().equals(mozoDeFactura)) {
						esta = true;
						aux.sumarVenta(factura.getTotal());
					}
				}
				if (!esta) {
					aux = new TotalVentaMozo(factura.getMesa().getNombreMozo());
					aux.sumarVenta(factura.getTotal());
					ventasMozos.add(aux);
				}
			}
			
		} else
			throw new NoHayFacturasException();

		for(TotalVentaMozo ventaMozo : ventasMozos) {
			
			if(ventaMozo.getTotal()>mayor) {
				mayor=ventaMozo.getTotal();
				mozoMayor=ventaMozo.getNombreMozo();
			}
			if(ventaMozo.getTotal()<menor) {
				menor=ventaMozo.getTotal();
				mozoMenor=ventaMozo.getNombreMozo();
			}
		}
		
		return "El mozo con el mayor volumen de venta es: "+mozoMayor+" con un total de $"+mayor+
				"\nEl mozo con el menor volumen de venta es: "+mozoMenor+" con un total de $"+menor;
	}
}
