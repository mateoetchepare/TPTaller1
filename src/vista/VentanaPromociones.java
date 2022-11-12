package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemp;

public class VentanaPromociones extends JFrame implements KeyListener, MouseListener,IVistaPromocion {

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
	private DefaultListModel<Producto> modeloListaProductos;
	private DefaultListModel<PromocionProd> modeloListaPromProd;
	private DefaultListModel<PromocionTemp> modeloListaPromTemp;

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
		setBounds(100, 100, 950, 450);
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
		
		
		this.labelPromProd = new JLabel("PROMOCIONES POR PRODUCTO");
		this.labelPromProd.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPanePromProd.setColumnHeaderView(this.labelPromProd);
		
		this.listPromProd = new JList();
		this.scrollPanePromProd.setViewportView(this.listPromProd);
		
		this.scrollPanePromTemp = new JScrollPane();
		this.panelListas.add(this.scrollPanePromTemp);
		
		this.lblNewLabel = new JLabel("PROMOCIONES TEMPORALES");
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
		this.rdrdbtnLunes.addMouseListener(this);
		this.panelDiasPromos.add(this.rdrdbtnLunes);
		
		this.rdbtnMartes = new JRadioButton("Martes");
		this.rdbtnMartes.addMouseListener(this);
		this.panelDiasPromos.add(this.rdbtnMartes);
		
		this.rdbtnMiercoles = new JRadioButton("Miercoles");
		this.rdbtnMiercoles.addMouseListener(this);
		this.panelDiasPromos.add(this.rdbtnMiercoles);
		
		this.rdbtnJueves = new JRadioButton("Jueves");
		this.rdbtnJueves.addMouseListener(this);
		this.panelDiasPromos.add(this.rdbtnJueves);
		
		this.rdbtnViernes = new JRadioButton("Viernes");
		this.rdbtnViernes.addMouseListener(this);
		this.panelDiasPromos.add(this.rdbtnViernes);
		
		this.rdbtnSabado = new JRadioButton("Sabado");
		this.rdbtnSabado.addMouseListener(this);
		this.panelDiasPromos.add(this.rdbtnSabado);
		
		this.rdbtnDomingo = new JRadioButton("Domingo");
		this.rdbtnDomingo.addMouseListener(this);
		this.panelDiasPromos.add(this.rdbtnDomingo);
		
		this.btnAgregarDia = new JButton("Agregar dias");
		this.panelDiasPromos.add(this.btnAgregarDia);
		
		this.panelDatos2 = new JPanel();
		this.panelDatos.add(this.panelDatos2, BorderLayout.CENTER);
		this.panelDatos2.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelProductos = new JPanel();
		this.panelDatos2.add(this.panelProductos);
		this.panelProductos.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.labelPromProductos = new JLabel("PROMOCIONES POR PRODUCTOS:");
		this.panelProductos.add(this.labelPromProductos);
		
		this.panelTipo = new JPanel();
		this.panelProductos.add(this.panelTipo);
		
		this.labelTipoPromo = new JLabel("Promo tipo: ");
		this.panelTipo.add(this.labelTipoPromo);
		
		this.rdbtnDosPorUno = new JRadioButton("2x1");
		this.rdbtnDosPorUno.addMouseListener(this);
		buttonGroup.add(this.rdbtnDosPorUno);
		this.panelTipo.add(this.rdbtnDosPorUno);
		
		this.rdbtnPorCantidad = new JRadioButton("Por cantidad");
		this.rdbtnPorCantidad.addMouseListener(this);
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
		
		this.labelPromTemporales = new JLabel("PROMOCIONES TEMPORALES:");
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
		this.rdbtnEfectivo.addMouseListener(this);
		buttonGroup_1.add(this.rdbtnEfectivo);
		this.panelFormaPago.add(this.rdbtnEfectivo);
		
		this.rdbtnTarjeta = new JRadioButton("Tarjeta");
		this.rdbtnTarjeta.addMouseListener(this);
		buttonGroup_1.add(this.rdbtnTarjeta);
		this.panelFormaPago.add(this.rdbtnTarjeta);
		
		this.rdbtnCuentaDNI = new JRadioButton("Cuenta DNI");
		this.rdbtnCuentaDNI.addMouseListener(this);
		buttonGroup_1.add(this.rdbtnCuentaDNI);
		this.panelFormaPago.add(this.rdbtnCuentaDNI);
		
		this.rdbtnMP = new JRadioButton("Mercado Pago");
		this.rdbtnMP.addMouseListener(this);
		buttonGroup_1.add(this.rdbtnMP);
		this.panelFormaPago.add(this.rdbtnMP);
		
		this.panelBotones2 = new JPanel();
		this.panelTemporales.add(this.panelBotones2);
		
		this.btnAgregarTemp = new JButton("Agregar1");
		this.panelBotones2.add(this.btnAgregarTemp);
		
		this.btnActivarTemp = new JButton("Activar1");
		this.panelBotones2.add(this.btnActivarTemp);
		
		this.btnDesactivarTemp = new JButton("Desactivar1");
		this.panelBotones2.add(this.btnDesactivarTemp);
		
		this.labelTitulo = new JLabel("Promociones");
		this.labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(this.labelTitulo, BorderLayout.NORTH);
		
		this.btnListo = new JButton("Listo");
		this.contentPane.add(this.btnListo, BorderLayout.SOUTH);
		
		this.textFieldCantidadMinima.addKeyListener(this);
		this.textFieldDescuento.addKeyListener(this);
		this.textFieldNombre.addKeyListener(this);
		this.textFieldPrecioUnitario.addKeyListener(this);
		
		this.listProductos.addMouseListener(this);
		this.listProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listPromProd.addMouseListener(this);
		this.listPromProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listPromTemp.addMouseListener(this);
		this.listPromTemp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		actualizaBotones();
		actualizaCampos();
		
		this.modeloListaProductos=new DefaultListModel<Producto>();
		this.listProductos.setModel(modeloListaProductos);
		
		this.modeloListaPromProd=new DefaultListModel<PromocionProd>();
		this.listPromProd.setModel(modeloListaPromProd);
		
		this.modeloListaPromTemp=new DefaultListModel<PromocionTemp>();
		this.listPromTemp.setModel(modeloListaPromTemp);
		
	}
	
	public void actualizaCampos() {
		this.textFieldCantidadMinima.setText("");
		this.textFieldDescuento.setText("");
		this.textFieldNombre.setText("");
		this.textFieldPrecioUnitario.setText("");
	}
	
	
	public void actualizaBotones() {
		this.btnAgregarTemp.setEnabled(false);
		this.btnAgregarDia.setEnabled(false);
		this.btnActivar.setEnabled(false);
		this.btnAgregar.setEnabled(false);
		this.btnActivarTemp.setEnabled(false);
		this.btnDesactivar.setEnabled(false);
		this.btnDesactivarTemp.setEnabled(false);
		this.rdbtnAcumulable.setDisabledSelectedIcon(null);
		this.rdbtnCuentaDNI.setDisabledSelectedIcon(null);
		this.rdbtnDomingo.setDisabledSelectedIcon(null);
		this.rdbtnDosPorUno.setDisabledSelectedIcon(null);
		this.rdbtnEfectivo.setDisabledSelectedIcon(null);
		this.rdbtnJueves.setDisabledSelectedIcon(null);
		this.rdbtnMartes.setDisabledSelectedIcon(null);
		this.rdbtnMiercoles.setDisabledSelectedIcon(null);
		this.rdbtnMP.setDisabledSelectedIcon(null);
		this.rdbtnPorCantidad.setDisabledSelectedIcon(null);
		this.rdbtnSabado.setDisabledSelectedIcon(null);
		this.rdbtnTarjeta.setDisabledSelectedIcon(null);
		this.rdbtnViernes.setDisabledSelectedIcon(null);
		this.rdrdbtnLunes.setDisabledSelectedIcon(null);
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
		if (!this.textFieldCantidadMinima.getText().isEmpty() && 
				!this.textFieldPrecioUnitario.getText().isEmpty() && (this.rdbtnDosPorUno.isSelected() || 
						!this.rdbtnPorCantidad.isSelected())) {
			this.btnAgregar.setEnabled(true);
		}
		else {
			this.btnAgregar.setEnabled(false);
		}
		if (!this.textFieldNombre.getText().isEmpty() && (this.rdbtnCuentaDNI.isSelected() || this.rdbtnEfectivo.isSelected() ||
				this.rdbtnMP.isSelected() || this.rdbtnTarjeta.isSelected())) {
			this.btnAgregarTemp.setEnabled(true);
		} 
		else {
			this.btnAgregarTemp.setEnabled(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!this.listPromProd.isSelectionEmpty()) {
			this.btnDesactivar.setEnabled(true);
			this.btnActivar.setEnabled(true);
		}
		else {
			this.btnDesactivar.setEnabled(false);
			this.btnActivar.setEnabled(false);
		}
		if (!this.listPromTemp.isSelectionEmpty()) {
			this.btnDesactivarTemp.setEnabled(true);
			this.btnActivarTemp.setEnabled(true);
		}
		else {
			this.btnDesactivarTemp.setEnabled(false);
			this.btnActivarTemp.setEnabled(false);
		}
		
		if ((!this.textFieldCantidadMinima.getText().isEmpty() && 
				!this.textFieldPrecioUnitario.getText().isEmpty() && this.rdbtnPorCantidad.isSelected())|| 
				this.rdbtnDosPorUno.isSelected()) {
			this.btnAgregar.setEnabled(true);
		}
		else {
			this.btnAgregar.setEnabled(false);
		}
		if (!this.textFieldNombre.getText().isEmpty() && (this.rdbtnCuentaDNI.isSelected() || this.rdbtnEfectivo.isSelected() ||
				this.rdbtnMP.isSelected() || this.rdbtnTarjeta.isSelected())) {
			this.btnAgregarTemp.setEnabled(true);
		} 
		else {
			this.btnAgregarTemp.setEnabled(false);
		}
		
		if (this.rdbtnDomingo.isSelected() || this.rdrdbtnLunes.isSelected() ||
				this.rdbtnMartes.isSelected() || this.rdbtnMiercoles.isSelected() || this.rdbtnJueves.isSelected() ||
				this.rdbtnViernes.isSelected() || this.rdbtnSabado.isSelected() && (!this.listPromProd.isSelectionEmpty() ||
						!this.listPromTemp.isSelectionEmpty())) {
			this.btnAgregarDia.setEnabled(true);
		} 
		else
			this.btnAgregarDia.setEnabled(false);
			
	}
	
	/*
	(this.rdbtnDomingo.isSelected() || this.rdrdbtnLunes.isSelected() ||
						this.rdbtnMartes.isSelected() || this.rdbtnMiercoles.isSelected() || this.rdbtnJueves.isSelected() ||
						this.rdbtnViernes.isSelected() || this.rdbtnSabado.isSelected())
	 */
	 

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
	public void addActionListener(ActionListener listener) {
		this.btnAgregarTemp.addActionListener(listener);
		this.btnAgregarDia.addActionListener(listener);
		this.btnActivar.addActionListener(listener);
		this.btnAgregar.addActionListener(listener);
		this.btnActivarTemp.addActionListener(listener);
		this.btnDesactivar.addActionListener(listener);
		this.btnDesactivarTemp.addActionListener(listener);
		this.btnListo.addActionListener(listener);
	}

	@Override
	public DefaultListModel<Producto> getModeloListaProductos() {
		// TODO Auto-generated method stub
		return this.modeloListaProductos;
	}

	@Override
	public DefaultListModel<PromocionProd> getModeloListaPromProd() {
		// TODO Auto-generated method stub
		return this.modeloListaPromProd;
	}

	@Override
	public DefaultListModel<PromocionTemp> getModeloListaPromTemp() {
		// TODO Auto-generated method stub
		return this.modeloListaPromTemp;
	}

	@Override
	public JList<Producto> getListProductos() {
		// TODO Auto-generated method stub
		return this.listProductos;
	}

	@Override
	public JList<PromocionProd> getListPromProd() {
		// TODO Auto-generated method stub
		return this.listPromProd;
	}

	@Override
	public JList<PromocionTemp> getListPromTemp() {
		// TODO Auto-generated method stub
		return this.listPromTemp;
	}

	@Override
	public ArrayList<JRadioButton> getDias() {
		ArrayList<JRadioButton> dias=new ArrayList<JRadioButton>();
		if(this.rdrdbtnLunes.isSelected())
			dias.add(this.rdrdbtnLunes);
		if(this.rdbtnMartes.isSelected())
			dias.add(this.rdbtnMartes);
		if(this.rdbtnMiercoles.isSelected())
			dias.add(this.rdbtnMiercoles);
		if(this.rdbtnJueves.isSelected())
			dias.add(this.rdbtnJueves);
		if(this.rdbtnViernes.isSelected())
			dias.add(this.rdbtnViernes);
		if(this.rdbtnSabado.isSelected())
			dias.add(this.rdbtnSabado);
		if(this.rdbtnDomingo.isSelected())
			dias.add(this.rdbtnDomingo);
		
		return dias;
	}

	@Override
	public JRadioButton getTipo() {
		JRadioButton rb=null;
		if(this.rdbtnDosPorUno.isSelected())
			rb=this.rdbtnDosPorUno;
		else if(this.rdbtnPorCantidad.isSelected())
			rb=this.rdbtnPorCantidad;
		
		return rb;
	}

	@Override
	public String getCantidadMin() {
		// TODO Auto-generated method stub
		return this.textFieldCantidadMinima.getText();
	}

	@Override
	public String getPrecioUnitario() {
		// TODO Auto-generated method stub
		return this.textFieldPrecioUnitario.getText();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.textFieldNombre.getText();
	}

	@Override
	public JRadioButton getAcumulable() {
		if(this.rdbtnAcumulable.isSelected())
			return this.rdbtnAcumulable;
		else
			return null;
	}

	@Override
	public String getDescuento() {
		// TODO Auto-generated method stub
		return this.textFieldDescuento.getText();
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
		else if(this.rdbtnMP.isSelected())
			rb=this.rdbtnMP;
		
		return rb;
	}

	@Override
	public void emergenteNoHaySeleccionPromocion() {
		JOptionPane.showMessageDialog(this,"Seleccione una promocion para agregarle los dias");
	}

	@Override
	public void emergenteNoHayDiasSeleccionados() {
		JOptionPane.showMessageDialog(this,"Seleccione los dias a agregar");
	}

	@Override
	public void emergenteNoTieneTipo() {
		JOptionPane.showMessageDialog(this,"La promo tiene ue tener un tipo");
	}

	@Override
	public void emergenteNoEsNumero() {
		JOptionPane.showMessageDialog(this,"Numero mal ingresado, ingrese un numero entero");
	}

	@Override
	public void emergenteCamposPromProdIncompletos() {
		JOptionPane.showMessageDialog(this,"Complete los campos de cantidad minima y precio");
	}

	@Override
	public void emergenteNoHaySeleccionTipo() {
		JOptionPane.showMessageDialog(this,"Seleccione el tipo de la promocion");
	}

	@Override
	public void emergenteNoHayProductoSeleccionado() {
		JOptionPane.showMessageDialog(this,"Seleccione un producto para agregarlo a la promocion");
	}

	@Override
	public void emergenteNoHayPromProdSelecionado() {
		JOptionPane.showMessageDialog(this,"Seleccione una promocion por producto de la lista");
	}

	@Override
	public void emergenteNoEsNumeroValido() {
		JOptionPane.showMessageDialog(this,"Numero mal ingesado, ingrese un numero entre 1 y 100");
	}

	@Override
	public void emergenteNoHayFormaPago() {
		JOptionPane.showMessageDialog(this,"Seleccione una forma de pago");
	}

	@Override
	public void emergenteCampoNombreVacio() {
		JOptionPane.showMessageDialog(this,"Complete el campo nombre");
	}

	@Override
	public void emergenteCampoDescuentoVacio() {
		JOptionPane.showMessageDialog(this,"Complete el campo descuento");
	}

	@Override
	public void emergenteNoHayPromTempSelecionado() {
		JOptionPane.showMessageDialog(this,"Seleccione una promocion temporal de la lista");
	}

	@Override
	public void emergentePrecioUnitario(String msg) {
		JOptionPane.showMessageDialog(this, msg);
		
	}
	
}
