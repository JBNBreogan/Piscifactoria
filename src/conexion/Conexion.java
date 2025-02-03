package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    /**Objeto para la conexion a la base de datos*/
    public static Connection conn;
    /**Nombre de usuario de la base de datos */
    private static String USERNAME="";
    /**Contraseña del usuario para la base de datos */
    private static String PASSWORD="";
    /**Direccion ip del servidor donde esta la base de datos */
    private static String SERVER="";
    /**Puerto de la base de datos */
    private static String PORT_NUMBER="";
    /**Nombre de la base de datos */
    private static String DATABASE="";

    /**
     * Constructor vacio de la clase conexion
     */
    private Conexion(){
    }

    /**
     * Método que en caso de no existir crea la conexion a la base de datos
     * y en que caso de que ya exista la devuelve.
     * @return El objeto de conexion a la base de datos.
     */
    public static Connection getConexion() {
        if (conn == null) {
            try {
                Properties connectionProps = new Properties();
                connectionProps.put("user", USERNAME);
                connectionProps.put("password", PASSWORD);

                conn = DriverManager.getConnection(
                                "jdbc:mysql://" + 
                                SERVER + 
                                ":" + PORT_NUMBER + "/" + 
                                DATABASE,
                                connectionProps);
            } catch (SQLException e) {
                System.out.println("Error al crear la conexion a la base de datos");
            }
        }
        return conn;
    }

    /**
     * Método que cierra la conexion a la base de datos.
     */
    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch(SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

}
