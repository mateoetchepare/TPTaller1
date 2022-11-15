package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excepciones.CambioObligatorioContraseniaException;
import excepciones.ContraseniaIncorrectaException;
import excepciones.ContraseniaLongitudInvalidaException;
import excepciones.ContraseniaReqNoCumplidosException;
import excepciones.LoginIncorrectoException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioIncorrectoException;
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
		} catch (UsuarioIncorrectoException e) {
			fail("No deberia arrojar excepcion UsuarioIncorrectoException");
		}catch (ContraseniaIncorrectaException e) {
			fail("No deberia arrojar excepcion ContraseniaIncorrectaException");
		}catch (UsuarioInactivoException e) {
			fail("No deberia arrojar excepcion UsuarioInactivoException");
		}catch (CambioObligatorioContraseniaException e) {
			fail("No deberia arrojar excepcion CambioObligatorioContraseniaException");
		}catch (LoginIncorrectoException e) {
			fail("No deberia arrojar excepcion LoginIncorrectoException");
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
		}catch (UsuarioIncorrectoException e) {
			
		}catch (ContraseniaIncorrectaException e) {
			fail("No deberia arrojar excepcion ContraseniaIncorrectaException");
		}catch (UsuarioInactivoException e) {
			fail("No deberia arrojar excepcionUsuarioInactivoException ");
		}catch (CambioObligatorioContraseniaException e) {
			fail("No deberia arrojar excepcion CambioObligatorioContraseniaException");
		}catch (LoginIncorrectoException e) {
			fail("No deberia arrojar excepcion LoginIncorrectoException");
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
		} catch (UsuarioIncorrectoException e) {
			fail("No deberia arrojar excepcion UsuarioIncorrectoException");
		}catch (ContraseniaIncorrectaException e) {
			
		}catch (UsuarioInactivoException e) {
			fail("No deberia arrojar excepcion UsuarioInactivoException");
		}catch (CambioObligatorioContraseniaException e) {
			fail("No deberia arrojar excepcion CambioObligatorioContraseniaException");
		}catch (LoginIncorrectoException e) {
			fail("No deberia arrojar excepcion LoginIncorrectoException");
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
		} catch (UsuarioIncorrectoException e) {
			fail("No deberia arrojar excepcion UsuarioIncorrectoException");
		}catch (ContraseniaIncorrectaException e) {
			fail("No deberia arrojar excepcion ContraseniaIncorrectaException");
		}catch (UsuarioInactivoException e) {
			
		}catch (CambioObligatorioContraseniaException e) {
			fail("No deberia arrojar excepcion CambioObligatorioContraseniaException");
		}catch (LoginIncorrectoException e) {
			fail("No deberia arrojar excepcion LoginIncorrectoException");
		}
		
	}

}
