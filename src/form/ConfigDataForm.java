package form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

public class ConfigDataForm extends javax.swing.JPanel {

    public ConfigDataForm() {
        initComponents();
        setOpaque(false);
        btnCrearConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnActualizarConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtIdConfig.setVisible(false);

        cargarConfigEnTabla();

        tableDatos.getColumnModel().getColumn(0).setMinWidth(0);
        tableDatos.getColumnModel().getColumn(0).setMaxWidth(0);

        tableDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tableDatos.getSelectedRow();
                if (fila >= 0) {
                    cargarDatosEnFormulario(fila);
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

    private void cargarConfigEnTabla() {
        model.ConfigDAO dao = new model.ConfigDAO();
        List<model.Config> lista = dao.listarConfig();

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableDatos.getModel();
        modelo.setRowCount(0);

        for (model.Config cfg : lista) {
            modelo.addRow(new Object[]{
                cfg.getId(),
                cfg.getNombre(),
                cfg.getRuc(),
                cfg.getTelefono(),
                cfg.getDireccion(),
                cfg.getRazon_social()
            });
        }
    }

    private void cargarDatosEnFormulario(int fila) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableDatos.getModel();

        txtIdConfig.setText(modelo.getValueAt(fila, 0).toString());
        txtNombreEmpresa.setText(modelo.getValueAt(fila, 1).toString());
        txtRucEmpresa.setText(modelo.getValueAt(fila, 2).toString());
        txtTelefonoEmpresa.setText(modelo.getValueAt(fila, 3).toString());
        txtDireccionEmpresa.setText(modelo.getValueAt(fila, 4).toString());
        txtRazonEmpresa.setText(modelo.getValueAt(fila, 5).toString());
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
        roundedPanelEliminarConfig = new components.RoundedPanel();
        btnEliminarConfig = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatos = new components.CustomTable();
        txtIdConfig = new javax.swing.JTextField();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        lblTitleFormCategoria.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblTitleFormCategoria.setForeground(new java.awt.Color(196, 94, 95));
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

        roundedPanelEliminarConfig.setBottomColor(new java.awt.Color(213, 69, 53));
        roundedPanelEliminarConfig.setCornerRadius(10);
        roundedPanelEliminarConfig.setTopColor(new java.awt.Color(224, 109, 106));
        roundedPanelEliminarConfig.setLayout(null);

        btnEliminarConfig.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnEliminarConfig.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarConfig.setText("Eliminar datos");
        btnEliminarConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarConfigMouseClicked(evt);
            }
        });
        btnEliminarConfig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarConfigKeyPressed(evt);
            }
        });
        roundedPanelEliminarConfig.add(btnEliminarConfig);
        btnEliminarConfig.setBounds(0, 0, 250, 40);

        add(roundedPanelEliminarConfig);
        roundedPanelEliminarConfig.setBounds(30, 480, 250, 40);

        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "RUC/NIT", "TELEFONO", "DIRECCION", "RAZON SOCIAL"
            }
        ));
        jScrollPane1.setViewportView(tableDatos);
        if (tableDatos.getColumnModel().getColumnCount() > 0) {
            tableDatos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableDatos.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableDatos.getColumnModel().getColumn(2).setPreferredWidth(70);
            tableDatos.getColumnModel().getColumn(4).setPreferredWidth(120);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(310, 20, 520, 500);
        add(txtIdConfig);
        txtIdConfig.setBounds(240, 40, 30, 23);
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
            if (txtIdConfig.getText().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para actualizar");
                return;
            }

            model.Config cfg = new model.Config();
            cfg.setId(Integer.parseInt(txtIdConfig.getText()));
            cfg.setNombre(txtNombreEmpresa.getText().trim());
            cfg.setRuc(Integer.parseInt(txtRucEmpresa.getText().trim()));
            cfg.setTelefono(Integer.parseInt(txtTelefonoEmpresa.getText().trim()));
            cfg.setDireccion(txtDireccionEmpresa.getText().trim());
            cfg.setRazon_social(txtRazonEmpresa.getText().trim());
            cfg.setFecha(new java.sql.Timestamp(System.currentTimeMillis()));

            model.ConfigDAO dao = new model.ConfigDAO();
            boolean actualizado = dao.actualizarConfig(cfg);

            if (actualizado) {
                javax.swing.JOptionPane.showMessageDialog(this, "Configuración actualizada correctamente");
                int fila = tableDatos.getSelectedRow();
                javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableDatos.getModel();
                modelo.setValueAt(cfg.getNombre(), fila, 1);
                modelo.setValueAt(cfg.getRuc(), fila, 2);
                modelo.setValueAt(cfg.getTelefono(), fila, 3);
                modelo.setValueAt(cfg.getDireccion(), fila, 4);
                modelo.setValueAt(cfg.getRazon_social(), fila, 5);
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

        try {
            model.Config cfg = new model.Config();
            cfg.setNombre(txtNombreEmpresa.getText().trim());
            cfg.setRuc(Integer.parseInt(txtRucEmpresa.getText().trim()));
            cfg.setTelefono(Integer.parseInt(txtTelefonoEmpresa.getText().trim()));
            cfg.setDireccion(txtDireccionEmpresa.getText().trim());
            cfg.setRazon_social(txtRazonEmpresa.getText().trim());
            cfg.setFecha(new java.sql.Timestamp(System.currentTimeMillis()));

            model.ConfigDAO dao = new model.ConfigDAO();

            boolean registrado = dao.registrarConfig(cfg);

            if (registrado) {
                javax.swing.JOptionPane.showMessageDialog(this, "Configuración registrada correctamente");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar configuración");
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Verifique los campos numéricos (RUC, Teléfono)");
        }

    }//GEN-LAST:event_btnCrearConfigMouseClicked

    private void btnCrearConfigKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearConfigKeyPressed

    }//GEN-LAST:event_btnCrearConfigKeyPressed

    private void btnEliminarConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarConfigMouseClicked
        try {
            if (txtIdConfig.getText().isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para eliminar");
                return;
            }

            int id = Integer.parseInt(txtIdConfig.getText());
            int opcion = javax.swing.JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de eliminar esta configuración?",
                    "Confirmar eliminación",
                    javax.swing.JOptionPane.YES_NO_OPTION
            );

            if (opcion == javax.swing.JOptionPane.YES_OPTION) {
                model.ConfigDAO dao = new model.ConfigDAO();
                boolean eliminado = dao.eliminarConfig(id);

                if (eliminado) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Configuración eliminada correctamente");
                    int fila = tableDatos.getSelectedRow();
                    javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableDatos.getModel();
                    modelo.removeRow(fila);
                    limpiarCamposFormulario();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar configuración");
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Eliminación cancelada");
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID inválido");
        }
    }//GEN-LAST:event_btnEliminarConfigMouseClicked

    private void btnEliminarConfigKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarConfigKeyPressed

    }//GEN-LAST:event_btnEliminarConfigKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarConfig;
    private javax.swing.JLabel btnCrearConfig;
    private javax.swing.JLabel btnEliminarConfig;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDireccionEmpresa1;
    private javax.swing.JLabel lblNombreEmpresa;
    private javax.swing.JLabel lblRazonEmpresa;
    private javax.swing.JLabel lblRucEmpresa;
    private javax.swing.JLabel lblTelefonoEmpresa;
    private javax.swing.JLabel lblTitleFormCategoria;
    private components.RoundedPanel roundedPanelActualizarConfig;
    private components.RoundedPanel roundedPanelCrearConfig1;
    private components.RoundedPanel roundedPanelEliminarConfig;
    private components.CustomTable tableDatos;
    private components.CustomTextField txtDireccionEmpresa;
    private javax.swing.JTextField txtIdConfig;
    private components.CustomTextField txtNombreEmpresa;
    private components.CustomTextField txtRazonEmpresa;
    private components.CustomTextField txtRucEmpresa;
    private components.CustomTextField txtTelefonoEmpresa;
    // End of variables declaration//GEN-END:variables

    private void limpiarCamposFormulario() {
        txtIdConfig.setText("");
        txtNombreEmpresa.setText("");
        txtRucEmpresa.setText("");
        txtTelefonoEmpresa.setText("");
        txtDireccionEmpresa.setText("");
        txtRazonEmpresa.setText("");
    }
}
