package form;

import java.awt.Color;

public class VentasForm extends javax.swing.JPanel {

    private javax.swing.JTable tableVentas;

    public void setTableVentas(javax.swing.JTable tableVentas) {
        this.tableVentas = tableVentas;
    }

    public VentasForm() {
        initComponents();
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generarPDFVentaSeleccionada();
            }
        });

    }

    private void generarPDFVentaSeleccionada() {
        if (tableVentas == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se ha vinculado la tabla de ventas");
            return;
        }

        int fila = tableVentas.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una venta de la tabla");
            return;
        }

        int idVenta = Integer.parseInt(tableVentas.getValueAt(fila, 0).toString());
        String ruta = "/home/DeathRaven1221/Documentos/Miscelanea_bellavista/pdf/venta" + idVenta + ".pdf";
        java.io.File file = new java.io.File(ruta);

        if (file.exists()) {
            try {
                java.awt.Desktop.getDesktop().open(file);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al abrir PDF: " + e.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "El PDF de la venta no existe en la carpeta");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPDF = new javax.swing.JLabel();
        roundedPanel1 = new components.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        lblPDF.setFont(new java.awt.Font("Caladea", 1, 18)); // NOI18N
        lblPDF.setForeground(new java.awt.Color(255, 255, 255));
        lblPDF.setText("Seleccione una fila para generar PDF de la venta");
        add(lblPDF);
        lblPDF.setBounds(200, 20, 400, 17);

        roundedPanel1.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanel1.setTopColor(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Caladea", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar PDF");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(roundedPanel1);
        roundedPanel1.setBounds(20, 10, 170, 40);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPDF;
    private components.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
