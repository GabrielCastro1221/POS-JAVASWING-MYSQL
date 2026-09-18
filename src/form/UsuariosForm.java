package form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import model.Usuarios;
import model.UsuariosDAO;
import model.ValidacionesTextField;

public class UsuariosForm extends javax.swing.JPanel {

    public UsuariosForm() {
        initComponents();
        btnCrearUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnActualizarUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbxRolUsuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbxRolUsuario.removeAllItems();
        cbxRolUsuario.addItem("admin");
        cbxRolUsuario.addItem("vendedor");
        txtIdUsuario.setVisible(false);
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int arc = 20;
        RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
        g2.setColor(new Color(255, 255, 255, 80));
        g2.draw(rounded);
        g2.dispose();
    }

    public void setDatosUsuario(String id, String nombre, String correo, String pass, String rol, String telefono, String numeroDocumento) {
        txtIdUsuario.setText(id);
        txtNombreUsuario.setText(nombre);
        txtEmailUsuario.setText(correo);
        txtPassUsuario.setText(pass);
        cbxRolUsuario.setSelectedItem(rol);
        txtTelefonoUsuario.setText(telefono);
        txtDocumento.setText(numeroDocumento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDocumento = new javax.swing.JLabel();
        txtDocumento = new components.CustomTextField();
        lblEmailUsuario = new javax.swing.JLabel();
        txtEmailUsuario = new components.CustomTextField();
        lblPassUsuario = new javax.swing.JLabel();
        cbxRolUsuario = new components.CustomComboBox();
        txtPassUsuario = new components.CustomPasswordField();
        lblTelefonoUsuario = new javax.swing.JLabel();
        txtTelefonoUsuario = new components.CustomTextField();
        lblRolUsuario = new javax.swing.JLabel();
        roundedPanelCrearUsuario = new components.RoundedPanel();
        btnCrearUsuario = new javax.swing.JLabel();
        roundedPanelActualizarCliente = new components.RoundedPanel();
        btnActualizarUsuario = new javax.swing.JLabel();
        roundedPanelEliminarUsuario = new components.RoundedPanel();
        btnEliminarUsuario = new javax.swing.JLabel();
        txtIdUsuario = new components.CustomTextField();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new components.CustomTextField();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        lblDocumento.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblDocumento.setForeground(new java.awt.Color(255, 255, 255));
        lblDocumento.setText("Numero de documento");
        add(lblDocumento);
        lblDocumento.setBounds(40, 110, 160, 17);

        txtDocumento.setForeground(new java.awt.Color(200, 200, 200));
        txtDocumento.setText("Ingrese el numero de documento");
        add(txtDocumento);
        txtDocumento.setBounds(30, 130, 286, 33);

        lblEmailUsuario.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblEmailUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailUsuario.setText("Correo electronico");
        add(lblEmailUsuario);
        lblEmailUsuario.setBounds(40, 170, 150, 17);

        txtEmailUsuario.setForeground(new java.awt.Color(200, 200, 200));
        txtEmailUsuario.setText("Ingrese el email del usuario");
        add(txtEmailUsuario);
        txtEmailUsuario.setBounds(30, 190, 290, 33);

        lblPassUsuario.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblPassUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblPassUsuario.setText("Contraseña");
        add(lblPassUsuario);
        lblPassUsuario.setBounds(40, 230, 110, 17);

        cbxRolUsuario.setToolTipText("");
        add(cbxRolUsuario);
        cbxRolUsuario.setBounds(30, 390, 290, 21);

        txtPassUsuario.setPlaceholder("Ingrese la contraseña del usuario");
        add(txtPassUsuario);
        txtPassUsuario.setBounds(30, 250, 290, 33);

        lblTelefonoUsuario.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblTelefonoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoUsuario.setText("Telefono");
        add(lblTelefonoUsuario);
        lblTelefonoUsuario.setBounds(40, 300, 70, 17);

        txtTelefonoUsuario.setForeground(new java.awt.Color(200, 200, 200));
        txtTelefonoUsuario.setText("Ingrese el telefono del cliente");
        add(txtTelefonoUsuario);
        txtTelefonoUsuario.setBounds(30, 320, 290, 33);

        lblRolUsuario.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblRolUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblRolUsuario.setText("Rol de usuario");
        add(lblRolUsuario);
        lblRolUsuario.setBounds(30, 370, 110, 17);

        roundedPanelCrearUsuario.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelCrearUsuario.setCornerRadius(10);
        roundedPanelCrearUsuario.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelCrearUsuario.setLayout(null);

        btnCrearUsuario.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnCrearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrearUsuario.setText("Crear usuario");
        btnCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearUsuarioMouseClicked(evt);
            }
        });
        btnCrearUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCrearUsuarioKeyPressed(evt);
            }
        });
        roundedPanelCrearUsuario.add(btnCrearUsuario);
        btnCrearUsuario.setBounds(0, 0, 290, 40);

        add(roundedPanelCrearUsuario);
        roundedPanelCrearUsuario.setBounds(30, 440, 290, 40);

        roundedPanelActualizarCliente.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelActualizarCliente.setCornerRadius(10);
        roundedPanelActualizarCliente.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelActualizarCliente.setLayout(null);

        btnActualizarUsuario.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnActualizarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizarUsuario.setText("Actualizar usuario");
        btnActualizarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarUsuarioMouseClicked(evt);
            }
        });
        btnActualizarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarUsuarioKeyPressed(evt);
            }
        });
        roundedPanelActualizarCliente.add(btnActualizarUsuario);
        btnActualizarUsuario.setBounds(0, 0, 290, 40);

        add(roundedPanelActualizarCliente);
        roundedPanelActualizarCliente.setBounds(30, 490, 290, 40);

        roundedPanelEliminarUsuario.setBottomColor(new java.awt.Color(213, 69, 53));
        roundedPanelEliminarUsuario.setCornerRadius(10);
        roundedPanelEliminarUsuario.setTopColor(new java.awt.Color(224, 109, 106));
        roundedPanelEliminarUsuario.setLayout(null);

        btnEliminarUsuario.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnEliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarUsuario.setText("Eliminar usuario");
        btnEliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarUsuarioMouseClicked(evt);
            }
        });
        btnEliminarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarUsuarioKeyPressed(evt);
            }
        });
        roundedPanelEliminarUsuario.add(btnEliminarUsuario);
        btnEliminarUsuario.setBounds(0, 0, 290, 40);

        add(roundedPanelEliminarUsuario);
        roundedPanelEliminarUsuario.setBounds(30, 540, 290, 40);
        add(txtIdUsuario);
        txtIdUsuario.setBounds(0, 600, 10, 33);

        lblNombreUsuario.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Nombre completo");
        add(lblNombreUsuario);
        lblNombreUsuario.setBounds(40, 40, 109, 17);

        txtNombreUsuario.setForeground(new java.awt.Color(200, 200, 200));
        txtNombreUsuario.setText("Ingrese el nombre del usuario");
        add(txtNombreUsuario);
        txtNombreUsuario.setBounds(30, 70, 286, 33);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUsuarioMouseClicked
        if (!"admin".equalsIgnoreCase(config.Session.getUsuario().getRol())) {
            JOptionPane.showMessageDialog(this, "No tienes permiso para registrar usuarios en la plataforma");
            return;
        }
        ValidacionesTextField val = new ValidacionesTextField();
        String nombre = txtNombreUsuario.getText().trim();
        String numeroDocumento = txtDocumento.getText().trim();
        String correo = txtEmailUsuario.getText().trim();
        String pass = new String(txtPassUsuario.getPassword());
        String telefono = txtTelefonoUsuario.getText().trim();
        String rol = cbxRolUsuario.getSelectedItem().toString();

        if (!val.validarNombre(nombre)) {
            JOptionPane.showMessageDialog(this, "El nombre debe tener al menos 8 caracteres");
            return;
        }
        if (numeroDocumento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el número de documento");
            return;
        }
        if (!numeroDocumento.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El número de documento debe ser numérico");
            return;
        }
        if (!val.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "Ingrese un correo válido");
            return;
        }
        if (!val.validarPassword(pass)) {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener mayúscula, minúscula y número");
            return;
        }
        if (!val.validarCelularColombia(telefono)) {
            JOptionPane.showMessageDialog(this, "El teléfono debe ser un número válido de 10 dígitos que empiece por 3");
            return;
        }
        if (rol == null || rol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un rol de usuario");
            return;
        }

        UsuariosDAO dao = new UsuariosDAO();
        Usuarios u = new Usuarios();
        u.setNombre(nombre);
        u.setNumero_documento(numeroDocumento);
        u.setCorreo(correo);
        u.setPass(pass);
        u.setRol(rol);
        u.setTelefono(telefono);
        boolean registrado = dao.RegistrarUsuario(u);
        ((Usuario) getParent()).cargarUsuarios();
        if (registrado) {
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar usuario");
        }
    }//GEN-LAST:event_btnCrearUsuarioMouseClicked

    private void btnCrearUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearUsuarioKeyPressed

    }//GEN-LAST:event_btnCrearUsuarioKeyPressed

    private void btnActualizarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarUsuarioMouseClicked
        if (!"admin".equalsIgnoreCase(config.Session.getUsuario().getRol())) {
            JOptionPane.showMessageDialog(this, "No tienes permiso para actualizar usuarios de plataforma");
            return;
        }
        try {
            String numeroDocumento = txtDocumento.getText().trim();
            if (!numeroDocumento.isEmpty() && !numeroDocumento.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "El número de documento debe ser numérico");
                return;
            }

            Usuarios u = new Usuarios();
            u.setId(Integer.parseInt(txtIdUsuario.getText()));
            u.setNombre(txtNombreUsuario.getText().trim());
            u.setNumero_documento(numeroDocumento);
            u.setCorreo(txtEmailUsuario.getText().trim());
            u.setPass(new String(txtPassUsuario.getPassword()));
            u.setRol(cbxRolUsuario.getSelectedItem().toString());
            u.setTelefono(txtTelefonoUsuario.getText().trim());
            UsuariosDAO dao = new UsuariosDAO();
            if (dao.ModificarUsuario(u)) {
                JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente");
                limpiarCampos();
                ((Usuario) getParent()).cargarUsuarios();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarUsuarioMouseClicked

    private void btnActualizarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarUsuarioKeyPressed

    }//GEN-LAST:event_btnActualizarUsuarioKeyPressed

    private void btnEliminarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioMouseClicked
        if (!"admin".equalsIgnoreCase(config.Session.getUsuario().getRol())) {
            JOptionPane.showMessageDialog(this, "No tienes permiso para eliminar usuarios de plataforma");
            return;
        }
        try {
            int id = Integer.parseInt(txtIdUsuario.getText());
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                UsuariosDAO dao = new UsuariosDAO();
                if (dao.EliminarUsuario(id)) {
                    JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
                    limpiarCampos();
                    ((Usuario) getParent()).cargarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar usuario");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarUsuarioMouseClicked

    private void btnEliminarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioKeyPressed

    }//GEN-LAST:event_btnEliminarUsuarioKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarUsuario;
    private javax.swing.JLabel btnCrearUsuario;
    private javax.swing.JLabel btnEliminarUsuario;
    private components.CustomComboBox cbxRolUsuario;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEmailUsuario;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPassUsuario;
    private javax.swing.JLabel lblRolUsuario;
    private javax.swing.JLabel lblTelefonoUsuario;
    private components.RoundedPanel roundedPanelActualizarCliente;
    private components.RoundedPanel roundedPanelCrearUsuario;
    private components.RoundedPanel roundedPanelEliminarUsuario;
    private components.CustomTextField txtDocumento;
    private components.CustomTextField txtEmailUsuario;
    private components.CustomTextField txtIdUsuario;
    private components.CustomTextField txtNombreUsuario;
    private components.CustomPasswordField txtPassUsuario;
    private components.CustomTextField txtTelefonoUsuario;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtIdUsuario.setText("");
        txtNombreUsuario.setText("");
        txtDocumento.setText("");
        txtEmailUsuario.setText("");
        txtPassUsuario.setText("");
        txtTelefonoUsuario.setText("");
        cbxRolUsuario.setSelectedIndex(0);
        txtNombreUsuario.requestFocus();
    }
}
