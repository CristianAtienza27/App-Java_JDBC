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
		
		CargarInterfazGrafica();
		gestionClientes = new ClienteDAO();		
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(60, 313, 120, 30);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(180, 318, 200, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(60, 354, 120, 30);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(180, 359, 200, 20);
		contentPane.add(txtApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(60, 395, 120, 30);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(180, 400, 200, 20);
		contentPane.add(txtDni);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNacimiento.setBounds(60, 442, 120, 30);
		contentPane.add(lblFechaNacimiento);
		
		JPanel panel = new JPanel();
		panel.setBounds(134, 72, 173, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(10, 5, 153, 148);
		panel.add(lblImagen);
		
		JLabel lblContraseña = new JLabel("CONTRASE\u00D1A");
		lblContraseña.setBounds(60, 511, 120, 30);
		contentPane.add(lblContraseña);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(180, 516, 200, 20);
		contentPane.add(txtContraseña);
		
		dtFechaNacimiento = new JDateChooser();
		dtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
		dtFechaNacimiento.setBounds(180, 442, 200, 20);
		contentPane.add(dtFechaNacimiento);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(180, 483, 200, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addMouseListener(new MouseAdapter() {
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
		btnConfirmar.setBounds(230, 552, 144, 50);
		contentPane.add(btnConfirmar);
		
		
		
		
		
		
		
		
		
		
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vlogin login = new Vlogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(60, 552, 142, 50);
		contentPane.add(btnCancelar);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setBounds(10, 11, 415, 50);
		contentPane.add(lblCliente);
		
		JButton btnAñadir = new JButton("A\u00D1ADIR");
		btnAñadir.setBounds(180, 247, 89, 23);
		contentPane.add(btnAñadir);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(60, 486, 49, 14);
		contentPane.add(lblNewLabel);
		
	}
	
	public String convertirFecha(JDateChooser dt) {
		
		String dia = Integer.toString(dt.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes =  Integer.toString(dt.getCalendar().get(Calendar.MONTH));
		String año =  Integer.toString(dt.getCalendar().get(Calendar.YEAR));
		
		return año + "-" + mes + "-" + dia;
		
	}

}
