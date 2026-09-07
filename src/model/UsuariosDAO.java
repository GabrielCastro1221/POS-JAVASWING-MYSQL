package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

public class UsuariosDAO {

    private final Conexion cn = Conexion.getInstancia();

    public boolean RegistrarUsuario(Usuarios u) {
        String sql = "INSERT INTO usuarios (nombre, correo, pass, rol, telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            String hashedPass = BCrypt.hashpw(u.getPass(), BCrypt.gensalt());

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, hashedPass);
            ps.setString(4, u.getRol());
            ps.setString(5, u.getTelefono());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.toString());
            return false;
        }
    }

    public List<Usuarios> ListarUsuarios() {
        List<Usuarios> listaUs = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setPass(rs.getString("pass"));
                u.setRol(rs.getString("rol"));
                u.setTelefono(rs.getString("telefono"));
                listaUs.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.toString());
        }
        return listaUs;
    }

    public boolean EliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.toString());
            return false;
        }
    }

    public boolean ModificarUsuario(Usuarios u) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, pass = ?, rol = ?, telefono = ? WHERE id = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getPass());
            ps.setString(4, u.getRol());
            ps.setString(5, u.getTelefono());
            ps.setInt(6, u.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar usuario: " + e.toString());
            return false;
        }
    }

    public Usuarios buscarUsuario(String correo) {
        Usuarios u = null;
        String sql = "SELECT * FROM usuarios WHERE correo = ?";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    u = new Usuarios();
                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setCorreo(rs.getString("correo"));
                    u.setPass(rs.getString("pass"));
                    u.setRol(rs.getString("rol"));
                    u.setTelefono(rs.getString("telefono"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.toString());
        }
        return u;
    }
}
