package form;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import model.Productos;
import model.ProductosDAO;

public class ComprasForm extends javax.swing.JPanel {

    private Productos productoSeleccionado;

    public ComprasForm() {
        initComponents();
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        cargarTasasIva();
        txtCodigoCompraProd.addActionListener(e -> cargarProductoPorCodigo());
        txtCantidadCompraProd.addActionListener(e -> agregarProductoATabla());
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

    private void cargarTasasIva() {
        cbxTasaIva.removeAllItems();
        cbxTasaIva.addItem("0%");
        cbxTasaIva.addItem("5%");
        cbxTasaIva.addItem("19%");
        cbxTasaIva.setSelectedItem("19%");
    }

    public double getTasaIvaSeleccionada() {
        String seleccion = (String) cbxTasaIva.getSelectedItem();
        if (seleccion == null) {
            return 0.0;
        }
        return Double.parseDouble(seleccion.replace("%", "").trim());
    }

    private void cargarProductoPorCodigo() {
        String codigo = txtCodigoCompraProd.getText().trim();
        if (codigo.isEmpty()) {
            return;
        }
        ProductosDAO dao = new ProductosDAO();
        productoSeleccionado = dao.buscarProductoPorCodigoBarra(codigo);
        if (productoSeleccionado == null) {
            productoSeleccionado = dao.buscarProd(codigo);
        }
        if (productoSeleccionado != null) {
            txtNombreCompraProd.setText(productoSeleccionado.getNombre());
            txtStockCompraProd.setText(String.valueOf(productoSeleccionado.getStock()));
            txtPrecioCompraProd.setText("");
            txtCantidadCompraProd.setText("");
            txtPrecioCompraProd.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado");
            limpiarCamposCompra();
        }
    }

    private void agregarProductoATabla() {
        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Primero busca un producto válido");
            return;
        }
        String cantidadStr = txtCantidadCompraProd.getText().trim();
        String precioStr = txtPrecioCompraProd.getText().trim();
        if (cantidadStr.isEmpty() || precioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa la cantidad y el costo unitario");
            return;
        }
        if (!cantidadStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero válido");
            return;
        }
        if (!precioStr.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "El costo unitario debe ser un número válido");
            return;
        }
        int cantidad = Integer.parseInt(cantidadStr);
        double costoUnitario = Double.parseDouble(precioStr);
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero");
            return;
        }
        double tasaIva = getTasaIvaSeleccionada();
        if (getParent() instanceof Compras) {
            Compras panelCompra = (Compras) getParent();
            panelCompra.agregarProductoATabla(
                    productoSeleccionado.getId(),
                    productoSeleccionado.getCodigo(),
                    productoSeleccionado.getNombre(),
                    cantidad,
                    costoUnitario,
                    tasaIva
            );
        }
        limpiarCamposCompra();
        txtCodigoCompraProd.requestFocus();
    }

    private void limpiarCamposCompra() {
        productoSeleccionado = null;
        txtCodigoCompraProd.setText("");
        txtNombreCompraProd.setText("");
        txtStockCompraProd.setText("");
        txtPrecioCompraProd.setText("");
        txtCantidadCompraProd.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigoCompraProd = new javax.swing.JLabel();
        txtCodigoCompraProd = new components.CustomTextField();
        lblNombreCompraProd = new javax.swing.JLabel();
        txtNombreCompraProd = new components.CustomTextField();
        lblCantidadCompraProd = new javax.swing.JLabel();
        txtCantidadCompraProd = new components.CustomTextField();
        lblPrecioCompraProd = new javax.swing.JLabel();
        txtPrecioCompraProd = new components.CustomTextField();
        lblStockCompraProd = new javax.swing.JLabel();
        txtStockCompraProd = new components.CustomTextField();
        btnLimpiarVenta = new components.Picture();
        lblTasaIvaCompra = new javax.swing.JLabel();
        cbxTasaIva = new components.CustomComboBox();

        setBackground(new java.awt.Color(61, 63, 65));

        lblCodigoCompraProd.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblCodigoCompraProd.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoCompraProd.setText("Codigo producto");

        txtCodigoCompraProd.setForeground(new java.awt.Color(200, 200, 200));
        txtCodigoCompraProd.setText("Ingrese codigo");
        txtCodigoCompraProd.addActionListener(this::txtCodigoCompraProdActionPerformed);

        lblNombreCompraProd.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreCompraProd.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCompraProd.setText("Nombre producto");

        txtNombreCompraProd.setForeground(new java.awt.Color(200, 200, 200));

        lblCantidadCompraProd.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblCantidadCompraProd.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadCompraProd.setText("Cantidad");

        txtCantidadCompraProd.setForeground(new java.awt.Color(200, 200, 200));

        lblPrecioCompraProd.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblPrecioCompraProd.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioCompraProd.setText("Precio unitario");

        txtPrecioCompraProd.setForeground(new java.awt.Color(200, 200, 200));

        lblStockCompraProd.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblStockCompraProd.setForeground(new java.awt.Color(255, 255, 255));
        lblStockCompraProd.setText("Stock disponible");

        txtStockCompraProd.setForeground(new java.awt.Color(200, 200, 200));

        btnLimpiarVenta.setPath("/assets/close.png");

        lblTasaIvaCompra.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblTasaIvaCompra.setForeground(new java.awt.Color(255, 255, 255));
        lblTasaIvaCompra.setText("Tasa iva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(476, 476, 476)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblCantidadCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCantidadCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPrecioCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(lblStockCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblTasaIvaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPrecioCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtStockCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTasaIva, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(lblCodigoCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(130, 130, 130)
                            .addComponent(lblNombreCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtCodigoCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtNombreCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(614, 614, 614)
                            .addComponent(btnLimpiarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCantidadCompraProd)
                        .addGap(3, 3, 3)
                        .addComponent(txtCantidadCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecioCompraProd)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblStockCompraProd)
                                .addComponent(lblTasaIvaCompra)))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPrecioCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStockCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxTasaIva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCodigoCompraProd)
                        .addComponent(lblNombreCompraProd))
                    .addGap(3, 3, 3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCodigoCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreCompraProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpiarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoCompraProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCompraProdActionPerformed

    }//GEN-LAST:event_txtCodigoCompraProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.Picture btnLimpiarVenta;
    private components.CustomComboBox cbxTasaIva;
    private javax.swing.JLabel lblCantidadCompraProd;
    private javax.swing.JLabel lblCodigoCompraProd;
    private javax.swing.JLabel lblNombreCompraProd;
    private javax.swing.JLabel lblPrecioCompraProd;
    private javax.swing.JLabel lblStockCompraProd;
    private javax.swing.JLabel lblTasaIvaCompra;
    private components.CustomTextField txtCantidadCompraProd;
    private components.CustomTextField txtCodigoCompraProd;
    private components.CustomTextField txtNombreCompraProd;
    private components.CustomTextField txtPrecioCompraProd;
    private components.CustomTextField txtStockCompraProd;
    // End of variables declaration//GEN-END:variables
}
