package datos;

public class Reserva {
	
	private int numReserva;
	private int idCliente;
	private int idHotel;
	private int numHabitacion;
	private String fechaIni;
	private String fechaFin;
	
	public Reserva(int numReserva) {
		super();
		this.numReserva = numReserva;
	}
	
	public Reserva(int idHotel, int numHabitacion, String fechaIni, String fechaFin) {
		super();
		this.idHotel = idHotel;
		this.numHabitacion = numHabitacion;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
	}
	
	public Reserva(int numReserva, int idHotel, int numHabitacion, String fechaIni, String fechaFin) {
		super();
		this.numReserva = numReserva;
		this.idHotel = idHotel;
		this.numHabitacion = numHabitacion;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
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
	
	
	
}
