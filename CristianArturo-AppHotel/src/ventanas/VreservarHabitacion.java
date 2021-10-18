package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import datos.Cliente;
import datos.Reserva;
import modelo.HabitacionDAO;
import modelo.HotelDAO;
import modelo.ReservaDAO;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Color;


public class VreservarHabitacion extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private HotelDAO gestionHotel;
	private JDateChooser dtFechaIni;
	private JDateChooser dtFechaFin;
	
	private Cliente cliente;
	private ReservaDAO gestionReserva;
	private JTable table;
	
	//private HabitacionDAO gestionHabitaciones;
	/**
	 * Create the frame.
	 */
	public VreservarHabitacion(Cliente cliente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VreservarHabitacion.class.getResource("/Imagenes/hoteles.png")));
		CargarInterfazGrafica();
		
		this.cliente = cliente;
		
		gestionHotel = new HotelDAO();
		gestionHotel.mostrar(comboBox, null);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vcliente ventanaCliente = new Vcliente(cliente);
				ventanaCliente.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(VreservarHabitacion.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(692, 11, 32, 32);
		contentPane.add(lblAtras);
		
		JLabel lblReservar = new JLabel("");
		lblReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				gestionReserva = new ReservaDAO();
				
				if(!dtFechaIni.getDate().equals(null) && !dtFechaFin.getDate().equals(null)) {
					
					if(gestionReserva.insertar(
							new Reserva(
									cliente.getId(),
									HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString()),
									Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()),
									convertirFecha(dtFechaIni),
									convertirFecha(dtFechaFin)
									))) {
						
						VmisReservas vMisReservas = new VmisReservas(cliente);
						vMisReservas.setVisible(true);
						dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Error al hacer la reserva");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Introduce día de entrada y de salida");
				}
				
			}
		});
		lblReservar.setIcon(new ImageIcon(VreservarHabitacion.class.getResource("/Imagenes/confirmar_64.png")));
		lblReservar.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservar.setBounds(328, 346, 64, 64);
		contentPane.add(lblReservar);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(!comboBox.getSelectedItem().equals("") && !dtFechaIni.getDate().equals(null) && !dtFechaFin.getDate().equals(null)) {
					
					ReservaDAO gestionReserva = new ReservaDAO();
					
					gestionReserva.buscarHabitacionesLibres(
							table, 
							HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString()),
							convertirFecha(dtFechaIni),
							convertirFecha(dtFechaFin));
				}
				
			}
		});
		lblBuscar.setIcon(new ImageIcon(VreservarHabitacion.class.getResource("/Imagenes/1490129321-rounded10_82180.png")));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setBounds(328, 91, 64, 64);
		contentPane.add(lblBuscar);
		
		JLabel lblNewLabel = new JLabel("RESERVAR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(328, 416, 64, 14);
		contentPane.add(lblNewLabel);
	
		//gestionHabitaciones = new HabitacionDAO();
		//gestionHabitaciones.mostrar(comboBox, getName());
	}
	
	public String convertirFecha(JDateChooser dt) {
		
		String dia = Integer.toString(dt.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes =  Integer.toString(dt.getCalendar().get(Calendar.MONTH) + 1);
		String año =  Integer.toString(dt.getCalendar().get(Calendar.YEAR));
		
		return año + "-" + mes + "-" + dia;
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblHotel = new JLabel("HOTEL");
		lblHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHotel.setBounds(31, 60, 89, 23);
		contentPane.add(lblHotel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(130, 60, 89, 22);
		contentPane.add(comboBox);
		
		JLabel lblFechaIni = new JLabel("FECHA INICIO");
		lblFechaIni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaIni.setBounds(229, 60, 89, 23);
		contentPane.add(lblFechaIni);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaFin.setBounds(427, 60, 89, 23);
		contentPane.add(lblFechaFin);
		
		
		
		
		
		
		
		
		JLabel lblReservarHabitacion = new JLabel("RESERVAR HABITACIONES");
		lblReservarHabitacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservarHabitacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReservarHabitacion.setBounds(69, 11, 556, 38);
		contentPane.add(lblReservarHabitacion);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 166, 714, 169);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 694, 147);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(table);
		
		dtFechaIni = new JDateChooser();
		dtFechaIni.setDateFormatString("yyyy-MM-dd");
		dtFechaIni.setBounds(328, 63, 120, 20);
		contentPane.add(dtFechaIni);
		
		dtFechaFin = new JDateChooser();
		dtFechaFin.setDateFormatString("yyyy-MM-dd");
		dtFechaFin.setBounds(526, 63, 120, 20);
		contentPane.add(dtFechaFin);
	}
}
