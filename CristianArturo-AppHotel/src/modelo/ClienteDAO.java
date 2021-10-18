package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Cliente;
import datos.Conexion;

import interfaces.ICrud;

public class ClienteDAO implements ICrud{
	
	@Override
	public boolean insertar(Object obj) {
		
		Conexion con = new Conexion();
		
		try {
			
			Cliente cliente = (Cliente)obj;
			
			con.setStmt(con.getConnection()
					.prepareCall("{CALL pInsertarCliente (?, ?, ?, ?, ?, ?, ?, ?)}"));
			
		    con.getStmt().setString(1, cliente.getNombre());
		    con.getStmt().setString(2, cliente.getApellidos());
		    con.getStmt().setString(3, cliente.getDNI());
		    con.getStmt().setString(4,  cliente.getFecha_nac().toString());
		    con.getStmt().setString(5, cliente.getImagen());
		    con.getStmt().setString(6, cliente.getUsuario());
		    con.getStmt().setString(7, cliente.getContraseña());
			con.getStmt().setString(8, cliente.getRol());
		    
		    con.getStmt().executeUpdate();
		    
		    JOptionPane.showMessageDialog(null, "Registro con éxito");
		    
		    return true;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {	
			con.cerrarStmt();
			con.cerrarCon();	
		}
		
		return false;
	}

	@Override
	public boolean modificar(Object obj) {
		
		Conexion con = new Conexion();
		
		try {
			
			Cliente cliente = (Cliente)obj;
			
			con.setStmt((con.getConnection()
					.prepareStatement("UPDATE tusuario SET `usuario` = ?, `contraseña` = ? "
							+ "WHERE `usuario` = (SELECT `usuario` FROM tcliente WHERE `idCliente` = ?);")));
			
			con.getStmt().setString(1, cliente.getUsuario());
			con.getStmt().setString(2, cliente.getContraseña());
			con.getStmt().setInt(3, cliente.getId());
			
			con.getStmt().executeUpdate();
			
			con.setStmt(con.getConnection()
					.prepareStatement("UPDATE `tcliente` SET `nombre`= ?,`apellidos`= ?,`DNI`= ?,"
							+ "`fechaNac`= ?,`imagen`= ? WHERE `idCliente` = ?"));
			
		    con.getStmt().setString(1, cliente.getNombre());
		    con.getStmt().setString(2, cliente.getApellidos());
		    con.getStmt().setString(3, cliente.getDNI());
		    con.getStmt().setString(4,  cliente.getFecha_nac().toString());
		    con.getStmt().setString(5, cliente.getImagen());
			con.getStmt().setInt(6, cliente.getId());
			
			con.getStmt().executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Actualizado con éxito");
			
			return true;
		    
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			con.cerrarStmt();
			con.cerrarCon();
		}
		return false;
	}

	@Override
	public boolean eliminar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mostrar(Object tabla, String iD) {
		
		Conexion con = new Conexion();
		
		JTable jtable = (JTable)tabla;
		
		String[] columnNames = {"ID","NOMBRE","APELLIDOS","DNI","FECHA NACIMIENTO"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
		
		try {
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT * FROM tcliente WHERE usuario = ?"));
			
			con.getStmt().setString(1, iD);
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				int id = con.getRs().getInt(1);
				String nombre = con.getRs().getString(2);
				String apellidos = con.getRs().getString(3);
				String dni = con.getRs().getString(4);
				String fechaNac = con.getRs().getString(5);
				String imagen = con.getRs().getString(6);
				
				modelo.addRow(new Object[] {id, nombre, apellidos, dni, fechaNac });
				//clientes.add(new Cliente(id, nombre, apellidos, dni, fechaNac, imagen, null, null));
			}
			
			jtable.setModel(modelo);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			con.cerrarStmt();
			con.cerrarRs();
			con.cerrarCon();
		}

	}
	
	public static Cliente obtenerClientePorUsuario(String usuario) {
		
		Conexion con = new Conexion();
		
		try {
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT * FROM tcliente WHERE usuario = ?"));
			
			con.getStmt().setString(1, usuario);
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				int id = con.getRs().getInt(1);
				String nombre = con.getRs().getString(2);
				String apellidos = con.getRs().getString(3);
				String dni = con.getRs().getString(4);
				String fechaNac = con.getRs().getString(5);
				String imagen = con.getRs().getString(6);
				String user = con.getRs().getString(7);
				
				return new Cliente(id, nombre, apellidos, dni, fechaNac, imagen, user, null);
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
