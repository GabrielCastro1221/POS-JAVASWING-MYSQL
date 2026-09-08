package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ProductosDAO {

    private final Conexion cn = Conexion.getInstancia();

    public boolean registrarProducto(Productos pro) {
        String sql = "INSERT INTO productos (codigo, nombre, proveedor_id, stock, precio_neto, precio_bruto, categoria_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getProveedor_id());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio_neto());
            ps.setDouble(6, pro.getPrecio_bruto());
            ps.setInt(7, pro.getCategoria_id());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar producto: " + e.toString());
            return false;
        }
    }

    public List<Productos> listarProductos() {
        List<Productos> listaPr = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Productos pr = new Productos();
                pr.setId(rs.getInt("id"));
                pr.setCodigo(rs.getString("codigo"));
                pr.setNombre(rs.getString("nombre"));
                pr.setProveedor_id(rs.getInt("proveedor_id"));
                pr.setStock(rs.getInt("stock"));
                pr.setPrecio_neto(rs.getDouble("precio_neto"));
                pr.setPrecio_bruto(rs.getDouble("precio_bruto"));
                pr.setCategoria_id(rs.getInt("categoria_id"));
                pr.setFecha(rs.getTimestamp("fecha"));
                listaPr.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.toString());
        }
        return listaPr;
    }

    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.toString());
            return false;
        }
    }

    public boolean modificarProducto(Productos pro) {
        String sql = "UPDATE productos SET codigo = ?, nombre = ?, proveedor_id = ?, stock = ?, precio_neto = ?, precio_bruto = ?, categoria_id = ? WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getProveedor_id());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio_neto());
            ps.setDouble(6, pro.getPrecio_bruto());
            ps.setInt(7, pro.getCategoria_id());
            ps.setInt(8, pro.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar producto: " + e.toString());
            return false;
        }
    }

    public Productos buscarProducto(String codigo) {
        Productos pro = null;
        String sql = "SELECT * FROM productos WHERE codigo = ?";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pro = new Productos();
                    pro.setId(rs.getInt("id"));
                    pro.setCodigo(rs.getString("codigo"));
                    pro.setNombre(rs.getString("nombre"));
                    pro.setProveedor_id(rs.getInt("proveedor_id"));
                    pro.setStock(rs.getInt("stock"));
                    pro.setPrecio_neto(rs.getDouble("precio_neto"));
                    pro.setPrecio_bruto(rs.getDouble("precio_bruto"));
                    pro.setCategoria_id(rs.getInt("categoria_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.toString());
        }
        return pro;
    }
}
