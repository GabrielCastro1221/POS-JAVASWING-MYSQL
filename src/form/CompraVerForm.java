package form;

import java.awt.Cursor;
import javax.swing.JTable;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

public class CompraVerForm extends javax.swing.JPanel {

    private JTable tableCompras;

    public void setTableCompras(JTable tableCompras) {
        this.tableCompras = tableCompras;
    }

    public CompraVerForm() {
        initComponents();
        setOpaque(false);
        btnVerFactura.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVerFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verFacturaCompra();
            }
        });
    }

    private void verFacturaCompra() {
        if (tableCompras == null) {
            JOptionPane.showMessageDialog(this, "No se ha vinculado la tabla de compras");
            return;
        }
        int fila = tableCompras.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una compra");
            return;
        }
        int idCompra = Integer.parseInt(tableCompras.getValueAt(fila, 0).toString());
        File file = new File(System.getProperty("user.home") + File.separator + "MiscelaneaBellavista" + File.separator
                + "Facturas_compras" + File.separator + "compra_" + idCompra + ".pdf");
        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al abrir PDF:\n" + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No existe el PDF de la compra:\n" + file.getAbsolutePath());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFacturaCompra = new javax.swing.JLabel();
        roundedPanelVerFactura = new components.RoundedPanel();
        btnVerFactura = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        lblFacturaCompra.setFont(new java.awt.Font("Caladea", 1, 18)); // NOI18N
        lblFacturaCompra.setForeground(new java.awt.Color(255, 255, 255));
        lblFacturaCompra.setText("Seleccione una fila para ver factura de la compra");
        add(lblFacturaCompra);
        lblFacturaCompra.setBounds(220, 20, 400, 17);

        roundedPanelVerFactura.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelVerFactura.setTopColor(new java.awt.Color(0, 153, 255));

        btnVerFactura.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnVerFactura.setForeground(new java.awt.Color(255, 255, 255));
        btnVerFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVerFactura.setText("Ver factura");

        javax.swing.GroupLayout roundedPanelVerFacturaLayout = new javax.swing.GroupLayout(roundedPanelVerFactura);
        roundedPanelVerFactura.setLayout(roundedPanelVerFacturaLayout);
        roundedPanelVerFacturaLayout.setHorizontalGroup(
            roundedPanelVerFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVerFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        roundedPanelVerFacturaLayout.setVerticalGroup(
            roundedPanelVerFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVerFactura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(roundedPanelVerFactura);
        roundedPanelVerFactura.setBounds(20, 10, 170, 40);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnVerFactura;
    private javax.swing.JLabel lblFacturaCompra;
    private components.RoundedPanel roundedPanelVerFactura;
    // End of variables declaration//GEN-END:variables
}
