package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Enviroment {

    private static Enviroment instancia;
    private Properties props;

    private Enviroment() {
        props = new Properties();
        try (FileInputStream fis = new FileInputStream(".env")) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Error cargando .env: " + e.getMessage());
        }
    }

    public static Enviroment getInstancia() {
        if (instancia == null) {
            instancia = new Enviroment();
        }
        return instancia;
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
