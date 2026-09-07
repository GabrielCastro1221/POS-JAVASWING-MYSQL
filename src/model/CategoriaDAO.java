package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class CategoriaDAO {

    private final Conexion cn = Conexion.getInstancia();

    public boolean registrarCategoria(Categoria cat) {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cat.getNombre());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar categoría: " + e.toString());
            return false;
        }
    }

    public List<Categoria> listarCategorias() {
        List<Categoria> listaCat = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setNombre(rs.getString("nombre"));
                listaCat.add(cat);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar categorías: " + e.toString());
        }
        return listaCat;
    }

    public boolean eliminarCategoria(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría: " + e.toString());
            return false;
        }
    }

    public boolean modificarCategoria(Categoria cat) {
        String sql = "UPDATE categorias SET nombre = ? WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cat.getNombre());
            ps.setInt(2, cat.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar categoría: " + e.toString());
            return false;
        }
    }

    public Categoria buscarCategoria(String nombre) {
        Categoria cat = null;
        String sql = "SELECT * FROM categorias WHERE nombre = ?";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cat = new Categoria();
                    cat.setId(rs.getInt("id"));
                    cat.setNombre(rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar categoría: " + e.toString());
        }
        return cat;
    }
}
