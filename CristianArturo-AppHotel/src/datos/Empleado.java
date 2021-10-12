package datos;

import java.util.Date;

public class Empleado extends Usuario{
	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String fecha_nac;
	private String poblacion;
	private int idHotel;
	
	public Empleado(int id) {
		super("","","");
		this.id = id;
	}
	
	public Empleado(int id, String nombre, String apellidos, String dni,
			String fecha_nac, String poblacion, int idHotel, String usuario, String contraseña) {
		super(usuario, contraseña, "empleado");
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fecha_nac = fecha_nac;
		this.poblacion = poblacion;
		this.idHotel = idHotel;
	}

	public Empleado(String nombre, String apellidos, String dni, String fecha_nac, 
			String poblacion, int idHotel,String usuario, String contraseña) {
		super(usuario, contraseña, "empleado");
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fecha_nac = fecha_nac;
		this.poblacion = poblacion;
		this.idHotel = idHotel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	
	
}
