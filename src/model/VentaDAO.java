package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class VentaDAO {

    private final Conexion cn = Conexion.getInstancia();

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
        String sql = "INSERT INTO ventas (cliente, vendedor, total, fecha) VALUES (?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
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

    public List<Venta> listarVentas() {
        List<Venta> listaVenta = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Venta vent = new Venta();
                vent.setId(rs.getInt("id"));
                vent.setCliente(rs.getString("cliente"));
                vent.setVendedor(rs.getString("vendedor"));
                vent.setTotal(rs.getDouble("total"));
                vent.setFecha(rs.getTimestamp("fecha"));
                listaVenta.add(vent);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.toString());
        }
        return listaVenta;
    }
}
