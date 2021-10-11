package modelo;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

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
					.prepareStatement("INSERT INTO `tcliente`(`nombre`, `apellidos`, `DNI`, `fechaNac`, `imagen`) "
							+ "VALUES (?,?,?,?,?)"));
			
		    con.getStmt().setString(1, cliente.getNombre());
		    con.getStmt().setString(2, cliente.getApellidos());
		    con.getStmt().setString(3, cliente.getDNI());
		    con.getStmt().setString(4,  cliente.getFecha_nac().toString());
		    con.getStmt().setString(5, cliente.getImagen());
			
		    con.getStmt().execute();
		    
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> mostrar(JTable table) {
		// TODO Auto-generated method stub
		return null;
	}

}
