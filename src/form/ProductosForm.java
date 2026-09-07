package form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import model.Proveedores;
import model.ProveedoresDAO;
import model.Categoria;
import model.CategoriaDAO;
import model.Productos;
import model.ProductosDAO;

public class ProductosForm extends javax.swing.JPanel {

    public ProductosForm() {
        initComponents();
        cbxProveedorProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cbxCategoriaProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCrearProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnActualizarProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEliminarProducto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.init();
        cargarProveedores();
        cargarCategorias();
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

    private void cargarProveedores() {
        ProveedoresDAO dao = new ProveedoresDAO();
        cbxProveedorProducto.removeAllItems();

        for (Proveedores pr : dao.listarProveedores()) {
            cbxProveedorProducto.addItem(pr);
        }
    }

    private void cargarCategorias() {
        CategoriaDAO dao = new CategoriaDAO();
        cbxCategoriaProducto.removeAllItems();

        for (Categoria cat : dao.listarCategorias()) {
            cbxCategoriaProducto.addItem(cat);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigoProducto = new javax.swing.JLabel();
        txtCodigoProducto = new components.CustomTextField();
        lblNombreProducto = new javax.swing.JLabel();
        txtNombreProducto = new components.CustomTextField();
        lblProveedorProducto = new javax.swing.JLabel();
        lblStockProducto = new javax.swing.JLabel();
        txtStockProducto = new components.CustomTextField();
        lblPrecioNetoProducto = new javax.swing.JLabel();
        txtPrecioNetoProducto = new components.CustomTextField();
        lblPrecioBrutoProducto = new javax.swing.JLabel();
        txtPrecioBrutoProducto = new components.CustomTextField();
        lblCategoriaProducto = new javax.swing.JLabel();
        roundedPanelCrearProducto = new components.RoundedPanel();
        btnCrearProducto = new javax.swing.JLabel();
        roundedPanelActualizarProducto = new components.RoundedPanel();
        btnActualizarProducto = new javax.swing.JLabel();
        roundedPanelEliminarProducto = new components.RoundedPanel();
        btnEliminarProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbxCategoriaProducto = new components.CustomComboBox();
        cbxProveedorProducto = new components.CustomComboBox();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        lblCodigoProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblCodigoProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoProducto.setText("Codigo");
        add(lblCodigoProducto);
        lblCodigoProducto.setBounds(30, 110, 41, 17);

        txtCodigoProducto.setForeground(new java.awt.Color(200, 200, 200));
        txtCodigoProducto.setText("Codigo producto");
        add(txtCodigoProducto);
        txtCodigoProducto.setBounds(20, 140, 160, 33);

        lblNombreProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreProducto.setText("Nombre");
        add(lblNombreProducto);
        lblNombreProducto.setBounds(190, 110, 60, 17);

        txtNombreProducto.setForeground(new java.awt.Color(200, 200, 200));
        txtNombreProducto.setText("Nombre producto");
        add(txtNombreProducto);
        txtNombreProducto.setBounds(190, 140, 160, 33);

        lblProveedorProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblProveedorProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblProveedorProducto.setText("Proveedor");
        add(lblProveedorProducto);
        lblProveedorProducto.setBounds(20, 190, 80, 17);

        lblStockProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblStockProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblStockProducto.setText("Stock");
        add(lblStockProducto);
        lblStockProducto.setBounds(200, 190, 45, 17);

        txtStockProducto.setForeground(new java.awt.Color(200, 200, 200));
        txtStockProducto.setText("Stock disponible");
        add(txtStockProducto);
        txtStockProducto.setBounds(190, 210, 160, 33);

        lblPrecioNetoProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblPrecioNetoProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioNetoProducto.setText("Precio neto");
        add(lblPrecioNetoProducto);
        lblPrecioNetoProducto.setBounds(20, 260, 90, 17);

        txtPrecioNetoProducto.setForeground(new java.awt.Color(200, 200, 200));
        txtPrecioNetoProducto.setText("Precio neto ");
        txtPrecioNetoProducto.addActionListener(this::txtPrecioNetoProductoActionPerformed);
        add(txtPrecioNetoProducto);
        txtPrecioNetoProducto.setBounds(20, 280, 160, 33);

        lblPrecioBrutoProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblPrecioBrutoProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioBrutoProducto.setText("Precio bruto");
        add(lblPrecioBrutoProducto);
        lblPrecioBrutoProducto.setBounds(190, 260, 90, 17);

        txtPrecioBrutoProducto.setForeground(new java.awt.Color(200, 200, 200));
        txtPrecioBrutoProducto.setText("Precio bruto");
        add(txtPrecioBrutoProducto);
        txtPrecioBrutoProducto.setBounds(190, 280, 160, 33);

        lblCategoriaProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblCategoriaProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoriaProducto.setText("Categoria");
        add(lblCategoriaProducto);
        lblCategoriaProducto.setBounds(150, 330, 70, 17);

        roundedPanelCrearProducto.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelCrearProducto.setCornerRadius(10);
        roundedPanelCrearProducto.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelCrearProducto.setLayout(null);

        btnCrearProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnCrearProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrearProducto.setText("Crear producto");
        btnCrearProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearProductoMouseClicked(evt);
            }
        });
        btnCrearProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCrearProductoKeyPressed(evt);
            }
        });
        roundedPanelCrearProducto.add(btnCrearProducto);
        btnCrearProducto.setBounds(0, 0, 330, 40);

        add(roundedPanelCrearProducto);
        roundedPanelCrearProducto.setBounds(20, 400, 330, 40);

        roundedPanelActualizarProducto.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelActualizarProducto.setCornerRadius(10);
        roundedPanelActualizarProducto.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelActualizarProducto.setLayout(null);

        btnActualizarProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnActualizarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizarProducto.setText("Actualizar producto");
        btnActualizarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarProductoMouseClicked(evt);
            }
        });
        btnActualizarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarProductoKeyPressed(evt);
            }
        });
        roundedPanelActualizarProducto.add(btnActualizarProducto);
        btnActualizarProducto.setBounds(0, 0, 330, 40);

        add(roundedPanelActualizarProducto);
        roundedPanelActualizarProducto.setBounds(20, 450, 330, 40);

        roundedPanelEliminarProducto.setBottomColor(new java.awt.Color(213, 69, 53));
        roundedPanelEliminarProducto.setCornerRadius(10);
        roundedPanelEliminarProducto.setTopColor(new java.awt.Color(224, 109, 106));
        roundedPanelEliminarProducto.setLayout(null);

        btnEliminarProducto.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarProductoMouseClicked(evt);
            }
        });
        btnEliminarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarProductoKeyPressed(evt);
            }
        });
        roundedPanelEliminarProducto.add(btnEliminarProducto);
        btnEliminarProducto.setBounds(0, 0, 330, 40);

        add(roundedPanelEliminarProducto);
        roundedPanelEliminarProducto.setBounds(20, 500, 330, 40);

        jLabel1.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(196, 94, 95));
        jLabel1.setText("Formulario productos");
        add(jLabel1);
        jLabel1.setBounds(60, 40, 250, 28);
        add(cbxCategoriaProducto);
        cbxCategoriaProducto.setBounds(90, 350, 200, 21);
        add(cbxProveedorProducto);
        cbxProveedorProducto.setBounds(20, 220, 160, 21);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioNetoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioNetoProductoActionPerformed

    }//GEN-LAST:event_txtPrecioNetoProductoActionPerformed

    private void btnCrearProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearProductoMouseClicked
        ProductosDAO dao = new ProductosDAO();

        Productos pro = new Productos();
        pro.setCodigo(txtCodigoProducto.getText().trim());
        pro.setNombre(txtNombreProducto.getText().trim());
        pro.setStock(Integer.parseInt(txtStockProducto.getText().trim()));
        pro.setPrecio_neto(Double.parseDouble(txtPrecioNetoProducto.getText().trim()));
        pro.setPrecio_bruto(Double.parseDouble(txtPrecioBrutoProducto.getText().trim()));

        Proveedores proveedorSeleccionado = (Proveedores) cbxProveedorProducto.getSelectedItem();
        pro.setProveedor_id(proveedorSeleccionado.getId());

        Categoria categoriaSeleccionada = (Categoria) cbxCategoriaProducto.getSelectedItem();
        pro.setCategoria_id(categoriaSeleccionada.getId());

        boolean registrado = dao.registrarProducto(pro);

        if (registrado) {
            javax.swing.JOptionPane.showMessageDialog(this, "Producto registrado correctamente");
            txtCodigoProducto.setText("");
            txtNombreProducto.setText("");
            txtStockProducto.setText("");
            txtPrecioNetoProducto.setText("");
            txtPrecioBrutoProducto.setText("");
            cbxProveedorProducto.setSelectedIndex(0);
            cbxCategoriaProducto.setSelectedIndex(0);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar producto");
        }
    }//GEN-LAST:event_btnCrearProductoMouseClicked

    private void btnCrearProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearProductoKeyPressed

    }//GEN-LAST:event_btnCrearProductoKeyPressed

    private void btnActualizarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarProductoMouseClicked

    }//GEN-LAST:event_btnActualizarProductoMouseClicked

    private void btnActualizarProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarProductoKeyPressed

    }//GEN-LAST:event_btnActualizarProductoKeyPressed

    private void btnEliminarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProductoMouseClicked

    }//GEN-LAST:event_btnEliminarProductoMouseClicked

    private void btnEliminarProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarProductoKeyPressed

    }//GEN-LAST:event_btnEliminarProductoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarProducto;
    private javax.swing.JLabel btnCrearProducto;
    private javax.swing.JLabel btnEliminarProducto;
    private components.CustomComboBox cbxCategoriaProducto;
    private components.CustomComboBox cbxProveedorProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCategoriaProducto;
    private javax.swing.JLabel lblCodigoProducto;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecioBrutoProducto;
    private javax.swing.JLabel lblPrecioNetoProducto;
    private javax.swing.JLabel lblProveedorProducto;
    private javax.swing.JLabel lblStockProducto;
    private components.RoundedPanel roundedPanelActualizarProducto;
    private components.RoundedPanel roundedPanelCrearProducto;
    private components.RoundedPanel roundedPanelEliminarProducto;
    private components.CustomTextField txtCodigoProducto;
    private components.CustomTextField txtNombreProducto;
    private components.CustomTextField txtPrecioBrutoProducto;
    private components.CustomTextField txtPrecioNetoProducto;
    private components.CustomTextField txtStockProducto;
    // End of variables declaration//GEN-END:variables
}
