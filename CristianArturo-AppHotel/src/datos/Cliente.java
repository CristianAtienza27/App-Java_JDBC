package datos;

import java.util.Date;

public class Cliente {
	private String nombre;
	private String apellidos;
	private String dni;
	private Date fecha_nac;
	private String imagen;
	
	public Cliente(String nombre, String apellidos, String dNI, Date fecha_nac, String imagen) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dNI;
		this.fecha_nac = fecha_nac;
		this.imagen = imagen;
	}	
	
	public Cliente(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dNI) {
		this.dni = dNI;
	}
	public Date getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
