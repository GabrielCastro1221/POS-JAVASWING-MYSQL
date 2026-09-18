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

    public boolean RegistrarCliente(Cliente cl) {
        String sql = "INSERT INTO clientes (nombre, telefono, correo, numero_documento) VALUES (?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getTelefono());
            ps.setString(3, cl.getCorreo());
            ps.setString(4, cl.getNumero_documento());
            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> ListarClientes() {
        List<Cliente> listaCl = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setCorreo(rs.getString("correo"));
                cl.setNumero_documento(rs.getString("numero_documento"));
                cl.setFecha(rs.getTimestamp("fecha"));
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

    public boolean ModificarCliente(Cliente cl) {
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, correo = ?, numero_documento = ? WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getTelefono());
            ps.setString(3, cl.getCorreo());
            ps.setString(4, cl.getNumero_documento());
            ps.setInt(5, cl.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.toString());
            return false;
        }
    }

    public Cliente buscarCliente(String correo) {
        Cliente c = null;
        String sql = "SELECT * FROM clientes WHERE correo = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, correo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setCorreo(rs.getString("correo"));
                    c.setNumero_documento(rs.getString("numero_documento"));
                    c.setFecha(rs.getTimestamp("fecha"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.toString());
        }
        return c;
    }

    public Cliente buscarClientePorId(int id) {
        Cliente c = null;
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setCorreo(rs.getString("correo"));
                    c.setNumero_documento(rs.getString("numero_documento"));
                    c.setFecha(rs.getTimestamp("fecha"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por ID: " + e.toString());
        }
        return c;
    }

    public Cliente buscarClientePorDocumento(String numeroDocumento) {
        Cliente c = null;
        String sql = "SELECT * FROM clientes WHERE numero_documento = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, numeroDocumento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setCorreo(rs.getString("correo"));
                    c.setNumero_documento(rs.getString("numero_documento"));
                    c.setFecha(rs.getTimestamp("fecha"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por documento: " + e.toString());
        }
        return c;
    }
}
