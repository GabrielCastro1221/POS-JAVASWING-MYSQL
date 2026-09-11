package model;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class ValidacionesTextField {

    public void textKeyPress(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }

    public void numberKeyPress(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    public void numberDecimalKeyPress(KeyEvent evt, JTextField textField) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && textField.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    public boolean validarCorreo(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return correo.matches(regex);
    }

    public boolean validarPassword(String pass) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
        return pass.matches(regex);
    }

    public boolean validarNombre(String nombre) {
        return nombre != null && nombre.trim().length() >= 8;
    }

    public boolean validarCelularColombia(String telefono) {
        String regex = "^3\\d{9}$";
        return telefono.matches(regex);
    }

    public boolean validarCategoria(String categoria) {
        String regex = "^[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]{3,}$";
        return categoria != null && categoria.matches(regex);
    }
}
