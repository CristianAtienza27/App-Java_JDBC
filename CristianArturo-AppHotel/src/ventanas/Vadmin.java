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

public class Vadmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtPoblacion;
	private JTextField txtContraseña;
	private JTable table;
	private JDateChooser dtFechaNacimiento;
	JComboBox comboBox;
	
	private EmpleadoDAO gestionEmpleados;
	private HotelDAO gestionHoteles;
	private JTextField txtUsuario;
	

	/**
	 * Create the frame.
	 */
	public Vadmin() {

		CargarInterfazGrafica();
		gestionEmpleados = new EmpleadoDAO();
		gestionHoteles = new HotelDAO();
		
		gestionEmpleados.mostrar(table, null);
		gestionHoteles.mostrar(comboBox, null);
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel pnlTablaEmpleado = new JPanel();
		pnlTablaEmpleado.setBounds(374, 50, 542, 349);
		contentPane.add(pnlTablaEmpleado);
		
		
		
		
		
		
		
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
		pnlTablaEmpleado.add(table);
		
		
		
		
		
		
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
		btnModificar.setBounds(140, 349, 100, 50);
		contentPane.add(btnModificar);
		
		
		
		
		
		
		
		
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnEliminar.setBounds(250, 350, 100, 50);
		contentPane.add(btnEliminar);
		
		
		
		
		
		
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				
				//Limpiar
				gestionEmpleados.mostrar(table, null);
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Error al insertar empleado");
			}
				
		}
		});
		btnInsertar.setBounds(30, 349, 100, 50);
		contentPane.add(btnInsertar);
		
		
		
		
		
		
		
		
		JLabel lblTablaEmpleado = new JLabel("TABLA DE EMPLEADOS");
		lblTablaEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTablaEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		lblTablaEmpleado.setBounds(374, 11, 254, 28);
		contentPane.add(lblTablaEmpleado);
		
		JLabel lblEmpleado = new JLabel("DATOS DE EMPLEADO");
		lblEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleado.setBounds(30, 11, 320, 37);
		contentPane.add(lblEmpleado);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 50, 120, 30);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(160, 55, 190, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(30, 91, 120, 30);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(160, 96, 190, 20);
		contentPane.add(txtApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(30, 132, 120, 30);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(160, 137, 190, 20);
		contentPane.add(txtDni);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNacimiento.setBounds(30, 163, 120, 30);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblPoblacion = new JLabel("POBLACION");
		lblPoblacion.setBounds(30, 204, 120, 30);
		contentPane.add(lblPoblacion);
		
		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBounds(160, 209, 190, 20);
		contentPane.add(txtPoblacion);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vlogin login = new Vlogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(830, 11, 86, 24);
		contentPane.add(btnAtras);
		
		
		JLabel lblContraseña = new JLabel("CONTRASE\u00D1A");
		lblContraseña.setBounds(30, 269, 120, 30);
		contentPane.add(lblContraseña);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(160, 274, 190, 20);
		contentPane.add(txtContraseña);
		
		dtFechaNacimiento = new JDateChooser();
		dtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
		dtFechaNacimiento.setBounds(160, 173, 190, 20);
		contentPane.add(dtFechaNacimiento);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(30, 245, 49, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(160, 243, 190, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("HOTEL");
		lblNewLabel_1.setBounds(30, 310, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(160, 305, 190, 22);
		contentPane.add(comboBox);
	}
	
	public String convertirFecha(JDateChooser dt) {
		
		String dia = Integer.toString(dt.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes =  Integer.toString(dt.getCalendar().get(Calendar.MONTH));
		String año =  Integer.toString(dt.getCalendar().get(Calendar.YEAR));
		
		return año + "-" + mes + "-" + dia;
		
	}
}
