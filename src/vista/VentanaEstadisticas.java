package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class VentanaEstadisticas extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel labelMozos;
	private JPanel panelCentral;
	private JList listMozos;
	private JPanel panelBotonera;
	private JButton btnVerificar;
	private JButton btnListo;
	private JScrollPane scrollPane_1;
	private JLabel labelEstadisticas;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEstadisticas frame = new VentanaEstadisticas();
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
	public VentanaEstadisticas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane, BorderLayout.WEST);
		this.scrollPane.setPreferredSize(new Dimension(150,50));
		
		this.labelMozos = new JLabel("MOZOS");
		this.labelMozos.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane.setColumnHeaderView(this.labelMozos);
		
		this.listMozos = new JList();
		this.scrollPane.setViewportView(this.listMozos);
		
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new BorderLayout(0, 0));
		
		this.panelBotonera = new JPanel();
		this.panelCentral.add(this.panelBotonera, BorderLayout.SOUTH);
		
		this.btnVerificar = new JButton("Verificar");
		this.panelBotonera.add(this.btnVerificar);
		
		this.btnListo = new JButton("Listo");
		this.panelBotonera.add(this.btnListo);
		
		this.scrollPane_1 = new JScrollPane();
		this.panelCentral.add(this.scrollPane_1, BorderLayout.CENTER);
		
		this.labelEstadisticas = new JLabel("Estadisticas");
		this.labelEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane_1.setColumnHeaderView(this.labelEstadisticas);
		
		this.textPane = new JTextPane();
		this.textPane.setEditable(false);
		this.scrollPane_1.setViewportView(this.textPane);
	}

}
