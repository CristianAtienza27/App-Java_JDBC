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
		lblModificarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VregistrarCliente registrarCliente = new VregistrarCliente();
				registrarCliente.setVisible(true);
				dispose();
			}
		});
		lblModificarDatos.setIcon(new ImageIcon(Vcliente.class.getResource("/Imagenes/compose_edit_modify_icon_177769.png")));
		lblModificarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon(Vcliente.class.getResource("/Imagenes/user_84308.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(89)
					.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(lblAtras))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblMisRevervas, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblModificarDatos, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblReservarHabitacion, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAtras))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(lblImagen, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMisRevervas, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModificarDatos, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblReservarHabitacion, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
		);
		
		scrollPane.setViewportView(tablaCliente);
		contentPane.setLayout(gl_contentPane);
	
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 460);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		lblCliente = new JLabel("BIENVENIDO CLIENTE");
		lblCliente.setBackground(SystemColor.text);
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		tablaCliente = new JTable();
	}
}

