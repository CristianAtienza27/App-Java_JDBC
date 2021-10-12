package modelo;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Conexion;
import datos.Hotel;
import datos.Reserva;
import interfaces.ICrud;

public class ReservaDAO implements ICrud{

	@Override
	public boolean insertar(Object obj) {
		
		Conexion con = new Conexion();
		
		try {
			
			Reserva reserva = (Reserva)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("INSERT INTO `treserva`(`IdCliente`, `numHabitacion`, `idHotel`, `fechaIni`, `fechaFin`) "
							+ "VALUES (?, ?, ?, ?, ?)"));
			
			con.getStmt().setInt(1, reserva.getIdCliente());
			con.getStmt().setInt(2, reserva.getNumHabitacion());
			con.getStmt().setInt(3, reserva.getIdHotel());
			con.getStmt().setString(4, reserva.getFechaIni());
			con.getStmt().setString(5, reserva.getFechaFin());
			
			con.getStmt().executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Reserva confirmada");
			
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
			
			Reserva reserva = (Reserva)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("UPDATE `treserva` SET `IdCliente`= ?,`numHabitacion`= ?,"
							+ "`idHotel`= ?,`fechaIni`= ?,`fechaFin`= ? "
							+ "WHERE idReserva = ?"));
			
			con.getStmt().setInt(1, reserva.getIdCliente());
			con.getStmt().setInt(2, reserva.getNumHabitacion());
			con.getStmt().setInt(3, reserva.getIdHotel());
			con.getStmt().setString(4, reserva.getFechaIni());
			con.getStmt().setString(5, reserva.getFechaFin());
			con.getStmt().setInt(6, reserva.getNumReserva());
			
			con.getStmt().executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Reserva modificada");
			
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
			
			Reserva reserva = (Reserva)obj;
			
			con.setStmt(con.getConnection()
					.prepareStatement("DELETE FROM `treserva` WHERE idReserva = ?"));
			
			con.getStmt().setInt(1, reserva.getNumReserva());
			
			con.getStmt().executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Reserva eliminada");
			
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
		
		String[] columnNames = {"Nº RESERVA","HOTEL","HABITACIÓN","FECHA ENTRADA","FECHA SALIDA"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT TR.idReserva, TH.nombre, THA.tipo, TR.fechaIni, TR.fechaFin "
							+ "FROM treserva TR INNER JOIN tcliente TC ON TR.IdCliente = TC.IdCliente "
							+ "INNER JOIN THOTEL TH ON TR.idHotel = TH.idHotel "
							+ "INNER JOIN thabitacion THA ON THA.idHotel = TH.idHotel;"));
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				int idReserva  = con.getRs().getInt(1);
				String hotel = con.getRs().getString(2);
				String habitacion = con.getRs().getString(3);
				String fechaIni = con.getRs().getString(4);
				String fechaFin = con.getRs().getString(5);
				
				modelo.addRow(new Object[] {idReserva, hotel, habitacion, fechaIni, fechaFin});
				
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
