package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

public class VvalorarEstancia extends JFrame {

	private JPanel contentPane;
	private JTextField txtHotel;
	private JTextField txtComentario;
	private JTextField txtHabitacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VvalorarEstancia frame = new VvalorarEstancia();
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
	public VvalorarEstancia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VvalorarEstancia.class.getResource("/Imagenes/hoteles.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 520);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
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
		
		JLabel lblHabitacion = new JLabel("HABITACION");
		lblHabitacion.setBounds(47, 245, 120, 30);
		contentPane.add(lblHabitacion);
		
		txtHabitacion = new JTextField();
		txtHabitacion.setColumns(10);
		txtHabitacion.setBounds(167, 250, 200, 20);
		contentPane.add(txtHabitacion);
		
		JLabel lblValoracion = new JLabel("VALORACION");
		lblValoracion.setBounds(47, 276, 120, 30);
		contentPane.add(lblValoracion);
		
		JSpinner spnValoracion = new JSpinner();
		spnValoracion.setBounds(167, 281, 200, 20);
		contentPane.add(spnValoracion);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vcliente cliente = new Vcliente(null);
				cliente.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(VvalorarEstancia.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(392, 11, 32, 32);
		contentPane.add(lblAtras);
		
		JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblCancelar.setIcon(new ImageIcon(VvalorarEstancia.class.getResource("/Imagenes/Cancelar_96.png")));
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setBounds(47, 335, 96, 96);
		contentPane.add(lblCancelar);
		
		JLabel lblEntrar = new JLabel("");
		lblEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblEntrar.setIcon(new ImageIcon(VvalorarEstancia.class.getResource("/Imagenes/Cnfirmar_96.png")));
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setBounds(271, 335, 96, 96);
		contentPane.add(lblEntrar);
	}
}
