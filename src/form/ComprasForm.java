package form;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import model.ProveedoresDAO;

public class ComprasForm extends javax.swing.JPanel {

    ProveedoresDAO provDAO = new ProveedoresDAO();

    public ComprasForm() {
        initComponents();
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        cargarProveedores(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int arc = 25;
        RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.draw(rounded);
        g2.dispose();
    }

    private void cargarProveedores() {
        cbxProveedorCompra.removeAllItems();
        for (model.Proveedores pr : provDAO.listarProveedores()) {
            cbxProveedorCompra.addItem(pr.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitleFormCompras = new javax.swing.JLabel();
        lblNumeroFactura = new javax.swing.JLabel();
        txtNumeroFactura = new components.CustomTextField();
        lblSubtotal = new javax.swing.JLabel();
        txtIvaPagado = new components.CustomTextField();
        lblIvaPagado = new javax.swing.JLabel();
        txtSubtotal1 = new components.CustomTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new components.CustomTextField();
        lblProveedorCompra = new javax.swing.JLabel();
        cbxProveedorCompra = new components.CustomComboBox();
        roundedPanelCrearCompra = new components.RoundedPanel();
        btnCrearCompra = new javax.swing.JLabel();
        roundedPanelActualizarCompra = new components.RoundedPanel();
        btnActualizarCompra = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 63, 65));

        lblTitleFormCompras.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblTitleFormCompras.setForeground(new java.awt.Color(204, 0, 0));
        lblTitleFormCompras.setText("Formulario compras");

        lblNumeroFactura.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNumeroFactura.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroFactura.setText("Numero de Factura proovedeor");

        txtNumeroFactura.setForeground(new java.awt.Color(200, 200, 200));
        txtNumeroFactura.setText("Ingrese el numerode la factura");

        lblSubtotal.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtotal.setText("Subtotal");

        txtIvaPagado.setForeground(new java.awt.Color(200, 200, 200));
        txtIvaPagado.setText("Ingrese Iva");

        lblIvaPagado.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblIvaPagado.setForeground(new java.awt.Color(255, 255, 255));
        lblIvaPagado.setText("Iva pagado");

        txtSubtotal1.setForeground(new java.awt.Color(200, 200, 200));
        txtSubtotal1.setText("Ingrese subtotal");
        txtSubtotal1.addActionListener(this::txtSubtotal1ActionPerformed);

        lblTotal.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("Total compra");

        txtTotal.setForeground(new java.awt.Color(200, 200, 200));
        txtTotal.setText("Total de la venta");

        lblProveedorCompra.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblProveedorCompra.setForeground(new java.awt.Color(255, 255, 255));
        lblProveedorCompra.setText("Proveedor");

        roundedPanelCrearCompra.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelCrearCompra.setCornerRadius(10);
        roundedPanelCrearCompra.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelCrearCompra.setLayout(null);

        btnCrearCompra.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnCrearCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrearCompra.setText("Crear compra");
        btnCrearCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearCompraMouseClicked(evt);
            }
        });
        btnCrearCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCrearCompraKeyPressed(evt);
            }
        });
        roundedPanelCrearCompra.add(btnCrearCompra);
        btnCrearCompra.setBounds(0, 0, 260, 40);

        roundedPanelActualizarCompra.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelActualizarCompra.setCornerRadius(10);
        roundedPanelActualizarCompra.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelActualizarCompra.setLayout(null);

        btnActualizarCompra.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnActualizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizarCompra.setText("Actualizar compra");
        btnActualizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarCompraMouseClicked(evt);
            }
        });
        btnActualizarCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarCompraKeyPressed(evt);
            }
        });
        roundedPanelActualizarCompra.add(btnActualizarCompra);
        btnActualizarCompra.setBounds(0, 0, 260, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNumeroFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(lblSubtotal))
                                .addComponent(txtSubtotal1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(lblIvaPagado)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIvaPagado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblProveedorCompra)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxProveedorCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addComponent(roundedPanelCrearCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundedPanelActualizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblTitleFormCompras))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblNumeroFactura)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitleFormCompras)
                .addGap(29, 29, 29)
                .addComponent(lblNumeroFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubtotal)
                    .addComponent(lblIvaPagado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIvaPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblProveedorCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(roundedPanelCrearCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundedPanelActualizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSubtotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotal1ActionPerformed

    }//GEN-LAST:event_txtSubtotal1ActionPerformed

    private void btnCrearCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCompraMouseClicked

    }//GEN-LAST:event_btnCrearCompraMouseClicked

    private void btnCrearCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearCompraKeyPressed

    }//GEN-LAST:event_btnCrearCompraKeyPressed

    private void btnActualizarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarCompraMouseClicked

    }//GEN-LAST:event_btnActualizarCompraMouseClicked

    private void btnActualizarCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarCompraKeyPressed

    }//GEN-LAST:event_btnActualizarCompraKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarCompra;
    private javax.swing.JLabel btnCrearCompra;
    private components.CustomComboBox cbxProveedorCompra;
    private javax.swing.JLabel lblIvaPagado;
    private javax.swing.JLabel lblNumeroFactura;
    private javax.swing.JLabel lblProveedorCompra;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTitleFormCompras;
    private javax.swing.JLabel lblTotal;
    private components.RoundedPanel roundedPanelActualizarCompra;
    private components.RoundedPanel roundedPanelCrearCompra;
    private components.CustomTextField txtIvaPagado;
    private components.CustomTextField txtNumeroFactura;
    private components.CustomTextField txtSubtotal1;
    private components.CustomTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
