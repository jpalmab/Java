package modelo;

public class Cliente
{
	// -------------------
	// ATRIBUTOS
	// -------------------

	private int codigo;

	private String nombre;

	private String apellido;

	private String celular;

	private int cedula;


	// -------------------
	// MÉTODOS
	// -------------------

	public int getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido() 
	{
		return apellido;
	}

	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

	public String getCelular() 
	{
		return celular;
	}

	public void setCelular(String celular)
	{
		this.celular = celular;
	}

	public int getCedula() 
	{
		return cedula;
	}

	public void setCedula(int cedula)
	{
		this.cedula = cedula;
	}


}
