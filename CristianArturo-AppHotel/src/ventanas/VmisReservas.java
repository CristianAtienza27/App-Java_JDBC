package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Cliente;
import modelo.ClienteDAO;
import modelo.ReservaDAO;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VmisReservas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Cliente cliente;
	private ReservaDAO misReservas;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VmisReservas(Cliente cliente) {
		CargarInterfazGrafica();
		
		this.cliente = cliente;
		
		misReservas = new ReservaDAO();
		misReservas.mostrar(table, cliente.getUsuario());
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblMisReservas = new JLabel("MIS RESERVAS");
		lblMisReservas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMisReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMisReservas.setBounds(10, 45, 414, 43);
		contentPane.add(lblMisReservas);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 99, 414, 294);
		contentPane.add(panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.add(table);
		
		JButton btnCancelarReserva = new JButton("CANCELAR RESERVA");
		btnCancelarReserva.setBounds(64, 424, 151, 68);
		contentPane.add(btnCancelarReserva);
		
		JButton btnValorarEstancia = new JButton("VALORAR ESTANCIA");
		btnValorarEstancia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VvalorarEstancia valorarEstancia = new VvalorarEstancia();
				valorarEstancia.setVisible(true);
				dispose();
			}
		});
		btnValorarEstancia.setBounds(225, 424, 151, 68);
		contentPane.add(btnValorarEstancia);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vcliente ventanaCliente = new Vcliente(cliente);
				ventanaCliente.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(340, 11, 89, 23);
		contentPane.add(btnAtras);
	}

}
