package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class AuthDAO {

    private final Conexion cn = Conexion.getInstancia();

    public Auth login(String correo, String pass) {
        Auth usuario = null;
        String sql = "SELECT id, nombre, correo, pass, rol, telefono FROM usuarios WHERE correo = ?";
        try (Connection con = cn.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, correo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hashedPass = rs.getString("pass");
                    if (BCrypt.checkpw(pass, hashedPass)) {
                        usuario = new Auth();
                        usuario.setId(rs.getInt("id"));
                        usuario.setNombre(rs.getString("nombre"));
                        usuario.setCorreo(rs.getString("correo"));
                        usuario.setPass(hashedPass);
                        usuario.setRol(rs.getString("rol"));
                        usuario.setTelefono(rs.getString("telefono"));
                        cn.activarPerfil(usuario.getRol());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en login: " + e.getMessage());
        }
        return usuario;
    }
}