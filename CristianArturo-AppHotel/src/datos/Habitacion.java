package datos;

public class Habitacion {
	private int numHab;
	private String tipo;
	private Double precioNoche;
	private String extras;
	
	public Habitacion(int numHab, String tipo, Double precioNoche, String extras) {
		this.numHab = numHab;
		this.tipo = tipo;
		this.precioNoche = precioNoche;
		this.extras = extras;
	}
	
	public Habitacion(int numHab) {
		this.numHab = numHab;
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
