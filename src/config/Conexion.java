package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion instancia;
    private Connection con;

    private Conexion() {
        try {
            Enviroment env = Enviroment.getInstancia();

            String url = "jdbc:mysql://" + env.get("DB_HOST") + ":" + env.get("DB_PORT")
                    + "/" + env.get("DB_NAME") + "?serverTimezone=" + env.get("DB_TIMEZONE");
            String usuario = env.get("DB_USER");
            String clave = env.get("DB_PASSWORD");

            con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConnection() {
        return con;
    }
}
