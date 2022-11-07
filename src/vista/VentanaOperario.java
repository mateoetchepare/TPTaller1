package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Mesa;
import modelo.Mozo;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class VentanaOperario extends JFrame implements IVistaOperario, MouseListener{

	private JPanel contentPane;
	private JLabel LabelPrincipal;
	private JPanel panelPrincipal;
	private JPanel panelIz;
	private JPanel panelCentral;
	private JPanel panelDer;
	private JScrollPane scrollPane;
	private JList listMesas;
	private DefaultListModel<Mesa> modeloListaMesas;
	private JLabel LabelMesas;
	private JPanel panelBotonesMesas;
	private JScrollPane scrollPane_1;
	private JList listMozos;
	private DefaultListModel<Mozo> modeloListaMozos;
	private JLabel lblNewLabel;
	private JPanel panelBotonesMozos;
	private JButton btnModificar;
	private JButton btnHabilitar;
	private JButton btnDeshabilitar;
	private JButton btnVerMesa;
	private JButton btnAsignarMozo;
	private JButton btnProductosPromociones;
	private JButton btnAgregarOperario;
	private JButton btnCerrarSecion;
	boolean seleccionado=false;
	private JButton btnEstadisticas;
	private JRadioButton rdbtnActivo;
	private JRadioButton rdbtnDeFranco;
	private JRadioButton rdbtnAusente;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnMozos;

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
		setBounds(100, 100, 750, 400);
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
		
		this.listMozos = new JList<Mozo>();
		this.listMozos.addMouseListener(this);
		this.listMozos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane_1.setViewportView(this.listMozos);////////////
		this.modeloListaMozos=new DefaultListModel<Mozo>();
		this.listMozos.setModel(modeloListaMozos);
		
		//////
		
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
		
		this.btnProductosPromociones = new JButton("Productos / Promociones");
		this.panelCentral.add(this.btnProductosPromociones);
		
		this.btnAgregarOperario = new JButton("Operario ");
		this.panelCentral.add(this.btnAgregarOperario);
		
		this.btnMozos = new JButton("Mozos");
		this.panelCentral.add(this.btnMozos);
		
		this.btnEstadisticas = new JButton("Estadisticas");
		this.panelCentral.add(this.btnEstadisticas);
		
		this.btnCerrarSecion = new JButton("Cerrar Sesion");
		this.panelCentral.add(this.btnCerrarSecion);
		
		this.panelDer = new JPanel();
		this.panelPrincipal.add(this.panelDer);
		this.panelDer.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panelDer.add(this.scrollPane, BorderLayout.CENTER);
		
		this.listMesas = new JList<Mesa>();
		this.listMesas.addMouseListener(this);
		this.listMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane.setViewportView(this.listMesas);
		this.modeloListaMesas=new DefaultListModel<Mesa>();
		this.listMesas.setModel(modeloListaMesas);
		
		this.LabelMesas = new JLabel("Lista Mesas");
		this.LabelMesas.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane.setColumnHeaderView(this.LabelMesas);
		
		this.panelBotonesMesas = new JPanel();
		this.panelDer.add(this.panelBotonesMesas, BorderLayout.SOUTH);
		
		this.panelBotonesMozos.setPreferredSize(new Dimension(70,70));
		this.panelBotonesMozos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.rdbtnActivo = new JRadioButton("Activo");
		this.rdbtnActivo.addMouseListener(this);
		buttonGroup.add(this.rdbtnActivo);
		this.panelBotonesMozos.add(this.rdbtnActivo);
		
		this.rdbtnDeFranco = new JRadioButton("De franco");
		this.rdbtnDeFranco.addMouseListener(this);
		buttonGroup.add(this.rdbtnDeFranco);
		this.panelBotonesMozos.add(this.rdbtnDeFranco);
		
		this.rdbtnAusente = new JRadioButton("Ausente");
		this.rdbtnAusente.addMouseListener(this);
		buttonGroup.add(this.rdbtnAusente);
		this.panelBotonesMozos.add(this.rdbtnAusente);
		
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
		this.btnHabilitar.addActionListener(listener);
		this.btnDeshabilitar.addActionListener(listener);
		this.btnVerMesa.addActionListener(listener);
		this.btnAsignarMozo.addActionListener(listener);
		this.btnProductosPromociones.addActionListener(listener);
		this.btnAgregarOperario.addActionListener(listener);
		this.btnMozos.addActionListener(listener);
		this.btnEstadisticas.addActionListener(listener);
		this.btnCerrarSecion.addActionListener(listener);
		this.btnModificar.addActionListener(listener);
		
	}

	@Override
	public void actualizarListas() {
		// TODO Auto-generated method stub
		//this.repaint();
		this.mouseClicked(null);
		
	}

	@Override
	public DefaultListModel<Mozo> getModeloListaMozos() {
		// TODO Auto-generated method stub
		return this.modeloListaMozos;
	}

	@Override
	public DefaultListModel<Mesa> getModeloListaMesas() {
		// TODO Auto-generated method stub
		return this.modeloListaMesas;
	}
	
	

	public void mouseClicked(MouseEvent e) {
		if(this.listMesas.getSelectedValue()!=null) {
			this.btnHabilitar.setEnabled(true);
			this.btnDeshabilitar.setEnabled(true);
			this.seleccionado=true;//sobra
			this.btnVerMesa.setEnabled(true);
			System.out.println(this.listMesas.getSelectedValue()+"++");
		}
		else {
			this.btnHabilitar.setEnabled(false);
			this.btnDeshabilitar.setEnabled(false);
			this.seleccionado=false;//sobra
			this.btnVerMesa.setEnabled(false);
			System.out.println("no hay seleccion en lista mesas");
		}
		if(this.listMozos.getSelectedValue()!=null && this.buttonGroup.getSelection()!=null) {
			this.btnModificar.setEnabled(true);
		}
		else {
			this.btnModificar.setEnabled(false);
		}
		
		if(this.listMozos.getSelectedValue()!=null && this.listMesas.getSelectedValue()!=null) {
			this.btnAsignarMozo.setEnabled(true);
		}
		else {
			this.btnAsignarMozo.setEnabled(false);
		}
			
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public JList<Mesa> getListMesas() {
		// TODO Auto-generated method stub
		return this.listMesas;
	}

	@Override
	public JButton getBtnVerMesa() {
		// TODO Auto-generated method stub
		return this.btnVerMesa;
	}
	
	@Override
	public void emergenteNoHaySeleccion() {
		JOptionPane.showMessageDialog(this,"No hay seleccion en la lista mesas");
	}

	@Override
	public void emergenteMesaDeshabilitada() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this,"No se puede ver mesa, esta deshabilitada");
	}

	@Override
	public void emergenteMesaOcupada() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this,"No se puede deshabilitar mesa, esta ocupada");
	}

	@Override
	public JList<Mozo> getListMozos() {
		// TODO Auto-generated method stub
		return this.listMozos;
	}

	@Override
	public void vistaAdmin(boolean admin) {
		this.btnAgregarOperario.setEnabled(admin);
		this.btnMozos.setEnabled(admin);
	}

	@Override
	public JRadioButton getEstadoMozo() {
		JRadioButton rb=null;	
		if(this.rdbtnActivo.isSelected())
			rb=this.rdbtnActivo;
		else if(this.rdbtnAusente.isSelected())
			rb=this.rdbtnAusente;
		else if(this.rdbtnDeFranco.isSelected())
			rb=this.rdbtnDeFranco;
		return rb;
	}
	
	
}
