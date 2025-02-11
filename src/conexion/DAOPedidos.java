package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dtos.DTOPedido;

public class DAOPedidos {

    /** Conexión a la base de datos */
    private Connection conn = Conexion.getConexion();

    /** Sentencia preparada para listar los pedidos no completados */
    private PreparedStatement pstListarNoComp;

    /** Sentencia preparada para listar los pedidos completados */
    private PreparedStatement pstListarComp;

    /** Sentencia preparada para editar los pedidos */
    private PreparedStatement pstNuevo;

    /** Sentencia preparada para conseguir las cantidades de un pedido */
    private PreparedStatement pstPedido;

    /** Sentencia preparada para para conseguir el numero de referencia del ultimo pedido */
    private PreparedStatement pstUltimo;

    /** Sentencia preparada para actualizar un pedido */
    private PreparedStatement pstUpdatePedido;

    /**
     * Constructor que prepara todas las sentencias sql
     */
    public DAOPedidos() {
        try {
            pstListarNoComp = conn.prepareStatement(
                    "SELECT p.numero_referencia AS ref, " +
                         "c.nombre AS nombre_cl, " +
                         "pe.nombre AS nombre_pe, " +
                         "p.enviados AS enviados, " +
                         "p.cantidad AS solicitados " +
                         "FROM Pedido p " +
                         "JOIN Cliente c ON p.cliente_id = c.id " +
                         "JOIN Pez pe ON p.pez_id = pe.id " +
                         "WHERE p.enviados < p.cantidad " +
                         "ORDER BY pe.nombre");
                         
            pstListarComp = conn.prepareStatement(
                    "SELECT p.numero_referencia AS ref, " +
                         "c.nombre AS nombre_cl, " +
                         "pe.nombre AS nombre_pe, " +
                         "p.enviados AS enviados, " +
                         "p.cantidad AS solicitados " +
                         "FROM Pedido p " +
                         "JOIN Cliente c ON p.cliente_id = c.id " +
                         "JOIN Pez pe ON p.pez_id = pe.id " +
                         "WHERE p.enviados = p.cantidad " +
                         "ORDER BY pe.nombre");

            pstNuevo = conn.prepareStatement(
                    "INSERT INTO Pedido (cliente_id, pez_id, cantidad, enviados)" +
                            "VALUES (?, ?, ?, 0)");

            pstPedido = conn.prepareStatement(
                "SELECT cantidad, enviados " +   
                "FROM Pedido " +
                "WHERE numero_referencia = ?"
            );

            pstUltimo = conn.prepareStatement(
                "SELECT numero_referencia " + 
                "FROM pedido " + 
                "ORDER BY numero_referrncia DESC " + 
                "LIMIT 1"
            );

            pstUpdatePedido = conn.prepareStatement(
                "UPDATE Pedido SET enviados = enviados + ? WHERE numero_referencia = ?"
            );

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Borra todos los pedidos de la base de datos
     */
    public void borrarPedidos() {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM Pedido");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Devuelve los pedidos no completados
     * 
     * @return Array con los dto de los pedidos no completados
     */
    public List<DTOPedido> listarPedidosNoComp() {

        List<DTOPedido> devolver = new ArrayList<>();

        try (ResultSet rs = this.pstListarNoComp.executeQuery()) {
            while (rs.next()) {
                devolver.add(new DTOPedido(rs.getInt("ref"), rs.getString("nombre_cl"), rs.getInt("solicitados"),
                        rs.getInt("enviados"), rs.getString("nombre_pe")));
            }
            return devolver;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Devuelve los pedidos completados
     * 
     * @return Array con los dto de los pedidos completados
     */
    public List<DTOPedido> listarPedidosComp() {

        List<DTOPedido> devolver = new ArrayList<>();

        try (ResultSet rs = this.pstListarComp.executeQuery()) {
            while (rs.next()) {
                devolver.add(new DTOPedido(rs.getInt("ref"), rs.getString("nombre_cl"), rs.getInt("solicitados"),
                        rs.getInt("enviados"), rs.getString("nombre_pe")));
            }
            return devolver;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Añade un nuevo pedido a la base de datos
     * 
     * @return El numero del ultimo pedido añadido, 0 si ha fallado
     */
    public int addPedido(){
        Random rand = new Random();
        try {
            pstNuevo.setInt(1, rand.nextInt(10)+1);
            pstNuevo.setInt(2, rand.nextInt(12)+1);
            pstNuevo.setInt(3, rand.nextInt(41)+10);
            pstNuevo.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (ResultSet rs = this.pstUltimo.executeQuery()) {
            rs.next();            
            return rs.getInt(1);
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return 0;
    }

    /**
     * Añade cierta cantidad de peces a un pedido en concreto.
     * @return true si el pedido se ha completado.
     */
    public boolean progresarPedido(int id, int cantidad){
        try {
            pstUpdatePedido.setInt(1, cantidad);
            pstUpdatePedido.setInt(2, id);

            int affected = pstUpdatePedido.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public DTOPedido getCantidadPedido(int id){
        DTOPedido pedido = null;
        try {
            pstPedido.setInt(1, id);
            try (ResultSet rs = this.pstPedido.executeQuery()) {
                rs.next();
                pedido = new DTOPedido(id, null, rs.getInt(1), rs.getInt(2), null);
            } catch (SQLException e) {}
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return pedido;
    }

    public void closePST(){
        try {
            pstListarComp.close();
            pstListarNoComp.close();
            pstNuevo.close();
            pstPedido.close();
            pstUpdatePedido.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}