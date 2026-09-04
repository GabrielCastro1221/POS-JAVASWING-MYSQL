package view;

import java.awt.Color;

public class Sidebar extends javax.swing.JPanel {

    public Sidebar() {
        initComponents();
        setOpaque(false);
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        jPanel1.setOpaque(false);
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel2.setOpaque(false);
        jPanel2.setBackground(new Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        listMenu1 = new view.ListMenu();
        listMenu2 = new view.ListMenu();
        listMenu3 = new view.ListMenu();
        listMenu4 = new view.ListMenu();
        listMenu5 = new view.ListMenu();
        jPanel2 = new javax.swing.JPanel();
        listMenu6 = new view.ListMenu();
        listMenu7 = new view.ListMenu();
        listMenu8 = new view.ListMenu();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(196, 94, 95));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Miscelanea");
        add(jLabel1);
        jLabel1.setBounds(40, 30, 130, 30);

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        listMenu1.setText("Nueva venta");
        jPanel1.add(listMenu1);

        listMenu2.setPath("/assets/apps.png");
        listMenu2.setText("Productos");
        jPanel1.add(listMenu2);

        listMenu3.setPath("/assets/plugin.png");
        listMenu3.setText("Proveedores");
        jPanel1.add(listMenu3);

        listMenu4.setPath("/assets/sounds.png");
        listMenu4.setText("Ventas");
        jPanel1.add(listMenu4);

        listMenu5.setPath("/assets/element.png");
        listMenu5.setText("Clientes");
        jPanel1.add(listMenu5);

        add(jPanel1);
        jPanel1.setBounds(20, 150, 190, 248);

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));
        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        listMenu6.setPath("/assets/notification.png");
        listMenu6.setText("Reportes");
        jPanel2.add(listMenu6);

        listMenu7.setPath("/assets/library.png");
        listMenu7.setText("Usuarios");
        jPanel2.add(listMenu7);

        listMenu8.setPath("/assets/settings.png");
        listMenu8.setText("Configuracion");
        jPanel2.add(listMenu8);

        add(jPanel2);
        jPanel2.setBounds(20, 530, 190, 140);

        jLabel2.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(196, 94, 95));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bellavista");
        add(jLabel2);
        jLabel2.setBounds(40, 60, 130, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private view.ListMenu listMenu1;
    private view.ListMenu listMenu2;
    private view.ListMenu listMenu3;
    private view.ListMenu listMenu4;
    private view.ListMenu listMenu5;
    private view.ListMenu listMenu6;
    private view.ListMenu listMenu7;
    private view.ListMenu listMenu8;
    // End of variables declaration//GEN-END:variables
}
