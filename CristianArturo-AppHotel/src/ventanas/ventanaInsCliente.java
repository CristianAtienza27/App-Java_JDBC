package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import datos.Cliente;
import modelo.ClienteDAO;

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
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaInsCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtFechadeNacimiento;
	private JTextField txtImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaInsCliente frame = new ventanaInsCliente();
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
	public ventanaInsCliente() {
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(58, 79, 120, 30);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(178, 84, 200, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(58, 120, 120, 30);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(178, 125, 200, 20);
		contentPane.add(txtApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(58, 161, 120, 30);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(178, 166, 200, 20);
		contentPane.add(txtDni);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNacimiento.setBounds(58, 202, 120, 30);
		contentPane.add(lblFechaNacimiento);
		
		txtFechadeNacimiento = new JTextField();
		txtFechadeNacimiento.setColumns(10);
		txtFechadeNacimiento.setBounds(178, 207, 200, 20);
		contentPane.add(txtFechadeNacimiento);
		
		JLabel lblPoblacion = new JLabel("IMAGEN");
		lblPoblacion.setBounds(58, 243, 120, 30);
		contentPane.add(lblPoblacion);
		
		txtImagen = new JTextField();
		txtImagen.setColumns(10);
		txtImagen.setBounds(178, 248, 200, 20);
		contentPane.add(txtImagen);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClienteDAO gestionClientes = new ClienteDAO();
				
				if(gestionClientes.insertar(
								new Cliente(txtNombre.getText(),
											txtApellido.getText(),
											txtDni.getText(),
										    convertirFecha("1994-01-01"),
										    txtImagen.getText()
											))) {
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al insertar");
				}
				
				ventanaLogin login = new ventanaLogin();
				login.setVisible(true);
				dispose();
			}			
		});

		btnConfirmar.setBounds(228, 351, 144, 50);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaLogin login = new ventanaLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(58, 351, 142, 50);
		contentPane.add(btnCancelar);
		
		JLabel lblNuevoCliente = new JLabel("NUEVO CLIENTE");
		lblNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoCliente.setBounds(10, 11, 415, 50);
		contentPane.add(lblNuevoCliente);
	}
	
	public Date convertirFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
		Date fech = null;
		try {
			fech = formato.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fech;
	}
	
}
