package datos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reserva {
	
	private int numReserva;
	private int idCliente;
	private int idHotel;
	private String hotel;
	private int numHabitacion;
	private String fechaIni;
	private String fechaFin;
	private String fechaReserva;
	
	public Reserva(int numReserva) {
		this.numReserva = numReserva;
	}
	
	public Reserva(int idCliente, int idHotel, int numHabitacion, String fechaIni, String fechaFin) {
		super();
		this.idCliente = idCliente;
		this.idHotel = idHotel;
		this.numHabitacion = numHabitacion;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.fechaReserva = horaReserva();
	}
	
	public Reserva(int idCliente, int numReserva, int idHotel, int numHabitacion, String fechaIni, String fechaFin) {
		super();
		this.idCliente = idCliente;
		this.numReserva = numReserva;
		this.idHotel = idHotel;
		this.numHabitacion = numHabitacion;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.fechaReserva = horaReserva();
	}
	
	
	public Reserva(int numReserva, String hotel) {
		super();
		this.numReserva = numReserva;
		this.hotel = hotel;
	}

	
	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public int getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public int getNumHabitacion() {
		return numHabitacion;
	}
	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String horaReserva() {
		 DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
	     return dtf5.format(LocalDateTime.now());
	}

}
