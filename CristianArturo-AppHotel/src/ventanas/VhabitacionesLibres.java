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


public class VhabitacionesLibres extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public VhabitacionesLibres() {
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
		
		JLabel lblHabitacionesLibres = new JLabel("HABITACIONES LIBRES");
		lblHabitacionesLibres.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHabitacionesLibres.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitacionesLibres.setBounds(10, 11, 714, 38);
		contentPane.add(lblHabitacionesLibres);
		
		JLabel lblHotel = new JLabel("HOTEL");
		lblHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHotel.setBounds(121, 60, 89, 23);
		contentPane.add(lblHotel);
		
		JLabel lblFechaIni = new JLabel("FECHA INICIO");
		lblFechaIni.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaIni.setBounds(343, 60, 89, 23);
		contentPane.add(lblFechaIni);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaFin.setBounds(343, 94, 89, 23);
		contentPane.add(lblFechaFin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(220, 60, 113, 22);
		contentPane.add(comboBox);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(220, 94, 89, 23);
		contentPane.add(btnBuscar);
		
		JDateChooser dtFechaIni = new JDateChooser();
		dtFechaIni.setDateFormatString("yyyy-MM-dd");
		dtFechaIni.setBounds(442, 60, 120, 20);
		contentPane.add(dtFechaIni);
		
		JDateChooser dtFechaFin = new JDateChooser();
		dtFechaFin.setDateFormatString("yyyy-MM-dd");
		dtFechaFin.setBounds(442, 94, 120, 20);
		contentPane.add(dtFechaFin);

	}
}
