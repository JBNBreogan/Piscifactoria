package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import helpers.ErrorHelper;
import propiedades.AlmacenPropiedades;

/**
 * Clase encargada de la generación y manipulación de la base de datos.
 * Contiene métodos para crear tablas e insertar datos iniciales.
 */
public class GeneradorBD {

    /**
     * Atributo para almacenar la conexión.
     */
    private Connection con = Conexion.getConexion();

     /**
     * Crea las tablas Cliente, Pez y Pedido en la base de datos si no existen.
     */
    public void crearTablas() {
       // String crear = "CREATE DATABASE IF NOT EXISTS pescaditos";
       // String borrar = "DROP DATABASE pescaditos;";
        String usar = "USE pescaditos";

        String tablaClientes = "CREATE TABLE IF NOT EXISTS Cliente (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(255) NOT NULL, " +
                "nif VARCHAR(9) UNIQUE NOT NULL, " +
                "telefono VARCHAR(9) NOT NULL" +
                ");";

        String tablaPedidos = "CREATE TABLE IF NOT EXISTS Pedido (" +
                "numero_referencia INT AUTO_INCREMENT PRIMARY KEY, " +
                "cliente_id INT NOT NULL, " +
                "pez_id INT NOT NULL, " +
                "cantidad INT NOT NULL, " +
                "enviados INT DEFAULT 0, " +
                "FOREIGN KEY (cliente_id) REFERENCES Cliente(id), " +
                "FOREIGN KEY (pez_id) REFERENCES Pez(id)" +
                ");";

        String tablaPez = "CREATE TABLE IF NOT EXISTS Pez (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(255) NOT NULL, " +
                "nombre_cientifico VARCHAR(255) NOT NULL" +
                ");";

        Statement stmt = null;

        try {
            stmt = con.createStatement();
           // stmt.execute(borrar);
           // stmt.execute(crear);
            stmt.execute(usar);

            stmt.execute(tablaClientes);
            stmt.execute(tablaPez);
            stmt.execute(tablaPedidos);
        } catch (SQLException e) {
            ErrorHelper.writeError("Error al crear las tablas");
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (Exception e) {
            }
        }
    }

     /**
     * Inserta clientes en la tabla Cliente si no existen previamente.
     */
    public void insertarClientes() {
        String sqlCheck = "SELECT COUNT(*) FROM Cliente WHERE nif = ?";
        String sqlInsert = "INSERT INTO Cliente (nombre, nif, telefono) VALUES (?, ?, ?)";

        try (PreparedStatement stmtCheck = con.prepareStatement(sqlCheck);
                PreparedStatement stmtInsert = con.prepareStatement(sqlInsert)) {

            String[][] clientes = {
                    { "Rosario Porto Ortega", "12345678A", "600111222" },
                    { "Tomás Gimeno", "23456789B", "600223344" },
                    { "Miguel Carcaño", "34567890C", "600334455" },
                    { "Miguel Ricart", "45678901D", "600445566" },
                    { "Antonio Anglés", "56789012E", "600556677" },
                    { "José Rabadán Pardo", "67890123F", "600667788" },
                    { "Joaquín Ferrándiz Ventura", "78901234G", "600778899" },
                    { "Ana Julia Quezada", "89012345H", "600889900" },
                    { "José Bretón", "90123456I", "600990011" },
                    { "José Enrique Abuín Gey", "01234567J", "600101112" }
            };

            for (String[] cliente : clientes) {
                String nif = cliente[1];

                // Verificar si el NIF ya existe
                stmtCheck.setString(1, nif);
                ResultSet rs = stmtCheck.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                rs.close();

                if (count == 0) { 
                    stmtInsert.setString(1, cliente[0]); // Nombre
                    stmtInsert.setString(2, cliente[1]); // NIF
                    stmtInsert.setString(3, cliente[2]); // Teléfono
                    stmtInsert.addBatch(); // Agregar al batch
                }
            }

            // Ejecutar solo si hay clientes nuevos
            stmtInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserta peces en la tabla Pez si no existen previamente.
     */
    public void insertarPeces() {
        String sqlCheck = "SELECT COUNT(*) FROM Pez WHERE nombre = ? AND nombre_cientifico = ?";
        String sqlInsert = "INSERT INTO Pez (nombre, nombre_cientifico) VALUES (?, ?)";
    
        try (PreparedStatement stmtCheck = con.prepareStatement(sqlCheck);
             PreparedStatement stmtInsert = con.prepareStatement(sqlInsert)) {
    
            String[][] peces = {
                    { AlmacenPropiedades.LUCIO_NORTE.getNombre(), AlmacenPropiedades.LUCIO_NORTE.getCientifico() },
                    { AlmacenPropiedades.CARPA_PLATEADA.getNombre(), AlmacenPropiedades.CARPA_PLATEADA.getCientifico() },
                    { AlmacenPropiedades.CARPA.getNombre(), AlmacenPropiedades.CARPA.getCientifico() },
                    { AlmacenPropiedades.TILAPIA_NILO.getNombre(), AlmacenPropiedades.TILAPIA_NILO.getCientifico() },
                    { AlmacenPropiedades.PEJERREY.getNombre(), AlmacenPropiedades.PEJERREY.getCientifico() },
                    { AlmacenPropiedades.RODABALLO.getNombre(), AlmacenPropiedades.RODABALLO.getCientifico() },
                    { AlmacenPropiedades.CABALLA.getNombre(), AlmacenPropiedades.CABALLA.getCientifico() },
                    { AlmacenPropiedades.BESUGO.getNombre(), AlmacenPropiedades.BESUGO.getCientifico() },
                    { AlmacenPropiedades.ABADEJO.getNombre(), AlmacenPropiedades.ABADEJO.getCientifico() },
                    { AlmacenPropiedades.SARGO.getNombre(), AlmacenPropiedades.SARGO.getCientifico() },
                    { AlmacenPropiedades.TRUCHA_ARCOIRIS.getNombre(), AlmacenPropiedades.TRUCHA_ARCOIRIS.getCientifico() },
                    { AlmacenPropiedades.DORADA.getNombre(), AlmacenPropiedades.DORADA.getCientifico() }
            };
    
            for (String[] pez : peces) {
                String nombre = pez[0];
                String cientifico = pez[1];
    
                // Verificar si ya existe en la base de datos
                stmtCheck.setString(1, nombre);
                stmtCheck.setString(2, cientifico);
                ResultSet rs = stmtCheck.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                rs.close();
    
                if (count == 0) { // Si no existe, agregar al batch
                    stmtInsert.setString(1, nombre);
                    stmtInsert.setString(2, cientifico);
                    stmtInsert.addBatch();
                }
            }
    
            // Ejecutar solo si hay peces nuevos
            stmtInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Inicia la base de datos creando las tablas e insertando los datos iniciales.
     */
    public void iniciarBD() {
        crearTablas();
        insertarClientes();
        insertarPeces();
    }
}
