package config;

import model.Auth;

public class Session {

    private static Auth usuarioActual;

    public static void setUsuario(Auth usuario) {
        usuarioActual = usuario;
    }

    public static Auth getUsuario() {
        return usuarioActual;
    }
}
