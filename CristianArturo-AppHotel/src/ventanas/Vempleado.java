package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import datos.Empleado;
import modelo.EmpleadoDAO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Vempleado extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private Empleado empleadoLogeado;
	private EmpleadoDAO gestionEmpleados;
	
	/**
	 * Create the frame.
	 */
	public Vempleado(Empleado empleadoLogeado) {
		CargarInterfazGrafica();
		this.empleadoLogeado = empleadoLogeado;
		gestionEmpleados = new EmpleadoDAO();
		gestionEmpleados.mostrar(table, null);
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblGestionEmpleado = new JLabel("GESTOR DEL EMPLEADO");
		lblGestionEmpleado.setBounds(69, 11, 473, 60);
		lblGestionEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestionEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGestionEmpleado);
		
		JButton btnClienteHosp = new JButton("CLIENTES HOS.");
		btnClienteHosp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VclientesHospedados cHospedados = new VclientesHospedados();
				cHospedados.setVisible(true);
				dispose();
			}
		});
		btnClienteHosp.setBounds(69, 349, 151, 50);
		contentPane.add(btnClienteHosp);
		
		JButton btnComentarioHotel = new JButton("COMENTARIOS H.");
		btnComentarioHotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VcomentarioHoteles cHoteles = new VcomentarioHoteles();
				cHoteles.setVisible(true);
				dispose();
			}
		});
		btnComentarioHotel.setBounds(230, 349, 150, 50);
		contentPane.add(btnComentarioHotel);
		
		JButton btnGestionarHotel = new JButton("GESTIONAR HOTELES");
		btnGestionarHotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VcrudHoteles cHotel = new VcrudHoteles(empleadoLogeado);
				cHotel.setVisible(true);
				dispose();
			}
		});
		btnGestionarHotel.setBounds(391, 349, 151, 50);
		contentPane.add(btnGestionarHotel);
		
		JButton btnHabitacionesLibres = new JButton("VER HABITACIONES LIBRES");
		btnHabitacionesLibres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VhabitacionesLibres hLibres = new VhabitacionesLibres();
				hLibres.setVisible(true);
				dispose();
			}
		});
		btnHabitacionesLibres.setBounds(69, 288, 230, 50);
		contentPane.add(btnHabitacionesLibres);
		
		JButton btnGestionarHabitacion = new JButton("GESTIONAR HABITACIONES");
		btnGestionarHabitacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VcrudHabitaciones cHab = new VcrudHabitaciones(empleadoLogeado);
				cHab.setVisible(true);
				dispose();
			}
		});
		btnGestionarHabitacion.setBounds(309, 288, 232, 50);
		contentPane.add(btnGestionarHabitacion);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vlogin login = new Vlogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(503, 11, 86, 24);
		contentPane.add(btnAtras);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 82, 473, 195);
		contentPane.add(panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.add(table);
	}
}
