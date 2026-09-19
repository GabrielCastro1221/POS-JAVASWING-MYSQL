package model;

import config.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {

    private final Conexion cn = Conexion.getInstancia();
    private SQLException ultimoError;

    public SQLException getUltimoError() {
        return ultimoError;
    }

    public static class ResultadoCompra {

        public final int compraId;
        public final String mensaje;

        public ResultadoCompra(int compraId, String mensaje) {
            this.compraId = compraId;
            this.mensaje = mensaje;
        }
    }

    public ResultadoCompra registrarCompraTransaccional(int proveedorId, Integer usuarioId,
            String numeroFactura, String itemsJson) {
        String sql = "{CALL sp_registrar_compra(?, ?, ?, ?, ?, ?)}";
        try (Connection con = cn.getConnection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, proveedorId);
            if (usuarioId != null) {
                cs.setInt(2, usuarioId);
            } else {
                cs.setNull(2, Types.INTEGER);
            }
            cs.setString(3, numeroFactura);
            cs.setString(4, itemsJson);
            cs.registerOutParameter(5, Types.INTEGER);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.execute();
            int compraId = cs.getInt(5);
            String mensaje = cs.getString(6);
            return new ResultadoCompra(compraId, mensaje);
        } catch (SQLException e) {
            ultimoError = e;
            System.out.println("Error en registrarCompraTransaccional: " + e.toString());
            return new ResultadoCompra(-1, "Error: " + e.getMessage());
        }
    }

    public List<Compra> listarCompras() {
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT c.id, c.proveedor_id, c.usuario_id, c.numero_factura_proveedor, "
                + "c.fecha, c.subtotal, c.iva_total, c.total, c.estado, "
                + "p.nombre AS nombre_proveedor, u.nombre AS nombre_usuario "
                + "FROM compras c "
                + "JOIN proveedores p ON c.proveedor_id = p.id "
                + "LEFT JOIN usuarios u ON c.usuario_id = u.id "
                + "ORDER BY c.id DESC";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapearCompra(rs));
            }
        } catch (SQLException e) {
            ultimoError = e;
            System.out.println("Error en listarCompras: " + e.toString());
        }
        return lista;
    }

    public Compra buscarCompraPorId(int idCompra) {
        Compra c = null;
        String sql = "SELECT c.id, c.proveedor_id, c.usuario_id, c.numero_factura_proveedor, "
                + "c.fecha, c.subtotal, c.iva_total, c.total, c.estado, "
                + "p.nombre AS nombre_proveedor, u.nombre AS nombre_usuario "
                + "FROM compras c "
                + "JOIN proveedores p ON c.proveedor_id = p.id "
                + "LEFT JOIN usuarios u ON c.usuario_id = u.id "
                + "WHERE c.id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCompra);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = mapearCompra(rs);
                }
            }
        } catch (SQLException e) {
            ultimoError = e;
            System.out.println("Error en buscarCompraPorId: " + e.toString());
        }
        return c;
    }

    public List<DetalleCompra> listarDetalleCompra(int idCompra) {
        List<DetalleCompra> lista = new ArrayList<>();
        String sql = "SELECT dc.id, dc.id_compra, dc.producto_id, dc.cantidad, "
                + "dc.costo_unitario, dc.iva_linea, dc.subtotal_linea, p.nombre "
                + "FROM detalle_compras dc "
                + "JOIN productos p ON dc.producto_id = p.id "
                + "WHERE dc.id_compra = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCompra);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetalleCompra dc = new DetalleCompra();
                    dc.setId(rs.getInt("id"));
                    dc.setIdCompra(rs.getInt("id_compra"));
                    dc.setProductoId(rs.getInt("producto_id"));
                    dc.setCantidad(rs.getInt("cantidad"));
                    dc.setCostoUnitario(rs.getDouble("costo_unitario"));
                    dc.setIvaLinea(rs.getDouble("iva_linea"));
                    dc.setSubtotalLinea(rs.getDouble("subtotal_linea"));
                    dc.setNombreProducto(rs.getString("nombre"));
                    lista.add(dc);
                }
            }
        } catch (SQLException e) {
            ultimoError = e;
            System.out.println("Error en listarDetalleCompra: " + e.toString());
        }
        return lista;
    }

    private Compra mapearCompra(ResultSet rs) throws SQLException {
        Compra c = new Compra();
        c.setId(rs.getInt("id"));
        c.setProveedorId(rs.getInt("proveedor_id"));
        int usuarioId = rs.getInt("usuario_id");
        c.setUsuarioId(rs.wasNull() ? null : usuarioId);
        c.setNumeroFacturaProveedor(rs.getString("numero_factura_proveedor"));
        c.setFecha(rs.getTimestamp("fecha"));
        c.setSubtotal(rs.getDouble("subtotal"));
        c.setIvaTotal(rs.getDouble("iva_total"));
        c.setTotal(rs.getDouble("total"));
        c.setEstado(rs.getString("estado"));
        c.setNombreProveedor(rs.getString("nombre_proveedor"));
        c.setNombreUsuario(rs.getString("nombre_usuario"));
        return c;
    }

    public boolean anularCompra(int idCompra) {
        String sqlDetalle = "SELECT producto_id, cantidad FROM detalle_compras WHERE id_compra = ?";
        String sqlRevertirStock = "UPDATE productos SET stock = stock - ? WHERE id = ?";
        String sqlMarcarAnulada = "UPDATE compras SET estado = 'anulada' WHERE id = ?";
        try (Connection con = cn.getConnection()) {
            con.setAutoCommit(false);
            try {
                try (PreparedStatement psDetalle = con.prepareStatement(sqlDetalle)) {
                    psDetalle.setInt(1, idCompra);
                    try (ResultSet rs = psDetalle.executeQuery()) {
                        try (PreparedStatement psStock = con.prepareStatement(sqlRevertirStock)) {
                            while (rs.next()) {
                                psStock.setInt(1, rs.getInt("cantidad"));
                                psStock.setInt(2, rs.getInt("producto_id"));
                                psStock.executeUpdate();
                            }
                        }
                    }
                }
                try (PreparedStatement psAnular = con.prepareStatement(sqlMarcarAnulada)) {
                    psAnular.setInt(1, idCompra);
                    psAnular.executeUpdate();
                }
                con.commit();
                return true;
            } catch (SQLException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (SQLException e) {
            ultimoError = e;
            System.out.println("Error en anularCompra: " + e.toString());
            return false;
        }
    }
}
