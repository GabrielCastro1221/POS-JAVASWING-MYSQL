package model;

import config.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;

public class VentaDAO {

    private final Conexion cn = Conexion.getInstancia();

    public static class ResultadoVenta {

        public final int ventaId;
        public final String mensaje;

        public ResultadoVenta(int ventaId, String mensaje) {
            this.ventaId = ventaId;
            this.mensaje = mensaje;
        }
    }

    public ResultadoVenta registrarVentaTransaccional(int clienteId, String vendedor, String itemsJson) {
        String sql = "{CALL sp_registrar_venta(?, ?, ?, ?, ?)}";
        try (Connection con = cn.getConnection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, clienteId);
            cs.setString(2, vendedor);
            cs.setString(3, itemsJson);
            cs.registerOutParameter(4, Types.INTEGER);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.execute();
            int ventaId = cs.getInt(4);
            String mensaje = cs.getString(5);
            return new ResultadoVenta(ventaId, mensaje);
        } catch (SQLException e) {
            System.out.println("Error en registrarVentaTransaccional: " + e.toString());
            return new ResultadoVenta(-1, "Error: " + e.getMessage());
        }
    }

    public String registrarDevolucion(int ventaId, int productoId, int cantidad) {
        String sql = "{CALL sp_registrar_devolucion(?, ?, ?)}";
        String json = String.format("[{\"producto_id\": %d, \"cantidad\": %d}]", productoId, cantidad);
        try (Connection con = cn.getConnection(); CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, ventaId);
            cs.setString(2, json);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.execute();
            return cs.getString(3);
        } catch (SQLException e) {
            System.out.println("Error en registrarDevolucion: " + e.toString());
            return "Error: " + e.getMessage();
        }
    }

    public int idVenta() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM ventas";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener idVenta: " + e.toString());
        }
        return id;
    }

    public boolean registrarVenta(Venta v) {
        String sql = "INSERT INTO ventas (cliente_id, vendedor, total, fecha) VALUES (?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, v.getCliente_id());
            ps.setString(2, v.getNombreVendedor());
            ps.setDouble(3, v.getTotal());
            ps.setTimestamp(4, v.getFecha());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar venta: " + e.toString());
            return false;
        }
    }

    public boolean registrarDetalleVenta(DetalleVenta dv) {
        String sql = "INSERT INTO detalle_ventas(codigo_producto, cantidad, precio, id_venta) VALUES (?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dv.getCodigo_producto());
            ps.setInt(2, dv.getCantidad());
            ps.setDouble(3, dv.getPrecio());
            ps.setInt(4, dv.getId_venta());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar detalle venta: " + e.toString());
            return false;
        }
    }

    public boolean actualizarStock(int cant, String cod) {
        String sql = "UPDATE productos SET stock = ? WHERE codigo = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar stock: " + e.toString());
            return false;
        }
    }

    public Venta buscarVentaPorId(int idVenta) {
        Venta v = null;
        String sql = "SELECT id, cliente_id, vendedor, total, fecha, subtotal, iva_total, "
                + "descuento_total, estado, forma_pago, numero_factura "
                + "FROM ventas WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    v = new Venta();
                    v.setId(rs.getInt("id"));
                    v.setCliente_id(rs.getInt("cliente_id"));
                    v.setNombreVendedor(rs.getString("vendedor"));
                    v.setTotal(rs.getDouble("total"));
                    v.setFecha(rs.getTimestamp("fecha"));

                    java.math.BigDecimal subtotal = rs.getBigDecimal("subtotal");
                    v.setSubtotal(subtotal != null ? subtotal.doubleValue() : null);

                    java.math.BigDecimal ivaTotal = rs.getBigDecimal("iva_total");
                    v.setIva_total(ivaTotal != null ? ivaTotal.doubleValue() : null);

                    v.setDescuento_total(rs.getDouble("descuento_total"));
                    v.setEstado(rs.getString("estado"));
                    v.setForma_pago(rs.getString("forma_pago"));
                    v.setNumero_factura(rs.getString("numero_factura"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en buscarVentaPorId: " + e.toString());
        }
        return v;
    }

    public List<DetalleVenta> listarDetalleVenta(int idVenta) {
        List<DetalleVenta> lista = new ArrayList<>();
        String sql = "SELECT d.id_venta, d.codigo_producto, d.cantidad, d.precio, p.nombre "
                + "FROM detalle_ventas d "
                + "JOIN productos p ON d.codigo_producto = p.id "
                + "WHERE d.id_venta = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetalleVenta dv = new DetalleVenta();
                    dv.setId_venta(rs.getInt("id_venta"));
                    dv.setCodigo_producto(rs.getInt("codigo_producto"));
                    dv.setCantidad(rs.getInt("cantidad"));
                    dv.setPrecio(rs.getDouble("precio"));
                    dv.setNombreProducto(rs.getString("nombre"));
                    lista.add(dv);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en listarDetalleVenta: " + e.toString());
        }
        return lista;
    }

    public List<Venta> listarVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT v.id, c.nombre AS cliente, v.vendedor, v.total, v.fecha "
                + "FROM ventas v "
                + "JOIN clientes c ON v.cliente_id = c.id "
                + "ORDER BY v.id DESC";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Venta v = new Venta();
                v.setId(rs.getInt("id"));
                v.setNombreCliente(rs.getString("cliente"));
                v.setNombreVendedor(rs.getString("vendedor"));
                v.setTotal(rs.getDouble("total"));
                v.setFecha(rs.getTimestamp("fecha"));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error en listarVentas: " + e.toString());
        }
        return lista;
    }
}
