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
		lblHabitacionesLibres.setBounds(192, 314, 72, 72);
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
		lblGestionarHabitacion.setBounds(271, 314, 72, 72);
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
		lblComentarioHotel.setBounds(435, 314, 72, 72);
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
		lblGestionarHotel.setBounds(517, 314, 72, 72);
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
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
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
