package form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import model.ClientesDAO;
import model.Cliente;
import model.ValidacionesTextField;

public class ClientesForm extends javax.swing.JPanel {

    private final ClientesDAO client = new ClientesDAO();

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
        txtIdCliente.setVisible(false);
        txtFechaCliente.setVisible(false);
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

    public void setDatosCliente(int id, String nombre, String numeroDocumento, String telefono, String correo, String fecha) {
        txtIdCliente.setText(String.valueOf(id));
        txtNombreCliente.setText(nombre);
        txtDocumentoCliente.setText(numeroDocumento);
        txtTelefonoCliente.setText(telefono);
        txtEmailCliente.setText(correo);
        txtFechaCliente.setText(fecha);
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
        txtIdCliente = new components.CustomTextField();
        txtFechaCliente = new components.CustomTextField();
        lblDocumentoCliente = new javax.swing.JLabel();
        txtDocumentoCliente = new components.CustomTextField();

        setBackground(new java.awt.Color(61, 63, 65));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(null);

        txtTelefonoCliente.setForeground(new java.awt.Color(200, 200, 200));
        txtTelefonoCliente.setText("Ingrese el telefono del cliente");
        add(txtTelefonoCliente);
        txtTelefonoCliente.setBounds(30, 250, 290, 40);

        txtNombreCliente.setForeground(new java.awt.Color(200, 200, 200));
        txtNombreCliente.setText("Ingrese el nombre del cliente");
        add(txtNombreCliente);
        txtNombreCliente.setBounds(30, 40, 290, 40);

        txtEmailCliente.setForeground(new java.awt.Color(200, 200, 200));
        txtEmailCliente.setText("Ingrese el email del cliente");
        add(txtEmailCliente);
        txtEmailCliente.setBounds(30, 180, 290, 40);

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
        roundedPanelCrearCliente.setBounds(30, 320, 290, 40);

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
        roundedPanelActualizarCliente.setBounds(30, 380, 290, 40);

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
        roundedPanelEliminarCliente.setBounds(30, 440, 290, 40);

        lblNombreCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCliente.setText("Nombre completo");
        add(lblNombreCliente);
        lblNombreCliente.setBounds(40, 20, 150, 17);

        lblEmailCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblEmailCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblEmailCliente.setText("Correo electronico");
        add(lblEmailCliente);
        lblEmailCliente.setBounds(40, 160, 160, 17);

        lblTelefonoCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblTelefonoCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoCliente.setText("Telefono");
        add(lblTelefonoCliente);
        lblTelefonoCliente.setBounds(40, 230, 90, 17);
        add(txtIdCliente);
        txtIdCliente.setBounds(10, 490, 10, 33);
        add(txtFechaCliente);
        txtFechaCliente.setBounds(30, 490, 10, 33);

        lblDocumentoCliente.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblDocumentoCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblDocumentoCliente.setText("Numero de documento");
        add(lblDocumentoCliente);
        lblDocumentoCliente.setBounds(40, 90, 150, 17);

        txtDocumentoCliente.setForeground(new java.awt.Color(200, 200, 200));
        txtDocumentoCliente.setText("Ingrese numero de documento");
        add(txtDocumentoCliente);
        txtDocumentoCliente.setBounds(30, 110, 290, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearClienteMouseClicked
        ValidacionesTextField val = new ValidacionesTextField();
        String nombre = txtNombreCliente.getText().trim();
        String documento = txtDocumentoCliente.getText().trim();
        String correo = txtEmailCliente.getText().trim();
        String telefono = txtTelefonoCliente.getText().trim();
        if (!val.validarNombre(nombre)) {
            JOptionPane.showMessageDialog(this, "El nombre debe tener al menos 8 caracteres");
            return;
        }
        if (documento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el número de documento");
            return;
        }
        if (!val.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "Correo inválido");
            return;
        }
        if (!val.validarCelularColombia(telefono)) {
            JOptionPane.showMessageDialog(this, "El teléfono debe ser un número válido de 10 dígitos que empiece por 3");
            return;
        }
        try {
            ClientesDAO client = new ClientesDAO();

            if (client.buscarClientePorDocumento(documento) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un cliente registrado con ese número de documento");
                return;
            }
            Cliente nuevo = new Cliente();
            nuevo.setNombre(nombre);
            nuevo.setNumero_documento(documento);
            nuevo.setCorreo(correo);
            nuevo.setTelefono(telefono);
            if (client.RegistrarCliente(nuevo)) {
                JOptionPane.showMessageDialog(this, "Cliente registrado con éxito");
                limpiarCampos();
                if (getParent() instanceof Clientes panelClientes) {
                    panelClientes.cargarClientes();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar cliente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al registrar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCrearClienteMouseClicked

    private void btnCrearClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearClienteKeyPressed

    }//GEN-LAST:event_btnCrearClienteKeyPressed

    private void btnActualizarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarClienteMouseClicked
        try {
            Cliente c = new Cliente();
            c.setId(Integer.parseInt(txtIdCliente.getText()));
            c.setNombre(txtNombreCliente.getText());
            c.setNumero_documento(txtDocumentoCliente.getText());
            c.setTelefono(txtTelefonoCliente.getText());
            c.setCorreo(txtEmailCliente.getText());
            if (client.ModificarCliente(c)) {
                JOptionPane.showMessageDialog(this, "Cliente actualizado con éxito");
                limpiarCampos();
                if (getParent() instanceof Clientes) {
                    Clientes panelClientes = (Clientes) getParent();
                    panelClientes.cargarClientes();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar cliente");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: ID inválido");
        }
    }//GEN-LAST:event_btnActualizarClienteMouseClicked

    private void btnActualizarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarClienteKeyPressed

    }//GEN-LAST:event_btnActualizarClienteKeyPressed

    private void btnEliminarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarClienteMouseClicked
        if (!"admin".equalsIgnoreCase(config.Session.getUsuario().getRol())) {
            JOptionPane.showMessageDialog(this, "No tienes permiso para eliminar clientes");
            return;
        }
        try {
            int id = Integer.parseInt(txtIdCliente.getText());
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                if (client.EliminarCliente(id)) {
                    JOptionPane.showMessageDialog(this, "Cliente eliminado con éxito");
                    limpiarCampos();
                    if (getParent() instanceof Clientes) {
                        Clientes panelClientes = (Clientes) getParent();
                        panelClientes.cargarClientes();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar cliente");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: ID inválido");
        }
    }//GEN-LAST:event_btnEliminarClienteMouseClicked

    private void btnEliminarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarClienteKeyPressed

    }//GEN-LAST:event_btnEliminarClienteKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarCliente;
    private javax.swing.JLabel btnCrearCliente;
    private javax.swing.JLabel btnEliminarCliente;
    private javax.swing.JLabel lblDocumentoCliente;
    private javax.swing.JLabel lblEmailCliente;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblTelefonoCliente;
    private components.RoundedPanel roundedPanelActualizarCliente;
    private components.RoundedPanel roundedPanelCrearCliente;
    private components.RoundedPanel roundedPanelEliminarCliente;
    private components.CustomTextField txtDocumentoCliente;
    private components.CustomTextField txtEmailCliente;
    private components.CustomTextField txtFechaCliente;
    private components.CustomTextField txtIdCliente;
    private components.CustomTextField txtNombreCliente;
    private components.CustomTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtIdCliente.setText("");
        txtNombreCliente.setText("");
        txtDocumentoCliente.setText("");
        txtTelefonoCliente.setText("");
        txtEmailCliente.setText("");
        txtFechaCliente.setText("");
        txtNombreCliente.requestFocus();
    }
}
