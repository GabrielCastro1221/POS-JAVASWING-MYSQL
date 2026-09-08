package form;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class NuevaVentaUserForm extends javax.swing.JPanel {

    public NuevaVentaUserForm() {
        initComponents();
        this.init();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreClienteVenta = new javax.swing.JLabel();
        txtNombreClienteVenta = new components.CustomTextField();
        lblDniClienteVenta1 = new javax.swing.JLabel();
        txtDniClienteVenta1 = new components.CustomTextField();
        roundedPanelGenerarVenta = new components.RoundedPanel();
        btnGenerarVenta = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        lblTotalVenta = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 63, 65));
        setPreferredSize(new java.awt.Dimension(1000, 300));
        setLayout(null);

        lblNombreClienteVenta.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreClienteVenta.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreClienteVenta.setText("Nombre cliente");
        add(lblNombreClienteVenta);
        lblNombreClienteVenta.setBounds(320, 40, 110, 17);

        txtNombreClienteVenta.setForeground(new java.awt.Color(200, 200, 200));
        txtNombreClienteVenta.setEnabled(false);
        add(txtNombreClienteVenta);
        txtNombreClienteVenta.setBounds(270, 60, 210, 33);

        lblDniClienteVenta1.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblDniClienteVenta1.setForeground(new java.awt.Color(255, 255, 255));
        lblDniClienteVenta1.setText("CC/DNI - Cliente");
        add(lblDniClienteVenta1);
        lblDniClienteVenta1.setBounds(60, 40, 110, 17);

        txtDniClienteVenta1.setForeground(new java.awt.Color(200, 200, 200));
        txtDniClienteVenta1.setText("Ingrese Identificacion");
        add(txtDniClienteVenta1);
        txtDniClienteVenta1.setBounds(20, 60, 210, 33);

        roundedPanelGenerarVenta.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelGenerarVenta.setTopColor(new java.awt.Color(0, 153, 255));

        btnGenerarVenta.setFont(new java.awt.Font("Caladea", 1, 16)); // NOI18N
        btnGenerarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGenerarVenta.setText("Generar Venta");

        javax.swing.GroupLayout roundedPanelGenerarVentaLayout = new javax.swing.GroupLayout(roundedPanelGenerarVenta);
        roundedPanelGenerarVenta.setLayout(roundedPanelGenerarVentaLayout);
        roundedPanelGenerarVentaLayout.setHorizontalGroup(
            roundedPanelGenerarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelGenerarVentaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roundedPanelGenerarVentaLayout.setVerticalGroup(
            roundedPanelGenerarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelGenerarVentaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(roundedPanelGenerarVenta);
        roundedPanelGenerarVenta.setBounds(550, 50, 150, 40);

        lblTotalPagar.setFont(new java.awt.Font("Caladea", 1, 18)); // NOI18N
        lblTotalPagar.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPagar.setText("TOTAL A PAGAR");
        add(lblTotalPagar);
        lblTotalPagar.setBounds(780, 60, 150, 22);

        lblTotalVenta.setFont(new java.awt.Font("Caladea", 1, 20)); // NOI18N
        lblTotalVenta.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalVenta.setText("$ ----------");
        add(lblTotalVenta);
        lblTotalVenta.setBounds(990, 60, 80, 23);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGenerarVenta;
    private javax.swing.JLabel lblDniClienteVenta1;
    private javax.swing.JLabel lblNombreClienteVenta;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JLabel lblTotalVenta;
    private components.RoundedPanel roundedPanelGenerarVenta;
    private components.CustomTextField txtDniClienteVenta1;
    private components.CustomTextField txtNombreClienteVenta;
    // End of variables declaration//GEN-END:variables
}
