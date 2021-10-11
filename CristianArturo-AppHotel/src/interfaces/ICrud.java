package interfaces;

import java.util.List;

import javax.swing.JTable;

import datos.Cliente;

public interface ICrud {
	public boolean insertar(Object obj);
	public boolean modificar(Object obj);
	public boolean eliminar(Object obj);
	public List<Object> mostrar(JTable table);
}
