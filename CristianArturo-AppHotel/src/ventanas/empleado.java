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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class empleado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					empleado frame = new empleado();
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
	public empleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblGestionEmpleado = new JLabel("GESTOR DEL EMPLEADO");
		lblGestionEmpleado.setBounds(10, 46, 424, 60);
		lblGestionEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGestionEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGestionEmpleado);
		
		JButton btnDatosP = new JButton("VER DATOS PERSONALES");
		btnDatosP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				datosPersonalesE dpe = new datosPersonalesE();
				dpe.setVisible(true);
				dispose();
			}
		});
		btnDatosP.setBounds(25, 118, 180, 50);
		contentPane.add(btnDatosP);
		
		JButton btnClienteHosp = new JButton("CLIENTES HOSPEDADOS");
		btnClienteHosp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clientesHospedados cHospedados = new clientesHospedados();
				cHospedados.setVisible(true);
				dispose();
			}
		});
		btnClienteHosp.setBounds(235, 117, 180, 50);
		contentPane.add(btnClienteHosp);
		
		JButton btnComentarios = new JButton("COMENTARIOS DE HOTELES");
		btnComentarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comentariosHoteles cHoteles = new comentariosHoteles();
				cHoteles.setVisible(true);
				dispose();
			}
		});
		btnComentarios.setBounds(235, 178, 180, 50);
		contentPane.add(btnComentarios);
		
		JButton btnHotel = new JButton("GESTIONAR HOTELES");
		btnHotel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crudHoteles cHotel = new crudHoteles();
				cHotel.setVisible(true);
				dispose();
			}
		});
		btnHotel.setBounds(25, 179, 180, 50);
		contentPane.add(btnHotel);
		
		JButton btnHabitacionesL = new JButton("VER HABITACIONES LIBRES");
		btnHabitacionesL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				habitacionesLibres hLibres = new habitacionesLibres();
				hLibres.setVisible(true);
				dispose();
			}
		});
		btnHabitacionesL.setBounds(232, 240, 183, 50);
		contentPane.add(btnHabitacionesL);
		
		JButton btnHabitacion = new JButton("GESTIONAR HABITACIONES");
		btnHabitacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crudHabitaciones cHab = new crudHabitaciones();
				cHab.setVisible(true);
				dispose();
			}
		});
		btnHabitacion.setBounds(25, 240, 180, 50);
		contentPane.add(btnHabitacion);
		
		JButton btnAtras = new JButton("SALIR");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login login = new login();
				login.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(338, 11, 86, 24);
		contentPane.add(btnAtras);
	}

}
