package datos;


public class Cliente extends Usuario{
	private int id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String fecha_nac;
	private String imagen;
	
	public Cliente(int id, String nombre, String apellidos, String dNI, String fecha_nac, String imagen, String usuario, String contraseña) {
		super(usuario,contraseña,"cliente");
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dNI;
		this.fecha_nac = fecha_nac;
		this.imagen = imagen;
	}	
	
	public Cliente(String nombre, String apellidos, String dNI, String fecha_nac, String imagen, String usuario, String contraseña) {
		super(usuario,contraseña,"cliente");
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dNI;
		this.fecha_nac = fecha_nac;
		this.imagen = imagen;
	}	
	
	
	public Cliente(int id) {
		super("","","");
		this.id = id;
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
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dNI) {
		this.dni = dNI;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
