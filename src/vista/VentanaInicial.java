package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaInicial extends JFrame {

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
		this.contentPane.setLayout(new GridLayout(6, 0, 0, 0));
		
		this.labelTitulo = new JLabel("Usuario: ADMIN123");
		this.labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(this.labelTitulo);
		
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
	}

}
