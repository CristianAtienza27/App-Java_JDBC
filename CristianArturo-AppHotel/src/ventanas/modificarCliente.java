package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class modificarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtPoblacion;
	private JTextField txtFechadeNacimiento;
	private JTextField txtDni;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificarCliente frame = new modificarCliente();
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
	public modificarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(58, 351, 142, 50);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setBounds(228, 351, 144, 50);
		contentPane.add(btnConfirmar);
		
		txtPoblacion = new JTextField();
		txtPoblacion.setColumns(10);
		txtPoblacion.setBounds(178, 248, 200, 20);
		contentPane.add(txtPoblacion);
		
		JLabel lblPoblacion = new JLabel("POBLACION");
		lblPoblacion.setBounds(58, 243, 120, 30);
		contentPane.add(lblPoblacion);
		
		txtFechadeNacimiento = new JTextField();
		txtFechadeNacimiento.setColumns(10);
		txtFechadeNacimiento.setBounds(178, 207, 200, 20);
		contentPane.add(txtFechadeNacimiento);
		
		JLabel lblFechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNacimiento.setBounds(58, 202, 120, 30);
		contentPane.add(lblFechaNacimiento);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(178, 166, 200, 20);
		contentPane.add(txtDni);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(58, 161, 120, 30);
		contentPane.add(lblDni);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(58, 120, 120, 30);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(178, 125, 200, 20);
		contentPane.add(txtApellido);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(178, 84, 200, 20);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(58, 79, 120, 30);
		contentPane.add(lblNombre);
		
		JLabel lblModificarCliente = new JLabel("MODIFICAR CLIENTE");
		lblModificarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblModificarCliente.setBounds(10, 11, 415, 50);
		contentPane.add(lblModificarCliente);
		setLocationRelativeTo(null);
		
		
	}

}
