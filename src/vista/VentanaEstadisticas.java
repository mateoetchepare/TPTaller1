package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Mozo;

public class VentanaEstadisticas extends JFrame implements IVistaEstadisticas, MouseListener{

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
	private DefaultListModel<Mozo> modeloListaMozos;
	private JButton btnMayorMenorVenta;

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
		setBounds(100, 100, 600, 300);
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
		this.listMozos.addMouseListener(this);
		this.listMozos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane.setViewportView(this.listMozos);
		this.modeloListaMozos=new DefaultListModel<Mozo>();
		this.listMozos.setModel(modeloListaMozos);
		
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new BorderLayout(0, 0));
		
		this.panelBotonera = new JPanel();
		this.panelCentral.add(this.panelBotonera, BorderLayout.SOUTH);
		
		this.btnVerificar = new JButton("Verificar");
		this.btnVerificar.setEnabled(false);
		this.panelBotonera.add(this.btnVerificar);
		
		this.btnMayorMenorVenta = new JButton("Mayor/Menor venta");
		this.panelBotonera.add(this.btnMayorMenorVenta);
		
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

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnListo.addActionListener(listener);
		this.btnVerificar.addActionListener(listener);
		this.btnMayorMenorVenta.addActionListener(listener);
	}

	public void mouseClicked(MouseEvent e) {
		if(this.listMozos.getSelectedValue()!=null)
			this.btnVerificar.setEnabled(true);
		else
			this.btnVerificar.setEnabled(false);
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
	public DefaultListModel<Mozo> getModeloListaMozos() {
		// TODO Auto-generated method stub
		return this.modeloListaMozos;
	}

	@Override
	public JList<Mozo> getListMozos() {
		// TODO Auto-generated method stub
		return this.listMozos;
	}

	@Override
	public void escribirEstadistica(String estadistica) {
		// TODO Auto-generated method stub
		String cadena=this.textPane.getText();
		this.textPane.setText(cadena+estadistica+"\n");
	}

	@Override
	public void emergenteSinFacturas() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this,"El sistema no posee facturas para calcular estadisticas");
		
	}

	@Override
	public void emergenteMozoSinFacturas() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this,"El mozo seleccionado no tiene ventas asociadas para sus estadisticas");
	}

	@Override
	public void emergenteSinSeleccion() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this,"No hay un mozo seleccionado");
		
	}
	
	
}
