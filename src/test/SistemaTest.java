package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excepciones.CambioObligatorioContraseniaException;
import excepciones.ContraseniaLongitudInvalidaException;
import excepciones.ContraseniaReqNoCumplidosException;
import excepciones.LoginIncorrectoException;
import excepciones.UsuarioNuevoInvalidoException;
import modelo.Operario;
import modelo.Sistema;

public class SistemaTest {
	Sistema sistema;

	@Before
	public void setUp() throws Exception {
		this.sistema = Sistema.getInstancia();
		this.sistema.setOperarios(new ArrayList<Operario>());
	}

	@Test
	public void testloginOperario1() {
		Operario opTest = new Operario("LeoMessi10","CopaAmerica1", "Lionel Andres Messi");
		try {
			sistema.agregaOperario(opTest);
		} catch (ContraseniaReqNoCumplidosException e1) {
			fail("No deberia arrojar excepcion ContraseniaReqNoCumplidosException");
		} catch (ContraseniaLongitudInvalidaException e1) {
			fail("No deberia arrojar excepcion ContraseniaLongitudInvalidaException");
		} catch (UsuarioNuevoInvalidoException e1) {
			fail("No deberia arrojar excepcion UsuarioNuevoInvalidoException");
		}
		
		try {
			sistema.loginOperario("LeoMessi10","CopaAmerica1");
		} catch (LoginIncorrectoException e) {
			fail("No deberia arrojar excepcion LoginIncorrectoException");
		} catch (CambioObligatorioContraseniaException e) {
			fail("No deberia arrojar excepcion CambioObligatorioContraseniaException");
		}
	}
	
	@Test
	public void testloginOperario2() {
		Operario opTest = new Operario("LeoMessi10","CopaAmerica1", "Lionel Andres Messi");
		try {
			sistema.agregaOperario(opTest);
		} catch (ContraseniaReqNoCumplidosException e1) {
			fail("No deberia arrojar excepcion ContraseniaReqNoCumplidosException");
		} catch (ContraseniaLongitudInvalidaException e1) {
			fail("No deberia arrojar excepcion ContraseniaLongitudInvalidaException");
		} catch (UsuarioNuevoInvalidoException e1) {
			fail("No deberia arrojar excepcion UsuarioNuevoInvalidoException");
		}
		
		try {
			sistema.loginOperario("AngelDimaria11","Traemelaco1");
		} catch (LoginIncorrectoException e) {

		} catch (CambioObligatorioContraseniaException e) {
			fail("No deberia arrojar excepcion CambioObligatorioContraseniaException");
		}
		
	}
	
	@Test
	public void testloginOperario3() {
		Operario opTest = new Operario("LeoMessi10","CopaAmerica1", "Lionel Andres Messi");
		try {
			sistema.agregaOperario(opTest);
		} catch (ContraseniaReqNoCumplidosException e1) {
			fail("No deberia arrojar excepcion ContraseniaReqNoCumplidosException");
		} catch (ContraseniaLongitudInvalidaException e1) {
			fail("No deberia arrojar excepcion ContraseniaLongitudInvalidaException");
		} catch (UsuarioNuevoInvalidoException e1) {
			fail("No deberia arrojar excepcion UsuarioNuevoInvalidoException");
		}
		
		try {
			sistema.loginOperario("LeoMessi10","Antonella5");
		} catch (LoginIncorrectoException e) {
			
		} catch (CambioObligatorioContraseniaException e) {
			fail("No deberia arrojar excepcion CambioObligatorioContraseniaException");
		}
		
	}
	
	@Test
	public void testloginOperario4() {
		Operario opTest = new Operario("LeoMessi10","CopaAmerica1", "Lionel Andres Messi");
		try {
			opTest.setActivo(false);
			sistema.agregaOperario(opTest);	 
		} catch (ContraseniaReqNoCumplidosException e1) {
			fail("No deberia arrojar excepcion ContraseniaReqNoCumplidosException");
		} catch (ContraseniaLongitudInvalidaException e1) {
			fail("No deberia arrojar excepcion ContraseniaLongitudInvalidaException");
		} catch (UsuarioNuevoInvalidoException e1) {
			fail("No deberia arrojar excepcion UsuarioNuevoInvalidoException");
		}
		
		try {
			sistema.loginOperario("LeoMessi10","CopaAmerica1");
		} catch (LoginIncorrectoException e) {
			
		} catch (CambioObligatorioContraseniaException e) {
			fail("No deberia arrojar excepcion CambioObligatorioContraseniaException");
		}
		
	}

}
