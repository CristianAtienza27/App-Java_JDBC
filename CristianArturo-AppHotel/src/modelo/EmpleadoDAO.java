package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Cliente;
import datos.Conexion;
import datos.Empleado;
import datos.Usuario;
import interfaces.ICrud;

public class EmpleadoDAO implements ICrud{
	
	@Override
	public boolean insertar(Object obj) {
		
		Conexion con = new Conexion();
		
		try {
			
			Empleado empleado = (Empleado)obj;
			
			con.setStmt(con.getConnection()
					.prepareCall("{CALL pInsertarEmpleado (?, ?, ?, ? ,? ,? ,? ,?, ?)}"));
			
			con.getStmt().setString(1, empleado.getNombre());
			con.getStmt().setString(2, empleado.getApellidos());
			con.getStmt().setString(3, empleado.getDni());
			con.getStmt().setString(4, empleado.getFecha_nac());
			con.getStmt().setString(5, empleado.getPoblacion());
			con.getStmt().setInt(6, empleado.getIdHotel());
			con.getStmt().setString(7, empleado.getUsuario());
			con.getStmt().setString(8, empleado.getContraseña());
			con.getStmt().setString(9, empleado.getRol());
			
			con.getStmt().executeUpdate();
		    
		    JOptionPane.showMessageDialog(null, "Registro con éxito");
		    
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
			
			Empleado empleado = (Empleado)obj;
			
			con.setStmt((con.getConnection()
					.prepareStatement("UPDATE tusuario SET `usuario` = ?, `contraseña` = ? "
							+ "WHERE `usuario` = (SELECT `usuario` FROM templeado WHERE `idEmpleado` = ?);")));
			
			con.getStmt().setString(1, empleado.getUsuario());
			con.getStmt().setString(2, empleado.getContraseña());
			con.getStmt().setInt(3, empleado.getId());
			
			con.getStmt().executeUpdate();
			
			con.setStmt((con.getConnection()
					.prepareStatement("UPDATE templeado SET `nombre` = ?, `apellidos` = ?, `DNI` = ?, `fechaNac` = ?,"
							+ " `poblacion` = ?, `idHotel` = ? "
							+ "WHERE idEmpleado = ?;")));
			
			con.getStmt().setString(1, empleado.getNombre());
			con.getStmt().setString(2, empleado.getApellidos());
			con.getStmt().setString(3, empleado.getDni());
			con.getStmt().setString(4, empleado.getFecha_nac());
			con.getStmt().setString(5, empleado.getPoblacion());
			con.getStmt().setInt(6, empleado.getIdHotel());
			con.getStmt().setInt(7, empleado.getId());

			
			con.getStmt().executeUpdate();
		    
		    JOptionPane.showMessageDialog(null, "Modificado con éxito");
		    
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
			
			Empleado empleado = (Empleado)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("DELETE FROM templeado WHERE idEmpleado = ?"));
			
			con.getStmt().setInt(1, empleado.getId());
			
			con.getStmt().executeUpdate();
		    
		    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
		    
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
	public void mostrar(Object table, String iD) {
		
		Conexion con = new Conexion();
		
		JTable JTable = (JTable)table;
		
		String[] columnNames = {"ID","NOMBRE","APELLIDOS","DNI","FECHA NACIMIENTO", "POBLACIÓN", "LUGAR DE TRABAJO"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
		
		try {
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT te.idEmpleado, te.nombre, te.apellidos, te.DNI, te.fechaNac, te.poblacion, th.nombre, te.usuario "
							+ "FROM templeado TE INNER JOIN thotel TH "
							+ "ON TE.idHotel = TH.idHotel "
							+ "INNER JOIN tusuario TU "
							+ "ON TE.usuario = TU.usuario;"));
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				int id = con.getRs().getInt(1);
				String nombre = con.getRs().getString(2);
				String apellidos = con.getRs().getString(3);
				String dni = con.getRs().getString(4);
				String fechaNac = con.getRs().getString(5);
				String poblacion = con.getRs().getString(6);
				String hotel = con.getRs().getString(7);
				String usuario = con.getRs().getString(8);
				
				modelo.addRow(new Object[] {id, nombre, apellidos, dni, fechaNac, poblacion, hotel, usuario});
				
				//empleados.add(new Empleado(id, nombre, apellidos, dni, fechaNac, poblacion, idHotel, usuario, null));
			}
			
			JTable.setModel(modelo);
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
	
	public static Empleado obtenerEmpleadoPorUsuario(String usuario) {
		
		Conexion con = new Conexion();
		
		try {
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT * FROM templeado WHERE usuario = ?"));
			
			con.getStmt().setString(1, usuario);
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				int id = con.getRs().getInt(1);
				String nombre = con.getRs().getString(2);
				String apellidos = con.getRs().getString(3);
				String dni = con.getRs().getString(4);
				String fechaNac = con.getRs().getString(5);
				String poblacion = con.getRs().getString(6);
				int idHotel = con.getRs().getInt(7);
				String user = con.getRs().getString(8);
				
				return new Empleado(id, nombre, apellidos, dni, fechaNac, poblacion, idHotel, user, "");
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			con.cerrarStmt();
			con.cerrarRs();
			con.cerrarCon();
		}
		
		return null;
	}
}
