package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion instancia;
    private String url;
    private String usuario;
    private String clave;

    private Conexion() {
        Enviroment env = Enviroment.getInstancia();
        url = "jdbc:mysql://" + env.get("DB_HOST") + ":" + env.get("DB_PORT") + "/" + env.get("DB_NAME") + "?serverTimezone=" + env.get("DB_TIMEZONE");
        usuario = env.get("DB_USER");
        clave = env.get("DB_PASSWORD");
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, clave);
    }
}
