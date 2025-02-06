package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Constructor que prepara todas las sentencias sql
     */
    public DAOPedidos() {
        try {
            pstListarNoComp = conn.prepareStatement(
                    "SELECT p.id_referencia as ref, c.nombre as nombre_cl, pe.nombre_pez as nombre_pe, p.enviados as enviados, p.solicitados as solicitados "
                            +
                            "FROM Pedido p" +
                            "JOIN Usuario c ON p.cliente_id = c.id " +
                            "JOIN Pez pe ON p.pez_id = pe.id " +
                            "WHERE enviados < solicitados");

            pstListarComp = conn.prepareStatement(
                    "SELECT p.id_referencia as ref, c.nombre as nombre_cl, pe.nombre_pez as nombre_pe, p.enviados as enviados, p.solicitados as solicitados "
                            +
                            "FROM Pedido p" +
                            "JOIN Cliente c ON p.usuario_id = c.id " +
                            "JOIN Pez pe ON p.pez_id = pe.id " +
                            "WHERE enviados = solicitados");

            pstNuevo = conn.prepareStatement(
                    "INSERT INTO Pedido (cliente_id, pez_id, cantidad, enviados)" +
                            "VALUES (?, ?, ?, 0)");

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
            stmt.executeUpdate("DELETE * FROM pedidos");
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
     */
    public void addPedido(){
        
    }

}
