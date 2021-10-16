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
	public void mostrar(Object table, String id) {
		
	Conexion con = new Conexion();
		
		String[] columnNames = {"Nº RESERVA","HOTEL","HABITACIÓN","FECHA ENTRADA","FECHA SALIDA"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
		
		JTable jTable = (JTable)table;
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT TR.idReserva, THO.nombre, THA.tipo, TR.fechaIni, TR.fechaFin FROM tcliente TC INNER JOIN treserva TR\r\n"
							+ "ON TC.IdCliente = TR.IdCliente\r\n"
							+ "INNER JOIN thabitacion THA \r\n"
							+ "ON TR.numHabitacion = THA.numHabitacion\r\n"
							+ "INNER JOIN thotel THO \r\n"
							+ "ON THA.idHotel = THO.idHotel\r\n"
							+ "WHERE TC.usuario = ?"));
			
			con.getStmt().setString(1, id);
			
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
	
	public void buscarHabitacionesLibres(JTable table, String hotelSelec, String fechaIniSelec, String fechaFinSelec) {
	
	Conexion con = new Conexion();
		
		String[] columnNames = {"Nº HABITACION","HABITACIÓN","EXTRAS","PRECIO/NOCHE"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
		
		JTable jTable = (JTable)table;
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT THA.numHabitacion, THA.tipo, THA.extras, THA.precioNoche "
							+ "FROM thabitacion THA INNER JOIN thotel THO "
							+ "ON THA.idHotel = THO.idHotel "
							+ "WHERE THO.idHotel = ? AND THA.numHabitacion "
							+ "NOT IN (SELECT numHabitacion FROM treserva "
							+ "WHERE '2021-09-15' BETWEEN fechaIni AND fechaFin "
							+ "OR '2021-09-16' BETWEEN fechaIni AND fechaFin)"));
			
			con.getStmt().setString(1, hotelSelec);
			//con.getStmt().setString(2, fechaIniSelec);
			//con.getStmt().setString(3, fechaFinSelec);
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				int numHabitacion  = con.getRs().getInt(1);
				String habitacion = con.getRs().getString(2);
				String extras = con.getRs().getString(3);
				String precioNoche = con.getRs().getString(4);
				
				modelo.addRow(new Object[] {numHabitacion, habitacion, extras, precioNoche});
				
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
	
	private void verClientesHospedados() {
		
	}

}
