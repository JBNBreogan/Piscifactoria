package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import helpers.ErrorHelper;

public class Conexion {
    /**Objeto para la conexion a la base de datos*/
    public static Connection conn;
    /**Nombre de usuario de la base de datos */
    private static String USERNAME="niglesias0";
    /**Contraseña del usuario para la base de datos */
    private static String PASSWORD="abc123.";
    /**Direccion ip del servidor donde esta la base de datos */
    private static String SERVER="213.32.47.44";
    /**Puerto de la base de datos */
    private static String PORT_NUMBER="3306";
    /**Nombre de la base de datos */
    private static String DATABASE="pescaditos";

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
                                DATABASE +
                                "?rewriteBatchedStatements=true",
                                connectionProps);
            } catch (SQLException e) {
                ErrorHelper.writeError("Error al crear la conexion a la base de datos");
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
            } catch(SQLException e) {
                ErrorHelper.writeError("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }

}
