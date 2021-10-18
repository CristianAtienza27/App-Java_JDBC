package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Cliente;
import datos.Reserva;
import modelo.ClienteDAO;
import modelo.HotelDAO;
import modelo.ReservaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Color;

public class VmisReservas extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;
	private ReservaDAO misReservas;
	private Reserva miReserva;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VmisReservas(Cliente cliente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VmisReservas.class.getResource("/Imagenes/hoteles.png")));
		CargarInterfazGrafica();
		
		this.cliente = cliente;
		
		misReservas = new ReservaDAO();
		
		misReservas.mostrar(table, cliente.getUsuario());
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vcliente ventanaCliente = new Vcliente(cliente);
				ventanaCliente.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(VmisReservas.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(392, 11, 32, 32);
		contentPane.add(lblAtras);
		
		JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(table.getSelectedRowCount() != 0) {
					
					if(misReservas.eliminar(
							new Reserva(
									Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()))))
					{
						
						misReservas.mostrar(table, cliente.getUsuario());
						
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecciona una reserva");
				}
						
			}
		});
		lblCancelar.setIcon(new ImageIcon(VmisReservas.class.getResource("/Imagenes/cancelbutton_83661.png")));
		lblCancelar.setBounds(63, 422, 128, 128);
		contentPane.add(lblCancelar);
		
		JLabel lblValorar = new JLabel("");
		lblValorar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(table.getSelectedRow() != -1) {
					
					VvalorarEstancia valorarEstancia = new VvalorarEstancia(cliente, miReserva);
					valorarEstancia.setVisible(true);
					dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecciona una reserva");
				}
				
			}
		});
		lblValorar.setIcon(new ImageIcon(VmisReservas.class.getResource("/Imagenes/rate_favoriteapplicationstarratin_calificacion_aplicacionfavorita_2889.png")));
		lblValorar.setBounds(237, 422, 128, 128);
		contentPane.add(lblValorar);
		
		JLabel lblNewLabel = new JLabel("CANCELAR RESERVA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(63, 561, 128, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblValorarReserva = new JLabel("VALORAR RESERVA");
		lblValorarReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorarReserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorarReserva.setBounds(237, 561, 128, 14);
		contentPane.add(lblValorarReserva);
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
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
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 16, 394, 267);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(table.getSelectedRow() != -1) {
					
					miReserva = new Reserva(
							Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()),
							table.getValueAt(table.getSelectedRow(), 1).toString()
							);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecciona una reserva");
				}
					
			}
		});
		scrollPane.setViewportView(table);
	}

}
