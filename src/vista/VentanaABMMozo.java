package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VentanaABMMozo extends JFrame {

	private JPanel contentPane;
	private JLabel labelTitulo;
	private JPanel panelPrincipal;
	private JScrollPane scrollPane;
	private JLabel labelListaMozos;
	private JList list;
	private JPanel panelNombre;
	private JLabel labelNombre;
	private JTextField textFieldNombre;
	private JPanel panel;
	private JPanel panelApellido;
	private JLabel labelApellido;
	private JPanel panel_1;
	private JTextField textFieldApellido;
	private JPanel panelHijos;
	private JLabel labelHijos;
	private JPanel panel_2;
	private JTextField textFieldHijos;
	private JPanel panelFecha;
	private JLabel labelFecha;
	private JPanel panel_3;
	private JTextField textFieldFecha;
	private JPanel panelEstado;
	private JRadioButton rdbtnActivo;
	private JRadioButton rdbtnFranco;
	private JRadioButton rdbtnAusente;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelBotones;
	private JButton btnAgregar;
	private JButton btnSacar;
	private JButton btnModificar;
	private JButton btnListo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaABMMozo frame = new VentanaABMMozo();
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
	public VentanaABMMozo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.labelTitulo = new JLabel("ABM Mozo");
		this.labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(this.labelTitulo, BorderLayout.NORTH);
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(6, 0, 0, 0));
		
		this.panelNombre = new JPanel();
		this.panelPrincipal.add(this.panelNombre);
		this.panelNombre.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.labelNombre = new JLabel("Nombre: ");
		this.labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelNombre.add(this.labelNombre);
		
		this.panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panel.getLayout();
		flowLayout.setVgap(10);
		this.panelNombre.add(this.panel);
		
		this.textFieldNombre = new JTextField();
		this.panel.add(this.textFieldNombre);
		this.textFieldNombre.setColumns(10);
		
		this.panelApellido = new JPanel();
		this.panelPrincipal.add(this.panelApellido);
		this.panelApellido.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.labelApellido = new JLabel("Apellido: ");
		this.labelApellido.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelApellido.add(this.labelApellido);
		
		this.panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) this.panel_1.getLayout();
		flowLayout_1.setVgap(10);
		this.panelApellido.add(this.panel_1);
		
		this.textFieldApellido = new JTextField();
		this.textFieldApellido.setColumns(10);
		this.panel_1.add(this.textFieldApellido);
		
		this.panelHijos = new JPanel();
		this.panelPrincipal.add(this.panelHijos);
		this.panelHijos.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.labelHijos = new JLabel("Cantidad de Hijos: ");
		this.labelHijos.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelHijos.add(this.labelHijos);
		
		this.panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) this.panel_2.getLayout();
		flowLayout_2.setVgap(10);
		this.panelHijos.add(this.panel_2);
		
		this.textFieldHijos = new JTextField();
		this.textFieldHijos.setColumns(10);
		this.panel_2.add(this.textFieldHijos);
		
		this.panelFecha = new JPanel();
		this.panelPrincipal.add(this.panelFecha);
		this.panelFecha.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.labelFecha = new JLabel("Fecha de Nacimiento: ");
		this.labelFecha.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelFecha.add(this.labelFecha);
		
		this.panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) this.panel_3.getLayout();
		flowLayout_3.setVgap(10);
		this.panelFecha.add(this.panel_3);
		
		this.textFieldFecha = new JTextField();
		this.textFieldFecha.setColumns(10);
		this.panel_3.add(this.textFieldFecha);
		
		this.panelEstado = new JPanel();
		this.panelPrincipal.add(this.panelEstado);
		this.panelEstado.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.rdbtnActivo = new JRadioButton("Activo");
		buttonGroup.add(this.rdbtnActivo);
		this.rdbtnActivo.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelEstado.add(this.rdbtnActivo);
		
		this.rdbtnFranco = new JRadioButton("De Franco");
		buttonGroup.add(this.rdbtnFranco);
		this.rdbtnFranco.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelEstado.add(this.rdbtnFranco);
		
		this.rdbtnAusente = new JRadioButton("Ausente");
		buttonGroup.add(this.rdbtnAusente);
		this.rdbtnAusente.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelEstado.add(this.rdbtnAusente);
		
		this.panelBotones = new JPanel();
		this.panelPrincipal.add(this.panelBotones);
		this.panelBotones.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.btnAgregar = new JButton("Agregar");
		this.panelBotones.add(this.btnAgregar);
		
		this.btnSacar = new JButton("Sacar");
		this.panelBotones.add(this.btnSacar);
		
		this.btnModificar = new JButton("Modificar");
		this.panelBotones.add(this.btnModificar);
		
		this.btnListo = new JButton("Listo");
		this.panelBotones.add(this.btnListo);
		
		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane, BorderLayout.WEST);
		this.scrollPane.setPreferredSize(new Dimension(150,50));
		
		this.labelListaMozos = new JLabel("Mozos");
		this.labelListaMozos.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane.setColumnHeaderView(this.labelListaMozos);
		
		this.list = new JList();
		this.scrollPane.setViewportView(this.list);
	}

}