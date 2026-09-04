package view;

import java.awt.Cursor;

public class Login extends javax.swing.JPanel {

    public Login() {
        initComponents();
        setOpaque(false);
        this.init();
    }

    public void init() {
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        customTextField1 = new components.CustomTextField();
        customPasswordField1 = new components.CustomPasswordField();
        roundedPanel1 = new components.RoundedPanel();
        btnLogin = new javax.swing.JLabel();

        setBackground(new java.awt.Color(60, 63, 65));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Caladea", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INGRESAR");
        add(jLabel1);
        jLabel1.setBounds(30, 20, 360, 52);

        customTextField1.setPlaceholder("Email");
        add(customTextField1);
        customTextField1.setBounds(30, 140, 360, 40);

        customPasswordField1.setPlaceholder("Contraseña");
        add(customPasswordField1);
        customPasswordField1.setBounds(30, 200, 360, 40);

        roundedPanel1.setBottomColor(new java.awt.Color(213, 69, 53));
        roundedPanel1.setCornerRadius(10);
        roundedPanel1.setTopColor(new java.awt.Color(224, 109, 106));
        roundedPanel1.setLayout(null);

        btnLogin.setFont(new java.awt.Font("Caladea", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLogin.setText("Ingresar");
        roundedPanel1.add(btnLogin);
        btnLogin.setBounds(0, 0, 360, 40);

        add(roundedPanel1);
        roundedPanel1.setBounds(30, 280, 360, 40);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnLogin;
    private components.CustomPasswordField customPasswordField1;
    private components.CustomTextField customTextField1;
    private javax.swing.JLabel jLabel1;
    private components.RoundedPanel roundedPanel1;
    // End of variables declaration//GEN-END:variables
}
