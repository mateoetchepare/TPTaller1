package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Producto;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class VentanaProducto extends JFrame implements MouseListener, KeyListener{

	private JPanel contentPane;
	private JPanel panelProducto;
	private JLabel labelProducto;
	private JPanel panelProductoPrincipal;
	private JScrollPane scrollPane;
	private JList listProductos;
	private JLabel labelListProductos;
	private JPanel panelDatosProducto;
	private JPanel panelNombre;
	private JLabel labelNombreProducto;
	private JTextField textFieldNombreProducto;
	private JPanel panelPrecio;
	private JLabel labelPrecioCompra;
	private JTextField textFieldPrecioCompra;
	private JLabel labelID;
	private JTextField textFieldID;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panelPrecio2;
	private JLabel labelPrecioVenta;
	private JTextField textFieldPrecioVenta;
	private JPanel panel_3;
	private JPanel panelBotoneraProductos;
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
					VentanaProducto frame = new VentanaProducto();
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
	public VentanaProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 320);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelProducto = new JPanel();
		this.contentPane.add(this.panelProducto);
		this.panelProducto.setLayout(new BorderLayout(0, 0));
		
		this.labelProducto = new JLabel("Productos");
		this.labelProducto.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelProducto.add(this.labelProducto, BorderLayout.NORTH);
		
		this.panelProductoPrincipal = new JPanel();
		this.panelProducto.add(this.panelProductoPrincipal, BorderLayout.CENTER);
		this.panelProductoPrincipal.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panelProductoPrincipal.add(this.scrollPane, BorderLayout.WEST);
		this.scrollPane.setPreferredSize(new Dimension(150,50));
		
		this.listProductos = new JList();
		this.scrollPane.setViewportView(this.listProductos);
		
		this.labelListProductos = new JLabel("Productos");
		this.labelListProductos.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane.setColumnHeaderView(this.labelListProductos);
		
		this.panelDatosProducto = new JPanel();
		this.panelProductoPrincipal.add(this.panelDatosProducto, BorderLayout.CENTER);
		this.panelDatosProducto.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.panelNombre = new JPanel();
		this.panelDatosProducto.add(this.panelNombre);
		this.panelNombre.setLayout(new GridLayout(0, 4, 0, 0));
		
		this.labelNombreProducto = new JLabel("Nombre: ");
		this.labelNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelNombre.add(this.labelNombreProducto);
		
		this.panel = new JPanel();
		this.panelNombre.add(this.panel);
		
		this.textFieldNombreProducto = new JTextField();
		this.panel.add(this.textFieldNombreProducto);
		this.textFieldNombreProducto.setColumns(10);
		
		this.labelID = new JLabel("ID: ");
		this.labelID.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelNombre.add(this.labelID);
		
		this.panel_1 = new JPanel();
		this.panelNombre.add(this.panel_1);
		
		this.textFieldID = new JTextField();
		this.panel_1.add(this.textFieldID);
		this.textFieldID.setColumns(10);
		
		this.panelPrecio = new JPanel();
		this.panelDatosProducto.add(this.panelPrecio);
		this.panelPrecio.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.labelPrecioCompra = new JLabel("Precio de Compra:");
		this.labelPrecioCompra.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelPrecio.add(this.labelPrecioCompra);
		
		this.panel_2 = new JPanel();
		this.panelPrecio.add(this.panel_2);
		
		this.textFieldPrecioCompra = new JTextField();
		this.panel_2.add(this.textFieldPrecioCompra);
		this.textFieldPrecioCompra.setColumns(10);
		
		this.panelPrecio2 = new JPanel();
		this.panelDatosProducto.add(this.panelPrecio2);
		this.panelPrecio2.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.labelPrecioVenta = new JLabel("Precio de Venta: ");
		this.labelPrecioVenta.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelPrecio2.add(this.labelPrecioVenta);
		
		this.panel_3 = new JPanel();
		this.panelPrecio2.add(this.panel_3);
		
		this.textFieldPrecioVenta = new JTextField();
		this.panel_3.add(this.textFieldPrecioVenta);
		this.textFieldPrecioVenta.setColumns(10);
		
		this.panelBotoneraProductos = new JPanel();
		this.panelDatosProducto.add(this.panelBotoneraProductos);
		this.panelBotoneraProductos.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.btnAgregar = new JButton("Agregar");
		this.panelBotoneraProductos.add(this.btnAgregar);
		
		this.btnSacar = new JButton("Sacar");
		this.panelBotoneraProductos.add(this.btnSacar);
		
		this.btnModificar = new JButton("Modificar");
		this.panelBotoneraProductos.add(this.btnModificar);
		
		
		this.textFieldID.addKeyListener(this);
		this.textFieldNombreProducto.addKeyListener(this);
		this.textFieldPrecioCompra.addKeyListener(this);
		this.textFieldPrecioVenta.addKeyListener(this);
		
		this.btnAgregar.setEnabled(false);
		this.btnModificar.setEnabled(false);
		this.btnSacar.setEnabled(false);
		
		this.btnListo = new JButton("Listo");
		this.contentPane.add(this.btnListo, BorderLayout.SOUTH);
		
		this.listProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listProductos.addMouseListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!this.textFieldID.getText().isEmpty() && !this.textFieldNombreProducto.getText().isEmpty() && 
				!this.textFieldPrecioCompra.getText().isEmpty() && !this.textFieldPrecioVenta.getText().isEmpty()) {
			this.btnAgregar.setEnabled(true);
		}
		else
			this.btnAgregar.setEnabled(false);
		if (!this.listProductos.isSelectionEmpty() && (!this.textFieldID.getText().isEmpty() || !this.textFieldNombreProducto.getText().isEmpty() 
				|| !this.textFieldPrecioCompra.getText().isEmpty() || !this.textFieldPrecioVenta.getText().isEmpty())) {
			this.btnModificar.setEnabled(true);
		} else
			this.btnModificar.setEnabled(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!this.listProductos.isSelectionEmpty()) {
			this.btnSacar.setEnabled(true);
		} else
			this.btnSacar.setEnabled(false);
		if (!this.listProductos.isSelectionEmpty() && (!this.textFieldID.getText().isEmpty() || !this.textFieldNombreProducto.getText().isEmpty() 
				|| !this.textFieldPrecioCompra.getText().isEmpty() || !this.textFieldPrecioVenta.getText().isEmpty())) {
			this.btnModificar.setEnabled(true);
		} else
			this.btnModificar.setEnabled(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public String getTextFieldNombreProducto() {
		return textFieldNombreProducto.getText();
	}

	public String getTextFieldPrecioCompra() {
		return textFieldPrecioCompra.getText();
	}

	public String getTextFieldID() {
		return textFieldID.getText();
	}

	public String getTextFieldPrecioVenta() {
		return textFieldPrecioVenta.getText();
	}
	
	public Producto getProducto() {
		return (Producto) this.listProductos.getSelectedValue();
	}

}
