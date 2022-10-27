package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VentanaLogin extends JFrame implements KeyListener, IVistaLogin {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JLabel LabelTitulo;
	private JPanel panelDatos;
	private JPanel panelNombre;
	private JLabel LabelUsuario;
	private JTextField textFieldUsuario;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panelContrasenia;
	private JLabel LabelContrasenia;
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panelBotonera;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnLogin;
	private JPasswordField textFieldContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setTitle("Sistema Restaurante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panelDatos = new JPanel();
		this.panelPrincipal.add(this.panelDatos);
		this.panelDatos.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panelNombre = new JPanel();
		this.panelDatos.add(this.panelNombre);
		this.panelNombre.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.LabelUsuario = new JLabel("Usuario:");
		this.LabelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelNombre.add(this.LabelUsuario);
		
		this.panel = new JPanel();
		this.panelNombre.add(this.panel);
		this.panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_2 = new JPanel();
		this.panel.add(this.panel_2);
		
		this.textFieldUsuario = new JTextField();
		this.textFieldUsuario.addKeyListener(this);
		this.panel.add(this.textFieldUsuario);
		this.textFieldUsuario.setColumns(10);
		
		this.panelContrasenia = new JPanel();
		this.panelDatos.add(this.panelContrasenia);
		this.panelContrasenia.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.LabelContrasenia = new JLabel("Contrase\u00F1a:");
		this.LabelContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelContrasenia.add(this.LabelContrasenia);
		
		this.panel_1 = new JPanel();
		this.panelContrasenia.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);
		
		this.textFieldContrasenia = new JPasswordField();
		this.textFieldContrasenia.addKeyListener(this);
		this.panel_1.add(this.textFieldContrasenia);
		
		this.panelBotonera = new JPanel();
		this.panelPrincipal.add(this.panelBotonera);
		this.panelBotonera.setLayout(new GridLayout(5, 0, 0, 0));
		
		this.panel_4 = new JPanel();
		this.panelBotonera.add(this.panel_4);
		
		this.panel_5 = new JPanel();
		this.panelBotonera.add(this.panel_5);
		
		this.panel_6 = new JPanel();
		this.panelBotonera.add(this.panel_6);
		this.panel_6.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panel_7 = new JPanel();
		this.panel_6.add(this.panel_7);
		
		this.btnLogin = new JButton("Ingresar");
		this.btnLogin.setEnabled(false);
		//this.btnLogin.addActionListener(this);
		this.panel_6.add(this.btnLogin);
		
		this.LabelTitulo = new JLabel("Ventana login");
		this.contentPane.add(this.LabelTitulo, BorderLayout.NORTH);
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		this.btnLogin.setEnabled(this.textFieldContrasenia.getText().length()>=6 && this.textFieldContrasenia.getText().length()<=12 && this.textFieldUsuario.getText().length()>0);
	}
	public void keyTyped(KeyEvent e) {
	}
	public void actionPerformed(ActionEvent e) {
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return this.textFieldUsuario.getText();
	}

	
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.textFieldContrasenia.getText();
	}

	
	public void addActionListener(ActionListener listener) {
		this.btnLogin.addActionListener(listener);
		
	}

	@Override
	public void emergenteUsuarioIncorecto() {
		JOptionPane.showMessageDialog(this,"Usuario no encontrado");
		
	}

	@Override
	public void emergetneContraseniaIncorrecta() {
		JOptionPane.showMessageDialog(this,"Contrasenia Incorrecta");
	}

	@Override
	public void emergenteUsuarioInactivo() {
		JOptionPane.showMessageDialog(this,"El operario NO esta activo, no puede ingresar al sistema. Consulte con el administrador");
	}
}
