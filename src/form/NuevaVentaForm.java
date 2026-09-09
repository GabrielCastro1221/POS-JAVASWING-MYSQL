package form;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class NuevaVentaForm extends javax.swing.JPanel {

    private model.Productos productoSeleccionado;

    public NuevaVentaForm() {
        initComponents();
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0));
        txtCodigoVentaProd.addActionListener(e -> cargarProductoPorCodigo());
        txtCantidadVentaProd.addActionListener(e -> agregarProductoATabla());
        txtVendedorNombre.setVisible(false);
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

    private void cargarProductoPorCodigo() {
        String codigoBarra = txtCodigoVentaProd.getText().trim();
        if (codigoBarra.isEmpty()) {
            return;
        }

        model.ProductosDAO dao = new model.ProductosDAO();
        productoSeleccionado = dao.buscarProductoPorCodigoBarra(codigoBarra);

        if (productoSeleccionado != null) {
            txtNombreVentaProd.setText(productoSeleccionado.getNombre());
            txtStockVentaProd.setText(String.valueOf(productoSeleccionado.getStock()));
            txtPrecioVentaProd.setText(String.valueOf(productoSeleccionado.getPrecio_bruto()));
            txtCantidadVentaProd.setText("1");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Producto no encontrado");
            limpiarCamposVenta();
        }
    }

    private void agregarProductoATabla() {
        try {
            int cantidad = Integer.parseInt(txtCantidadVentaProd.getText().trim());
            int stock = Integer.parseInt(txtStockVentaProd.getText().trim());
            double precioUnitario = Double.parseDouble(txtPrecioVentaProd.getText().trim());

            if (cantidad > stock) {
                javax.swing.JOptionPane.showMessageDialog(this, "No hay suficiente stock disponible");
                return;
            }

            double subtotal = cantidad * precioUnitario;

            if (getParent() instanceof NuevaVenta && productoSeleccionado != null) {
                NuevaVenta panelVenta = (NuevaVenta) getParent();
                panelVenta.agregarProductoATabla(
                        productoSeleccionado.getId(),
                        txtCodigoVentaProd.getText().trim(),
                        txtNombreVentaProd.getText().trim(),
                        cantidad,
                        precioUnitario,
                        subtotal,
                        stock
                );
            }
            limpiarCamposVenta();
            productoSeleccionado = null;
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStockVentaProd = new javax.swing.JLabel();
        txtStockVentaProd = new components.CustomTextField();
        lblCodigoVentaProd1 = new javax.swing.JLabel();
        txtCodigoVentaProd = new components.CustomTextField();
        lblNombreVentaProd = new javax.swing.JLabel();
        txtNombreVentaProd = new components.CustomTextField();
        lblCantidadVentaProd = new javax.swing.JLabel();
        txtCantidadVentaProd = new components.CustomTextField();
        lblPrecioVentaProd1 = new javax.swing.JLabel();
        txtPrecioVentaProd = new components.CustomTextField();
        btnLimpiarVenta = new components.Picture();
        txtVendedorNombre = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 63, 65));
        setPreferredSize(new java.awt.Dimension(1000, 1000));
        setLayout(null);

        lblStockVentaProd.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblStockVentaProd.setForeground(new java.awt.Color(255, 255, 255));
        lblStockVentaProd.setText("Stock disponible");
        add(lblStockVentaProd);
        lblStockVentaProd.setBounds(860, 20, 110, 17);

        txtStockVentaProd.setForeground(new java.awt.Color(200, 200, 200));
        add(txtStockVentaProd);
        txtStockVentaProd.setBounds(850, 40, 170, 33);

        lblCodigoVentaProd1.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblCodigoVentaProd1.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoVentaProd1.setText("Codigo producto");
        add(lblCodigoVentaProd1);
        lblCodigoVentaProd1.setBounds(30, 20, 110, 17);

        txtCodigoVentaProd.setForeground(new java.awt.Color(200, 200, 200));
        txtCodigoVentaProd.setText("Ingrese codigo");
        add(txtCodigoVentaProd);
        txtCodigoVentaProd.setBounds(20, 40, 230, 33);

        lblNombreVentaProd.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreVentaProd.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreVentaProd.setText("Nombre producto");
        add(lblNombreVentaProd);
        lblNombreVentaProd.setBounds(270, 20, 120, 17);

        txtNombreVentaProd.setForeground(new java.awt.Color(200, 200, 200));
        add(txtNombreVentaProd);
        txtNombreVentaProd.setBounds(260, 40, 270, 33);

        lblCantidadVentaProd.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblCantidadVentaProd.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadVentaProd.setText("Cantidad");
        add(lblCantidadVentaProd);
        lblCantidadVentaProd.setBounds(560, 20, 60, 17);

        txtCantidadVentaProd.setForeground(new java.awt.Color(200, 200, 200));
        add(txtCantidadVentaProd);
        txtCantidadVentaProd.setBounds(550, 40, 130, 33);

        lblPrecioVentaProd1.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblPrecioVentaProd1.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioVentaProd1.setText("Precio unitario");
        add(lblPrecioVentaProd1);
        lblPrecioVentaProd1.setBounds(710, 20, 100, 17);

        txtPrecioVentaProd.setForeground(new java.awt.Color(200, 200, 200));
        add(txtPrecioVentaProd);
        txtPrecioVentaProd.setBounds(700, 40, 130, 33);

        btnLimpiarVenta.setPath("/assets/close.png");
        add(btnLimpiarVenta);
        btnLimpiarVenta.setBounds(1060, 40, 20, 20);

        txtVendedorNombre.setText("Gabriel Castro Ramirez");
        add(txtVendedorNombre);
        txtVendedorNombre.setBounds(1000, 10, 147, 17);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.Picture btnLimpiarVenta;
    private javax.swing.JLabel lblCantidadVentaProd;
    private javax.swing.JLabel lblCodigoVentaProd1;
    private javax.swing.JLabel lblNombreVentaProd;
    private javax.swing.JLabel lblPrecioVentaProd1;
    private javax.swing.JLabel lblStockVentaProd;
    private components.CustomTextField txtCantidadVentaProd;
    private components.CustomTextField txtCodigoVentaProd;
    private components.CustomTextField txtNombreVentaProd;
    private components.CustomTextField txtPrecioVentaProd;
    private components.CustomTextField txtStockVentaProd;
    private javax.swing.JLabel txtVendedorNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiarCamposVenta() {
        txtCodigoVentaProd.setText("");
        txtNombreVentaProd.setText("");
        txtStockVentaProd.setText("");
        txtPrecioVentaProd.setText("");
        txtCantidadVentaProd.setText("");
    }
}
