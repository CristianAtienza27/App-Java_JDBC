package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datos.Cliente;
import datos.Empleado;
import datos.Usuario;
import modelo.ClienteDAO;
import modelo.GestionUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Color;


public class Vlogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JComboBox cmbEntrar;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vlogin frame = new Vlogin();
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
	public Vlogin() {
		setForeground(SystemColor.activeCaption);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vlogin.class.getResource("/Imagenes/hoteles.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblLogin = new JLabel("INICIO DE SESION");
		lblLogin.setBounds(5, 5, 319, 50);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(62, 110, 92, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("CONTRASE\u00D1A");
		lblContraseña.setBounds(62, 160, 92, 20);
		contentPane.add(lblContraseña);
		

		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(161, 110, 115, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(161, 160, 115, 20);
		contentPane.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblCancelar.setIcon(new ImageIcon(Vlogin.class.getResource("/Imagenes/Cancelar_64.png")));
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setBounds(10, 310, 64, 64);
		contentPane.add(lblCancelar);
		
		JLabel lblEntrar = new JLabel("");
		lblEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionUsuario gestionUsuario = new GestionUsuario();
				
				try 
				{
					
					if(!txtUsuario.getText().equals("") || !txtContraseña.getText().equals("")){
						
						Usuario usuario = (Usuario) gestionUsuario.comprobarUsuario(new Usuario(txtUsuario.getText(), txtContraseña.getText()));
						
						if(usuario.getRol() == "cliente") {
	
							Vcliente ventanaCliente = new Vcliente((Cliente)usuario);	
							
							ventanaCliente.setVisible(true);
							dispose();
						}
						else if(usuario.getRol() == "empleado") {
							
							Vempleado ventanaEmpleado = new Vempleado((Empleado)usuario);
							
							ventanaEmpleado.setVisible(true);
							dispose();
							
						}
						else if(usuario.getRol() == "admin") {
							
							Vadmin ventanaAdmin = new Vadmin();
							
							ventanaAdmin.setVisible(true);
							dispose();
							
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Correo/contraseña no pueden ir vacíos");
					}
					
				}
				catch(Exception ex) 
				{
					JOptionPane.showMessageDialog(null, "Correo/contraseña incorrecta");
				}
			}
		});
		lblEntrar.setIcon(new ImageIcon(Vlogin.class.getResource("/Imagenes/confirmar_64.png")));
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setBounds(243, 310, 64, 64);
		contentPane.add(lblEntrar);
		
		JLabel lblNuevoCliente = new JLabel("");
		lblNuevoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VregistrarCliente nuevoC = new VregistrarCliente();
				nuevoC.setVisible(true);
				dispose();
			}
		});
		lblNuevoCliente.setIcon(new ImageIcon(Vlogin.class.getResource("/Imagenes/NuevoCliente_64.png")));
		lblNuevoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoCliente.setBounds(121, 191, 72, 72);
		contentPane.add(lblNuevoCliente);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(121, 274, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NUEVO CLIENTE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(103, 286, 115, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ENTRAR");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(243, 377, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("CANCELAR");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(5, 377, 69, 14);
		contentPane.add(lblNewLabel_2_1);
	}
}
