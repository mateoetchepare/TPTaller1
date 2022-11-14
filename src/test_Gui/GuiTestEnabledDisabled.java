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
import org.junit.Test;

public class GuiTestEnabledDisabled {

	Robot robot;
	ControladorLogin controlador;
	Operario admin;
	Sistema sistema;
	VentanaLogin ventana = new VentanaLogin();
	JTextField usuario,password;
	JButton boton;
	
	
	public GuiTestEnabledDisabled() {
		try
        {
			robot = new Robot();
        }catch (AWTException e) 
        {
        }
	}
	
	
	@Before
    public void setUp() throws Exception
    {
		sistema = Sistema.getInstancia();
		sistema.agregaOperario(new Operario("firmanig","Gregorio1","Gregorio Firmani"));
		controlador = new ControladorLogin(ventana); 
		usuario = ventana.getTextFieldUsuario();
		password = ventana.getTextFieldContrasenia();
		boton = ventana.getBtnLogin();
		ventana.setVisible(true);
    }
       
	@After
    public void tearDown() throws Exception
    {
       ventana.setVisible(false);
    }
	
	@Test
    public void testIngresoSoloUsuario()
    {
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
	    TestUtils.tipeaTexto("firmanig", robot); 
	    TestUtils.clickComponent(boton, robot);
	    
	    Assert.assertTrue("El boton no deberia estar habilitado",!boton.isEnabled());
    }
	
	@Test
    public void testIngresoTodosLosDatos()
    {
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
	    TestUtils.tipeaTexto("firmanig", robot);
	    TestUtils.clickComponent(password, robot);
	    TestUtils.tipeaTexto("Gregorio1", robot);  
	    TestUtils.clickComponent(boton, robot);
	    
	    Assert.assertTrue("El boton deberia estar habilitado",boton.isEnabled());
    }

	
	
}
