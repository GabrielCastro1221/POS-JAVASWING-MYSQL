package form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class ClientesForm extends javax.swing.JPanel {

    public ClientesForm() {
        initComponents();
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        roundedPanelCrearCliente.setOpaque(false);
        roundedPanelCrearCliente.setBackground(new Color(0, 0, 0, 0));
        btnCrearCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnActualizarCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

        txtTelefonoCliente = new components.CustomTextField();
        txtNombreCliente = new components.CustomTextField();
        txtEmailCliente = new components.CustomTextField();
        roundedPanelCrearCliente = new components.RoundedPanel();
        btnCrearCliente = new javax.swing.JLabel();
        roundedPanelActualizarCliente = new components.RoundedPanel();
        btnActualizarCliente = new javax.swing.JLabel();
        roundedPanelEliminarCliente = new components.RoundedPanel();
        btnEliminarCliente = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        lblEmailCliente = new javax.swing.JLabel();
        lblTelefonoCliente = new javax.swing.JLabel();
        lblTitleFormClientes = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 63, 65));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(null);

        txtTelefonoCliente.setForeground(new java.awt.Color(200, 200, 200));
        txtTelefonoCliente.setText("Ingrese el telefono del cliente");
        add(txtTelefonoCliente);
        txtTelefonoCliente.setBounds(30, 240, 290, 40);

        txtNombreCliente.setForeground(new java.awt.Color(200, 200, 200));
        txtNombreCliente.setText("Ingrese el nombre del cliente");
        add(txtNombreCliente);
        txtNombreCliente.setBounds(30, 100, 290, 40);

        txtEmailCliente.setForeground(new java.awt.Color(200, 200, 200));
        txtEmailCliente.setText("Ingrese el email del cliente");
        add(txtEmailCliente);
        txtEmailCliente.setBounds(30, 170, 290, 40);

        roundedPanelCrearCliente.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelCrearCliente.setCornerRadius(10);
        roundedPanelCrearCliente.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelCrearCliente.setLayout(null);

        btnCrearCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnCrearCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrearCliente.setText("Crear cliente");
        btnCrearCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearClienteMouseClicked(evt);
            }
        });
        btnCrearCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCrearClienteKeyPressed(evt);
            }
        });
        roundedPanelCrearCliente.add(btnCrearCliente);
        btnCrearCliente.setBounds(0, 0, 290, 40);

        add(roundedPanelCrearCliente);
        roundedPanelCrearCliente.setBounds(30, 300, 290, 40);

        roundedPanelActualizarCliente.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelActualizarCliente.setCornerRadius(10);
        roundedPanelActualizarCliente.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelActualizarCliente.setLayout(null);

        btnActualizarCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnActualizarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizarCliente.setText("Actualizar cliente");
        btnActualizarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarClienteMouseClicked(evt);
            }
        });
        btnActualizarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarClienteKeyPressed(evt);
            }
        });
        roundedPanelActualizarCliente.add(btnActualizarCliente);
        btnActualizarCliente.setBounds(0, 0, 290, 40);

        add(roundedPanelActualizarCliente);
        roundedPanelActualizarCliente.setBounds(30, 360, 290, 40);

        roundedPanelEliminarCliente.setBottomColor(new java.awt.Color(213, 69, 53));
        roundedPanelEliminarCliente.setCornerRadius(10);
        roundedPanelEliminarCliente.setTopColor(new java.awt.Color(224, 109, 106));
        roundedPanelEliminarCliente.setLayout(null);

        btnEliminarCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarCliente.setText("Eliminar cliente");
        btnEliminarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarClienteMouseClicked(evt);
            }
        });
        btnEliminarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarClienteKeyPressed(evt);
            }
        });
        roundedPanelEliminarCliente.add(btnEliminarCliente);
        btnEliminarCliente.setBounds(0, 0, 290, 40);

        add(roundedPanelEliminarCliente);
        roundedPanelEliminarCliente.setBounds(30, 420, 290, 40);

        lblNombreCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCliente.setText("Nombre completo");
        add(lblNombreCliente);
        lblNombreCliente.setBounds(40, 80, 150, 17);

        lblEmailCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblEmailCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailCliente.setText("Correo electronico");
        add(lblEmailCliente);
        lblEmailCliente.setBounds(40, 150, 160, 17);

        lblTelefonoCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblTelefonoCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoCliente.setText("Telefono");
        add(lblTelefonoCliente);
        lblTelefonoCliente.setBounds(40, 220, 90, 17);

        lblTitleFormClientes.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblTitleFormClientes.setForeground(new java.awt.Color(196, 94, 95));
        lblTitleFormClientes.setText("Formulario clientes");
        add(lblTitleFormClientes);
        lblTitleFormClientes.setBounds(30, 20, 300, 28);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearClienteMouseClicked

    }//GEN-LAST:event_btnCrearClienteMouseClicked

    private void btnCrearClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearClienteKeyPressed

    }//GEN-LAST:event_btnCrearClienteKeyPressed

    private void btnActualizarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarClienteMouseClicked

    }//GEN-LAST:event_btnActualizarClienteMouseClicked

    private void btnActualizarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarClienteKeyPressed

    }//GEN-LAST:event_btnActualizarClienteKeyPressed

    private void btnEliminarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarClienteMouseClicked

    }//GEN-LAST:event_btnEliminarClienteMouseClicked

    private void btnEliminarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarClienteKeyPressed

    }//GEN-LAST:event_btnEliminarClienteKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarCliente;
    private javax.swing.JLabel btnCrearCliente;
    private javax.swing.JLabel btnEliminarCliente;
    private javax.swing.JLabel lblEmailCliente;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblTelefonoCliente;
    private javax.swing.JLabel lblTitleFormClientes;
    private components.RoundedPanel roundedPanelActualizarCliente;
    private components.RoundedPanel roundedPanelCrearCliente;
    private components.RoundedPanel roundedPanelEliminarCliente;
    private components.CustomTextField txtEmailCliente;
    private components.CustomTextField txtNombreCliente;
    private components.CustomTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
