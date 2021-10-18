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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import datos.Empleado;
import modelo.HotelDAO;
import modelo.ReservaDAO;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JScrollPane;



public class VclientesHospedados extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private Empleado empleado;
	private HotelDAO gestionHoteles;

	/**
	 * Create the frame.
	 */
	public VclientesHospedados(Empleado empleado) {
		
		CargarInterfazGrafica();
		
		this.empleado = empleado;
		gestionHoteles = new HotelDAO();
		gestionHoteles.mostrar(comboBox, null);

	}
	
	public void CargarInterfazGrafica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VclientesHospedados.class.getResource("/Imagenes/hoteles.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
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
		
		JLabel lblClientesHospedados = new JLabel("CLIENTES HOSPEDADOS");
		lblClientesHospedados.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClientesHospedados.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientesHospedados.setBounds(31, 11, 651, 38);
		contentPane.add(lblClientesHospedados);
		
		JLabel lblHotel = new JLabel("HOTEL");
		lblHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHotel.setBounds(115, 60, 89, 23);
		contentPane.add(lblHotel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(214, 60, 89, 22);
		contentPane.add(comboBox);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(313, 60, 89, 23);
		contentPane.add(lblFecha);
		
		JDateChooser dtFechaClienteHospedado = new JDateChooser();
		dtFechaClienteHospedado.setDateFormatString("yyyy-MM-dd");
		dtFechaClienteHospedado.setBounds(412, 60, 130, 20);
		contentPane.add(dtFechaClienteHospedado);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ReservaDAO.verClientesHospedados(
						table, 
						HotelDAO.obtenerIdHotelPorNombre(comboBox.getSelectedItem().toString()),
						convertirFecha(dtFechaClienteHospedado));
				
			}
		});
		lblBuscar.setIcon(new ImageIcon(VclientesHospedados.class.getResource("/Imagenes/1490129321-rounded10_82180.png")));
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setBounds(306, 93, 96, 96);
		contentPane.add(lblBuscar);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vempleado vEmpleado = new Vempleado(empleado);
				vEmpleado.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(VclientesHospedados.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(692, 11, 32, 32);
		contentPane.add(lblAtras);

	}
	
	public String convertirFecha(JDateChooser dt) {
		
		String dia = Integer.toString(dt.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes =  Integer.toString(dt.getCalendar().get(Calendar.MONTH) + 1);
		String año =  Integer.toString(dt.getCalendar().get(Calendar.YEAR));
		
		return año + "-" + mes + "-" + dia;
		
	}
}
