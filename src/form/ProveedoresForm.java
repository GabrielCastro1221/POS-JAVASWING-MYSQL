package form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;

import model.Proveedores;
import model.ProveedoresDAO;
import model.ValidacionesTextField;

public class ProveedoresForm extends javax.swing.JPanel {

    public ProveedoresForm() {
        initComponents();
        btnCrearProveedor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnActualizarProveedor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarProveedor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtIdProveedor.setVisible(false);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRucProveedor = new javax.swing.JLabel();
        txtRucProveedor = new components.CustomTextField();
        lblNombreProveedor = new javax.swing.JLabel();
        txtNombreProveedor = new components.CustomTextField();
        lblVendedorProveedor = new javax.swing.JLabel();
        txtVendedorProveedor = new components.CustomTextField();
        lblDireccionProveedor = new javax.swing.JLabel();
        txtDireccionProveedor = new components.CustomTextField();
        lblTelefonoProveedor = new javax.swing.JLabel();
        txtTelefonoProveedor = new components.CustomTextField();
        lblRazonProvvedor = new javax.swing.JLabel();
        txtRazonProveedor = new components.CustomTextField();
        roundedPanelCrearProveedor = new components.RoundedPanel();
        btnCrearProveedor = new javax.swing.JLabel();
        roundedPanelActualizarProveedor = new components.RoundedPanel();
        btnActualizarProveedor = new javax.swing.JLabel();
        roundedPanelEliminarProveedor = new components.RoundedPanel();
        btnEliminarProveedor = new javax.swing.JLabel();
        txtIdProveedor = new components.CustomTextField();

        setBackground(new java.awt.Color(61, 63, 65));

        lblRucProveedor.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblRucProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblRucProveedor.setText("RUC/NIT");

        txtRucProveedor.setForeground(new java.awt.Color(200, 200, 200));
        txtRucProveedor.setText("Ingrese NIT");

        lblNombreProveedor.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreProveedor.setText("Nombre");

        txtNombreProveedor.setForeground(new java.awt.Color(200, 200, 200));
        txtNombreProveedor.setText("Ingrese Nombre");

        lblVendedorProveedor.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblVendedorProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblVendedorProveedor.setText("Vendedor");

        txtVendedorProveedor.setForeground(new java.awt.Color(200, 200, 200));
        txtVendedorProveedor.setText("Ingrese vendedor");

        lblDireccionProveedor.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblDireccionProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccionProveedor.setText("Direccion");

        txtDireccionProveedor.setForeground(new java.awt.Color(200, 200, 200));
        txtDireccionProveedor.setText("Ingrese direccion");
        txtDireccionProveedor.addActionListener(this::txtDireccionProveedorActionPerformed);

        lblTelefonoProveedor.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblTelefonoProveedor.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoProveedor.setText("Telefono");

        txtTelefonoProveedor.setForeground(new java.awt.Color(200, 200, 200));
        txtTelefonoProveedor.setText("Ingrese telefono");

        lblRazonProvvedor.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblRazonProvvedor.setForeground(new java.awt.Color(255, 255, 255));
        lblRazonProvvedor.setText("Razon social");

        txtRazonProveedor.setForeground(new java.awt.Color(200, 200, 200));
        txtRazonProveedor.setText("Ingrese razon social");

        roundedPanelCrearProveedor.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelCrearProveedor.setCornerRadius(10);
        roundedPanelCrearProveedor.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelCrearProveedor.setLayout(null);

        btnCrearProveedor.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnCrearProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrearProveedor.setText("Crear proveedor");
        btnCrearProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearProveedorMouseClicked(evt);
            }
        });
        btnCrearProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCrearProveedorKeyPressed(evt);
            }
        });
        roundedPanelCrearProveedor.add(btnCrearProveedor);
        btnCrearProveedor.setBounds(0, 0, 250, 40);

        roundedPanelActualizarProveedor.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelActualizarProveedor.setCornerRadius(10);
        roundedPanelActualizarProveedor.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelActualizarProveedor.setLayout(null);

        btnActualizarProveedor.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnActualizarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizarProveedor.setText("Actualizar proveedor");
        btnActualizarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarProveedorMouseClicked(evt);
            }
        });
        btnActualizarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarProveedorKeyPressed(evt);
            }
        });
        roundedPanelActualizarProveedor.add(btnActualizarProveedor);
        btnActualizarProveedor.setBounds(0, 0, 250, 40);

        roundedPanelEliminarProveedor.setBottomColor(new java.awt.Color(213, 69, 53));
        roundedPanelEliminarProveedor.setCornerRadius(10);
        roundedPanelEliminarProveedor.setTopColor(new java.awt.Color(224, 109, 106));
        roundedPanelEliminarProveedor.setLayout(null);

        btnEliminarProveedor.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnEliminarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarProveedor.setText("Eliminar proveedor");
        btnEliminarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarProveedorMouseClicked(evt);
            }
        });
        btnEliminarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarProveedorKeyPressed(evt);
            }
        });
        roundedPanelEliminarProveedor.add(btnEliminarProveedor);
        btnEliminarProveedor.setBounds(0, 0, 250, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblRazonProvvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblTelefonoProveedor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblVendedorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblRucProveedor)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtVendedorProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRazonProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addComponent(roundedPanelCrearProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roundedPanelActualizarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roundedPanelEliminarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRucProveedor)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVendedorProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVendedorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefonoProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDireccionProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lblRazonProvvedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRazonProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(roundedPanelCrearProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundedPanelActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundedPanelEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionProveedorActionPerformed

    }//GEN-LAST:event_txtDireccionProveedorActionPerformed

    private void btnCrearProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearProveedorMouseClicked
        ValidacionesTextField val = new ValidacionesTextField();

        String rucStr = txtRucProveedor.getText().trim();
        String nombre = txtNombreProveedor.getText().trim();
        String vendedor = txtVendedorProveedor.getText().trim();
        String telefono = txtTelefonoProveedor.getText().trim();
        String direccion = txtDireccionProveedor.getText().trim();
        String razon = txtRazonProveedor.getText().trim();

        if (!rucStr.matches("\\d{8,}")) {
            JOptionPane.showMessageDialog(this, "El RUC/NIT debe ser numérico y tener al menos 8 dígitos");
            return;
        }

        if (nombre.length() < 3) {
            JOptionPane.showMessageDialog(this, "El nombre del proveedor debe tener al menos 3 caracteres");
            return;
        }

        if (vendedor.length() < 3) {
            JOptionPane.showMessageDialog(this, "El nombre del vendedor debe tener al menos 3 caracteres");
            return;
        }

        if (!val.validarCelularColombia(telefono)) {
            JOptionPane.showMessageDialog(this, "El teléfono debe ser un número válido de 10 dígitos que empiece por 3");
            return;
        }

        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La dirección no puede estar vacía");
            return;
        }

        if (razon.length() < 5) {
            JOptionPane.showMessageDialog(this, "La razón social debe tener al menos 5 caracteres");
            return;
        }

        try {
            Proveedores proveedor = new Proveedores();
            proveedor.setRuc(Long.parseLong(rucStr));
            proveedor.setNombre(nombre);
            proveedor.setVendedor(vendedor);
            proveedor.setTelefono(telefono);
            proveedor.setDireccion(direccion);
            proveedor.setRazon_social(razon);

            ProveedoresDAO dao = new ProveedoresDAO();
            if (dao.registrarProveedor(proveedor)) {
                JOptionPane.showMessageDialog(this, "Proveedor registrado correctamente");
                limpiarCampos();
                ((Proveedor) getParent()).cargarProveedores();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar el proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El RUC debe contener solo números", "Dato inválido", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnCrearProveedorMouseClicked

    private void btnCrearProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearProveedorKeyPressed

    }//GEN-LAST:event_btnCrearProveedorKeyPressed

    private void btnActualizarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarProveedorMouseClicked
        try {
            Proveedores pr = new Proveedores();
            pr.setId(Integer.parseInt(txtIdProveedor.getText()));
            pr.setRuc(Long.parseLong(txtRucProveedor.getText().trim()));
            pr.setNombre(txtNombreProveedor.getText().trim());
            pr.setVendedor(txtVendedorProveedor.getText().trim());
            pr.setTelefono(txtTelefonoProveedor.getText().trim());
            pr.setDireccion(txtDireccionProveedor.getText().trim());
            pr.setRazon_social(txtRazonProveedor.getText().trim());

            ProveedoresDAO dao = new ProveedoresDAO();
            if (dao.modificarProveedor(pr)) {
                JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente");
                limpiarCampos();
                ((Proveedor) getParent()).cargarProveedores();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar proveedor");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarProveedorMouseClicked

    private void btnActualizarProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarProveedorKeyPressed

    }//GEN-LAST:event_btnActualizarProveedorKeyPressed

    private void btnEliminarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProveedorMouseClicked
        try {
            int id = Integer.parseInt(txtIdProveedor.getText());
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar este proveedor?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                ProveedoresDAO dao = new ProveedoresDAO();
                if (dao.eliminarProveedor(id)) {
                    JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente");
                    limpiarCampos();
                    ((Proveedor) getParent()).cargarProveedores();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar proveedor");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarProveedorMouseClicked

    private void btnEliminarProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarProveedorKeyPressed

    }//GEN-LAST:event_btnEliminarProveedorKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarProveedor;
    private javax.swing.JLabel btnCrearProveedor;
    private javax.swing.JLabel btnEliminarProveedor;
    private javax.swing.JLabel lblDireccionProveedor;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lblRazonProvvedor;
    private javax.swing.JLabel lblRucProveedor;
    private javax.swing.JLabel lblTelefonoProveedor;
    private javax.swing.JLabel lblVendedorProveedor;
    private components.RoundedPanel roundedPanelActualizarProveedor;
    private components.RoundedPanel roundedPanelCrearProveedor;
    private components.RoundedPanel roundedPanelEliminarProveedor;
    private components.CustomTextField txtDireccionProveedor;
    private components.CustomTextField txtIdProveedor;
    private components.CustomTextField txtNombreProveedor;
    private components.CustomTextField txtRazonProveedor;
    private components.CustomTextField txtRucProveedor;
    private components.CustomTextField txtTelefonoProveedor;
    private components.CustomTextField txtVendedorProveedor;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtRucProveedor.setText("");
        txtNombreProveedor.setText("");
        txtVendedorProveedor.setText("");
        txtTelefonoProveedor.setText("");
        txtDireccionProveedor.setText("");
        txtRazonProveedor.setText("");

        txtRucProveedor.requestFocus();
    }

    public void setDatosProveedor(String id, String ruc, String nombre, String vendedor, String telefono, String direccion, String razon) {
        txtIdProveedor.setText(id);
        txtRucProveedor.setText(ruc);
        txtNombreProveedor.setText(nombre);
        txtVendedorProveedor.setText(vendedor);
        txtTelefonoProveedor.setText(telefono);
        txtDireccionProveedor.setText(direccion);
        txtRazonProveedor.setText(razon);
    }
}
