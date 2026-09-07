package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ClientesDAO {

    private final Conexion cn = Conexion.getInstancia();

    public boolean RegistrarCliente(Clientes cl) {
        String sql = "INSERT INTO clientes (nombre, telefono, correo) VALUES (?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cl.getNombre());
            ps.setInt(2, cl.getTelefono());
            ps.setString(3, cl.getCorreo());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar cliente: " + e.toString());
            return false;
        }
    }

    public List<Clientes> ListarClientes() {
        List<Clientes> listaCl = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Clientes cl = new Clientes();
                cl.setId(rs.getInt("id"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setCorreo(rs.getString("correo"));
                listaCl.add(cl);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.toString());
        }
        return listaCl;
    }

    public boolean EliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.toString());
            return false;
        }
    }

    public boolean ModificarCliente(Clientes cl) {
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, correo = ? WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cl.getNombre());
            ps.setInt(2, cl.getTelefono());
            ps.setString(3, cl.getCorreo());
            ps.setInt(4, cl.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.toString());
            return false;
        }
    }

    public Clientes buscarCliente(String correo) {
        Clientes c = null;
        String sql = "SELECT * FROM clientes WHERE correo = ?";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Clientes();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setTelefono(rs.getInt("telefono"));
                    c.setCorreo(rs.getString("correo"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.toString());
        }
        return c;
    }
}
