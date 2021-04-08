package modelo;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CrudCliente 
{
	
	// -------------------
	// ATRIBUTOS
	// -------------------
	
	// Relación con la Clase ConexionMySQL
	ConexionMySQL bd = new ConexionMySQL();

	// Creo el objeto de tipo Cliente
	Cliente c = new Cliente();
	
	// -------------------
	// MÉTODOS
	// -------------------
	
	// Consulto los clientes de la base de datos
	public void consultarCliente()
	{
		try
		{
			String sql = "SELECT * FROM cliente";

			Statement statement = (Statement) bd.conectarMySQL().createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next())
			{
				String idCliente = result.getString("idCliente");
				String nombre = result.getString("nombre");
				String apellido = result.getString("apellido");
				String celular = result.getString("celular"); 
				String cedula = result.getString("cedula"); 

				String output = "%s - %s - %s - %s - %s";
				System.out.println(String.format(output, idCliente, nombre, apellido, celular, cedula));
			} 
		}
		catch(Exception e)
		{
			System.out.println("Error, Revisar Sentencia SQL");
		}
	}

	//Método que permite agregar un cliente de la base de datos
	public void agregarCliente(int pCodigo, String pNombre, String pApellido,int pCelular, int pCedula)
	{
		try 
		{
			c.setCodigo(pCodigo);
			c.setNombre(pNombre);
			c.setApellido(pApellido);
			c.setCedula(pCelular);
			c.setCedula(pCedula);

			String sql = "INSERT INTO cliente (idCliente, nombre, apellido, celular, cedula) VALUES (?, ?, ?, ?, ?) ";

			PreparedStatement statement = (PreparedStatement) bd.conectarMySQL().prepareStatement(sql);
			statement.setLong(1, c.getCodigo());
			statement.setString(2, c.getNombre());
			statement.setString(3, c.getApellido());
			statement.setString(4, c.getCelular());
			statement.setLong(5, (long) c.getCedula());

			int rowsInserted = statement.executeUpdate();

			if (rowsInserted > 0) 
			{
				JOptionPane.showMessageDialog(null,"Se agregó el Cliente con el código " + c.getCodigo() + " y el nombre " + c.getNombre());
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No se pudo agregar el cliente");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "El Cliente con ese código ya exíste");
		}
	}

	//Método que permite modificar un cliente de la base de datos
	public void modificarCliente(int pCodigo, String pNombre, String pApellido, String pCelular, int pCedula)
	{	
		try
		{		
			PreparedStatement updateEXP = (PreparedStatement)
					bd.conectarMySQL().prepareStatement("update`cliente` set `nombre`=?, `apellido`=?, `celular`=?, `cedula`=?  where `idCliente` = ?");

			c.setCodigo(pCodigo);
			c.setNombre(pNombre);
			c.setApellido(pApellido);
			c.setCelular(pCelular);
			c.setCedula(pCedula);

			updateEXP.setString(1, c.getNombre());
			updateEXP.setString(2, c.getApellido());    
			updateEXP.setString(3, c.getCelular()); 
			updateEXP.setLong(4, (long) c.getCedula());
			updateEXP.setLong(5, c.getCodigo());

			int updateEXP_done = updateEXP.executeUpdate(); 

			if (updateEXP_done > 0) 
			{
				JOptionPane.showMessageDialog(null,"Se modificó el Cliente con el código: " + c.getCodigo());
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"No se pudo modificar el Cliente con el código: " + c.getCodigo());
			}
		}
		catch(Exception e)
		{ 
			JOptionPane.showMessageDialog(null,"Error con las Sentencias SQL y/o el objeto Cliente");
		}
	}

	//Método que permite eliminar un cliente de la base de datos, dato el código del cliente
	public void eliminarCliente(int pCodigo)
	{
		try
		{			
			c.setCodigo(pCodigo);

			String sql = "DELETE FROM cliente WHERE idCliente=?";


			PreparedStatement statement = (PreparedStatement) bd.conectarMySQL().prepareStatement(sql);
			statement.setLong(1, c.getCodigo());

			int rowsDeleted = statement.executeUpdate();

			if (rowsDeleted > 0) 
			{
				JOptionPane.showMessageDialog(null,"Se eliminó el Cliente con el código: " + c.getCodigo());
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"No exíste el Cliente con el código: " + c.getCodigo());
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error en la sentencia SQL o en el objeto Cliente");
		} 
	}

	//Método que permite buscar un cliente de la base de datos por su cédula
	public String buscarCliente(int pCedula)
	{
		String s = "";
		try
		{
			String sql = "SELECT * FROM cliente";

			Statement statement = (Statement) bd.conectarMySQL().createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next())
			{
				String idCliente = result.getString("idCliente");
				String nombre = result.getString("nombre");
				String apellido = result.getString("apellido");
				String celular = result.getString("celular"); 
				String cedula = result.getString("cedula"); 

				String output = "%s - %s - %s - %s - %s";

				if(pCedula == Integer.parseInt(cedula))
				{
					s = "El cliente es: \n" + String.format(output, idCliente, nombre, apellido, celular, cedula);
				}
				else
				{ 
					s = "No existe el cliente con la cédula "+ pCedula;
				}

			} 
		}
		catch(Exception e)
		{
			s = "Error, Revisar Sentencia SQL";
		}
		JOptionPane.showMessageDialog(null, s);
		return s;
	}

}
