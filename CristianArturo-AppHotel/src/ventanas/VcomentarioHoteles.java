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
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VcomentarioHoteles.class.getResource("/Imagenes/hoteles.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblComentarHoteles = new JLabel("COMENTAR HOTELES");
		lblComentarHoteles.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentarHoteles.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblComentarHoteles.setBounds(83, 11, 556, 38);
		contentPane.add(lblComentarHoteles);
		
		JLabel lblHotel = new JLabel("HOTEL");
		lblHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHotel.setBounds(83, 60, 89, 23);
		contentPane.add(lblHotel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(182, 60, 89, 22);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 200, 714, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 694, 178);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblBuscar.setIcon(new ImageIcon(VcomentarioHoteles.class.getResource("/Imagenes/1490129321-rounded10_82180.png")));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setBounds(321, 93, 96, 96);
		contentPane.add(lblBuscar);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vempleado empleado = new Vempleado(null);
				empleado.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(VcomentarioHoteles.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(692, 11, 32, 32);
		contentPane.add(lblAtras);
	}
}
