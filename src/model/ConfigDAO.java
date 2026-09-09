package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConfigDAO {

    private final Conexion cn = Conexion.getInstancia();

    public List<Config> listarConfig() {
        List<Config> lista = new ArrayList<>();
        String sql = "SELECT * FROM config";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Config cfg = new Config();
                cfg.setId(rs.getInt("id"));
                cfg.setNombre(rs.getString("nombre_empresa"));
                cfg.setRuc(rs.getInt("ruc"));
                cfg.setTelefono(rs.getInt("telefono"));
                cfg.setDireccion(rs.getString("direccion"));
                cfg.setRazon_social(rs.getString("razon_social"));
                cfg.setFecha(rs.getTimestamp("fecha"));
                lista.add(cfg);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar configuraciones: " + e.toString());
        }
        return lista;
    }

    public boolean registrarConfig(Config cfg) {
        String sql = "INSERT INTO config (nombre_empresa, ruc, telefono, direccion, razon_social, fecha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cfg.getNombre());
            ps.setInt(2, cfg.getRuc());
            ps.setInt(3, cfg.getTelefono());
            ps.setString(4, cfg.getDireccion());
            ps.setString(5, cfg.getRazon_social());
            ps.setTimestamp(6, cfg.getFecha());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar configuración: " + e.toString());
            return false;
        }
    }

    public boolean actualizarConfig(Config cfg) {
        String sql = "UPDATE config SET nombre_empresa = ?, ruc = ?, telefono = ?, direccion = ?, razon_social = ?, fecha = ? WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cfg.getNombre());
            ps.setInt(2, cfg.getRuc());
            ps.setInt(3, cfg.getTelefono());
            ps.setString(4, cfg.getDireccion());
            ps.setString(5, cfg.getRazon_social());
            ps.setTimestamp(6, cfg.getFecha());
            ps.setInt(7, cfg.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar configuración: " + e.toString());
            return false;
        }
    }

    public boolean eliminarConfig(int id) {
        String sql = "DELETE FROM config WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar configuración: " + e.toString());
            return false;
        }
    }
}
