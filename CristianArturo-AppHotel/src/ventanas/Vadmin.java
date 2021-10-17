package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;
import com.toedter.calendar.JDateChooser;

import datos.Empleado;
import modelo.EmpleadoDAO;
import modelo.HotelDAO;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Vadmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtPoblacion;
	private JTextField txtContraseña;
	private JDateChooser dtFechaNacimiento;
	JComboBox comboBox;
	
	private EmpleadoDAO gestionEmpleados;
	private HotelDAO gestionHoteles;
	private JTextField txtUsuario;
	private JTable table;
	

	/**
	 * Create the frame.
	 */
	public Vadmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vadmin.class.getResource("/Imagenes/hoteles.png")));

		CargarInterfazGrafica();
		gestionEmpleados = new EmpleadoDAO();
		gestionHoteles = new HotelDAO();
		gestionHoteles.mostrar(comboBox, null);
		gestionEmpleados.mostrar(table, null);
		
		JLabel lblInsertar = new JLabel("");
		lblInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gestionEmpleados.insertar(
						new Empleado(
								txtNombre.getText(),
								txtApellido.getText(),
								txtDni.getText(),
								convertirFecha(dtFechaNacimiento),
								txtPoblacion.getText(),
								HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString()),
								txtUsuario.getText(),
								txtContraseña.getText()
								))) 
				{
					gestionEmpleados.mostrar(table, null);
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Error al insertar empleado");
				}
			}
		});
		lblInsertar.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertar.setIcon(new ImageIcon(Vadmin.class.getResource("/Imagenes/insert_new_customer_icon-icons.com_72387.png")));
		lblInsertar.setBounds(30, 438, 64, 64);
		contentPane.add(lblInsertar);
		
		JLabel lblModificar = new JLabel("");
		lblModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(	gestionEmpleados.modificar(
						new Empleado(
								Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()),
								txtNombre.getText(),
								txtApellido.getText(),
								txtDni.getText(),
								convertirFecha(dtFechaNacimiento),
								txtPoblacion.getText(),
								HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString()),
								txtUsuario.getText(),
								txtContraseña.getText()
								))) 
				{
					//Limpiar
					gestionEmpleados.mostrar(table, null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al insertar empleado");
				};
				
			}
		});
		lblModificar.setIcon(new ImageIcon(Vadmin.class.getResource("/Imagenes/modif.png")));
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setBounds(150, 441, 64, 64);
		contentPane.add(lblModificar);
		
		
		
		
		JLabel lblEliminar = new JLabel("");
		lblEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gestionEmpleados.eliminar(
						new Empleado(
								Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())))
						) 
				{
					//Limpiar
					gestionEmpleados.mostrar(table, null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al eliminar un registro");
				}
			}
		});
		
		
		
		
		lblEliminar.setIcon(new ImageIcon(Vadmin.class.getResource("/Imagenes/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setBounds(276, 438, 64, 64);
		contentPane.add(lblEliminar);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vlogin login = new Vlogin();
				login.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(Vadmin.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(1133, 11, 32, 32);
		contentPane.add(lblAtras);
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1189, 569);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel pnlTablaEmpleado = new JPanel();
		pnlTablaEmpleado.setBounds(488, 50, 654, 455);
		contentPane.add(pnlTablaEmpleado);
		pnlTablaEmpleado.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 634, 433);
		pnlTablaEmpleado.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				txtApellido.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				txtDni.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				txtPoblacion.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		
		
		JLabel lblTablaEmpleado = new JLabel("TABLA DE EMPLEADOS");
		lblTablaEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTablaEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		lblTablaEmpleado.setBounds(718, 15, 254, 28);
		contentPane.add(lblTablaEmpleado);
		
		JLabel lblEmpleado = new JLabel("DATOS DE EMPLEADO");
		lblEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleado.setBounds(30, 11, 320, 37);
		contentPane.add(lblEmpleado);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 50, 184, 30);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(243, 52, 190, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(30, 91, 184, 30);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(243, 93, 190, 20);
		contentPane.add(txtApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(30, 132, 184, 30);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(243, 134, 190, 20);
		contentPane.add(txtDni);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNacimiento.setBounds(30, 163, 184, 30);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblPoblacion = new JLabel("POBLACION");
		lblPoblacion.setBounds(30, 204, 184, 30);
		contentPane.add(lblPoblacion);
		
		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBounds(243, 206, 190, 20);
		contentPane.add(txtPoblacion);
		
		
		JLabel lblContraseña = new JLabel("CONTRASE\u00D1A");
		lblContraseña.setBounds(30, 269, 184, 30);
		contentPane.add(lblContraseña);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(243, 271, 190, 20);
		contentPane.add(txtContraseña);
		
		dtFechaNacimiento = new JDateChooser();
		dtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
		dtFechaNacimiento.setBounds(243, 170, 190, 20);
		contentPane.add(dtFechaNacimiento);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(30, 245, 184, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(243, 240, 190, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("HOTEL");
		lblNewLabel_1.setBounds(30, 310, 184, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(243, 302, 190, 22);
		contentPane.add(comboBox);
	}
	
	public String convertirFecha(JDateChooser dt) {
		
		String dia = Integer.toString(dt.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes =  Integer.toString(dt.getCalendar().get(Calendar.MONTH));
		String año =  Integer.toString(dt.getCalendar().get(Calendar.YEAR));
		
		return año + "-" + mes + "-" + dia;
		
	}
}
