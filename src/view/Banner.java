package view;

import components.RoundedPanel;
import java.awt.Color;

public class Banner extends RoundedPanel {

    public Banner() {
        super(new Color(42, 43, 48), new Color(30, 31, 35), 18);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        picture1 = new components.Picture();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(60, 63, 65));
        setLayout(null);

        jLabel1.setBackground(new java.awt.Color(60, 63, 65));
        jLabel1.setFont(new java.awt.Font("Caladea", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Miscelanea Bellavista");
        add(jLabel1);
        jLabel1.setBounds(50, 50, 200, 20);

        picture1.setPath("/assets/brand.png");
        add(picture1);
        picture1.setBounds(260, 50, 30, 20);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(196, 94, 95));
        jLabel2.setText("Bienvenido");
        add(jLabel2);
        jLabel2.setBounds(30, 175, 110, 20);

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("eiusmod?");
        add(jLabel3);
        jLabel3.setBounds(30, 325, 250, 20);

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lorem Ipsum dolor");
        add(jLabel4);
        jLabel4.setBounds(30, 220, 240, 20);

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Consectetur adpisicing");
        add(jLabel5);
        jLabel5.setBounds(30, 253, 240, 20);

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sed do  eiusmod tempor");
        add(jLabel6);
        jLabel6.setBounds(30, 290, 250, 20);
        add(jSeparator1);
        jSeparator1.setBounds(30, 550, 100, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private components.Picture picture1;
    // End of variables declaration//GEN-END:variables
}
