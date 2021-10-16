package modelo;

import java.sql.SQLException;

import javax.swing.JComboBox;
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
	public void mostrar(Object salida, String id) {
		
	Conexion con = new Conexion();
		
	DefaultTableModel modelo = null;
	JTable jTable = null;
	JComboBox comboBox = null;
	
		if(salida instanceof JTable) {
			
			jTable = (JTable)salida;
			
			String[] columnNames = {"ID","NOMBRE","CIUDAD","DESCRIPCIÓN","DIRECCIÓN","TELÉFONO"};
			modelo = new DefaultTableModel(columnNames, 0);
			
		}
		else if(salida instanceof JComboBox) {
			comboBox = (JComboBox)salida;
		}
		
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
				
				if(salida instanceof JTable) {
					modelo.addRow(new Object[] {idHotel, nombre, ciudad, descripcion, telefono});
				}
				else if(salida instanceof JComboBox) {
					comboBox.addItem(nombre);
				}
				
				//empleados.add(new Empleado(id, nombre, apellidos, dni, fechaNac, poblacion, idHotel, usuario, null));
			}
			
			if(salida instanceof JTable) {
				jTable.setModel(modelo);
			}
			//return modelo;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			con.cerrarStmt();
			con.cerrarRs();
			con.cerrarCon();
		}

	}
	
	public static int obtenerIdHotelPorNombre(String nombre) {
		
		Conexion con = new Conexion();
		
		int idHotel = -1;
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT idHotel FROM thotel WHERE nombre = ?"));
			
			con.getStmt().setString(1, nombre);
			
			con.setRs();
			
			while(con.getRs().next()) {
				idHotel = con.getRs().getInt(1);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			con.cerrarStmt();
			con.cerrarRs();
			con.cerrarCon();
		}
		
		return idHotel;
	}
	
}
