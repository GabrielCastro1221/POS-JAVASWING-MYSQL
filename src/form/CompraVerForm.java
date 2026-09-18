package form;

import java.awt.Cursor;

public class CompraVerForm extends javax.swing.JPanel {

    public CompraVerForm() {
        initComponents();
        setOpaque(false);
        btnVerFactura.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
