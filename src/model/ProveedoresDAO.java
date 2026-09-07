package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ProveedoresDAO {

    private final Conexion cn = Conexion.getInstancia();

    public boolean registrarProveedor(Proveedores pr) {
        String sql = "INSERT INTO proveedores (ruc, nombre, vendedor, telefono, direccion, razon_social) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getVendedor());
            ps.setString(4, pr.getTelefono());
            ps.setString(5, pr.getDireccion());
            ps.setString(6, pr.getRazon_social());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar proveedor: " + e.toString());
            return false;
        }
    }

    public List<Proveedores> listarProveedores() {
        List<Proveedores> listaPr = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Proveedores pr = new Proveedores();
                pr.setId(rs.getInt("id"));
                pr.setRuc(rs.getLong("ruc"));
                pr.setNombre(rs.getString("nombre"));
                pr.setVendedor(rs.getString("vendedor"));
                pr.setTelefono(rs.getString("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setRazon_social(rs.getString("razon_social"));

                listaPr.add(pr);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar proveedores: " + e.toString());
        }
        return listaPr;
    }

    public boolean eliminarProveedor(int id) {
        String sql = "DELETE FROM proveedores WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e.toString());
            return false;
        }
    }

    public boolean modificarProveedor(Proveedores pr) {
        String sql = "UPDATE proveedores SET ruc = ?, nombre = ?, vendedor = ?, telefono = ?, direccion = ?, razon_social = ? WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getVendedor());
            ps.setString(4, pr.getTelefono());
            ps.setString(5, pr.getDireccion());
            ps.setString(6, pr.getRazon_social());
            ps.setInt(7, pr.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar proveedor: " + e.toString());
            return false;
        }
    }
}
