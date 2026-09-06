package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAO {

    private final Conexion cn = Conexion.getInstancia();

    public Auth login(String correo, String pass) {
        Auth usuario = null;
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?";

        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, pass);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Auth();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setPass(rs.getString("pass"));
                    usuario.setRol(rs.getString("rol"));
                    usuario.setTelefono(rs.getString("telefono"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en login: " + e.getMessage());
        }
        return usuario;
    }

    public boolean registrar(Auth reg) {
        String sql = "INSERT INTO usuarios (nombre, correo, pass, rol, telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPass());
            ps.setString(4, reg.getRol());
            ps.setString(5, reg.getTelefono());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en registrar: " + e.getMessage());
            return false;
        }
    }
}
