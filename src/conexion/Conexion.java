package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    public static Connection conn;

    private static String USERNAME="";
    private static String PASSWORD="";
    private static String SERVER="";
    private static String PORT_NUMBER="";
    private static String DATABASE="";

    private Conexion(){
    }

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
