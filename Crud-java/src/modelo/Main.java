package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Johan Sebastian Palma Burgos
 *
 */
public class Main 
{
	// -------------------
	// MÉTODOS
	// -------------------
	
	//Creo el método para ejecutar el algoritmo
	public static void main(String[] args)
	{

		CrudCliente c = new CrudCliente();
		c.consultarCliente();
		c.agregarCliente(2, "ohan", "Palma", 313310871, 1124875);
		c.modificarCliente(2, "Johan", "Palma Burgos", "3133100710", 11267870);
		c.buscarCliente(2);
		c.eliminarCliente(2);
	}
}
