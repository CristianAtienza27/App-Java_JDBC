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
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Vempleado extends JFrame {

	private JPanel contentPane;
	
	private Empleado empleadoLogeado;
	private EmpleadoDAO gestionEmpleados;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public Vempleado(Empleado empleadoLogeado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vempleado.class.getResource("/Imagenes/hoteles.png")));
		CargarInterfazGrafica();
		this.empleadoLogeado = empleadoLogeado;
		gestionEmpleados = new EmpleadoDAO();
		gestionEmpleados.mostrar(table, empleadoLogeado.getUsuario());
		
		JLabel lblHabitacionesLibres = new JLabel("");
		lblHabitacionesLibres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VhabitacionesLibres hLibres = new VhabitacionesLibres(empleadoLogeado);
				hLibres.setVisible(true);
				dispose();
			}
		});
		lblHabitacionesLibres.setIcon(new ImageIcon(Vempleado.class.getResource("/Imagenes/room_icon_144154.png")));
		lblHabitacionesLibres.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitacionesLibres.setBounds(69, 315, 72, 72);
		contentPane.add(lblHabitacionesLibres);
		
		JLabel lblGestionarHabitacion = new JLabel("");
		lblGestionarHabitacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VcrudHabitaciones cHab = new VcrudHabitaciones(empleadoLogeado);
				cHab.setVisible(true);
				dispose();
			}
		});
		lblGestionarHabitacion.setIcon(new ImageIcon(Vempleado.class.getResource("/Imagenes/management_settings_icon_152229.png")));
		lblGestionarHabitacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarHabitacion.setBounds(220, 315, 72, 72);
		contentPane.add(lblGestionarHabitacion);
		
		JLabel lblClientesHospedados = new JLabel("");
		lblClientesHospedados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VclientesHospedados cHospedados = new VclientesHospedados(empleadoLogeado);
				cHospedados.setVisible(true);
				dispose();
			}
		});
		lblClientesHospedados.setIcon(new ImageIcon(Vempleado.class.getResource("/Imagenes/users_group_customers_clients_icon-icons.com_72448.png")));
		lblClientesHospedados.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientesHospedados.setBounds(353, 314, 72, 72);
		contentPane.add(lblClientesHospedados);
		
		JLabel lblComentarioHotel = new JLabel("");
		lblComentarioHotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VcomentarioHoteles cHoteles = new VcomentarioHoteles(empleadoLogeado);
				cHoteles.setVisible(true);
				dispose();
			}
		});
		lblComentarioHotel.setIcon(new ImageIcon(Vempleado.class.getResource("/Imagenes/comments_alt_icon_125319.png")));
		lblComentarioHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentarioHotel.setBounds(489, 315, 72, 72);
		contentPane.add(lblComentarioHotel);
		
		JLabel lblGestionarHotel = new JLabel("");
		lblGestionarHotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VcrudHoteles cHotel = new VcrudHoteles(empleadoLogeado);
				cHotel.setVisible(true);
				dispose();
			}
		});
		lblGestionarHotel.setIcon(new ImageIcon(Vempleado.class.getResource("/Imagenes/hotel-signal-of-capital-letter_icon-icons.com_70710.png")));
		lblGestionarHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarHotel.setBounds(633, 315, 72, 72);
		contentPane.add(lblGestionarHotel);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vlogin login = new Vlogin();
				login.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(Vempleado.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(750, 11, 32, 32);
		contentPane.add(lblAtras);
		
		JLabel lblNewLabel = new JLabel("HABITACIONES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 398, 115, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLibres = new JLabel("LIBRES");
		lblLibres.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLibres.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibres.setBounds(46, 412, 115, 14);
		contentPane.add(lblLibres);
		
		JLabel lblGestionar = new JLabel("GESTIONAR");
		lblGestionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGestionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionar.setBounds(199, 398, 115, 14);
		contentPane.add(lblGestionar);
		
		JLabel lblNewLabel_3 = new JLabel("HABITACIONES");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(199, 412, 115, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(334, 397, 115, 14);
		contentPane.add(lblClientes);
		
		JLabel lblHospedados = new JLabel("HOSPEDADOS");
		lblHospedados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHospedados.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospedados.setBounds(334, 412, 115, 14);
		contentPane.add(lblHospedados);
		
		JLabel lblComentarios = new JLabel("COMENTARIOS");
		lblComentarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComentarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentarios.setBounds(470, 398, 115, 14);
		contentPane.add(lblComentarios);
		
		JLabel lblDelHotel = new JLabel("DEL HOTEL");
		lblDelHotel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDelHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelHotel.setBounds(470, 412, 115, 14);
		contentPane.add(lblDelHotel);
		
		JLabel lblGestionar_1 = new JLabel("GESTIONAR");
		lblGestionar_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGestionar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionar_1.setBounds(610, 398, 115, 14);
		contentPane.add(lblGestionar_1);
		
		JLabel lblHoteles = new JLabel("HOTELES");
		lblHoteles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHoteles.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoteles.setBounds(610, 412, 115, 14);
		contentPane.add(lblHoteles);
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblGestionEmpleado = new JLabel("GESTOR DEL EMPLEADO");
		lblGestionEmpleado.setBounds(154, 11, 473, 60);
		lblGestionEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestionEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGestionEmpleado);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 82, 636, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 616, 200);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(table);
	}
}
