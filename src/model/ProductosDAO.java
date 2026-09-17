package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;

public class ProductosDAO {

    private final Conexion cn = Conexion.getInstancia();

    public boolean registrarCodigoBarra(String codigoBarra, int productoId) {
        String sql = "INSERT INTO codigos_barras (codigo_barra, producto_id) VALUES (?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigoBarra);
            ps.setInt(2, productoId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar código de barras: " + e.toString());
            return false;
        }
    }

    public int registrarProducto(Productos pro) {
        String sql = "INSERT INTO productos "
                + "(codigo, nombre, proveedor_id, stock, precio_neto, precio_bruto, categoria_id, "
                + "tasa_iva, fecha_caducidad, unidad_medida, stock_minimo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getProveedor_id());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio_neto());
            ps.setDouble(6, pro.getPrecio_bruto());
            ps.setInt(7, pro.getCategoria_id());
            ps.setDouble(8, pro.getTasa_iva());

            if (pro.getFecha_caducidad() != null) {
                ps.setDate(9, pro.getFecha_caducidad());
            } else {
                ps.setNull(9, Types.DATE);
            }

            ps.setString(10, pro.getUnidad_medida());
            ps.setInt(11, pro.getStock_minimo());

            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar producto: " + e.toString());
        }
        return -1;
    }

    public List<Productos> listarProductos() {
        List<Productos> listaPr = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listaPr.add(mapearProducto(rs));
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
        String sql = "UPDATE productos SET codigo = ?, nombre = ?, proveedor_id = ?, stock = ?, "
                + "precio_neto = ?, precio_bruto = ?, categoria_id = ?, "
                + "tasa_iva = ?, fecha_caducidad = ?, unidad_medida = ?, stock_minimo = ? "
                + "WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getProveedor_id());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio_neto());
            ps.setDouble(6, pro.getPrecio_bruto());
            ps.setInt(7, pro.getCategoria_id());
            ps.setDouble(8, pro.getTasa_iva());
            if (pro.getFecha_caducidad() != null) {
                ps.setDate(9, pro.getFecha_caducidad());
            } else {
                ps.setNull(9, Types.DATE);
            }
            ps.setString(10, pro.getUnidad_medida());
            ps.setInt(11, pro.getStock_minimo());
            ps.setInt(12, pro.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar producto: " + e.toString());
            return false;
        }
    }

    public Productos buscarProd(String codigo) {
        Productos pro = null;
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pro = mapearProducto(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.toString());
        }
        return pro;
    }

    public Productos buscarProductoPorCodigoBarra(String codigoBarra) {
        Productos pro = null;
        String sql = "SELECT p.* FROM productos p "
                + "INNER JOIN codigos_barras cb ON p.id = cb.producto_id "
                + "WHERE cb.codigo_barra = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, codigoBarra);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pro = mapearProducto(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar producto por código de barras: " + e.toString());
        }
        return pro;
    }

    public List<Productos> buscarProductos(String criterio) {
        List<Productos> lista = new ArrayList<>();
        String sql = "SELECT p.*, pr.nombre AS proveedor_nombre "
                + "FROM productos p "
                + "LEFT JOIN proveedores pr ON p.proveedor_id = pr.id "
                + "WHERE p.codigo LIKE ? OR p.nombre LIKE ? OR pr.nombre LIKE ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            String like = "%" + criterio + "%";
            ps.setString(1, like);
            ps.setString(2, like);
            ps.setString(3, like);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearProducto(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar productos: " + e.getMessage());
        }
        return lista;
    }

    private Productos mapearProducto(ResultSet rs) throws SQLException {
        Productos pro = new Productos();
        pro.setId(rs.getInt("id"));
        pro.setCodigo(rs.getString("codigo"));
        pro.setNombre(rs.getString("nombre"));
        pro.setProveedor_id(rs.getInt("proveedor_id"));
        pro.setStock(rs.getInt("stock"));
        pro.setPrecio_neto(rs.getDouble("precio_neto"));
        pro.setPrecio_bruto(rs.getDouble("precio_bruto"));
        pro.setCategoria_id(rs.getInt("categoria_id"));
        pro.setFecha(rs.getTimestamp("fecha"));
        pro.setTasa_iva(rs.getDouble("tasa_iva"));
        pro.setFecha_caducidad(rs.getDate("fecha_caducidad"));
        pro.setUnidad_medida(rs.getString("unidad_medida"));
        pro.setStock_minimo(rs.getInt("stock_minimo"));
        java.math.BigDecimal costoProm = rs.getBigDecimal("costo_promedio");
        pro.setCosto_promedio(costoProm != null ? costoProm.doubleValue() : null);
        return pro;
    }

    public boolean restarStock(int productoId, int cantidadVendida) {
        String sql = "UPDATE productos SET stock = stock - ? WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cantidadVendida);
            ps.setInt(2, productoId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al restar stock: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCodigosBarras(int productoId, int cantidadVendida) {
        String sql = "DELETE FROM codigos_barras WHERE producto_id = ? LIMIT ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productoId);
            ps.setInt(2, cantidadVendida);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar códigos de barras: " + e.getMessage());
            return false;
        }
    }
}
