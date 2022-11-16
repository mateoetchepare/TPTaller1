package test_Gui;

import controlador.ControladorLogin;
import vista.VentanaLogin;
import vista.IVistaLogin;
import modelo.Operario;
import modelo.Sistema;
import test_Gui.TestUtils;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class GuiTestEnabledDisabled {

	static Robot robot;
	static ControladorLogin controlador;
	static Operario admin;
	static Sistema sistema;
	static VentanaLogin ventana = new VentanaLogin();
	static JTextField usuario,password;
	static JButton boton;
	
	
	public GuiTestEnabledDisabled() {
		try
        {
			robot = new Robot();
        }catch (AWTException e) 
        {
        }
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sistema = Sistema.getInstancia();
		sistema.agregaOperario(new Operario("firmanig","Gregorio1","Gregorio Firmani"));
		controlador = new ControladorLogin(ventana); 
		usuario = ventana.getTextFieldUsuario();
		password = ventana.getTextFieldContrasenia();
		boton = ventana.getBtnLogin();
		ventana.setVisible(true);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ventana.setVisible(false);
	}
	
	@Before
    public void setUp() throws Exception{
		robot.delay(TestUtils.getDelay());
		usuario.setText("");
		password.setText("");
		robot.delay(TestUtils.getDelay());
    }
       
	@After
    public void tearDown() throws Exception
    {
       
    }
	
	@Test
    public void testA_IngresoSoloUsuario(){
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
	    TestUtils.tipeaTexto("firmanig", robot); 
	    robot.delay(TestUtils.getDelay());
	    TestUtils.clickComponent(boton, robot);
	    
	    Assert.assertTrue("El boton no deberia estar habilitado",!boton.isEnabled());
    }
	
	@Test
	public void testB_IngresoSoloPassword() {
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Gregorio1", robot);
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(boton, robot);
		
		Assert.assertTrue("El boton no deberia estar habilitado",!boton.isEnabled());
	}
	
	@Test
	public void testC_IngresoUsuarioYPasswordMenor6Car() {
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
		TestUtils.tipeaTexto("firmanig", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Grego", robot);
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(boton, robot);
		
		Assert.assertTrue("El boton no deberia estar habilitado", !boton.isEnabled());
	}
	
	@Test
	public void testD_IngresoUsuarioYPasswordMayor12Car() {
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
		TestUtils.tipeaTexto("firmanig", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Gregorio1234567", robot);
		robot.delay(TestUtils.getDelay());
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(boton, robot);
		
		Assert.assertTrue("El boton no deberia estar habilitado", !boton.isEnabled());
	}
	
	@Test
	public void testE_IngresoDatosUsuarioYPasswordCorrectos() {
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
		TestUtils.tipeaTexto("firmanig", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Gregorio1", robot);
		robot.delay(TestUtils.getDelay());
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(boton, robot);
		
		Assert.assertTrue("El boton deberia estar habilitado", boton.isEnabled());
	}
	
}