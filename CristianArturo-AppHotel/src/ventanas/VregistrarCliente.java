package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import datos.Cliente;
import modelo.ClienteDAO;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class VregistrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtContraseña;
	private String fechaSeleccionada;
	private JDateChooser dtFechaNacimiento;
	
	private ClienteDAO gestionClientes;
	private JTextField txtUsuario;

	/**
	 * Create the frame.
	 */
	public VregistrarCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VregistrarCliente.class.getResource("/Imagenes/hoteles.png")));
		
		CargarInterfazGrafica();
		gestionClientes = new ClienteDAO();		
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 652);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(58, 281, 120, 30);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(178, 286, 200, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(58, 322, 120, 30);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(178, 327, 200, 20);
		contentPane.add(txtApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(58, 363, 120, 30);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(178, 368, 200, 20);
		contentPane.add(txtDni);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNacimiento.setBounds(58, 404, 120, 30);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblContraseña = new JLabel("CONTRASE\u00D1A");
		lblContraseña.setBounds(58, 479, 120, 25);
		contentPane.add(lblContraseña);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(178, 484, 200, 20);
		contentPane.add(txtContraseña);
		
		dtFechaNacimiento = new JDateChooser();
		dtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
		dtFechaNacimiento.setBounds(178, 410, 200, 20);
		contentPane.add(dtFechaNacimiento);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(178, 451, 200, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setBounds(10, 11, 415, 50);
		contentPane.add(lblCliente);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(58, 454, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vlogin login = new Vlogin();
				login.setVisible(true);
				dispose();
			}
		});
		lblCancelar.setIcon(new ImageIcon(VregistrarCliente.class.getResource("/Imagenes/Cancelar_96.png")));
		lblCancelar.setBounds(58, 515, 96, 96);
		contentPane.add(lblCancelar);
		
		JLabel lblConfirmar = new JLabel("");
		lblConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
Cliente cliente = null;
				
				if(!txtNombre.getText().equals("") || !txtApellido.getText().equals("") ||
				   !txtDni.getText().equals("") || !dtFechaNacimiento.getDate().toString().equals("") ||
				   !txtUsuario.getText().equals("") || !txtContraseña.getText().equals("")
				   ) 
				{
					
					try {
						
						cliente = new Cliente(
								txtNombre.getText(),
								txtApellido.getText(),
								txtDni.getText(),
								convertirFecha(dtFechaNacimiento),
								"URL:jejeje",
								txtUsuario.getText(),
								txtContraseña.getText()
								);
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error al crear un cliente");
					}
					
					if(cliente != null && gestionClientes.insertar(cliente)) {
						
						Vcliente ventanaCliente = new Vcliente(cliente);
						ventanaCliente.setVisible(true);
						dispose();
						
					}
				
				}
				else {
					JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
				}
			}
		});
		lblConfirmar.setIcon(new ImageIcon(VregistrarCliente.class.getResource("/Imagenes/Cnfirmar_96.png")));
		lblConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmar.setBounds(282, 515, 96, 96);
		contentPane.add(lblConfirmar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VregistrarCliente.class.getResource("/Imagenes/user_84308.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(154, 72, 128, 128);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(VregistrarCliente.class.getResource("/Imagenes/NuevoCliente_64.png")));
		lblNewLabel_2.setBounds(178, 203, 72, 72);
		contentPane.add(lblNewLabel_2);
		
	}
	
	public String convertirFecha(JDateChooser dt) {
		
		String dia = Integer.toString(dt.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes =  Integer.toString(dt.getCalendar().get(Calendar.MONTH));
		String año =  Integer.toString(dt.getCalendar().get(Calendar.YEAR));
		
		return año + "-" + mes + "-" + dia;
		
	}

}
