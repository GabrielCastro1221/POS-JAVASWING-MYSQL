package form;

import model.Proveedores;
import model.ProveedoresDAO;
import config.Session;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CompraDAO;

public class ComprasProveedorForm extends javax.swing.JPanel {

    ProveedoresDAO provDAO = new ProveedoresDAO();

    public ComprasProveedorForm() {
        initComponents();
        setOpaque(false);
        cargarProveedores();
    }

    private void cargarProveedores() {
        cbxProveedorCompra.removeAllItems();
        for (Proveedores pr : provDAO.listarProveedores()) {
            cbxProveedorCompra.addItem(pr);
        }
    }

    public void actualizarTotal(double total) {
        lblTotalCompraF.setText("$ " + String.format("%.2f", total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProveedorCompra = new javax.swing.JLabel();
        cbxProveedorCompra = new components.CustomComboBox();
        lblNumeroFactura = new javax.swing.JLabel();
        txtNumeroFactura = new components.CustomTextField();
        roundedPanelGuardarCompra = new components.RoundedPanel();
        btnGuardarCompra = new javax.swing.JLabel();
        lblTotalCompra = new javax.swing.JLabel();
        lblTotalCompraF = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        lblProveedorCompra.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblProveedorCompra.setForeground(new java.awt.Color(255, 255, 255));
        lblProveedorCompra.setText("Proveedor");
        add(lblProveedorCompra);
        lblProveedorCompra.setBounds(40, 20, 110, 17);
        add(cbxProveedorCompra);
        cbxProveedorCompra.setBounds(40, 40, 142, 30);

        lblNumeroFactura.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNumeroFactura.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroFactura.setText("Numero de la factura");
        add(lblNumeroFactura);
        lblNumeroFactura.setBounds(280, 20, 150, 17);

        txtNumeroFactura.setForeground(new java.awt.Color(200, 200, 200));
        txtNumeroFactura.setText("numero de la factura");
        add(txtNumeroFactura);
        txtNumeroFactura.setBounds(250, 40, 210, 33);

        roundedPanelGuardarCompra.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelGuardarCompra.setTopColor(new java.awt.Color(0, 153, 255));

        btnGuardarCompra.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnGuardarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardarCompra.setText("Guardar Compra");
        btnGuardarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarCompraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundedPanelGuardarCompraLayout = new javax.swing.GroupLayout(roundedPanelGuardarCompra);
        roundedPanelGuardarCompra.setLayout(roundedPanelGuardarCompraLayout);
        roundedPanelGuardarCompraLayout.setHorizontalGroup(
            roundedPanelGuardarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelGuardarCompraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roundedPanelGuardarCompraLayout.setVerticalGroup(
            roundedPanelGuardarCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelGuardarCompraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(roundedPanelGuardarCompra);
        roundedPanelGuardarCompra.setBounds(520, 30, 150, 40);

        lblTotalCompra.setFont(new java.awt.Font("Caladea", 1, 18)); // NOI18N
        lblTotalCompra.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalCompra.setText("TOTAL COMPRA");
        add(lblTotalCompra);
        lblTotalCompra.setBounds(740, 40, 150, 22);

        lblTotalCompraF.setFont(new java.awt.Font("Caladea", 1, 20)); // NOI18N
        lblTotalCompraF.setForeground(new java.awt.Color(255, 255, 0));
        lblTotalCompraF.setText("$ ----------");
        add(lblTotalCompraF);
        lblTotalCompraF.setBounds(900, 30, 130, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCompraMouseClicked
        Object seleccionado = cbxProveedorCompra.getSelectedItem();
        if (!(seleccionado instanceof Proveedores)) {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor válido");
            return;
        }
        Proveedores proveedor = (Proveedores) seleccionado;
        String numeroFactura = txtNumeroFactura.getText().trim();
        if (numeroFactura.isEmpty() || numeroFactura.equalsIgnoreCase("numero de la factura")) {
            JOptionPane.showMessageDialog(this, "Ingresa el número de factura del proveedor");
            return;
        }
        if (!(getParent() instanceof Compras)) {
            return;
        }
        Compras panelCompra = (Compras) getParent();
        DefaultTableModel modelo = (DefaultTableModel) panelCompra.getTableCompras().getModel();

        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Agrega al menos un producto a la compra");
            return;
        }
        String itemsJson = construirJsonItems(modelo);
        Integer usuarioId = (Session.getUsuario() != null) ? Session.getUsuario().getId() : null;
        CompraDAO compraDAO = new CompraDAO();
        CompraDAO.ResultadoCompra resultado = compraDAO.registrarCompraTransaccional(proveedor.getId(), usuarioId, numeroFactura, itemsJson);
        JOptionPane.showMessageDialog(this, resultado.mensaje);
        if (resultado.compraId > 0) {
            actualizarTotal(panelCompra.getTotalCompra());
            panelCompra.limpiarTabla();
            txtNumeroFactura.setText("");
        }
    }//GEN-LAST:event_btnGuardarCompraMouseClicked

    private String construirJsonItems(DefaultTableModel modelo) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int productoId = (int) modelo.getValueAt(i, 0);
            int cantidad = (int) modelo.getValueAt(i, 3);
            double costoUnitario = (double) modelo.getValueAt(i, 4);
            double tasaIva = (double) modelo.getValueAt(i, 5);
            if (i > 0) {
                sb.append(",");
            }
            sb.append("{\"producto_id\":").append(productoId)
                    .append(",\"cantidad\":").append(cantidad)
                    .append(",\"costo_unitario\":").append(costoUnitario)
                    .append(",\"tasa_iva\":").append(tasaIva)
                    .append("}");
        }
        sb.append("]");
        return sb.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGuardarCompra;
    private components.CustomComboBox cbxProveedorCompra;
    private javax.swing.JLabel lblNumeroFactura;
    private javax.swing.JLabel lblProveedorCompra;
    private javax.swing.JLabel lblTotalCompra;
    private javax.swing.JLabel lblTotalCompraF;
    private components.RoundedPanel roundedPanelGuardarCompra;
    private components.CustomTextField txtNumeroFactura;
    // End of variables declaration//GEN-END:variables
}
