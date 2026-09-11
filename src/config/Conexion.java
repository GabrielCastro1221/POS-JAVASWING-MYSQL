package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion instancia;

    private final String url;

    private final String usuarioLogin;
    private final String claveLogin;
    private final String usuarioAdmin;
    private final String claveAdmin;
    private final String usuarioVendedor;
    private final String claveVendedor;

    private String usuarioActual;
    private String claveActual;

    private Conexion() {
        Enviroment env = Enviroment.getInstancia();
        url = "jdbc:mysql://" + env.get("DB_HOST") + ":" + env.get("DB_PORT") + "/" + env.get("DB_NAME") + "?serverTimezone=" + env.get("DB_TIMEZONE");
        usuarioLogin = env.get("DB_USER_LOGIN");
        claveLogin = env.get("DB_PASS_LOGIN");
        usuarioAdmin = env.get("DB_USER_ADMIN");
        claveAdmin = env.get("DB_PASS_ADMIN");
        usuarioVendedor = env.get("DB_USER_VENDEDOR");
        claveVendedor = env.get("DB_PASS_VENDEDOR");
        usuarioActual = usuarioLogin;
        claveActual = claveLogin;
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public void activarPerfil(String rol) {
        switch (rol.toLowerCase()) {
            case "admin" -> {
                usuarioActual = usuarioAdmin;
                claveActual = claveAdmin;
            }
            case "vendedor" -> {
                usuarioActual = usuarioVendedor;
                claveActual = claveVendedor;
            }
            default ->
                throw new IllegalArgumentException("Rol no reconocido: " + rol);
        }
    }

    public void volverAPerfilLogin() {
        usuarioActual = usuarioLogin;
        claveActual = claveLogin;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuarioActual, claveActual);
    }
}
