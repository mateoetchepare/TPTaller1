package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaInicial extends JFrame {

	private JPanel contentPane;
	private JLabel labelTitulo;
	private JPanel panelContrasenia;
	private JPanel panelRepetirContrasenia;
	private JPanel panelRestaurante;
	private JPanel panelSueldo;
	private JPanel panelPorcentaje;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(7, 0, 0, 0));
		
		this.labelTitulo = new JLabel("Usuario: ADMIN123");
		this.labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(this.labelTitulo);
		
		this.panelContrasenia = new JPanel();
		this.contentPane.add(this.panelContrasenia);
		
		this.panelRepetirContrasenia = new JPanel();
		this.contentPane.add(this.panelRepetirContrasenia);
		
		this.panelRestaurante = new JPanel();
		this.contentPane.add(this.panelRestaurante);
		
		this.panelSueldo = new JPanel();
		this.contentPane.add(this.panelSueldo);
		
		this.panelPorcentaje = new JPanel();
		this.contentPane.add(this.panelPorcentaje);
	}

}
