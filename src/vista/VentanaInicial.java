package vista;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaInicial extends JFrame implements IVistaInicial, KeyListener{

	private JPanel contentPane;
	private JLabel labelTitulo;
	private JPanel panelContrasenia;
	private JPanel panelRepetirContrasenia;
	private JPanel panelRestaurante;
	private JPanel panelSueldo;
	private JPanel panelBoton;
	private JLabel labelContrasenia;
	private JTextField textContrasenia;
	private JLabel labelRepetirContrasenia;
	private JTextField textRepetirContrasenia;
	private JLabel labelRestaurant;
	private JTextField textFieldRestaurante;
	private JLabel labelSueldo;
	private JTextField textFieldSueldo;
	private JButton btnConfirmar;
	private JPanel panelNombreApellido;
	private JLabel labelNombreApellido;
	private JTextField textFieldNombreApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
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
	public VentanaInicial() {
		setTitle("Carga datos iniciales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(7, 0, 0, 0));
		
		this.labelTitulo = new JLabel("Usuario: ADMIN123");
		this.labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(this.labelTitulo);
		
		this.panelNombreApellido = new JPanel();
		this.contentPane.add(this.panelNombreApellido);
		
		this.labelNombreApellido = new JLabel("Nombre y Apellido: ");
		this.panelNombreApellido.add(this.labelNombreApellido);
		
		this.textFieldNombreApellido = new JTextField();
		this.panelNombreApellido.add(this.textFieldNombreApellido);
		this.textFieldNombreApellido.setColumns(10);
		
		this.panelContrasenia = new JPanel();
		this.contentPane.add(this.panelContrasenia);
		
		this.labelContrasenia = new JLabel("Nueva contrasenia: ");
		this.panelContrasenia.add(this.labelContrasenia);
		
		this.textContrasenia = new JTextField();
		this.panelContrasenia.add(this.textContrasenia);
		this.textContrasenia.setColumns(10);
		
		this.panelRepetirContrasenia = new JPanel();
		this.contentPane.add(this.panelRepetirContrasenia);
		
		this.labelRepetirContrasenia = new JLabel("Repetir nueva contrasenia: ");
		this.panelRepetirContrasenia.add(this.labelRepetirContrasenia);
		
		this.textRepetirContrasenia = new JTextField();
		this.panelRepetirContrasenia.add(this.textRepetirContrasenia);
		this.textRepetirContrasenia.setColumns(10);
		
		this.panelRestaurante = new JPanel();
		this.contentPane.add(this.panelRestaurante);
		
		this.labelRestaurant = new JLabel("Nombre restaurante: ");
		this.panelRestaurante.add(this.labelRestaurant);
		
		this.textFieldRestaurante = new JTextField();
		this.panelRestaurante.add(this.textFieldRestaurante);
		this.textFieldRestaurante.setColumns(10);
		
		this.panelSueldo = new JPanel();
		this.contentPane.add(this.panelSueldo);
		
		this.labelSueldo = new JLabel("Sueldo basico: ");
		this.panelSueldo.add(this.labelSueldo);
		
		this.textFieldSueldo = new JTextField();
		this.panelSueldo.add(this.textFieldSueldo);
		this.textFieldSueldo.setColumns(10);
		
		this.panelBoton = new JPanel();
		this.contentPane.add(this.panelBoton);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.panelBoton.add(this.btnConfirmar);
		
		this.btnConfirmar.setEnabled(false);
		
		this.textContrasenia.addKeyListener(this);
		this.textFieldNombreApellido.addKeyListener(this);
		this.textFieldRestaurante.addKeyListener(this);
		this.textFieldSueldo.addKeyListener(this);
		this.textRepetirContrasenia.addKeyListener(this);
		
		
	}

	@Override
	public void addActionListener(ActionListener listener) {
		// TODO Auto-generated method stub
		this.btnConfirmar.addActionListener(listener);
	}

	@Override
	public String getContrasenia() {
		// TODO Auto-generated method stub
		return this.textContrasenia.getText();
	}

	@Override
	public String getContrasenia2() {
		// TODO Auto-generated method stub
		return this.textRepetirContrasenia.getText();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.textFieldRestaurante.getText();
	}

	@Override
	public String getNombreApellido() {
		// TODO Auto-generated method stub
		return this.textFieldNombreApellido.getText();
	}
	
	@Override
	public String getSueldo() {
		// TODO Auto-generated method stub
		return this.textFieldSueldo.getText();
	}

	public void muestraError(String msg) {
		JOptionPane.showMessageDialog(this, msg);
		this.textContrasenia.setText("");
		this.textFieldNombreApellido.setText("");
		this.textFieldRestaurante.setText("");
		this.textFieldSueldo.setText("");
		this.textRepetirContrasenia.setText("");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (!this.textFieldNombreApellido.getText().isEmpty() && !this.textFieldRestaurante.getText().isEmpty() && 
				!this.textFieldSueldo.getText().isEmpty() && !this.textContrasenia.getText().isEmpty() && !this.textRepetirContrasenia.getText().isEmpty()) {
			this.btnConfirmar.setEnabled(true);
		}
		else
			this.btnConfirmar.setEnabled(false);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizaBotones() {
		this.btnConfirmar.setEnabled(false);
	}

	@Override
	public void actualizaCampos() {
		this.textContrasenia.setText("");
		this.textFieldNombreApellido.setText("");
		this.textFieldRestaurante.setText("");
		this.textFieldSueldo.setText("");
		this.textRepetirContrasenia.setText("");
	}
	

}
