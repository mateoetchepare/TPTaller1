package testPersistencia;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import modelo.Sistema;
import persistencia.Persistir;

public class TestPersistenciaVacio {
	Sistema sist = Sistema.getInstancia();
	
	@Before
	public void setUp() throws Exception {
		File archivo = new File("Sistema.bin");
		if (archivo.exists()) {
			archivo.delete();
		}
	}

	@Test
	public void testCrearArchivo() {
		Persistir.escribirSistema();	
		File archivo = new File("Sistema.bin");
		
		
	}

}
