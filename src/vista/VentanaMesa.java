package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Mozo;
import modelo.Pedido;
import modelo.Producto;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class VentanaMesa extends JFrame implements MouseListener, KeyListener,IVistaMesa {

	private JPanel contentPane;
	private JLabel LabelTitulo;
	private JPanel panelPrincipal;
	private JScrollPane scrollPane;
	private JLabel LabelComanda;
	private JList listComanda;
	private JPanel panelDerecho;
	private JScrollPane scrollPane_1;
	private JPanel panelBotonera;
	private JList listProductos;
	private JPanel panelCantidad;
	private JLabel LabelCantidad;
	private JTextField textFieldCantidad;
	private JButton btnAgregar;
	private JPanel panelSacarModificar;
	private JButton btnSacar;
	private JButton btnModificar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panelFinal;
	private JButton btnListo;
	private JButton btnCerrarMesa;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_2;
	private DefaultListModel<Pedido> modeloListaComanda;
	private DefaultListModel<Producto> modeloListaProductos;
	private JPanel panelFormaPago;
	private JRadioButton rdbtnEfectivo;
	private JRadioButton rdbtnTarjeta;
	private JRadioButton rdbtnMercadoPago;
	private JRadioButton rdbtnCuentaDNI;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

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
		setBounds(100, 100, 600, 400);
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
		
		this.listComanda = new JList();
		this.listComanda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane.setViewportView(this.listComanda);
		this.modeloListaComanda=new DefaultListModel<Pedido>();
		this.listComanda.setModel(modeloListaComanda);
		
		this.panelDerecho = new JPanel();
		this.panelPrincipal.add(this.panelDerecho, BorderLayout.CENTER);
		this.panelDerecho.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.scrollPane_1 = new JScrollPane();
		this.panelDerecho.add(this.scrollPane_1);
		
		JLabel LabelProductos = new JLabel("Productos");
		LabelProductos.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane_1.setColumnHeaderView(LabelProductos);
		
		this.listProductos = new JList();
		//this.listProductos.addMouseListener(this);
		this.listProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane_1.setViewportView(this.listProductos);
		this.modeloListaProductos=new DefaultListModel<Producto>();
		this.listProductos.setModel(modeloListaProductos);
		
		this.panelBotonera = new JPanel();
		this.panelDerecho.add(this.panelBotonera);
		this.panelBotonera.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.panelCantidad = new JPanel();
		this.panelBotonera.add(this.panelCantidad);
		this.panelCantidad.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.LabelCantidad = new JLabel("Cantidad: ");
		this.panelCantidad.add(this.LabelCantidad);
		
		this.textFieldCantidad = new JTextField();
		this.textFieldCantidad.addKeyListener(this);
		this.panelCantidad.add(this.textFieldCantidad);
		this.textFieldCantidad.setColumns(10);
		
		this.panelSacarModificar = new JPanel();
		this.panelBotonera.add(this.panelSacarModificar);
		this.panelSacarModificar.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panel_2 = new JPanel();
		this.panelSacarModificar.add(this.panel_2);
		
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.setEnabled(false);
		this.panel_2.add(this.btnAgregar);
		
		this.panel = new JPanel();
		this.panelSacarModificar.add(this.panel);
		
		this.btnSacar = new JButton("Sacar");
		this.btnSacar.setEnabled(false);
		this.panel.add(this.btnSacar);
		
		this.panel_1 = new JPanel();
		this.panelSacarModificar.add(this.panel_1);
		
		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setEnabled(false);
		this.panel_1.add(this.btnModificar);
		
		this.panelFormaPago = new JPanel();
		this.panelBotonera.add(this.panelFormaPago);
		
		this.rdbtnEfectivo = new JRadioButton("Efectivo");
		this.rdbtnEfectivo.addMouseListener(this);
		buttonGroup.add(this.rdbtnEfectivo);
		this.panelFormaPago.add(this.rdbtnEfectivo);
		
		this.rdbtnTarjeta = new JRadioButton("Tarjeta");
		this.rdbtnTarjeta.addMouseListener(this);
		buttonGroup.add(this.rdbtnTarjeta);
		this.panelFormaPago.add(this.rdbtnTarjeta);
		
		this.rdbtnMercadoPago = new JRadioButton("Mercado Pago");
		this.rdbtnMercadoPago.addMouseListener(this);
		buttonGroup.add(this.rdbtnMercadoPago);
		this.panelFormaPago.add(this.rdbtnMercadoPago);
		
		this.rdbtnCuentaDNI = new JRadioButton("Cuenta DNI");
		this.rdbtnCuentaDNI.addMouseListener(this);
		buttonGroup.add(this.rdbtnCuentaDNI);
		this.panelFormaPago.add(this.rdbtnCuentaDNI);
		
		this.panelFinal = new JPanel();
		this.panelBotonera.add(this.panelFinal);
		this.panelFinal.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panelFinal.add(this.panel_3);
		
		this.btnListo = new JButton("Listo");
		this.panel_3.add(this.btnListo);
		
		this.panel_4 = new JPanel();
		this.panelFinal.add(this.panel_4);
		
		this.btnCerrarMesa = new JButton("Cerrar Mesa");
		this.btnCerrarMesa.addMouseListener(this);
		this.panel_4.add(this.btnCerrarMesa);
		
		actualizaBotones();
		
		this.listComanda.addMouseListener(this);
		this.listProductos.addMouseListener(this);
	
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if(!this.listProductos.isSelectionEmpty() && !this.textFieldCantidad.getText().isEmpty()) {
			this.btnAgregar.setEnabled(true);
			//this.btnSacar.setEnabled(true);
			this.btnModificar.setEnabled(true);
		}
		else {
			this.btnAgregar.setEnabled(false);
			//this.btnSacar.setEnabled(false);
			this.btnModificar.setEnabled(false);
		}
	}
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregar.addActionListener(listener);
		this.btnSacar.addActionListener(listener);
		this.btnModificar.addActionListener(listener);
		this.btnListo.addActionListener(listener);
		this.btnCerrarMesa.addActionListener(listener);
		
	}

	@Override
	public String getCantidad() {
		// TODO Auto-generated method stub
		return this.textFieldCantidad.getText();
	}

	@Override
	public void emergenteCantidadInvalida() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this,"Numero mal ingresado, ingrese un numero mayor a 0");
		
		
	}

	@Override
	public DefaultListModel<Pedido> getModeloListaComanda() {
		// TODO Auto-generated method stub
		return this.modeloListaComanda;
	}

	@Override
	public DefaultListModel<Producto> getModeloListaProductos() {
		// TODO Auto-generated method stub
		return this.modeloListaProductos;
	}

	@Override
	public void emergentePedidoNoSeleccionado() {
		JOptionPane.showMessageDialog(this,"No hay seleccionado pedido de la comanda");
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(!this.listProductos.isSelectionEmpty() && !this.textFieldCantidad.getText().isEmpty()) {
			this.btnAgregar.setEnabled(true);
			//this.btnSacar.setEnabled(true);
			this.btnModificar.setEnabled(true);
		}
		else {
			this.btnAgregar.setEnabled(false);
			//this.btnSacar.setEnabled(false);
			this.btnModificar.setEnabled(false);
		}
		if ((this.rdbtnCuentaDNI.isSelected() || this.rdbtnEfectivo.isSelected() || this.rdbtnMercadoPago.isSelected() 
				|| this.rdbtnTarjeta.isSelected()) && this.listComanda.getFirstVisibleIndex()!=-1)
			this.btnCerrarMesa.setEnabled(true);
		else
			this.btnCerrarMesa.setEnabled(false);
		if (!this.listComanda.isSelectionEmpty()) 
			this.btnSacar.setEnabled(true); 
		else
			this.btnSacar.setEnabled(false);
	}
	
	
	public void emergenteStockInsuficiente(int cant,int stock) {
		JOptionPane.showMessageDialog(this,"No hay suficiente de este producto. Pedido: "+cant+", Stock: "+stock);
	}

	@Override
	public JList<Producto> getListProductos() {
		// TODO Auto-generated method stub
		return this.listProductos;
	}
	
	@Override
	public void emergenteProductoNoSeleccionado() {
		JOptionPane.showMessageDialog(this,"No hay seleccionado un producto");
		
	}

	@Override
	public JList<Pedido> getListComanda() {
		// TODO Auto-generated method stub
		return this.listComanda;
	}

	@Override
	public void completarTitulo(int numeroMesa,String estado) {
		String titulo=null;
		titulo="Mesa N� "+numeroMesa+", estado: "+estado;
		this.LabelTitulo.setText(titulo);

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

	@Override
	public void actualizaBotones() {
		this.btnAgregar.setEnabled(false);
		this.btnCerrarMesa.setEnabled(false);
		this.btnListo.setEnabled(true);
		this.btnModificar.setEnabled(false);
		this.btnSacar.setEnabled(false);
		this.rdbtnCuentaDNI.setDisabledSelectedIcon(null);
		this.rdbtnEfectivo.setDisabledSelectedIcon(null);
		this.rdbtnMercadoPago.setDisabledSelectedIcon(null);
		this.rdbtnTarjeta.setDisabledSelectedIcon(null);
	}

	@Override
	public void actualizaCampos() {
		this.textFieldCantidad.setText("");
	}

	@Override
	public JRadioButton getFormaPago() {
		JRadioButton rb=null;
		if(this.rdbtnEfectivo.isSelected())
			rb=this.rdbtnEfectivo;
		else if(this.rdbtnTarjeta.isSelected())
			rb=this.rdbtnTarjeta;
		else if(this.rdbtnCuentaDNI.isSelected())
			rb=this.rdbtnCuentaDNI;
		else if(this.rdbtnMercadoPago.isSelected())
			rb=this.rdbtnMercadoPago;
		return rb;
	}

	@Override
	public void mostrarTotal(double total) {
		JOptionPane.showMessageDialog(this,"Se cerro la mesa, el total a pagares de: "+total);
	}
	
	
	
}
