package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtFechaNacimiento;
	private JTextField txtPoblacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel pnlTablaEmpleado = new JPanel();
		pnlTablaEmpleado.setBounds(374, 50, 350, 349);
		contentPane.add(pnlTablaEmpleado);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(140, 349, 100, 50);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(250, 350, 100, 50);
		contentPane.add(btnEliminar);
		
		JButton btnInsertar = new JButton("INSERTAR");
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
		
		JLabel lblId = new JLabel("IDENTIFICADOR");
		lblId.setBounds(30, 80, 120, 30);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(150, 85, 200, 20);
		contentPane.add(txtId);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 121, 120, 30);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(150, 126, 200, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(30, 162, 120, 30);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(150, 167, 200, 20);
		contentPane.add(txtApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(30, 203, 120, 30);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(150, 208, 200, 20);
		contentPane.add(txtDni);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNacimiento.setBounds(30, 244, 120, 30);
		contentPane.add(lblFechaNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(150, 249, 200, 20);
		contentPane.add(txtFechaNacimiento);
		
		JLabel lblPoblacion = new JLabel("POBLACION");
		lblPoblacion.setBounds(30, 285, 120, 30);
		contentPane.add(lblPoblacion);
		
		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBounds(150, 290, 200, 20);
		contentPane.add(txtPoblacion);
		
		JButton btnAtras = new JButton("SALIR");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login login = new login();
				login.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(638, 11, 86, 24);
		contentPane.add(btnAtras);
		
		
	}

}
