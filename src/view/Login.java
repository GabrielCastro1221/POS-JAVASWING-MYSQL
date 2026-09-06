package view;

import java.awt.Cursor;
import model.AuthDAO;

public class Login extends javax.swing.JPanel {

    AuthDAO log = new AuthDAO();

    public Login() {
        initComponents();
        setOpaque(false);
        this.init();
    }

    public void init() {
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtLoginEmail.addActionListener(e -> iniciarSesion());
        txtLoginPass.addActionListener(e -> iniciarSesion());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtLoginEmail = new components.CustomTextField();
        txtLoginPass = new components.CustomPasswordField();
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

        txtLoginEmail.setPlaceholder("Email");
        add(txtLoginEmail);
        txtLoginEmail.setBounds(30, 140, 360, 40);

        txtLoginPass.setPlaceholder("Contraseña");
        add(txtLoginPass);
        txtLoginPass.setBounds(30, 200, 360, 40);

        roundedPanel1.setBottomColor(new java.awt.Color(213, 69, 53));
        roundedPanel1.setCornerRadius(10);
        roundedPanel1.setTopColor(new java.awt.Color(224, 109, 106));
        roundedPanel1.setLayout(null);

        btnLogin.setFont(new java.awt.Font("Caladea", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLogin.setText("Ingresar");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });
        roundedPanel1.add(btnLogin);
        btnLogin.setBounds(0, 0, 360, 40);

        add(roundedPanel1);
        roundedPanel1.setBounds(30, 280, 360, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        iniciarSesion();
    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed

    }//GEN-LAST:event_btnLoginKeyPressed

    private void iniciarSesion() {
        String correo = txtLoginEmail.getText();
        String pass = new String(txtLoginPass.getPassword());

        model.Auth usuario = log.login(correo, pass);

        if (usuario != null) {
            System sys = new System();
            sys.setVisible(true);

            java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Correo o contraseña incorrectos",
                    "Error de inicio de sesión",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnLogin;
    private javax.swing.JLabel jLabel1;
    private components.RoundedPanel roundedPanel1;
    private components.CustomTextField txtLoginEmail;
    private components.CustomPasswordField txtLoginPass;
    // End of variables declaration//GEN-END:variables
}
