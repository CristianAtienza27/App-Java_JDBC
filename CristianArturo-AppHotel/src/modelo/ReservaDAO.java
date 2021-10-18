package modelo;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
					.prepareStatement("INSERT INTO `treserva`(`IdCliente`, `numHabitacion`, `idHotel`, `fechaIni`, `fechaFin`,`fechaReserva`) "
							+ "VALUES (?, ?, ?, '" + reserva.getFechaIni() + "' , '" + reserva.getFechaFin() + "','" + reserva.getFechaReserva() + "')"));
			
			con.getStmt().setInt(1, reserva.getIdCliente());
			con.getStmt().setInt(2, reserva.getNumHabitacion());
			con.getStmt().setInt(3, reserva.getIdHotel());
			
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
		
		Reserva reserva = null;
		
		Conexion con = new Conexion();
		
		try {
			
			reserva = (Reserva)obj;
			
			if(!calcularPlazo24hr(reserva.getNumReserva())) {
				
				con.setStmt(con.getConnection()
						.prepareStatement("DELETE FROM `treserva` WHERE idReserva = ?"));
				
				con.getStmt().setInt(1, reserva.getNumReserva());
				
				con.getStmt().executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Reserva eliminada");
				
			}
			else {
				
				JOptionPane.showMessageDialog(null, "No es posible cancelar despues de 24 horas");
				
				return false;
				
			}
			
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
	
	public void buscarHabitacionesLibres(JTable table, int hotelSelec, String fechaIniSelec, String fechaFinSelec) {
	
	Conexion con = new Conexion();
		
		String[] columnNames = {"Nº HABITACION","HABITACIÓN","EXTRAS","PRECIO/NOCHE"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
		
		JTable jTable = (JTable)table;
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT numHabitacion, tipo, extras, precioNoche FROM thabitacion WHERE idHotel = ? "
							+ "AND numHabitacion NOT IN(SELECT numHabitacion FROM treserva WHERE idHotel = ?"
							+ " AND '" + fechaIniSelec + "' BETWEEN fechaIni AND fechaFin"
							+ " OR '" + fechaFinSelec + "' BETWEEN fechaIni and fechaFin)"));
			
			con.getStmt().setInt(1, hotelSelec);
			con.getStmt().setInt(2, hotelSelec);
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
	
	public static void verClientesHospedados(JTable tabla, int idHotel, String fecha) {
		
		Conexion con = new Conexion();
		
		String[] columnNames = {"NOMBRE","APELLIDOS","Nº HABITACIÓN","HABITACIÓN"};
		DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);

		try {
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT TC.nombre ,TC.apellidos, TR.numHabitacion, (SELECT tipo from thabitacion WHERE numHabitacion = TR.numHabitacion) , "
							+ "(SELECT nombre FROM thotel WHERE idHotel = TR.idHotel) "
							+ "FROM tcliente TC INNER JOIN treserva TR ON TC.IdCliente = TR.IdCliente "
							+ "WHERE TR.idHotel = ? AND '" + fecha + "' BETWEEN TR.fechaIni AND TR.fechaFin;"));
			
			con.getStmt().setInt(1, idHotel);
			
			con.setRs();
			
			while(con.getRs().next()) {
				
				String nombre = con.getRs().getString(1);
				String apellidos = con.getRs().getString(2);
				String habitacion = con.getRs().getString(3);
				String tipoHab = con.getRs().getString(4);
				
				modelo.addRow(new Object[] { nombre, apellidos , habitacion, tipoHab} );
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally
		{
			con.cerrarStmt();
			con.cerrarRs();
			con.cerrarCon();
		}
		
		tabla.setModel(modelo);
	}
	
	private String obtenerHoraReserva(int numReserva) {
		
		Conexion con = new Conexion();
		
		String horaReserva = null;
		
		try {
			
			con.setStmt(con.getConnection()
					.prepareStatement("SELECT fechaReserva FROM treserva WHERE idReserva = ?"));
			
			con.getStmt().setInt(1, numReserva);
			
			con.setRs();
			
			while(con.getRs().next()) {
				horaReserva = con.getRs().getString(1);
			}
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally {
			con.cerrarStmt();
			con.cerrarRs();
			con.cerrarCon();
		}
		
		return horaReserva;
	}
	
	public boolean calcularPlazo24hr(int numReserva) {
		
		String fechaReserva = obtenerHoraReserva(numReserva);
		
        Date fechaReser = null;
        Date fechaCancel = null;
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        
        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
      
        try {
        	
            fechaReser = formato.parse(fechaReserva);
            fechaCancel = formato.parse(dtf5.format(LocalDateTime.now())); 

        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        long dif = fechaReser.getTime() - fechaCancel.getTime();
                      
        TimeUnit time = TimeUnit.DAYS; 
        long diferencia = time.convert(dif, TimeUnit.MILLISECONDS);
		
        if(diferencia < -1) {
        	return true;
        }
        else {
    		return false;
        }
	
	}
	
}
