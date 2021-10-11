package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	private final String URL = "jdbc:mysql://localhost:3306/gestionhoteles";
	private final String USER = "root";
	private final String PASSWD = "";
	
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public Conexion(){
		try {		
			connection = DriverManager.getConnection(URL, USER, PASSWD);		
		} catch (SQLException e) {		
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection con) {
		this.connection = con;
	}

	public PreparedStatement getStmt() {
		return stmt;
	}

	public void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
		
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public void cerrarCon() {
		try {
			connection.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void cerrarStmt() {
		try {
			stmt.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void cerrarRs() {
		try {
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
