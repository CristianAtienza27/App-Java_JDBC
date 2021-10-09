package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class crudHabitaciones extends JFrame {

	private JPanel contentPane;
	private JTextField txtExtras;
	private JTextField txtPrecioNoche;
	private JTextField txtTipoHabitacion;
	private JTextField txtNumHabitacion;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crudHabitaciones frame = new crudHabitaciones();
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
	public crudHabitaciones() {
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
		lblTablaHabitacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblTablaHabitacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTablaHabitacion.setBounds(374, 11, 254, 28);
		contentPane.add(lblTablaHabitacion);
		
		JPanel pnlTablaHabitaciones = new JPanel();
		pnlTablaHabitaciones.setBounds(374, 50, 350, 350);
		contentPane.add(pnlTablaHabitaciones);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(250, 350, 100, 50);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(140, 349, 100, 50);
		contentPane.add(btnModificar);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.setBounds(30, 349, 100, 50);
		contentPane.add(btnInsertar);
		
		txtExtras = new JTextField();
		txtExtras.setColumns(10);
		txtExtras.setBounds(150, 249, 200, 20);
		contentPane.add(txtExtras);
		
		txtPrecioNoche = new JTextField();
		txtPrecioNoche.setColumns(10);
		txtPrecioNoche.setBounds(150, 208, 200, 20);
		contentPane.add(txtPrecioNoche);
		
		txtTipoHabitacion = new JTextField();
		txtTipoHabitacion.setColumns(10);
		txtTipoHabitacion.setBounds(150, 167, 200, 20);
		contentPane.add(txtTipoHabitacion);
		
		txtNumHabitacion = new JTextField();
		txtNumHabitacion.setColumns(10);
		txtNumHabitacion.setBounds(150, 126, 200, 20);
		contentPane.add(txtNumHabitacion);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(150, 85, 200, 20);
		contentPane.add(txtId);
		
		JLabel lblId = new JLabel("IDENTIFICADOR");
		lblId.setBounds(30, 80, 120, 30);
		contentPane.add(lblId);
		
		JLabel lblNumeroDeHabitacion = new JLabel("NUM HABITACION");
		lblNumeroDeHabitacion.setBounds(30, 121, 120, 30);
		contentPane.add(lblNumeroDeHabitacion);
		
		JLabel lblTipoDeHabitacion = new JLabel("TIPO DE HABITACION");
		lblTipoDeHabitacion.setBounds(30, 162, 120, 30);
		contentPane.add(lblTipoDeHabitacion);
		
		JLabel lblPecioNoche = new JLabel("PECIO NOCHE");
		lblPecioNoche.setBounds(30, 203, 120, 30);
		contentPane.add(lblPecioNoche);
		
		JLabel lblExtras = new JLabel("EXTRAS");
		lblExtras.setBounds(30, 244, 120, 30);
		contentPane.add(lblExtras);
		
		JButton btnAtras = new JButton("SALIR");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				empleado empleado = new empleado();
				empleado.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(638, 11, 86, 24);
		contentPane.add(btnAtras);
	}

}
