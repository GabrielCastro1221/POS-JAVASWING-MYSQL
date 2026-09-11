package form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import model.ValidacionesTextField;

public class ConfigDataForm extends javax.swing.JPanel {

    public ConfigDataForm() {
        initComponents();
        setOpaque(false);
        btnCrearConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnActualizarConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtIdConfig.setVisible(false);

        model.ConfigDAO dao = new model.ConfigDAO();
        model.Config cfg = dao.obtenerUltimaConfig();
        if (cfg != null) {
            txtIdConfig.setText(String.valueOf(cfg.getId()));
            mostrarConfigEnLabels(cfg);
        } else {
            limpiarLabels();
        }

        lblNombreConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    model.ConfigDAO dao = new model.ConfigDAO();
                    model.Config cfg = dao.obtenerUltimaConfig();
                    if (cfg != null) {
                        cargarConfigEnFormulario(cfg);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(ConfigDataForm.this, "No hay configuración registrada");
                    }
                }
            }
        });

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

    private void mostrarConfigEnLabels(model.Config cfg) {
        lblNombreConfig.setText(cfg.getNombre());
        lblRucConfig.setText(String.valueOf(cfg.getRuc()));
        lblTelefonoConfig1.setText(String.valueOf(cfg.getTelefono()));
        lblDireccionConfig.setText(cfg.getDireccion());
        lblRazonConfig.setText(cfg.getRazon_social());
    }

    private void cargarConfigEnFormulario(model.Config cfg) {
        txtIdConfig.setText(String.valueOf(cfg.getId()));
        txtNombreEmpresa.setText(cfg.getNombre());
        txtRucEmpresa.setText(String.valueOf(cfg.getRuc()));
        txtTelefonoEmpresa.setText(String.valueOf(cfg.getTelefono()));
        txtDireccionEmpresa.setText(cfg.getDireccion());
        txtRazonEmpresa.setText(cfg.getRazon_social());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitleFormCategoria = new javax.swing.JLabel();
        lblRazonEmpresa = new javax.swing.JLabel();
        txtRazonEmpresa = new components.CustomTextField();
        lblNombreEmpresa = new javax.swing.JLabel();
        txtNombreEmpresa = new components.CustomTextField();
        lblRucEmpresa = new javax.swing.JLabel();
        txtRucEmpresa = new components.CustomTextField();
        lblTelefonoEmpresa = new javax.swing.JLabel();
        txtTelefonoEmpresa = new components.CustomTextField();
        lblDireccionEmpresa1 = new javax.swing.JLabel();
        txtDireccionEmpresa = new components.CustomTextField();
        roundedPanelActualizarConfig = new components.RoundedPanel();
        btnActualizarConfig = new javax.swing.JLabel();
        roundedPanelCrearConfig1 = new components.RoundedPanel();
        btnCrearConfig = new javax.swing.JLabel();
        txtIdConfig = new javax.swing.JTextField();
        lblNombreConfig = new javax.swing.JLabel();
        lblRucConfig = new javax.swing.JLabel();
        lblRucTitle = new javax.swing.JLabel();
        lblRazonConfig = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTelefonoConfig1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDireccionConfig = new javax.swing.JLabel();
        picture1 = new components.Picture();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        lblTitleFormCategoria.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblTitleFormCategoria.setForeground(new java.awt.Color(255, 51, 51));
        lblTitleFormCategoria.setText("Datos de empresa");
        add(lblTitleFormCategoria);
        lblTitleFormCategoria.setBounds(40, 20, 240, 28);

        lblRazonEmpresa.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblRazonEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblRazonEmpresa.setText("Razon social");
        add(lblRazonEmpresa);
        lblRazonEmpresa.setBounds(40, 310, 80, 17);

        txtRazonEmpresa.setForeground(new java.awt.Color(200, 200, 200));
        txtRazonEmpresa.setText("Razon social de la empresa");
        txtRazonEmpresa.addActionListener(this::txtRazonEmpresaActionPerformed);
        add(txtRazonEmpresa);
        txtRazonEmpresa.setBounds(30, 330, 250, 33);

        lblNombreEmpresa.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEmpresa.setText("Nombre");
        add(lblNombreEmpresa);
        lblNombreEmpresa.setBounds(40, 70, 70, 17);

        txtNombreEmpresa.setForeground(new java.awt.Color(200, 200, 200));
        txtNombreEmpresa.setText("Nombre de la empresa");
        add(txtNombreEmpresa);
        txtNombreEmpresa.setBounds(30, 90, 250, 33);

        lblRucEmpresa.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblRucEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblRucEmpresa.setText("RUC/NIT");
        add(lblRucEmpresa);
        lblRucEmpresa.setBounds(40, 130, 70, 17);

        txtRucEmpresa.setForeground(new java.awt.Color(200, 200, 200));
        txtRucEmpresa.setText("RUC/NIT de la empresa");
        txtRucEmpresa.addActionListener(this::txtRucEmpresaActionPerformed);
        add(txtRucEmpresa);
        txtRucEmpresa.setBounds(30, 150, 250, 33);

        lblTelefonoEmpresa.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblTelefonoEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoEmpresa.setText("Telefono");
        add(lblTelefonoEmpresa);
        lblTelefonoEmpresa.setBounds(40, 190, 70, 17);

        txtTelefonoEmpresa.setForeground(new java.awt.Color(200, 200, 200));
        txtTelefonoEmpresa.setText("Telefono de la empresa");
        txtTelefonoEmpresa.addActionListener(this::txtTelefonoEmpresaActionPerformed);
        add(txtTelefonoEmpresa);
        txtTelefonoEmpresa.setBounds(30, 210, 250, 33);

        lblDireccionEmpresa1.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblDireccionEmpresa1.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccionEmpresa1.setText("Direccion");
        add(lblDireccionEmpresa1);
        lblDireccionEmpresa1.setBounds(40, 250, 70, 17);

        txtDireccionEmpresa.setForeground(new java.awt.Color(200, 200, 200));
        txtDireccionEmpresa.setText("Direccion de la empresa");
        txtDireccionEmpresa.addActionListener(this::txtDireccionEmpresaActionPerformed);
        add(txtDireccionEmpresa);
        txtDireccionEmpresa.setBounds(30, 270, 250, 33);

        roundedPanelActualizarConfig.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelActualizarConfig.setCornerRadius(10);
        roundedPanelActualizarConfig.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelActualizarConfig.setLayout(null);

        btnActualizarConfig.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnActualizarConfig.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizarConfig.setText("Actualizar datos");
        btnActualizarConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarConfigMouseClicked(evt);
            }
        });
        btnActualizarConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarConfigKeyPressed(evt);
            }
        });
        roundedPanelActualizarConfig.add(btnActualizarConfig);
        btnActualizarConfig.setBounds(0, 0, 250, 40);

        add(roundedPanelActualizarConfig);
        roundedPanelActualizarConfig.setBounds(30, 430, 250, 40);

        roundedPanelCrearConfig1.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelCrearConfig1.setCornerRadius(10);
        roundedPanelCrearConfig1.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelCrearConfig1.setLayout(null);

        btnCrearConfig.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnCrearConfig.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrearConfig.setText("Crear datos");
        btnCrearConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearConfigMouseClicked(evt);
            }
        });
        btnCrearConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCrearConfigKeyPressed(evt);
            }
        });
        roundedPanelCrearConfig1.add(btnCrearConfig);
        btnCrearConfig.setBounds(0, 0, 250, 40);

        add(roundedPanelCrearConfig1);
        roundedPanelCrearConfig1.setBounds(30, 380, 250, 40);
        add(txtIdConfig);
        txtIdConfig.setBounds(240, 40, 30, 23);

        lblNombreConfig.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        lblNombreConfig.setForeground(new java.awt.Color(255, 51, 51));
        lblNombreConfig.setText("Miscelanea Bellavista");
        add(lblNombreConfig);
        lblNombreConfig.setBounds(370, 80, 370, 50);

        lblRucConfig.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblRucConfig.setForeground(new java.awt.Color(255, 255, 255));
        lblRucConfig.setText("1053782271");
        add(lblRucConfig);
        lblRucConfig.setBounds(540, 160, 150, 20);

        lblRucTitle.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblRucTitle.setForeground(new java.awt.Color(255, 51, 51));
        lblRucTitle.setText("RUC/NIT:");
        add(lblRucTitle);
        lblRucTitle.setBounds(430, 160, 110, 28);

        lblRazonConfig.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblRazonConfig.setForeground(new java.awt.Color(255, 255, 255));
        lblRazonConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRazonConfig.setText("Tu tienda de confianza!");
        add(lblRazonConfig);
        lblRazonConfig.setBounds(420, 250, 270, 28);

        jLabel2.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Telefono:");
        add(jLabel2);
        jLabel2.setBounds(430, 190, 110, 28);

        lblTelefonoConfig1.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblTelefonoConfig1.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoConfig1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTelefonoConfig1.setText("3146381395");
        add(lblTelefonoConfig1);
        lblTelefonoConfig1.setBounds(530, 190, 150, 28);

        jLabel3.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Direccion:");
        add(jLabel3);
        jLabel3.setBounds(420, 220, 120, 28);

        lblDireccionConfig.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblDireccionConfig.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccionConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDireccionConfig.setText("Calle 9B #7-59");
        add(lblDireccionConfig);
        lblDireccionConfig.setBounds(530, 220, 170, 28);

        picture1.setPath("/assets/Logo.png");
        add(picture1);
        picture1.setBounds(380, 300, 350, 170);
    }// </editor-fold>//GEN-END:initComponents

    private void txtRazonEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonEmpresaActionPerformed

    }//GEN-LAST:event_txtRazonEmpresaActionPerformed

    private void txtRucEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucEmpresaActionPerformed

    }//GEN-LAST:event_txtRucEmpresaActionPerformed

    private void txtTelefonoEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoEmpresaActionPerformed

    }//GEN-LAST:event_txtTelefonoEmpresaActionPerformed

    private void txtDireccionEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionEmpresaActionPerformed

    }//GEN-LAST:event_txtDireccionEmpresaActionPerformed

    private void btnActualizarConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarConfigMouseClicked
        try {
            model.Config cfg = new model.Config();
            cfg.setId(Integer.parseInt(txtIdConfig.getText()));
            cfg.setNombre(txtNombreEmpresa.getText().trim());
            cfg.setRuc(Long.parseLong(txtRucEmpresa.getText().trim()));
            cfg.setTelefono(txtTelefonoEmpresa.getText().trim());
            cfg.setDireccion(txtDireccionEmpresa.getText().trim());
            cfg.setRazon_social(txtRazonEmpresa.getText().trim());
            cfg.setFecha(new java.sql.Timestamp(System.currentTimeMillis()));

            model.ConfigDAO dao = new model.ConfigDAO();
            boolean actualizado = dao.actualizarConfig(cfg);

            if (actualizado) {
                javax.swing.JOptionPane.showMessageDialog(this, "Configuración actualizada correctamente");
                mostrarConfigEnLabels(cfg);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar configuración");
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Verifique los campos numéricos (RUC, Teléfono)");
        }
    }//GEN-LAST:event_btnActualizarConfigMouseClicked

    private void btnActualizarConfigKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarConfigKeyPressed

    }//GEN-LAST:event_btnActualizarConfigKeyPressed

    private void btnCrearConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearConfigMouseClicked
        ValidacionesTextField val = new ValidacionesTextField();

        String nombre = txtNombreEmpresa.getText().trim();
        String rucStr = txtRucEmpresa.getText().trim();
        String telefono = txtTelefonoEmpresa.getText().trim();
        String direccion = txtDireccionEmpresa.getText().trim();
        String razon = txtRazonEmpresa.getText().trim();

        if (!val.validarNombre(nombre)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El nombre debe tener al menos 8 caracteres");
            return;
        }

        if (!rucStr.matches("\\d{8,10}")) {
            javax.swing.JOptionPane.showMessageDialog(this, "El RUC/NIT debe ser numérico y tener entre 8 y 10 dígitos");
            return;
        }

        if (!val.validarCelularColombia(telefono)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El teléfono debe ser un número válido de 10 dígitos que empiece por 3");
            return;
        }

        if (direccion.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "La dirección no puede estar vacía");
            return;
        }

        if (razon.length() < 5) {
            javax.swing.JOptionPane.showMessageDialog(this, "La razón social debe tener al menos 5 caracteres");
            return;
        }

        try {
            model.Config cfg = new model.Config();
            cfg.setNombre(nombre);
            cfg.setRuc(Long.parseLong(rucStr));
            cfg.setTelefono(telefono);
            cfg.setDireccion(direccion);
            cfg.setRazon_social(razon);
            cfg.setFecha(new java.sql.Timestamp(System.currentTimeMillis()));

            model.ConfigDAO dao = new model.ConfigDAO();
            boolean registrado = dao.registrarConfig(cfg);

            if (registrado) {
                javax.swing.JOptionPane.showMessageDialog(this, "Configuración registrada correctamente");
                mostrarConfigEnLabels(cfg);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar configuración");
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Verifique los campos numéricos (RUC, Teléfono)");
        }
    }//GEN-LAST:event_btnCrearConfigMouseClicked

    private void btnCrearConfigKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearConfigKeyPressed

    }//GEN-LAST:event_btnCrearConfigKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarConfig;
    private javax.swing.JLabel btnCrearConfig;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDireccionConfig;
    private javax.swing.JLabel lblDireccionEmpresa1;
    private javax.swing.JLabel lblNombreConfig;
    private javax.swing.JLabel lblNombreEmpresa;
    private javax.swing.JLabel lblRazonConfig;
    private javax.swing.JLabel lblRazonEmpresa;
    private javax.swing.JLabel lblRucConfig;
    private javax.swing.JLabel lblRucEmpresa;
    private javax.swing.JLabel lblRucTitle;
    private javax.swing.JLabel lblTelefonoConfig1;
    private javax.swing.JLabel lblTelefonoEmpresa;
    private javax.swing.JLabel lblTitleFormCategoria;
    private components.Picture picture1;
    private components.RoundedPanel roundedPanelActualizarConfig;
    private components.RoundedPanel roundedPanelCrearConfig1;
    private components.CustomTextField txtDireccionEmpresa;
    private javax.swing.JTextField txtIdConfig;
    private components.CustomTextField txtNombreEmpresa;
    private components.CustomTextField txtRazonEmpresa;
    private components.CustomTextField txtRucEmpresa;
    private components.CustomTextField txtTelefonoEmpresa;
    // End of variables declaration//GEN-END:variables

    private void limpiarLabels() {
        lblNombreConfig.setText("Sin configuración");
        lblRucConfig.setText("-");
        lblTelefonoConfig1.setText("-");
        lblDireccionConfig.setText("-");
        lblRazonConfig.setText("-");
    }
}
