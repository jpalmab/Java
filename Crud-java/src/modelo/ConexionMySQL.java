package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionMySQL
{
	// -------------------
	// ATRIBUTOS
	// -------------------
	
    // Librer�a de MySQL
    public String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "parqueaderodb";

    // Host
    public String hostname = "127.0.0.1";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";
    
	// -------------------
	// M�TODOS
	// -------------------

    public Connection conectarMySQL() 
    {
        Connection conn = null;
        try 
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);    
//            System.out.println("CONEXION EXITOSA");
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Conexi�n fallida con la base de datos");
        }
        return conn;
    }

}