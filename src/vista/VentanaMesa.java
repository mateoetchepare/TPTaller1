package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public class VentanaMesa extends JFrame {

	private JPanel contentPane;
	private JLabel LabelTitulo;
	private JPanel panelPrincipal;
	private JScrollPane scrollPane;
	private JLabel LabelComanda;
	private JList list;
	private JPanel panelBotonera;
	private JPanel panelPedido;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel;
	private JTextField textFieldCantidad;
	private JButton btnAgregar;
	private JButton btnSacar;
	private JButton btnModificar;
	private JButton btnCerrarMesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMesa frame = new VentanaMesa();
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
	public VentanaMesa() {
		setTitle("Sistema Restaurante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.LabelTitulo = new JLabel("Mesa numero estado mozo");
		this.contentPane.add(this.LabelTitulo, BorderLayout.NORTH);
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panelPrincipal.add(this.scrollPane, BorderLayout.WEST);
		this.scrollPane.setPreferredSize(new Dimension(150,150));
		
		this.LabelComanda = new JLabel("Comanda");
		this.LabelComanda.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane.setColumnHeaderView(this.LabelComanda);
		
		this.list = new JList();
		this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane.setViewportView(this.list);
		
		this.panelBotonera = new JPanel();
		this.panelPrincipal.add(this.panelBotonera, BorderLayout.CENTER);
		this.panelBotonera.setLayout(new GridLayout(6, 0, 0, 0));
		
		this.panelPedido = new JPanel();
		this.panelBotonera.add(this.panelPedido);
		this.panelPedido.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.lblNewLabel = new JLabel("Producto");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelPedido.add(this.lblNewLabel);
		
		this.textFieldCantidad = new JTextField();
		this.panelPedido.add(this.textFieldCantidad);
		this.textFieldCantidad.setColumns(10);
		
		this.panel_1 = new JPanel();
		this.panelBotonera.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.btnAgregar = new JButton("Agregar");
		this.panel_1.add(this.btnAgregar);
		
		this.btnSacar = new JButton("Sacar");
		this.panel_1.add(this.btnSacar);
		
		this.panel_2 = new JPanel();
		this.panelBotonera.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.btnModificar = new JButton("Modificar");
		this.panel_2.add(this.btnModificar);
		
		this.btnCerrarMesa = new JButton("Cerrar Mesa");
		this.panel_2.add(this.btnCerrarMesa);
		
		this.panel_3 = new JPanel();
		this.panelBotonera.add(this.panel_3);
		
		this.panel_4 = new JPanel();
		this.panelBotonera.add(this.panel_4);
		
		this.panel_5 = new JPanel();
		this.panelBotonera.add(this.panel_5);
	}

}
