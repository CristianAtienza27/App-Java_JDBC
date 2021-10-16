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


public class VreservarHabitacion extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private HotelDAO gestionHotel;
	private JDateChooser dtFechaIni;
	private JDateChooser dtFechaFin;
	
	private Cliente cliente;
	private ReservaDAO gestionReserva;
	
	//private HabitacionDAO gestionHabitaciones;
	/**
	 * Create the frame.
	 */
	public VreservarHabitacion(Cliente cliente) {
		CargarInterfazGrafica();
		
		this.cliente = cliente;
		
		gestionHotel = new HotelDAO();
		gestionHotel.mostrar(comboBox, null);
		
		JButton btnReservar = new JButton("RESERVAR");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				gestionReserva = new ReservaDAO();
				
				if(gestionReserva.insertar(
						new Reserva(
								cliente.getId(),
								HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString()),
								Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()),
								convertirFecha(dtFechaIni),
								convertirFecha(dtFechaFin)
								))) {
					
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Error al hacer la reserva");
				}
				
				
				
			}
		});
		btnReservar.setBounds(318, 379, 89, 23);
		contentPane.add(btnReservar);
	
		//gestionHabitaciones = new HabitacionDAO();
		//gestionHabitaciones.mostrar(comboBox, getName());
	}
	
	public String convertirFecha(JDateChooser dt) {
		
		String dia = Integer.toString(dt.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes =  Integer.toString(dt.getCalendar().get(Calendar.MONTH));
		String año =  Integer.toString(dt.getCalendar().get(Calendar.YEAR));
		
		return año + "-" + mes + "-" + dia;
		
	}
	
	public void CargarInterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
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
		
		
		
		
		
		
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!comboBox.getSelectedItem().equals("") && !dtFechaIni.getDate().equals(null) && !dtFechaFin.getDate().equals(null)) {
					
					ReservaDAO gestionReserva = new ReservaDAO();
					
					gestionReserva.buscarHabitacionesLibres(
							table, 
							comboBox.getSelectedItem().toString(),
							convertirFecha(dtFechaIni),
							convertirFecha(dtFechaFin));
				}
				
			}
		});
		btnBuscar.setBounds(318, 103, 89, 23);
		contentPane.add(btnBuscar);
		
		
		
		
		
		
		
		
		JLabel lblReservarHabitacion = new JLabel("RESERVAR HABITACIONES");
		lblReservarHabitacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservarHabitacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReservarHabitacion.setBounds(69, 11, 556, 38);
		contentPane.add(lblReservarHabitacion);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 137, 714, 222);
		contentPane.add(panel);
		
		
		
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			
				
				
				
				
			}
		});
		panel.add(table);
		
		
		
		
		
		
		
		
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vcliente ventanaCliente = new Vcliente(cliente);
				ventanaCliente.setVisible(true);
				dispose();
				
			}
		});
		btnAtras.setBounds(635, 11, 89, 23);
		contentPane.add(btnAtras);
		
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
