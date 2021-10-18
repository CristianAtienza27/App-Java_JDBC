package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Empleado;
import datos.Hotel;
import modelo.HotelDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class VcrudHoteles extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtCiudad;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	
	private Empleado empleado;
	private HotelDAO gestionHoteles;
	private JLabel lblHotel;
	private JLabel lblTablaHotel;
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JLabel lblCiudad;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JPanel pnlTablaHotel;
	private JLabel lblInsertar;
	private JLabel lblModificar;
	private JLabel lblEliminar;
	private JLabel lblAtras;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public VcrudHoteles(Empleado empleado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VcrudHoteles.class.getResource("/Imagenes/hoteles.png")));
		CargarInterfazGrafica();
		
		this.empleado = empleado;
		
		gestionHoteles = new HotelDAO();
		gestionHoteles.mostrar(table, null);
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		lblHotel = new JLabel("DATOS DEL HOTEL");
		lblHotel.setBounds(30, 11, 320, 37);
		lblHotel.setBackground(SystemColor.info);
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblTablaHotel = new JLabel("TABLA DE HOTELES");
		lblTablaHotel.setBounds(374, 11, 260, 28);
		lblTablaHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablaHotel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		pnlTablaHotel = new JPanel();
		pnlTablaHotel.setBounds(374, 50, 403, 368);
		pnlTablaHotel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(150, 85, 200, 20);
		txtNombre.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(150, 126, 200, 68);
		txtDescripcion.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(150, 205, 200, 20);
		txtCiudad.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(150, 269, 200, 20);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(150, 305, 200, 20);
		txtTelefono.setColumns(10);
		
		
		
		
		
		lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(30, 300, 120, 30);
		
		lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setBounds(30, 241, 120, 30);
		
		lblCiudad = new JLabel("CIUDAD");
		lblCiudad.setBounds(30, 200, 120, 30);
		
		lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(30, 121, 120, 30);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 80, 120, 30);
		
		contentPane.setLayout(null);
		contentPane.add(lblHotel);
		contentPane.add(lblTablaHotel);
		contentPane.add(lblNombre);
		contentPane.add(txtNombre);
		contentPane.add(lblDescripcion);
		contentPane.add(txtDescripcion);
		contentPane.add(lblCiudad);
		contentPane.add(txtCiudad);
		contentPane.add(lblDireccion);
		contentPane.add(txtDireccion);
		contentPane.add(lblTelefono);
		contentPane.add(txtTelefono);
		contentPane.add(pnlTablaHotel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 383, 346);
		pnlTablaHotel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				txtDescripcion.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				txtCiudad.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				txtDireccion.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				txtTelefono.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		lblInsertar = new JLabel("");
		lblInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gestionHoteles.insertar(
						new Hotel(
								txtNombre.getText(),
								txtDescripcion.getText(),
								txtCiudad.getText(),
								txtDireccion.getText(),
								txtTelefono.getText()
								)))
				{					
					gestionHoteles.mostrar(table, null);
					Limpiar();		
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al insertar el hotel");
				}
			}
		});
		lblInsertar.setIcon(new ImageIcon(VcrudHoteles.class.getResource("/Imagenes/insert_new_customer_icon-icons.com_72387.png")));
		lblInsertar.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertar.setBounds(30, 351, 99, 99);
		contentPane.add(lblInsertar);
		
		lblModificar = new JLabel("");
		lblModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(gestionHoteles.modificar(
						new Hotel(
								Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()),
								txtNombre.getText(),
								txtCiudad.getText(),
								txtDescripcion.getText(),
								txtDireccion.getText(),
								txtTelefono.getText()
								))) 
				{
					
					gestionHoteles.mostrar(table, null);
					Limpiar();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al modificar");
				}
				
			}
		});
		lblModificar.setIcon(new ImageIcon(VcrudHoteles.class.getResource("/Imagenes/modif.png")));
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setBounds(139, 351, 99, 99);
		contentPane.add(lblModificar);
		
		lblEliminar = new JLabel("");
		lblEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(gestionHoteles.eliminar(
						new Hotel(
								Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()))))
				{
					gestionHoteles.mostrar(table, null);
					Limpiar();
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}
				
				
			}
		});
		lblEliminar.setIcon(new ImageIcon(VcrudHoteles.class.getResource("/Imagenes/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setBounds(248, 351, 99, 99);
		contentPane.add(lblEliminar);
		
		lblAtras = new JLabel("");
		lblAtras.setIcon(new ImageIcon(VcrudHoteles.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vempleado vEmpleado = new Vempleado(empleado);
				vEmpleado.setVisible(true);
				dispose();
			}
		});
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(745, 11, 32, 32);
		contentPane.add(lblAtras);
	}
	
	public void Limpiar() {
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtCiudad.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
}
