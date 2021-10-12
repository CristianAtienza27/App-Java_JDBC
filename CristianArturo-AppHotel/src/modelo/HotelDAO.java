package modelo;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Conexion;
import datos.Hotel;
import interfaces.ICrud;

public class HotelDAO implements ICrud{

	@Override
	public boolean insertar(Object obj) {
		
		Conexion con = new Conexion();
		
		try {
			
			Hotel hotel = (Hotel)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("INSERT INTO `thotel`(`nombre`, `ciudad`, `descripcion`, `direccion`, `telefono`)"
							+ " VALUES (?, ?, ?, ?, ?)"));
			
			con.getStmt().setString(1, hotel.getNombre());
			con.getStmt().setString(2, hotel.getCiudad());
			con.getStmt().setString(3, hotel.getDescripcion());
			con.getStmt().setString(4, hotel.getDireccion());
			con.getStmt().setString(5, hotel.getTelefono());
			
			con.getStmt().executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Hotel registrado");
			
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
			
			Hotel hotel = (Hotel)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("UPDATE `thotel` SET `nombre`= ?,`ciudad`= ?,"
							+ "`descripcion`= ?,`direccion`= ?,`telefono`=' ?"
							+ "WHERE idHotel = ?"));
			
			con.getStmt().setString(1, hotel.getNombre());
			con.getStmt().setString(2, hotel.getCiudad());
			con.getStmt().setString(3, hotel.getDescripcion());
			con.getStmt().setString(4, hotel.getDireccion());
			con.getStmt().setString(5, hotel.getTelefono());
			con.getStmt().setInt(6, hotel.getId());
			
			con.getStmt().executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Hotel modificado");
			
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
			
			Hotel hotel = (Hotel)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("DELETE FROM `thotel` WHERE idHotel = ?"));
			
			con.getStmt().setInt(1, hotel.getId());
			
			con.getStmt().executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Hotel eliminado");
			
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
		
		String[] columnNames = {"ID","NOMBRE","CIUDAD","DESCRIPCIÓN","DIRECCIÓN","TELÉFONO"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT * FROM thotel"));
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				int idHotel  = con.getRs().getInt(1);
				String nombre = con.getRs().getString(2);
				String ciudad = con.getRs().getString(3);
				String descripcion = con.getRs().getString(4);
				String telefono = con.getRs().getString(5);
				
				modelo.addRow(new Object[] {idHotel, nombre, ciudad, descripcion, telefono});
				
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
