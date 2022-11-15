package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excepciones.MesaDeshabilitadaException;
import excepciones.MesaYaAsignadaException;
import excepciones.MozoInvalidoException;
import excepciones.NoHayPromosActivasException;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.Sistema;

public class MozoTest {

	private Sistema sistema;

	@Before
	public void setUp() throws Exception {
		this.sistema = Sistema.getInstancia();
		PromocionProd promo1 = new PromocionProd();
		PromocionProd promo2 = new PromocionProd();
		
		promo1.setActivo(true);
		promo2.setActivo(true);
		promo1.agregarDiaPromo("Lunes");
		promo2.agregarDiaPromo("Lunes");
		promo1.agregarDiaPromo("Martes");
		promo2.agregarDiaPromo("Martes");
		promo1.setActivo(true);
		promo2.setActivo(true);
		this.sistema.setMozos(new ArrayList<Mozo>());
		this.sistema.setProductos(new ArrayList<Producto>());
		this.sistema.nuevoProducto(new Producto(12,"Milanesa",120.0,150.0,100));
		this.sistema.agregarPromocion(promo1);
		this.sistema.agregarPromocion(promo2);

	}

	@Test
	public void testagregarMesa1() {
		LocalDate fecha = LocalDate.parse("2001-03-01");
		Mozo mozo = new Mozo("Gregorio Firmani",5,fecha);
		this.sistema.agregaMozo(mozo);
		Mesa mesa = new Mesa(1,4);
		
		try {
			mesa.habilitar();
		} catch (NoHayPromosActivasException e) {
			fail("No deberia lanzarse NoHayPromosActivasException");
		}
		
		mesa.setNombreMozo(null);
		mozo.setEstado("Activo");
		
		try {
			mozo.agregarMesa(mesa);
		} catch (MozoInvalidoException e) {
			fail("No deberia lanzarse MozoInvalidoException");
		} catch (MesaDeshabilitadaException e) {
			fail("No deberia lanzarse MesaDeshabilitadaException");
		} catch (MesaYaAsignadaException e) {
			fail("No deberia lanzarse MesaYaAsignadaException");
		}	
		
	}
	
	@Test
	public void testagregarMesa2() {
		LocalDate fecha = LocalDate.parse("2001-03-01");
		Mozo mozo = new Mozo("Gregorio Firmani",5,fecha);
		this.sistema.agregaMozo(mozo);
		Mesa mesa = new Mesa(1,4);
		
		try {
			mesa.habilitar();
		} catch (NoHayPromosActivasException e) {
			fail("No deberia lanzarse NoHayPromosActivasException");
		}
		
		mesa.setNombreMozo(null);
		
		try {
			mozo.agregarMesa(mesa);
		} catch (MozoInvalidoException e) {
			
		} catch (MesaDeshabilitadaException e) {
			fail("No deberia lanzarse MesaDeshabilitadaException");
		} catch (MesaYaAsignadaException e) {
			fail("No deberia lanzarse MesaYaAsignadaException");
		}	
		
	}
	
	@Test
	public void testagregarMesa3() {
		LocalDate fecha = LocalDate.parse("2001-03-01");
		Mozo mozo = new Mozo("Gregorio Firmani",5,fecha);
		this.sistema.agregaMozo(mozo);
		LocalDate fecha2 = LocalDate.parse("2002-06-04");
		Mozo mozo2 = new Mozo("Tomas Bedini",0,fecha2);
		this.sistema.agregaMozo(mozo2);
		Mesa mesa = new Mesa(1,4);
		
		try {
			mesa.habilitar();
		} catch (NoHayPromosActivasException e) {
			fail("No deberia lanzarse NoHayPromosActivasException");
		}
		
		mesa.
		mozo.setEstado("Activo");
		
		try {
			mozo.agregarMesa(mesa);
		} catch (MozoInvalidoException e) {
			fail("No deberia lanzarse MozoInvalidoException");
		} catch (MesaDeshabilitadaException e) {

		} catch (MesaYaAsignadaException e) {
			fail("No deberia lanzarse MesaYaAsignadaException");
		}	
		
	}


}
