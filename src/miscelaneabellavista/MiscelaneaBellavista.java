package miscelaneabellavista;

import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import view.AuthForm;

public class MiscelaneaBellavista {

    public static void main(String[] args) {
        AuthForm auth = new AuthForm();
        auth.setVisible(true);
    }
}
