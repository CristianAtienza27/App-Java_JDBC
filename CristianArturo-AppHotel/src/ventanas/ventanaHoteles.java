package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ventanaHoteles extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtCiudad;
	private JTextField txtDireccion;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaHoteles frame = new ventanaHoteles();
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
	public ventanaHoteles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblHotel = new JLabel("DATOS DEL HOTEL");
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHotel.setBounds(30, 11, 320, 37);
		contentPane.add(lblHotel);
		
		JLabel lblTablaHotel = new JLabel("TABLA DE HOTELES");
		lblTablaHotel.setHorizontalAlignment(SwingConstants.LEFT);
		lblTablaHotel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTablaHotel.setBounds(374, 11, 260, 28);
		contentPane.add(lblTablaHotel);
		
		JPanel pnlTablaHotel = new JPanel();
		pnlTablaHotel.setBounds(374, 50, 350, 350);
		contentPane.add(pnlTablaHotel);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(150, 85, 200, 20);
		contentPane.add(txtId);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(150, 126, 200, 20);
		contentPane.add(txtNombre);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(150, 167, 200, 20);
		contentPane.add(txtDescripcion);
		
		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(150, 208, 200, 20);
		contentPane.add(txtCiudad);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(150, 249, 200, 20);
		contentPane.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(150, 290, 200, 20);
		contentPane.add(txtTelefono);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(250, 350, 100, 50);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(140, 349, 100, 50);
		contentPane.add(btnModificar);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.setBounds(30, 349, 100, 50);
		contentPane.add(btnInsertar);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(30, 285, 120, 30);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("DIRECCION");
		lblDireccion.setBounds(30, 244, 120, 30);
		contentPane.add(lblDireccion);
		
		JLabel lblCiudad = new JLabel("CIUDAD");
		lblCiudad.setBounds(30, 203, 120, 30);
		contentPane.add(lblCiudad);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(30, 162, 120, 30);
		contentPane.add(lblDescripcion);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 121, 120, 30);
		contentPane.add(lblNombre);
		
		JLabel lblId = new JLabel("IDENTIFICADOR");
		lblId.setBounds(30, 80, 120, 30);
		contentPane.add(lblId);
		
		JButton btnAtras = new JButton("SALIR");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaEmpleado empleado = new ventanaEmpleado();
				empleado.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(638, 11, 86, 24);
		contentPane.add(btnAtras);
	}

}
