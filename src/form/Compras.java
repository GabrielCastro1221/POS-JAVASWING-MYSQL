package form;

public class Compras extends javax.swing.JPanel {

    private double subtotalCompra = 0;
    private double ivaCompra = 0;
    private double totalCompra = 0;

    public double getSubtotalCompra() {
        return subtotalCompra;
    }

    public double getIvaCompra() {
        return ivaCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public Compras() {
        initComponents();
        setOpaque(false);
        tableCompras.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "CODIGO", "NOMBRE", "CANTIDAD",
                    "PRECIO UNITARIO", "TASA IVA", "IVA LINEA",
                    "SUBTOTAL LINEA", "TOTAL LINEA"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        if (tableCompras.getColumnModel().getColumnCount() > 0) {
            tableCompras.getColumnModel().getColumn(4).setPreferredWidth(100);
        }
    }

    public void agregarProductoATabla(int productoId, String codigo, String nombre,
            int cantidad, double costoUnitario, double tasaIva) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableCompras.getModel();
        boolean encontrado = false;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int idTabla = (int) modelo.getValueAt(i, 0);
            if (idTabla == productoId) {
                int cantidadExistente = (int) modelo.getValueAt(i, 3);
                int nuevaCantidad = cantidadExistente + cantidad;
                double subtotalLinea = nuevaCantidad * costoUnitario;
                double ivaLinea = subtotalLinea * (tasaIva / 100);
                double totalLinea = subtotalLinea + ivaLinea;
                modelo.setValueAt(nuevaCantidad, i, 3);
                modelo.setValueAt(costoUnitario, i, 4);
                modelo.setValueAt(tasaIva, i, 5);
                modelo.setValueAt(ivaLinea, i, 6);
                modelo.setValueAt(subtotalLinea, i, 7);
                modelo.setValueAt(totalLinea, i, 8);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            double subtotalLinea = cantidad * costoUnitario;
            double ivaLinea = subtotalLinea * (tasaIva / 100);
            double totalLinea = subtotalLinea + ivaLinea;
            modelo.insertRow(0, new Object[]{
                productoId, codigo, nombre, cantidad,
                costoUnitario, tasaIva, ivaLinea, subtotalLinea, totalLinea
            });
        }
        calcularTotalesCompra();
    }

    private void calcularTotalesCompra() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableCompras.getModel();
        double subtotal = 0;
        double iva = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            subtotal += (double) modelo.getValueAt(i, 7);
            iva += (double) modelo.getValueAt(i, 6);
        }
        subtotalCompra = subtotal;
        ivaCompra = iva;
        totalCompra = subtotal + iva;
    }

    public javax.swing.JTable getTableCompras() {
        return tableCompras;
    }

    public void limpiarTabla() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableCompras.getModel();
        modelo.setRowCount(0);
        subtotalCompra = 0;
        ivaCompra = 0;
        totalCompra = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comprasForm1 = new form.ComprasForm();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompras = new components.CustomTable();
        comprasProveedorForm1 = new form.ComprasProveedorForm();

        setBackground(new java.awt.Color(61, 63, 65));
        setPreferredSize(new java.awt.Dimension(1180, 660));

        tableCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO UNITARIO", "TASA IVA", "IVA LINEA", "SUBTOTAL LINEA", "TOTAL LINEA"
            }
        ));
        jScrollPane1.setViewportView(tableCompras);
        if (tableCompras.getColumnModel().getColumnCount() > 0) {
            tableCompras.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comprasForm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comprasProveedorForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(comprasForm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comprasProveedorForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private form.ComprasForm comprasForm1;
    private form.ComprasProveedorForm comprasProveedorForm1;
    private javax.swing.JScrollPane jScrollPane1;
    private components.CustomTable tableCompras;
    // End of variables declaration//GEN-END:variables
}
