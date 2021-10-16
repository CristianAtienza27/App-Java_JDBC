package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class VcomentarioHoteles extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VcomentarioHoteles frame = new VcomentarioHoteles();
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
	public VcomentarioHoteles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblComentarHoteles = new JLabel("COMENTAR HOTELES");
		lblComentarHoteles.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentarHoteles.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblComentarHoteles.setBounds(69, 11, 556, 38);
		contentPane.add(lblComentarHoteles);
		
		JLabel lblHotel = new JLabel("HOTEL");
		lblHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHotel.setBounds(69, 60, 89, 23);
		contentPane.add(lblHotel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(168, 60, 89, 22);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 137, 714, 263);
		contentPane.add(panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel.add(table);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vempleado empleado = new Vempleado(null);
				empleado.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(635, 11, 89, 23);
		contentPane.add(btnAtras);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(318, 103, 89, 23);
		contentPane.add(btnBuscar);
	}
}
