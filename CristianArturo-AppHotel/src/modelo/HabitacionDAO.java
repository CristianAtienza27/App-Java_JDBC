package modelo;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Conexion;
import datos.Habitacion;
import interfaces.ICrud;

public class HabitacionDAO implements ICrud{

	@Override
	public boolean insertar(Object obj) {
		
		Conexion con = new Conexion();
		
		try {
			
			Habitacion habitacion = (Habitacion)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("INSERT INTO `thabitacion`(`idHotel`, `tipo`, `precioNoche`, `extras`) "
							+ "VALUES (?, ?, ?, ?, ?)"));
			
			con.getStmt().setInt(1, habitacion.getIdHotel());
			con.getStmt().setString(2, habitacion.getTipo());
			con.getStmt().setDouble(3, habitacion.getPrecioNoche());
			con.getStmt().setString(4, habitacion.getExtras());
			
			con.getStmt().executeUpdate();
			
		    JOptionPane.showMessageDialog(null, "Habitación añadida");
		    
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
		
		Conexion con = new Conexion();
		
		try {
			
			Habitacion habitacion = (Habitacion)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("UPDATE `thabitacion` SET `tipo`= ?,`precioNoche`= ?,`extras`= ?"
							+ " WHERE numHabitacion = ?"));
			
			con.getStmt().setString(1, habitacion.getTipo());
			con.getStmt().setDouble(2, habitacion.getPrecioNoche());
			con.getStmt().setString(3, habitacion.getExtras());
			con.getStmt().setInt(4, habitacion.getNumHab());
			
			con.getStmt().executeUpdate();
			
		    JOptionPane.showMessageDialog(null, "Habitación modificada");
		    
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
	public boolean eliminar(Object obj) {
		
		Conexion con = new Conexion();
		
		try {
			
			Habitacion habitacion = (Habitacion)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("DELETE FROM `thabitacion`"
							+ " WHERE numHabitacion = ?"));
			
			con.getStmt().setInt(1, habitacion.getNumHab());
			
			con.getStmt().executeUpdate();
			
		    JOptionPane.showMessageDialog(null, "Habitación eliminada");
		    
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
	public void mostrar(JTable table) {
		
		Conexion con = new Conexion();
		
		String[] columnNames = {"HOTEL","Nº HABITACION","TIPO","PRECIO/NOCHE","EXTRAS"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT THO.nombre, THA.numHabitacion, tha.tipo, tha.precioNoche, tha.extras "
							+ "FROM thabitacion THA INNER JOIN thotel THO "
							+ "ON THA.idHotel = THO.idHotel;"));
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				String hotel = con.getRs().getString(1);
				int numHabitacion  = con.getRs().getInt(2);
				String tipo = con.getRs().getString(3);
				Double precioNoche = con.getRs().getDouble(4);
				String extras = con.getRs().getString(5);
				
				modelo.addRow(new Object[] {hotel, numHabitacion, tipo, precioNoche, extras});
				
				//empleados.add(new Empleado(id, nombre, apellidos, dni, fechaNac, poblacion, idHotel, usuario, null));
			}
			
			table.setModel(modelo);
			
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
