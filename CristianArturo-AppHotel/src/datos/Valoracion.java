package datos;

public class Valoracion {
	private int numReserva;
	private String comentario;
	private int valoracion;
	
	public Valoracion(int numReserva, String comentario, int valoracion) {
		super();
		this.numReserva = numReserva;
		this.comentario = comentario;
		this.valoracion = valoracion;
	}
	
	public int getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
}
