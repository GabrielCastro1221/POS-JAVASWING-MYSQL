package form;

import model.ProveedoresDAO;

public class Proveedor extends javax.swing.JPanel {

    private ProveedoresDAO dao;
    private javax.swing.table.DefaultTableModel modelo;

    public Proveedor() {
        initComponents();
        setOpaque(false);
        dao = new ProveedoresDAO();
        modelo = (javax.swing.table.DefaultTableModel) tableProveedores.getModel();
        cargarProveedores();

        tableProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tableProveedores.getSelectedRow();
                if (fila >= 0) {
                    String id = tableProveedores.getValueAt(fila, 0).toString();
                    String ruc = tableProveedores.getValueAt(fila, 1).toString();
                    String nombre = tableProveedores.getValueAt(fila, 2).toString();
                    String vendedor = tableProveedores.getValueAt(fila, 3).toString();
                    String telefono = tableProveedores.getValueAt(fila, 4).toString();
                    String direccion = tableProveedores.getValueAt(fila, 5).toString();
                    String razon = tableProveedores.getValueAt(fila, 6).toString();

                    proveedoresForm2.setDatosProveedor(id, ruc, nombre, vendedor, telefono, direccion, razon);
                }
            }
        });
    }

    public void cargarProveedores() {
        modelo.setRowCount(0);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (model.Proveedores pr : dao.listarProveedores()) {
            String fechaFormateada = pr.getFecha() != null ? sdf.format(pr.getFecha()) : "";

            modelo.addRow(new Object[]{
                pr.getId(),
                pr.getRuc(),
                pr.getNombre(),
                pr.getVendedor(),
                pr.getTelefono(),
                pr.getDireccion(),
                pr.getRazon_social(),
                fechaFormateada
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        proveedoresForm2 = new form.ProveedoresForm();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProveedores = new components.CustomTable();

        setBackground(new java.awt.Color(61, 63, 65));

        tableProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "RUC/NIT", "NOMBRE", "VENDEDOR", "TELEFONO", "DIRECCION", "RAZON SOCIAL", "FECHA"
            }
        ));
        jScrollPane1.setViewportView(tableProveedores);
        if (tableProveedores.getColumnModel().getColumnCount() > 0) {
            tableProveedores.getColumnModel().getColumn(0).setPreferredWidth(60);
            tableProveedores.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableProveedores.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableProveedores.getColumnModel().getColumn(3).setPreferredWidth(120);
            tableProveedores.getColumnModel().getColumn(4).setPreferredWidth(120);
            tableProveedores.getColumnModel().getColumn(5).setPreferredWidth(120);
            tableProveedores.getColumnModel().getColumn(6).setPreferredWidth(120);
            tableProveedores.getColumnModel().getColumn(7).setPreferredWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(proveedoresForm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(proveedoresForm2, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private form.ProveedoresForm proveedoresForm2;
    private components.CustomTable tableProveedores;
    // End of variables declaration//GEN-END:variables
}
