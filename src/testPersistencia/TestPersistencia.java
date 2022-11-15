package testPersistencia;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import excepciones.ContraseniaLongitudInvalidaException;
import excepciones.ContraseniaReqNoCumplidosException;
import excepciones.UsuarioNuevoInvalidoException;
import modelo.Comanda;
import modelo.Factura;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Promocion;
import modelo.Sistema;
import persistencia.Persistir;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class TestPersistencia {
	Sistema sist = Sistema.getInstancia();
	
	@Before
	public void setUp() throws Exception {
		File archivo = new File("Sistema.bin");
		if (archivo.exists()) {
			archivo.delete();
		}
	}

	@Test
	public void testA_CrearArchivoCorrectamente() {
		Persistir.escribirSistema();	
		File archivo = new File("Sistema.bin");
		Assert.assertTrue("Tendria que existir el archivo", archivo.exists());
	}
	
	@Test
	public void testB_LecturaCorrectaSistema() {
		Persistir.escribirSistema();
		Persistir.leerSistema();
		
		Assert.assertNotEquals("Deberia haberse recuperado el Sistema", sist, null);
		Assert.assertNotEquals("Deberia haberse recuperado el ArrayList", sist.getProductos(), null);
		Assert.assertNotEquals("Deberia haberse recuperado el ArrayList", sist.getPromociones(), null);
		Assert.assertNotEquals("Deberia haberse recuperado el ArrayList", sist.getOperarios(), null);
		Assert.assertNotEquals("Deberia haberse recuperado el ArrayList", sist.getMozos(), null);
		Assert.assertNotEquals("Deberia haberse recuperado el ArrayList", sist.getMesas(), null);
		Assert.assertNotEquals("Deberia haberse recuperado el ArrayList", sist.getComandas(), null);
		Assert.assertNotEquals("Deberia haberse recuperado el ArrayList", sist.getFacturas(), null);
	}
	
	@Test
	public void testC_escrituraYLecturaCorrectaDeElementoDeArrayList() throws ContraseniaReqNoCumplidosException, ContraseniaLongitudInvalidaException, UsuarioNuevoInvalidoException {
		Operario operario = new Operario("firmanig","Gregorio1","Gregorio Firmani");
		sist.agregaOperario(operario); 
		//No se catchea ninguna excepcion ya que para este ejemplo nos aseguramos de crear al Operario correctamente
		Persistir.escribirSistema();
		Persistir.leerSistema();
		Assert.assertEquals("Los operarios deberian tener un mismo nombre y apellido",sist.getOperarios().get(0).getNombreYApellido(),operario.getNombreYApellido());
		Assert.assertEquals("Los operarios deberian tener un mismo usuario",sist.getOperarios().get(0).getNombreUsuario(),operario.getNombreUsuario());
		Assert.assertEquals("Los operarios deberian tener una misma contrasenia",sist.getOperarios().get(0).getPassword(),operario.getPassword());
		
	}
	//Revisar este ultimo caso ya que no funciona

}
