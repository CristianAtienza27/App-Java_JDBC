package modelo;

import java.sql.SQLException;

import datos.Conexion;
import datos.Usuario;

public class GestionUsuario {
	
	public Object comprobarUsuario(Usuario usuario) {
		
		Conexion con = new Conexion();
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT * FROM `tusuario` WHERE usuario = ? AND contraseña = ?"));
			
			con.getStmt().setString(1, usuario.getUsuario());
			con.getStmt().setString(2, usuario.getContraseña());
			
			con.setRs();
			
			if(con.getRs().next()) {
				usuario.setRol(con.getRs().getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally
		{
			 
			con.cerrarRs();
			con.cerrarStmt();
			con.cerrarCon();
		}
		
		return obtenerUsuario(usuario);	
		
	}
	
	protected Object obtenerUsuario(Usuario usuario) {
		
		switch(usuario.getRol()) {
		case "cliente":
			return ClienteDAO.obtenerClientePorUsuario(usuario.getUsuario());
			
		case "empleado":
			return EmpleadoDAO.obtenerEmpleadoPorUsuario(usuario.getUsuario());

		case "admin":
			return new Usuario("admin","admin","admin");
		}
		
		return null;
		
	}
	
}
