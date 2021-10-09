package interfaces;

import java.util.List;

import datos.Cliente;

public interface ICliente {
	public boolean insertar(Cliente cliente);
	public boolean modificar(Cliente cliente);
	public boolean eliminar(Cliente cliente);
	public List<Cliente> listaClientes;
}
