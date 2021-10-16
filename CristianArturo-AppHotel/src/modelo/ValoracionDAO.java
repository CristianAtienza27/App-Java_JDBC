package modelo;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Conexion;
import datos.Valoracion;
import interfaces.ICrud;

public class ValoracionDAO implements ICrud{

	@Override
	public boolean insertar(Object obj) {
		
	Conexion con = new Conexion();
		
		try {
			
			Valoracion valoracion = (Valoracion)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("INSERT INTO `tvaloracion`(`idReserva`, `comentario`, `valoracion`) "
							+ "VALUES (?, ?, ?)"));
			
			con.getStmt().setInt(1, valoracion.getNumReserva());
			con.getStmt().setString(2, valoracion.getComentario());
			con.getStmt().setInt(3, valoracion.getValoracion());
			
			con.getStmt().executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Valoración registrada");
			
			return true;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally 
		{
			con.cerrarStmt();
			con.cerrarCon();	
		}
		
		return false;
	}

	@Override
	public boolean modificar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mostrar(Object table, String id) {
		
		Conexion con = new Conexion();
		
		String[] columnNames = {"CLIENTE","HABITACIÓN","HOTEL","COMENTARIO","VALORACIÓN"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
		
		JTable jTable = (JTable)table;
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT TC.nombre + ' '+ TC.apellidos, THA.tipo, THO.nombre, TV.comentario, TV.valoracion FROM tvaloracion TV INNER JOIN treserva TR "
							+ "ON TV.idReserva = TR.idReserva "
							+ "INNER JOIN tcliente TC ON TR.idReserva = TC.IdCliente "
							+ "INNER JOIN thabitacion THA ON TR.numHabitacion = THA.numHabitacion "
							+ "INNER JOIN thotel THO ON THA.idHotel = THO.idHotel"));
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				String cliente  = con.getRs().getString(1);
				String habitacion = con.getRs().getString(2);
				String hotel = con.getRs().getString(3);
				String comentario = con.getRs().getString(4);
				int valoracion = con.getRs().getInt(5);
				
				modelo.addRow(new Object[] {cliente, habitacion, hotel, comentario, valoracion});
				
				//empleados.add(new Empleado(id, nombre, apellidos, dni, fechaNac, poblacion, idHotel, usuario, null));
			}
			
			jTable.setModel(modelo);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			con.cerrarStmt();
			con.cerrarRs();
			con.cerrarCon();
		}

	}
	
}
