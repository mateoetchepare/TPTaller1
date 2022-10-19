package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaOperario extends JFrame implements IVistaOperario{

	private JPanel contentPane;
	private JLabel LabelPrincipal;
	private JPanel panelPrincipal;
	private JPanel panelIz;
	private JPanel panelCentral;
	private JPanel panelDer;
	private JScrollPane scrollPane;
	private JList listMesas;
	private JLabel LabelMesas;
	private JPanel panelBotonesMesas;
	private JScrollPane scrollPane_1;
	private JList listMozos;
	private JLabel lblNewLabel;
	private JPanel panelBotonesMozos;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnHabilitar;
	private JButton btnDeshabilitar;
	private JButton btnVerMesa;
	private JButton btnAsignarMozo;
	private JButton btnProductosPromociones;
	private JButton btnAgregarOperario;
	private JButton btnCerrarSecion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOperario frame = new VentanaOperario();
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
	public VentanaOperario() {
		setTitle("Sistema Restaurante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.LabelPrincipal = new JLabel("Vista operario");
		this.contentPane.add(this.LabelPrincipal, BorderLayout.NORTH);
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panelIz = new JPanel();
		this.panelPrincipal.add(this.panelIz);
		this.panelIz.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane_1 = new JScrollPane();
		this.panelIz.add(this.scrollPane_1, BorderLayout.CENTER);
		
		this.listMozos = new JList();
		this.listMozos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane_1.setViewportView(this.listMozos);
		
		this.lblNewLabel = new JLabel("Lista Mozos");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane_1.setColumnHeaderView(this.lblNewLabel);
		
		this.panelBotonesMozos = new JPanel();
		this.panelIz.add(this.panelBotonesMozos, BorderLayout.SOUTH);
		
		this.panelCentral = new JPanel();
		this.panelPrincipal.add(this.panelCentral);
		this.panelCentral.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.btnAsignarMozo = new JButton("Asignar");
		this.btnAsignarMozo.setEnabled(false);
		this.panelCentral.add(this.btnAsignarMozo);
		
		this.btnProductosPromociones = new JButton("Productos/ Promociones");
		this.panelCentral.add(this.btnProductosPromociones);
		
		this.btnAgregarOperario = new JButton("Agregar Operario");
		this.panelCentral.add(this.btnAgregarOperario);
		
		this.btnCerrarSecion = new JButton("Cerrar Secion");
		this.panelCentral.add(this.btnCerrarSecion);
		
		this.panelDer = new JPanel();
		this.panelPrincipal.add(this.panelDer);
		this.panelDer.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panelDer.add(this.scrollPane, BorderLayout.CENTER);
		
		this.listMesas = new JList();
		this.listMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane.setViewportView(this.listMesas);
		
		this.LabelMesas = new JLabel("Lista Mesas");
		this.LabelMesas.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane.setColumnHeaderView(this.LabelMesas);
		
		this.panelBotonesMesas = new JPanel();
		this.panelDer.add(this.panelBotonesMesas, BorderLayout.SOUTH);
		
		this.panelBotonesMozos.setPreferredSize(new Dimension(70,70));
		this.panelBotonesMozos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.btnEliminar = new JButton("Eliminar");
		this.panelBotonesMozos.add(this.btnEliminar);
		
		this.btnAgregar = new JButton("Agregar");
		this.panelBotonesMozos.add(this.btnAgregar);
		
		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setEnabled(false);
		this.panelBotonesMozos.add(this.btnModificar);
		this.panelBotonesMesas.setPreferredSize(new Dimension(70,70));
		this.panelBotonesMesas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.btnHabilitar = new JButton("Habilitar");
		this.btnHabilitar.setEnabled(false);
		this.panelBotonesMesas.add(this.btnHabilitar);
		
		this.btnDeshabilitar = new JButton("Deshabilitar");
		this.btnDeshabilitar.setEnabled(false);
		this.panelBotonesMesas.add(this.btnDeshabilitar);
		
		this.btnVerMesa = new JButton("Ver Mesa");
		this.btnVerMesa.setEnabled(false);
		this.panelBotonesMesas.add(this.btnVerMesa);
	}
	
	public void completarTitulo(String nombre) {
		String titulo=this.LabelPrincipal.getText();
		titulo+= "                 "+nombre.toUpperCase();
		this.LabelPrincipal.setText(titulo);
	}
	
	public void addActionListener(ActionListener listener) {
		//agregar todos los botones
		this.btnAgregar.addActionListener(listener);
		
	}

}
