package form;

public class NuevaVenta extends javax.swing.JPanel {

    public NuevaVenta() {
        initComponents();
        setOpaque(false);

        tableVenta.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO UNITARIO", "TOTAL"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

    }

    public void agregarProductoATabla(int productoId, String codigo, String nombre, int cantidad, double precioUnitario, double subtotal, int stock) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableVenta.getModel();
        boolean encontrado = false;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            int idTabla = (int) modelo.getValueAt(i, 0);
            if (idTabla == productoId) {
                int cantidadExistente = (int) modelo.getValueAt(i, 3);
                int nuevaCantidad = cantidadExistente + cantidad;

                if (nuevaCantidad > stock) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No hay suficiente stock disponible");
                    return;
                }
                modelo.setValueAt(nuevaCantidad, i, 3);
                modelo.setValueAt(nuevaCantidad * precioUnitario, i, 5);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            modelo.insertRow(0, new Object[]{productoId, codigo, nombre, cantidad, precioUnitario, subtotal});
        }

        calcularTotalVenta();
    }

    private void calcularTotalVenta() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableVenta.getModel();
        double total = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            total += (double) modelo.getValueAt(i, 5);
        }
        nuevaVentaUserForm2.actualizarTotal(total);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevaVentaForm1 = new form.NuevaVentaForm();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVenta = new components.CustomTable();
        nuevaVentaUserForm2 = new form.NuevaVentaUserForm();

        setBackground(new java.awt.Color(61, 63, 65));
        setPreferredSize(new java.awt.Dimension(1180, 660));

        tableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO UNITARIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tableVenta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(nuevaVentaForm1, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
                    .addComponent(nuevaVentaUserForm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(nuevaVentaForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nuevaVentaUserForm2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(435, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private form.NuevaVentaForm nuevaVentaForm1;
    private form.NuevaVentaUserForm nuevaVentaUserForm2;
    private components.CustomTable tableVenta;
    // End of variables declaration//GEN-END:variables
}
