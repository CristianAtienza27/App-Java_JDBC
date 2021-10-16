package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Cliente;
import modelo.ClienteDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Vcliente extends JFrame {

	private JPanel contentPane;
	public JTable tablaCliente;
    public Cliente clienteLogeado;
    private ClienteDAO gestionClientes;

	/**
	 * Create the frame.
	 */
	public Vcliente(Cliente clienteLogeado) {
		
		CargarInterfazGrafica();
		
		this.clienteLogeado = clienteLogeado;
		
		gestionClientes = new ClienteDAO();
		gestionClientes.mostrar(tablaCliente, clienteLogeado.getUsuario());
	
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblCliente = new JLabel("BIENVENIDO CLIENTE");
		lblCliente.setBounds(95, 11, 407, 60);
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblCliente);
		
		JButton btnModificar = new JButton("MODIFICAR MIS DATOS");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VregistrarCliente registrarCliente = new VregistrarCliente();
				registrarCliente.setVisible(true);
				dispose();
			}
		});
		btnModificar.setBounds(10, 299, 579, 50);
		contentPane.add(btnModificar);
		
		
		
		
		
		
		
		JButton btnReservarHabitacion = new JButton("RESERVAR UNA HABITACION");
		btnReservarHabitacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VreservarHabitacion reservarHabitacion = new VreservarHabitacion(clienteLogeado);
				reservarHabitacion.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		
		
		
		
		btnReservarHabitacion.setBounds(10, 360, 579, 50);
		contentPane.add(btnReservarHabitacion);
		
		JButton btnMisReservas = new JButton("MIS RESERVAS");
		btnMisReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VmisReservas misReservas = new VmisReservas(clienteLogeado);
				misReservas.setVisible(true);
				dispose();
			}
		});
		btnMisReservas.setBounds(10, 237, 579, 50);
		contentPane.add(btnMisReservas);
		
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
		panel.setBounds(10, 82, 400, 144);
		contentPane.add(panel);
		
		tablaCliente = new JTable();
		tablaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.add(tablaCliente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(420, 82, 169, 144);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(10, 11, 149, 122);
		panel_1.add(lblImagen);
	}
}
