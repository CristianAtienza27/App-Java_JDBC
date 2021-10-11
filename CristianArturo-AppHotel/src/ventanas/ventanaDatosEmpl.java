package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ventanaDatosEmpl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaDatosEmpl frame = new ventanaDatosEmpl();
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
	public ventanaDatosEmpl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 60, 714, 300);
		contentPane.add(panel);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaEmpleado empleado = new ventanaEmpleado();
				empleado.setVisible(true);
				dispose();
			}
		});
		btnSalir.setBounds(323, 377, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lbldatosPersonalesE = new JLabel("DATOS PERSONALES DE LOS EMPLEADOS");
		lbldatosPersonalesE.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbldatosPersonalesE.setHorizontalAlignment(SwingConstants.CENTER);
		lbldatosPersonalesE.setBounds(10, 11, 714, 38);
		contentPane.add(lbldatosPersonalesE);
	}
}
