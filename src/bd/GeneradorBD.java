package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;
import helpers.ErrorHelper;
import propiedades.AlmacenPropiedades;

public class GeneradorBD {

    private Connection con = Conexion.getConexion();

    public void crearTablas() {
        String crear = "CREATE DATABASE IF NOT EXISTS pescaditos";
        String borrar = "DROP DATABASE pescaditos;";
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
            stmt.execute(borrar);
            stmt.execute(crear);
            stmt.execute(usar);

            stmt.execute(tablaClientes);
            stmt.execute(tablaPez);
            stmt.execute(tablaPedidos);
        } catch (SQLException e) {
            ErrorHelper.writeError("Error al crear las tablas");
        } finally {
            try {
                if(stmt != null) stmt.close();} catch (Exception e) {}
        }
    }

    public void insertarClientes( ){
        String sql = "INSERT INTO Cliente (nombre, nif, telefono) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Clientes fijos con valores preestablecidos
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

            // Añadir cada cliente a la base de datos
            for (String[] cliente : clientes) {
                stmt.setString(1, cliente[0]); // Nombre
                stmt.setString(2, cliente[1]); // NIF
                stmt.setString(3, cliente[2]); // Teléfono
                stmt.addBatch(); // Añadir a lote
            }

            // Ejecutar el lote
            stmt.executeBatch();
            System.out.println("Clientes insertados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarPeces( ) {
        String sql = "INSERT INTO Pez (nombre, nombre_cientifico) VALUES (?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Peces fijos con valores preestablecidos
            String[][] peces = {
                    { AlmacenPropiedades.LUCIO_NORTE.getNombre(), AlmacenPropiedades.LUCIO_NORTE.getCientifico() },
                    { AlmacenPropiedades.CARPA_PLATEADA.getNombre(),AlmacenPropiedades.CARPA_PLATEADA.getCientifico() },
                    { AlmacenPropiedades.CARPA.getNombre(), AlmacenPropiedades.CARPA.getCientifico() },
                    { AlmacenPropiedades.TILAPIA_NILO.getNombre(), AlmacenPropiedades.TILAPIA_NILO.getCientifico() },
                    { AlmacenPropiedades.PEJERREY.getNombre(), AlmacenPropiedades.PEJERREY.getCientifico() },
                    { AlmacenPropiedades.RODABALLO.getNombre(), AlmacenPropiedades.RODABALLO.getCientifico() },
                    { AlmacenPropiedades.CABALLA.getNombre(), AlmacenPropiedades.CABALLA.getCientifico() },
                    { AlmacenPropiedades.BESUGO.getNombre(), AlmacenPropiedades.BESUGO.getCientifico() },
                    { AlmacenPropiedades.ABADEJO.getNombre(), AlmacenPropiedades.ABADEJO.getCientifico() },
                    { AlmacenPropiedades.SARGO.getNombre(), AlmacenPropiedades.SARGO.getCientifico() },
                    { AlmacenPropiedades.TRUCHA_ARCOIRIS.getNombre(),AlmacenPropiedades.TRUCHA_ARCOIRIS.getCientifico() },
                    { AlmacenPropiedades.DORADA.getNombre(), AlmacenPropiedades.DORADA.getCientifico() }

            };

            // Añadir cada pez a la base de datos
            for (String[] pez : peces) {
                stmt.setString(1, pez[0]); // Nombre
                stmt.setString(2, pez[1]); // Nombre científico
                stmt.addBatch(); // Añadir a lote
            }

            // Ejecutar el lote
            stmt.executeBatch();
            System.out.println("Peces insertados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void iniciarBD(){
        crearTablas();
        insertarClientes();
        insertarPeces();
    }
}
