package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private static String USERNAME="";
    private static String PASSWORD="";
    private static String SERVER="";
    private static String PORT_NUMBER="";
    private static String DATABASE="";

    public static Connection getConexion(){
        Properties connectionProps = new Properties();
        connectionProps.put("user", USERNAME);
        connectionProps.put("password", PASSWORD);

        String url = "jdbc:mysql://" + SERVER + ":" +
        PORT_NUMBER + "/" + DATABASE;

        try {
            return DriverManager.getConnection(url,connectionProps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }

    public static void cerrarConexion(Connection conn) {
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
