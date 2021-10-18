package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Cliente;
import datos.Reserva;
import datos.Valoracion;
import modelo.ValoracionDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Color;

public class VvalorarEstancia extends JFrame {

	private JPanel contentPane;
	private JTextField txtHotel;
	private JTextField txtComentario;
	private Reserva reserva;
	private Cliente cliente;
	private ValoracionDAO gestionValoracion;
	/**
	 * Create the frame.
	 */
	public VvalorarEstancia(Cliente cliente, Reserva reserva) {
		
		CargarInterfazGrafica();
		this.cliente = cliente;
		this.reserva = reserva;
		gestionValoracion = new ValoracionDAO();
		
		txtHotel.setText(reserva.getHotel());
		
		JLabel lblNewLabel = new JLabel("CONFIRMAR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(167, 434, 96, 14);
		contentPane.add(lblNewLabel);
		
	}
	
	public void CargarInterfazGrafica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VvalorarEstancia.class.getResource("/Imagenes/hoteles.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblValorarEstancia = new JLabel("VALORAR ESTANCIA");
		lblValorarEstancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorarEstancia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblValorarEstancia.setBounds(10, 45, 414, 43);
		contentPane.add(lblValorarEstancia);
		
		JLabel lblHotel = new JLabel("HOTEL");
		lblHotel.setBounds(47, 125, 120, 30);
		contentPane.add(lblHotel);
		
		txtHotel = new JTextField();
		txtHotel.setColumns(10);
		txtHotel.setBounds(167, 130, 200, 20);
		contentPane.add(txtHotel);
		
		JLabel lblComentario = new JLabel("COMENTARIO");
		lblComentario.setBounds(47, 166, 120, 30);
		contentPane.add(lblComentario);
		
		txtComentario = new JTextField();
		txtComentario.setColumns(10);
		txtComentario.setBounds(167, 171, 200, 68);
		contentPane.add(txtComentario);
		
		JLabel lblValoracion = new JLabel("VALORACION");
		lblValoracion.setBounds(47, 250, 120, 30);
		contentPane.add(lblValoracion);
		
		JSpinner txtValoracion = new JSpinner();
		txtValoracion.setBounds(167, 255, 200, 20);
		contentPane.add(txtValoracion);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vcliente vCliente = new Vcliente(cliente);
				vCliente.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(VvalorarEstancia.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(392, 11, 32, 32);
		contentPane.add(lblAtras);
		
		JLabel lblConfirmar = new JLabel("");
		lblConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!txtComentario.getText().equals("") || !txtValoracion.getValue().equals("")) {
					
					gestionValoracion.insertar(
							new Valoracion(
									reserva.getNumReserva(),
									txtComentario.getText(),
									Integer.parseInt(txtValoracion.getValue().toString())
									));
					
				}
				else {
					JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
				}
								
			}
		});
		lblConfirmar.setIcon(new ImageIcon(VvalorarEstancia.class.getResource("/Imagenes/Cnfirmar_96.png")));
		lblConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmar.setBounds(167, 327, 96, 96);
		contentPane.add(lblConfirmar);
	}
}
