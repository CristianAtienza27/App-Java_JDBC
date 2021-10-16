package datos;

public class Habitacion {
	private int numHab;
	private String tipo;
	private Double precioNoche;
	private String extras;
	private int idHotel;
	
	public Habitacion(int numHab, String tipo, Double precioNoche, String extras, int idHotel) {
		this.numHab = numHab;
		this.tipo = tipo;
		this.precioNoche = precioNoche;
		this.extras = extras;
		this.idHotel = idHotel;
	}
	

	
	public Habitacion(String tipo, Double precioNoche, String extras, int idHotel) {
		super();
		this.tipo = tipo;
		this.precioNoche = precioNoche;
		this.extras = extras;
		this.idHotel = idHotel;
	}



	public Habitacion(int idHotel, int numHab) {
		this.idHotel = idHotel;
		this.numHab = numHab;
	}
	
	
	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getNumHab() {
		return numHab;
	}
	public void setNumHab(int numHab) {
		this.numHab = numHab;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getPrecioNoche() {
		return precioNoche;
	}
	public void setPrecioNoche(Double precioNoche) {
		this.precioNoche = precioNoche;
	}
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	}
	
	
}
