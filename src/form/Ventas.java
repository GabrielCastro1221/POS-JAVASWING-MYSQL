package form;

import java.util.List;
import model.Venta;
import model.VentaDAO;

public class Ventas extends javax.swing.JPanel {

    public Ventas() {
        initComponents();
        setOpaque(false);
        ventasForm1.setTableVentas(tableVentas);
        cargarVentas();
    }

    private void cargarVentas() {
        VentaDAO vDAO = new VentaDAO();
        List<Venta> lista = vDAO.listarVentas();
        javax.swing.table.DefaultTableModel modelo
                = (javax.swing.table.DefaultTableModel) tableVentas.getModel();
        modelo.setRowCount(0);

        for (Venta v : lista) {
            modelo.addRow(new Object[]{
                v.getId(),
                v.getNombreCliente(),
                v.getNombreVendedor(),
                String.format("%.2f", v.getTotal()),
                v.getFecha()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventasForm1 = new form.VentasForm();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new components.CustomTable();

        setBackground(new java.awt.Color(61, 63, 65));

        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "VENDEDOR", "TOTAL", "FECHA"
            }
        ));
        jScrollPane1.setViewportView(tableVentas);
        if (tableVentas.getColumnModel().getColumnCount() > 0) {
            tableVentas.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(ventasForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ventasForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private components.CustomTable tableVentas;
    private form.VentasForm ventasForm1;
    // End of variables declaration//GEN-END:variables
}
