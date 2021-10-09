package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class registrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtFechadeNacimiento;
	private JTextField txtPoblacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCliente frame = new registrarCliente();
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
	public registrarCliente() {
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
		
		JLabel lblPoblacion = new JLabel("POBLACION");
		lblPoblacion.setBounds(58, 243, 120, 30);
		contentPane.add(lblPoblacion);
		
		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBounds(178, 248, 200, 20);
		contentPane.add(txtPoblacion);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login login = new login();
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
				login login = new login();
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
}
