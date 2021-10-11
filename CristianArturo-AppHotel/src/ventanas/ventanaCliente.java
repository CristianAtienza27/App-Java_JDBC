package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaCliente frame = new ventanaCliente();
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
	public ventanaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("BIENVENIDO CLIENTE");
		lblCliente.setBounds(10, 46, 419, 60);
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblCliente);
		
		JButton btnModificar = new JButton("MODIFICAR DATOS");
		btnModificar.setBounds(25, 178, 180, 50);
		contentPane.add(btnModificar);
		
		JButton btnReservarH = new JButton("RESERVAR HABITACION");
		btnReservarH.setBounds(235, 117, 180, 50);
		contentPane.add(btnReservarH);
		
		JButton btnCanReserva = new JButton("CANCELAR RESERVA");
		btnCanReserva.setBounds(235, 178, 180, 50);
		contentPane.add(btnCanReserva);
		
		JButton btnVerDatos = new JButton("VER DATOS PERSONALES");
		btnVerDatos.setBounds(25, 117, 180, 50);
		contentPane.add(btnVerDatos);
		
		JButton btnValorar = new JButton("VALORAR HOTEL");
		btnValorar.setBounds(25, 239, 180, 50);
		contentPane.add(btnValorar);
		
		JButton btnHistorial = new JButton("HISTORIAL DE RESERVAS");
		btnHistorial.setBounds(235, 239, 180, 50);
		contentPane.add(btnHistorial);
		
		JButton btnAtras = new JButton("SALIR");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaLogin login = new ventanaLogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(338, 11, 86, 24);
		contentPane.add(btnAtras);
	}
}
