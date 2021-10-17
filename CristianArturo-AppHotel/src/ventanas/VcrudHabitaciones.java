package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Empleado;
import datos.Habitacion;
import modelo.HabitacionDAO;
import modelo.HotelDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class VcrudHabitaciones extends JFrame {

	private JPanel contentPane;
	private JTextField txtExtras;
	private JTextField txtPrecioNoche;
	private JTextField txtTipoHabitacion;
	JComboBox comboBox;
	private Empleado empleado;
	
	
	private HotelDAO gestionHoteles;
	private HabitacionDAO gestionHabitaciones;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public VcrudHabitaciones(Empleado empleado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VcrudHabitaciones.class.getResource("/Imagenes/hoteles.png")));
		CargarInterfazGrafica();
		
		this.empleado = empleado;
		gestionHoteles = new HotelDAO();
		gestionHabitaciones = new HabitacionDAO();
		
		gestionHoteles.mostrar(comboBox, null);
		
		JLabel lblInsertar = new JLabel("");
		lblInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gestionHabitaciones.insertar(
						new Habitacion(
								txtTipoHabitacion.getText(),
								Double.parseDouble(txtPrecioNoche.getText()),
								txtExtras.getText(),
								HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString())
								)))
				{
				
					gestionHabitaciones.mostrar(
							table, 
							String.valueOf(HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString())));
					
					Limpiar();
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al insertar la habitación");
				};
			}
		});
		lblInsertar.setIcon(new ImageIcon(VcrudHabitaciones.class.getResource("/Imagenes/insert_new_customer_icon-icons.com_72387.png")));
		lblInsertar.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertar.setBounds(40, 333, 64, 64);
		contentPane.add(lblInsertar);
		
		JLabel lblEliminar = new JLabel("");
		lblEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gestionHabitaciones.eliminar(
						new Habitacion(
								HotelDAO.obtenerIdHotelPorNombre(table.getValueAt(table.getSelectedRow(), 0).toString()),
								Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString())))) {
					
					gestionHabitaciones.mostrar(
							table, 
							String.valueOf(HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString())));
					
					Limpiar();
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al eliminar la habitación");
				};
			}
		});
		lblEliminar.setIcon(new ImageIcon(VcrudHabitaciones.class.getResource("/Imagenes/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setBounds(286, 333, 64, 64);
		contentPane.add(lblEliminar);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vempleado empleado = new Vempleado(null);
				empleado.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(VcrudHabitaciones.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(692, 11, 32, 32);
		contentPane.add(lblAtras);
		
		JLabel lblMidificar = new JLabel("");
		lblMidificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gestionHabitaciones.modificar(
						new Habitacion(
								Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString()),
								txtTipoHabitacion.getText(),
								Double.parseDouble(txtPrecioNoche.getText()),
								txtExtras.getText(),
								HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString())
								))) 
				{
					gestionHabitaciones.mostrar(
							table, 
							String.valueOf(HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString())));
					
					Limpiar();
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al modificar la habitación");
				};
			}
		});
		lblMidificar.setIcon(new ImageIcon(VcrudHabitaciones.class.getResource("/Imagenes/modif.png")));
		lblMidificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMidificar.setBounds(150, 337, 64, 64);
		contentPane.add(lblMidificar);

	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblHabitacion = new JLabel("DATOS DE LA HABITACION");
		lblHabitacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHabitacion.setBounds(30, 11, 320, 37);
		contentPane.add(lblHabitacion);
		
		JLabel lblTablaHabitacion = new JLabel("TABLA DE HABITACIONES");
		lblTablaHabitacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablaHabitacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTablaHabitacion.setBounds(374, 11, 254, 28);
		contentPane.add(lblTablaHabitacion);
		
		JPanel pnlTablaHabitaciones = new JPanel();
		pnlTablaHabitaciones.setBounds(374, 50, 350, 350);
		contentPane.add(pnlTablaHabitaciones);
		pnlTablaHabitaciones.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 330, 328);
		pnlTablaHabitaciones.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTipoHabitacion.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				txtPrecioNoche.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				txtExtras.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		
		txtExtras = new JTextField();
		txtExtras.setColumns(10);
		txtExtras.setBounds(150, 200, 200, 75);
		contentPane.add(txtExtras);
		
		txtPrecioNoche = new JTextField();
		txtPrecioNoche.setColumns(10);
		txtPrecioNoche.setBounds(150, 159, 200, 20);
		contentPane.add(txtPrecioNoche);
		
		txtTipoHabitacion = new JTextField();
		txtTipoHabitacion.setColumns(10);
		txtTipoHabitacion.setBounds(150, 118, 200, 20);
		contentPane.add(txtTipoHabitacion);
		
		JLabel lblTipoDeHabitacion = new JLabel("TIPO DE HABITACION");
		lblTipoDeHabitacion.setBounds(30, 113, 120, 30);
		contentPane.add(lblTipoDeHabitacion);
		
		JLabel lblPecioNoche = new JLabel("PECIO NOCHE");
		lblPecioNoche.setBounds(30, 154, 120, 30);
		contentPane.add(lblPecioNoche);
		
		JLabel lblExtras = new JLabel("EXTRAS");
		lblExtras.setBounds(30, 195, 120, 30);
		contentPane.add(lblExtras);
		
		JLabel lblNewLabel = new JLabel("HOTEL");
		lblNewLabel.setBounds(30, 308, 49, 14);
		contentPane.add(lblNewLabel);
		
		
		comboBox = new JComboBox();		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
				gestionHabitaciones.mostrar(
						table,
						String.valueOf(HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString())));
				
				Limpiar();
			}
		});
		comboBox.setBounds(158, 304, 192, 22);
		contentPane.add(comboBox);
	}
	
	public void Limpiar() {
		txtTipoHabitacion.setText("");
		txtPrecioNoche.setText("");
		txtExtras.setText("");
	}
}
