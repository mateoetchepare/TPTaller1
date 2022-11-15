package test_Gui;

import controlador.ControladorLogin;
import vista.VentanaLogin;
import vista.IVistaLogin;
import modelo.Operario;
import modelo.Sistema;
import test_Gui.FalsoOptionPane;
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
public class GuiTestConjuntoConDatos {

	static Robot robot;
	static ControladorLogin controlador;
	static Operario admin;
	static Sistema sistema;
	static VentanaLogin ventana = new VentanaLogin();
	static JTextField usuario,password;
	static JButton boton;
	static FalsoOptionPane op = new FalsoOptionPane();
	
	
	
	public GuiTestConjuntoConDatos() {
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
		admin = new Operario("firmanig","Gregorio1","Gregorio Firmani");
		sistema.agregaOperario(admin);
		controlador = new ControladorLogin(ventana); 
		usuario = ventana.getTextFieldUsuario();
		password = ventana.getTextFieldContrasenia();
		boton = ventana.getBtnLogin();
		ventana.setOptionPanel(op);
		ventana.setVisible(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ventana.setVisible(false);
	}

	@Before
	public void setUp() throws Exception {
		robot.delay(TestUtils.getDelay());
		usuario.setText("");
		password.setText("");
		robot.delay(TestUtils.getDelay());
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testA_UsuarioIncorrecto() {
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
		TestUtils.tipeaTexto("firmanih", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Gregorio1", robot);
		TestUtils.clickComponent(boton, robot);
		
		Assert.assertTrue("El boton deberia estar habilitado", boton.isEnabled());
		Assert.assertEquals("Deberia haber salido el siguiente mensaje : Usuario no encontrado ", "Usuario no encontrado", op.getMensaje());
	}
	
	@Test
	public void testB_ContraseniaIncorrecto() {
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
		TestUtils.tipeaTexto("firmanig", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Gregorio9", robot);
		TestUtils.clickComponent(boton, robot);
		
		Assert.assertTrue("El boton deberia estar habilitado", boton.isEnabled());
		Assert.assertEquals("Deberia haber salido el siguiente mensaje : Contrasenia Incorrecta ", "Contrasenia Incorrecta", op.getMensaje());
	}
	
	@Test
	public void testC_OperarioInactivo() {
		admin.setActivo(false);
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
		TestUtils.tipeaTexto("firmanig", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Gregorio9", robot);
		TestUtils.clickComponent(boton, robot);
		
		Assert.assertTrue("El boton deberia estar habilitado", boton.isEnabled());
		Assert.assertEquals("Deberia haber salido el siguiente mensaje : El operario NO esta activo, no puede ingresar al sistema. Consulte con el administrador ",
				"El operario NO esta activo, no puede ingresar al sistema. Consulte con el administrador", op.getMensaje());
		
		admin.setActivo(true);
		robot.delay(TestUtils.getDelay());
	}
	
	@Test
	public void testD_LoginCorrecto() {
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(usuario, robot);
		TestUtils.tipeaTexto("firmanig", robot);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Gregorio1", robot);
		TestUtils.clickComponent(boton, robot);
		
		Assert.assertTrue("El boton deberia estar habilitado", boton.isEnabled());
	}

}
