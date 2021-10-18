package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import datos.Empleado;
import modelo.HotelDAO;
import modelo.ReservaDAO;

import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;


public class VhabitacionesLibres extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private Empleado empleado;
	private ReservaDAO gestionReservas;
	private HotelDAO gestionHoteles;

	/**
	 * Create the frame.
	 */
	public VhabitacionesLibres(Empleado empleado) {
		CargarInterfazGrafica();
		
		this.empleado = empleado;
		gestionReservas = new ReservaDAO();
		gestionHoteles = new HotelDAO();
		
		gestionHoteles.mostrar(comboBox, null);
		
	}
	
	
	public void CargarInterfazGrafica() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(VhabitacionesLibres.class.getResource("/Imagenes/hoteles.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 137, 714, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 694, 241);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblHabitacionesLibres = new JLabel("HABITACIONES LIBRES");
		lblHabitacionesLibres.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHabitacionesLibres.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitacionesLibres.setBounds(56, 11, 626, 38);
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
		
		comboBox = new JComboBox();
		comboBox.setBounds(220, 60, 113, 22);
		contentPane.add(comboBox);
		
		JDateChooser dtFechaIni = new JDateChooser();
		dtFechaIni.setDateFormatString("yyyy-MM-dd");
		dtFechaIni.setBounds(442, 60, 120, 20);
		contentPane.add(dtFechaIni);
		
		JDateChooser dtFechaFin = new JDateChooser();
		dtFechaFin.setDateFormatString("yyyy-MM-dd");
		dtFechaFin.setBounds(442, 94, 120, 20);
		contentPane.add(dtFechaFin);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vempleado vEmpleado = new Vempleado(empleado);
				vEmpleado.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(VhabitacionesLibres.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(692, 11, 32, 32);
		contentPane.add(lblAtras);
		
		
		
		
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(dtFechaIni.getCalendar() != null || dtFechaFin.getCalendar() != null) {
					gestionReservas.buscarHabitacionesLibres(
							table,
							HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString()), 
							convertirFecha(dtFechaIni),
							convertirFecha(dtFechaFin));
				}	
				else {
					JOptionPane.showMessageDialog(null, "Selecciona el día de entrada y de salida");
				}
				
			}
			
		});
		lblBuscar.setIcon(new ImageIcon(VhabitacionesLibres.class.getResource("/Imagenes/1490129321-rounded10_82180.png")));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setBounds(56, 30, 96, 96);
		contentPane.add(lblBuscar);

	}

	public String convertirFecha(JDateChooser dt) {
		
		String dia = Integer.toString(dt.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes =  Integer.toString(dt.getCalendar().get(Calendar.MONTH) + 1);
		String año =  Integer.toString(dt.getCalendar().get(Calendar.YEAR));
		
		return año + "-" + mes + "-" + dia;
		
	}
}

