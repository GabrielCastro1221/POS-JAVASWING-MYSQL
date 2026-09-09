package view;

import components.RoundedPanel;
import java.awt.Color;

public class Banner extends RoundedPanel {

    public Banner() {
        super(new Color(42, 43, 48), new Color(30, 31, 35), 18);
        initComponents();

        model.ConfigDAO dao = new model.ConfigDAO();
        model.Config cfg = dao.obtenerUltimaConfig();
        if (cfg != null) {
            mostrarConfigEnBanner(cfg);
        } else {
            lblRucConfigLog.setText("NIT: -");
            lblTelefonoConfigLog.setText("Tel: -");
            lblDireccionConfigLog.setText("Dirección: -");
            lblRazonConfigLog.setText("Sin configuración");
        }
    }

    private void mostrarConfigEnBanner(model.Config cfg) {
        lblRucConfigLog.setText("NIT: " + cfg.getRuc());
        lblTelefonoConfigLog.setText("Tel: " + cfg.getTelefono());
        lblDireccionConfigLog.setText(cfg.getDireccion());
        lblRazonConfigLog.setText(cfg.getRazon_social());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRazonConfigLog = new javax.swing.JLabel();
        lblRucConfigLog = new javax.swing.JLabel();
        lblTelefonoConfigLog = new javax.swing.JLabel();
        lblDireccionConfigLog = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        picture2 = new components.Picture();

        setBackground(new java.awt.Color(60, 63, 65));
        setLayout(null);

        lblRazonConfigLog.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        lblRazonConfigLog.setForeground(new java.awt.Color(255, 255, 255));
        lblRazonConfigLog.setText("Tu tienda de confianza!");
        add(lblRazonConfigLog);
        lblRazonConfigLog.setBounds(80, 410, 180, 20);

        lblRucConfigLog.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        lblRucConfigLog.setForeground(new java.awt.Color(255, 255, 255));
        lblRucConfigLog.setText("NIT: 1053782271");
        add(lblRucConfigLog);
        lblRucConfigLog.setBounds(100, 320, 130, 20);

        lblTelefonoConfigLog.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        lblTelefonoConfigLog.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoConfigLog.setText("Tel: 3412547898");
        add(lblTelefonoConfigLog);
        lblTelefonoConfigLog.setBounds(100, 350, 130, 20);

        lblDireccionConfigLog.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        lblDireccionConfigLog.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccionConfigLog.setText("Calle 9B # 7-89");
        add(lblDireccionConfigLog);
        lblDireccionConfigLog.setBounds(110, 380, 120, 20);
        add(jSeparator1);
        jSeparator1.setBounds(30, 550, 100, 30);

        picture2.setPath("/assets/Logo.png");
        add(picture2);
        picture2.setBounds(40, 80, 250, 190);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDireccionConfigLog;
    private javax.swing.JLabel lblRazonConfigLog;
    private javax.swing.JLabel lblRucConfigLog;
    private javax.swing.JLabel lblTelefonoConfigLog;
    private components.Picture picture2;
    // End of variables declaration//GEN-END:variables
}
