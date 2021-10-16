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

public class VcrudHabitaciones extends JFrame {

	private JPanel contentPane;
	private JTextField txtExtras;
	private JTextField txtPrecioNoche;
	private JTextField txtTipoHabitacion;
	private JTable table;
	JComboBox comboBox;
	private Empleado empleado;
	
	
	private HotelDAO gestionHoteles;
	private HabitacionDAO gestionHabitaciones;

	/**
	 * Create the frame.
	 */
	public VcrudHabitaciones(Empleado empleado) {
		CargarInterfazGrafica();
		
		this.empleado = empleado;
		gestionHoteles = new HotelDAO();
		gestionHabitaciones = new HabitacionDAO();
		
		gestionHoteles.mostrar(comboBox, null);
		
		gestionHabitaciones.mostrar(
				table, 
				String.valueOf(HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString())));

	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
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
		
		
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTipoHabitacion.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				txtPrecioNoche.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				txtExtras.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				
			}
		});
		pnlTablaHabitaciones.add(table);
		
		
		
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
		btnEliminar.setBounds(250, 350, 100, 50);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
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
		btnModificar.setBounds(140, 349, 100, 50);
		contentPane.add(btnModificar);
		
		
		
		
		
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnInsertar.setBounds(30, 349, 100, 50);
		contentPane.add(btnInsertar);
		
		
		
		
		
		
		
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
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vempleado empleado = new Vempleado(null);
				empleado.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(638, 11, 86, 24);
		contentPane.add(btnAtras);
		
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
