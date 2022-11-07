package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Operario;
import modelo.Pedido;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class VentanaABMOperario extends JFrame implements IVistaABMOperario, KeyListener, MouseListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList listOperarios;
	private JLabel labelOperarios;
	private JLabel labelTitulo;
	private JPanel panelPrincipal;
	private JPanel panelUsername;
	private JPanel panelPassword;
	private JPanel panelNombre;
	private JPanel panelApellido;
	private JPanel panelBotones1;
	private JPanel panelBotones2;
	private JLabel labelUsername;
	private JTextField textFieldUsername;
	private JPanel panel;
	private JLabel labelPassword;
	private JTextField textFieldPassword;
	private JPanel panel_1;
	private JLabel laeblNombre;
	private JTextField textFieldNombre;
	private JLabel labelApellido;
	private JTextField textFieldApellido;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnAgregar;
	private JButton btnSacar;
	private JButton btnModificar;
	private JButton btnListo;
	private DefaultListModel<Operario> modeloListaOperarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaABMOperario frame = new VentanaABMOperario();
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
	public VentanaABMOperario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane, BorderLayout.WEST);
		this.scrollPane.setPreferredSize(new Dimension(225,50));
		
		this.listOperarios = new JList();
		this.listOperarios.addMouseListener(this);
		this.listOperarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane.setViewportView(this.listOperarios);
		this.modeloListaOperarios=new DefaultListModel<Operario>();
		this.listOperarios.setModel(modeloListaOperarios);
		
		this.labelOperarios = new JLabel("Operarios");
		this.labelOperarios.setHorizontalAlignment(SwingConstants.CENTER);
		this.scrollPane.setColumnHeaderView(this.labelOperarios);
		
		this.labelTitulo = new JLabel("ABM Operarios");
		this.labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.contentPane.add(this.labelTitulo, BorderLayout.NORTH);
		
		this.panelPrincipal = new JPanel();
		this.contentPane.add(this.panelPrincipal, BorderLayout.CENTER);
		this.panelPrincipal.setLayout(new GridLayout(6, 0, 0, 0));
		
		this.panelUsername = new JPanel();
		this.panelPrincipal.add(this.panelUsername);
		this.panelUsername.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.labelUsername = new JLabel("Nombre de Usuario:");
		this.labelUsername.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelUsername.add(this.labelUsername);
		
		this.panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panel.getLayout();
		flowLayout.setVgap(10);
		this.panelUsername.add(this.panel);
		
		this.textFieldUsername = new JTextField();
		this.textFieldUsername.addKeyListener(this);
		this.panel.add(this.textFieldUsername);
		this.textFieldUsername.setColumns(10);
		
		this.panelPassword = new JPanel();
		this.panelPrincipal.add(this.panelPassword);
		this.panelPassword.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.labelPassword = new JLabel("Contrase\u00F1a: ");
		this.labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelPassword.add(this.labelPassword);
		
		this.panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) this.panel_1.getLayout();
		flowLayout_1.setVgap(10);
		this.panelPassword.add(this.panel_1);
		
		this.textFieldPassword = new JTextField();
		this.textFieldPassword.addKeyListener(this);
		this.panel_1.add(this.textFieldPassword);
		this.textFieldPassword.setColumns(10);
		
		this.panelNombre = new JPanel();
		this.panelPrincipal.add(this.panelNombre);
		this.panelNombre.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.laeblNombre = new JLabel("Nombre: ");
		this.laeblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelNombre.add(this.laeblNombre);
		
		this.panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) this.panel_2.getLayout();
		flowLayout_2.setVgap(10);
		this.panelNombre.add(this.panel_2);
		
		this.textFieldNombre = new JTextField();
		this.textFieldNombre.addKeyListener(this);
		this.panel_2.add(this.textFieldNombre);
		this.textFieldNombre.setColumns(10);
		
		this.panelApellido = new JPanel();
		this.panelPrincipal.add(this.panelApellido);
		this.panelApellido.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.labelApellido = new JLabel("Apellido: ");
		this.labelApellido.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelApellido.add(this.labelApellido);
		
		this.panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) this.panel_3.getLayout();
		flowLayout_3.setVgap(10);
		this.panelApellido.add(this.panel_3);
		
		this.textFieldApellido = new JTextField();
		this.textFieldApellido.addKeyListener(this);
		this.panel_3.add(this.textFieldApellido);
		this.textFieldApellido.setColumns(10);
		
		this.panelBotones1 = new JPanel();
		this.panelPrincipal.add(this.panelBotones1);
		this.panelBotones1.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.setEnabled(false);
		this.panelBotones1.add(this.btnAgregar);
		
		this.btnSacar = new JButton("Sacar");
		this.btnSacar.setEnabled(false);
		this.panelBotones1.add(this.btnSacar);
		
		this.panelBotones2 = new JPanel();
		this.panelPrincipal.add(this.panelBotones2);
		this.panelBotones2.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setEnabled(false);
		this.panelBotones2.add(this.btnModificar);
		
		this.btnListo = new JButton("Listo");
		this.panelBotones2.add(this.btnListo);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregar.addActionListener(listener);
		this.btnListo.addActionListener(listener);
		this.btnModificar.addActionListener(listener);
		this.btnSacar.addActionListener(listener);
		
	}

	@Override
	public DefaultListModel<Operario> getModeloListaOperarios() {
		// TODO Auto-generated method stub
		mouseClicked(null);
		return this.modeloListaOperarios;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.textFieldUsername.getText();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.textFieldPassword.getText();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.textFieldNombre.getText();
	}

	@Override
	public String getApellido() {
		// TODO Auto-generated method stub
		return this.textFieldApellido.getText();
	}
	
	//SOLO DISPONIBLE PARA EL ADMIN
	

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if(this.textFieldApellido.getText().length()>0 && this.textFieldNombre.getText().length()>0 && 
				this.textFieldPassword.getText().length()>0 && this.textFieldUsername.getText().length()>0) {
			this.btnAgregar.setEnabled(true);
		}
		else {
			this.btnAgregar.setEnabled(false);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	
	public void mouseClicked(MouseEvent e) {
		if(this.listOperarios.getSelectedValue()!=null) {
			this.btnSacar.setEnabled(true);
		}
		else {
			this.btnSacar.setEnabled(false);
		}
		if(this.listOperarios.getSelectedValue()!=null &&(this.textFieldPassword.getText().length()>0))
			this.btnModificar.setEnabled(true);
		else
			this.btnModificar.setEnabled(false);
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
	public JList getListOperarios() {
		// TODO Auto-generated method stub
		return this.listOperarios;
	}
}
