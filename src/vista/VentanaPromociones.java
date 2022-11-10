package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class VentanaPromociones extends JFrame {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JPanel panelListas;
	private JPanel panelDatos;
	private JLabel labelTitulo;
	private JScrollPane scrollPaneProductos;
	private JScrollPane scrollPanePromProd;
	private JScrollPane scrollPanePromTemp;
	private JLabel labelProductos;
	private JList listProductos;
	private JLabel labelPromProd;
	private JLabel lblNewLabel;
	private JList listPromProd;
	private JList listPromTemp;
	private JPanel panelDiasPromos;
	private JLabel labelDiasPromos;
	private JRadioButton rdrdbtnLunes;
	private JRadioButton rdbtnMartes;
	private JRadioButton rdbtnMiercoles;
	private JRadioButton rdbtnJueves;
	private JRadioButton rdbtnViernes;
	private JRadioButton rdbtnSabado;
	private JRadioButton rdbtnDomingo;
	private JButton btnAgregarDia;
	private JPanel panelDatos2;
	private JPanel panelProductos;
	private JPanel panelTemporales;
	private JPanel panelTipo;
	private JLabel labelTipoPromo;
	private JRadioButton rdbtnDosPorUno;
	private JRadioButton rdbtnPorCantidad;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelPorCantidad;
	private JLabel labelCantidadMinima;
	private JTextField textFieldCantidadMinima;
	private JLabel labelPrecioUnitario;
	private JTextField textFieldPrecioUnitario;
	private JPanel panelBotones;
	private JButton btnAgregar;
	private JButton btnActivar;
	private JButton btnDesactivar;
	private JPanel panelNombre;
	private JLabel labelNombre;
	private JTextField textFieldNombre;
	private JRadioButton rdbtnAcumulable;
	private JPanel panelFormaPago;
	private JRadioButton rdbtnEfectivo;
	private JRadioButton rdbtnTarjeta;
	private JRadioButton rdbtnCuentaDNI;
	private JRadioButton rdbtnMP;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnListo;
	private JPanel panelBotones2;
	private JButton btnAgregarTemp;
	private JButton btnActivarTemp;
	private JButton btnDesactivarTemp;
	private JLabel labelPromProductos;
	private JLabel labelPromTemporales;
	private JLabel labelDescuento;
	private JTextField textFieldDescuento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPromociones frame = new VentanaPromociones();
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
	public VentanaPromociones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panelListas = new JPanel();
		this.panelPrincipal.add(this.panelListas);
		this.panelListas.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.scrollPaneProductos = new JScrollPane();
		this.panelListas.add(this.scrollPaneProductos);
		
		this.labelProductos = new JLabel("PRODUCTOS");
		this.labelProductos.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPaneProductos.setColumnHeaderView(this.labelProductos);
		
		this.listProductos = new JList();
		this.scrollPaneProductos.setViewportView(this.listProductos);
		this.panelListas.setPreferredSize(new Dimension(50,50));
		
		this.scrollPanePromProd = new JScrollPane();
		this.panelListas.add(this.scrollPanePromProd);
		
		
		this.labelPromProd = new JLabel("PROMOCIONES P");
		this.labelPromProd.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPanePromProd.setColumnHeaderView(this.labelPromProd);
		
		this.listPromProd = new JList();
		this.scrollPanePromProd.setViewportView(this.listPromProd);
		
		this.scrollPanePromTemp = new JScrollPane();
		this.panelListas.add(this.scrollPanePromTemp);
		
		this.lblNewLabel = new JLabel("PROMOCIONES T");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPanePromTemp.setColumnHeaderView(this.lblNewLabel);
		
		
		this.listPromTemp = new JList();
		this.scrollPanePromTemp.setViewportView(this.listPromTemp);
		
		this.panelDatos = new JPanel();
		this.panelPrincipal.add(this.panelDatos);
		this.panelDatos.setLayout(new BorderLayout(0, 0));
		
		this.panelDiasPromos = new JPanel();
		this.panelDatos.add(this.panelDiasPromos, BorderLayout.NORTH);
		
		this.labelDiasPromos = new JLabel("Dias de Promo:");
		this.panelDiasPromos.add(this.labelDiasPromos);
		
		this.rdrdbtnLunes = new JRadioButton("Lunes");
		this.panelDiasPromos.add(this.rdrdbtnLunes);
		
		this.rdbtnMartes = new JRadioButton("Martes");
		this.panelDiasPromos.add(this.rdbtnMartes);
		
		this.rdbtnMiercoles = new JRadioButton("Miercoles");
		this.panelDiasPromos.add(this.rdbtnMiercoles);
		
		this.rdbtnJueves = new JRadioButton("Jueves");
		this.panelDiasPromos.add(this.rdbtnJueves);
		
		this.rdbtnViernes = new JRadioButton("Viernes");
		this.panelDiasPromos.add(this.rdbtnViernes);
		
		this.rdbtnSabado = new JRadioButton("Sabado");
		this.panelDiasPromos.add(this.rdbtnSabado);
		
		this.rdbtnDomingo = new JRadioButton("Domingo");
		this.panelDiasPromos.add(this.rdbtnDomingo);
		
		this.btnAgregarDia = new JButton("Agregar dias");
		this.panelDiasPromos.add(this.btnAgregarDia);
		
		this.panelDatos2 = new JPanel();
		this.panelDatos.add(this.panelDatos2, BorderLayout.CENTER);
		this.panelDatos2.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelProductos = new JPanel();
		this.panelDatos2.add(this.panelProductos);
		this.panelProductos.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.labelPromProductos = new JLabel("PROMOCIONES PRODUCTOS");
		this.panelProductos.add(this.labelPromProductos);
		
		this.panelTipo = new JPanel();
		this.panelProductos.add(this.panelTipo);
		
		this.labelTipoPromo = new JLabel("Promo tipo: ");
		this.panelTipo.add(this.labelTipoPromo);
		
		this.rdbtnDosPorUno = new JRadioButton("2x1");
		buttonGroup.add(this.rdbtnDosPorUno);
		this.panelTipo.add(this.rdbtnDosPorUno);
		
		this.rdbtnPorCantidad = new JRadioButton("Por cantidad");
		buttonGroup.add(this.rdbtnPorCantidad);
		this.panelTipo.add(this.rdbtnPorCantidad);
		
		this.panelPorCantidad = new JPanel();
		this.panelProductos.add(this.panelPorCantidad);
		
		this.labelCantidadMinima = new JLabel("Cantidad Minima:");
		this.panelPorCantidad.add(this.labelCantidadMinima);
		
		this.textFieldCantidadMinima = new JTextField();
		this.panelPorCantidad.add(this.textFieldCantidadMinima);
		this.textFieldCantidadMinima.setColumns(10);
		
		this.labelPrecioUnitario = new JLabel("Precio:");
		this.panelPorCantidad.add(this.labelPrecioUnitario);
		
		this.textFieldPrecioUnitario = new JTextField();
		this.panelPorCantidad.add(this.textFieldPrecioUnitario);
		this.textFieldPrecioUnitario.setColumns(10);
		
		this.panelBotones = new JPanel();
		this.panelProductos.add(this.panelBotones);
		
		this.btnAgregar = new JButton("Agregar");
		this.panelBotones.add(this.btnAgregar);
		
		this.btnActivar = new JButton("Activar");
		this.panelBotones.add(this.btnActivar);
		
		this.btnDesactivar = new JButton("Desactivar");
		this.panelBotones.add(this.btnDesactivar);
		
		this.panelTemporales = new JPanel();
		this.panelDatos2.add(this.panelTemporales);
		this.panelTemporales.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.labelPromTemporales = new JLabel("PROMOCIONES TEMPORALES");
		this.panelTemporales.add(this.labelPromTemporales);
		
		this.panelNombre = new JPanel();
		this.panelTemporales.add(this.panelNombre);
		
		this.labelNombre = new JLabel("Nombre:");
		this.panelNombre.add(this.labelNombre);
		
		this.textFieldNombre = new JTextField();
		this.panelNombre.add(this.textFieldNombre);
		this.textFieldNombre.setColumns(10);
		
		this.rdbtnAcumulable = new JRadioButton("Acumulable");
		this.panelNombre.add(this.rdbtnAcumulable);
		
		this.labelDescuento = new JLabel("Descuento:");
		this.panelNombre.add(this.labelDescuento);
		
		this.textFieldDescuento = new JTextField();
		this.panelNombre.add(this.textFieldDescuento);
		this.textFieldDescuento.setColumns(10);
		
		this.panelFormaPago = new JPanel();
		this.panelTemporales.add(this.panelFormaPago);
		
		this.rdbtnEfectivo = new JRadioButton("Efectivo");
		buttonGroup_1.add(this.rdbtnEfectivo);
		this.panelFormaPago.add(this.rdbtnEfectivo);
		
		this.rdbtnTarjeta = new JRadioButton("Tarjeta");
		buttonGroup_1.add(this.rdbtnTarjeta);
		this.panelFormaPago.add(this.rdbtnTarjeta);
		
		this.rdbtnCuentaDNI = new JRadioButton("Cuenta DNI");
		buttonGroup_1.add(this.rdbtnCuentaDNI);
		this.panelFormaPago.add(this.rdbtnCuentaDNI);
		
		this.rdbtnMP = new JRadioButton("Mercado Pago");
		buttonGroup_1.add(this.rdbtnMP);
		this.panelFormaPago.add(this.rdbtnMP);
		
		this.panelBotones2 = new JPanel();
		this.panelTemporales.add(this.panelBotones2);
		
		this.btnAgregarTemp = new JButton("Agregar");
		this.panelBotones2.add(this.btnAgregarTemp);
		
		this.btnActivarTemp = new JButton("Activar");
		this.panelBotones2.add(this.btnActivarTemp);
		
		this.btnDesactivarTemp = new JButton("Desactivar");
		this.panelBotones2.add(this.btnDesactivarTemp);
		
		this.labelTitulo = new JLabel("Promociones");
		this.labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(this.labelTitulo, BorderLayout.NORTH);
		
		this.btnListo = new JButton("Listo");
		this.contentPane.add(this.btnListo, BorderLayout.SOUTH);
		
	}
	
	
	public void actualizaBotones() {
		this.btnAgregarDia.setEnabled(false);
		this.btnActivar.setEnabled(false);
		this.btnAgregar.setEnabled(false);
		this.btnActivarTemp.setEnabled(false);
		this.btnDesactivar.setEnabled(false);
		this.btnDesactivarTemp.setEnabled(false);
	}
}
