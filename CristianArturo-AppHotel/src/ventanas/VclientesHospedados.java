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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;



public class VclientesHospedados extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VclientesHospedados frame = new VclientesHospedados();
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
	public VclientesHospedados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
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
		
		JLabel lblClientesHospedados = new JLabel("CLIENTES HOSPEDADOS");
		lblClientesHospedados.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClientesHospedados.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientesHospedados.setBounds(10, 11, 714, 38);
		contentPane.add(lblClientesHospedados);
		
		JLabel lblHotel = new JLabel("HOTEL");
		lblHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHotel.setBounds(115, 60, 89, 23);
		contentPane.add(lblHotel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(214, 60, 89, 22);
		contentPane.add(comboBox);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(313, 60, 89, 23);
		contentPane.add(lblFecha);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(315, 103, 89, 23);
		contentPane.add(btnBuscar);
		
		JDateChooser dtFechaClienteHospedado = new JDateChooser();
		dtFechaClienteHospedado.setDateFormatString("yyyy-MM-dd");
		dtFechaClienteHospedado.setBounds(412, 60, 130, 20);
		contentPane.add(dtFechaClienteHospedado);

		

	}
}
