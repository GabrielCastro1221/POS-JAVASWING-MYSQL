package form;

public class Producto extends javax.swing.JPanel {

    private model.ProductosDAO dao;
    private javax.swing.table.DefaultTableModel modelo;

    public Producto() {
        initComponents();
        setOpaque(false);
        dao = new model.ProductosDAO();
        modelo = (javax.swing.table.DefaultTableModel) customTable1.getModel();
        cargarProductos();

        customTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = customTable1.getSelectedRow();
                if (fila >= 0) {
                    String id = customTable1.getValueAt(fila, 0).toString();
                    String codigo = customTable1.getValueAt(fila, 1).toString();
                    String nombre = customTable1.getValueAt(fila, 2).toString();
                    String proveedor = customTable1.getValueAt(fila, 3).toString();
                    String stock = customTable1.getValueAt(fila, 4).toString();
                    String precioNeto = customTable1.getValueAt(fila, 5).toString();
                    String precioBruto = customTable1.getValueAt(fila, 6).toString();
                    String categoria = customTable1.getValueAt(fila, 7).toString();

                    productosForm2.setDatosProducto(id, codigo, nombre, proveedor, stock, precioNeto, precioBruto, categoria);
                }
            }
        });
    }

    public void cargarProductos() {
        modelo.setRowCount(0);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (model.Productos p : dao.listarProductos()) {
            String fechaFormateada = p.getFecha() != null ? sdf.format(p.getFecha()) : "";

            modelo.addRow(new Object[]{
                p.getId(),
                p.getCodigo(),
                p.getNombre(),
                p.getProveedor_id(),
                p.getStock(),
                p.getPrecio_neto(),
                p.getPrecio_bruto(),
                p.getCategoria_id(),
                fechaFormateada
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productosForm2 = new form.ProductosForm();
        jScrollPane1 = new javax.swing.JScrollPane();
        customTable1 = new components.CustomTable();

        setBackground(new java.awt.Color(61, 63, 65));

        customTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODIGO", "NOMBRE", "PROVEEDOR", "STOCK", "PRECIO NETO", "PRECIO BRUTO", "CATEGORIA"
            }
        ));
        jScrollPane1.setViewportView(customTable1);
        if (customTable1.getColumnModel().getColumnCount() > 0) {
            customTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            customTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            customTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            customTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            customTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
            customTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(productosForm2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productosForm2, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.CustomTable customTable1;
    private javax.swing.JScrollPane jScrollPane1;
    private form.ProductosForm productosForm2;
    // End of variables declaration//GEN-END:variables
}
