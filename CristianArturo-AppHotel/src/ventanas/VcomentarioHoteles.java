package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Empleado;
import modelo.HotelDAO;
import modelo.ValoracionDAO;

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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class VcomentarioHoteles extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Empleado empleado;
	JComboBox comboBox;
	private HotelDAO gestionHoteles;
	private ValoracionDAO gestionValoraciones;

	/**
	 * Create the frame.
	 */
	public VcomentarioHoteles(Empleado empleado) {
		
		CargarInterfazGrafica();
		
		this.empleado = empleado;
		gestionHoteles = new HotelDAO();
		gestionValoraciones = new ValoracionDAO();
		gestionHoteles.mostrar(comboBox, null);
		gestionValoraciones.mostrar(table, comboBox.getSelectedItem().toString());
		
		
	}
	
	public void CargarInterfazGrafica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VcomentarioHoteles.class.getResource("/Imagenes/hoteles.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
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
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
					
				gestionValoraciones.mostrar(table, comboBox.getSelectedItem().toString());
				
			}
		});
		comboBox.setBounds(182, 60, 89, 22);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 125, 714, 275);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 694, 253);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblAtras = new JLabel("");
		lblAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vempleado vEmpleado = new Vempleado(empleado);
				vEmpleado.setVisible(true);
				dispose();
			}
		});
		lblAtras.setIcon(new ImageIcon(VcomentarioHoteles.class.getResource("/Imagenes/backleftarrowoutlinesymbolinblackcircularbutton_104747.png")));
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setBounds(692, 11, 32, 32);
		contentPane.add(lblAtras);
	}
}
