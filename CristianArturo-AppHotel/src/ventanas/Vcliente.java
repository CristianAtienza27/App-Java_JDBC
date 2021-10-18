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
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class Vcliente extends JFrame {

	private JPanel contentPane;
    public Cliente clienteLogeado;
    private ClienteDAO gestionClientes;
    private JLabel lblCliente;
    private JTable tablaCliente;

	/**
	 * Create the frame.
	 */
	public Vcliente(Cliente clienteLogeado) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vcliente.class.getResource("/Imagenes/hoteles.png")));
		
		CargarInterfazGrafica();
		
		this.clienteLogeado = clienteLogeado;
		
		gestionClientes = new ClienteDAO();
		gestionClientes.mostrar(tablaCliente, clienteLogeado.getUsuario());
		
		JLabel lblAtras = new JLabel("");
		lblAtras.setBounds(557, 11, 32, 32);
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vlogin login = new Vlogin();
				login.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(Vcliente.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblMisRevervas = new JLabel("");
		lblMisRevervas.setBounds(10, 244, 187, 141);
		lblMisRevervas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VmisReservas misReservas = new VmisReservas(clienteLogeado);
				misReservas.setVisible(true);
				dispose();
			}
		});
		lblMisRevervas.setIcon(new ImageIcon(Vcliente.class.getResource("/Imagenes/flexiblechagedatecalendarbooking_109688.png")));
		lblMisRevervas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblReservarHabitacion = new JLabel("");
		lblReservarHabitacion.setBounds(404, 244, 187, 141);
		lblReservarHabitacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VreservarHabitacion reservarHabitacion = new VreservarHabitacion(clienteLogeado);
				reservarHabitacion.setVisible(true);
				dispose();
			}
		});
		lblReservarHabitacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservarHabitacion.setIcon(new ImageIcon(Vcliente.class.getResource("/Imagenes/bed_bed_room_sleep_furniture_icon_124423.png")));
		
		JLabel lblModificarDatos = new JLabel("");
		lblModificarDatos.setBounds(207, 244, 187, 141);
		lblModificarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VregistrarCliente registrarCliente = new VregistrarCliente(clienteLogeado);
				registrarCliente.setVisible(true);
				dispose();
			}
		});
		lblModificarDatos.setIcon(new ImageIcon(Vcliente.class.getResource("/Imagenes/compose_edit_modify_icon_177769.png")));
		lblModificarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(422, 82, 169, 144);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon(Vcliente.class.getResource("/Imagenes/user_84308.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 94, 355, 89);
		
		scrollPane.setViewportView(tablaCliente);
		contentPane.setLayout(null);
		contentPane.add(lblCliente);
		contentPane.add(lblAtras);
		contentPane.add(scrollPane);
		contentPane.add(lblImagen);
		contentPane.add(lblMisRevervas);
		contentPane.add(lblModificarDatos);
		contentPane.add(lblReservarHabitacion);
		
		JLabel lblNewLabel = new JLabel("MIS RESERVAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 396, 187, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblModificarDatos_1 = new JLabel("MODIFICAR DATOS");
		lblModificarDatos_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModificarDatos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarDatos_1.setBounds(207, 396, 187, 14);
		contentPane.add(lblModificarDatos_1);
		
		JLabel lblReservarHabitacion_1 = new JLabel("RESERVAR HABITACION");
		lblReservarHabitacion_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReservarHabitacion_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservarHabitacion_1.setBounds(404, 396, 187, 14);
		contentPane.add(lblReservarHabitacion_1);
	
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		lblCliente = new JLabel("BIENVENIDO CLIENTE");
		lblCliente.setBounds(94, 11, 407, 60);
		lblCliente.setBackground(SystemColor.text);
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		tablaCliente = new JTable();
	}
}

