package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class AuthForm extends javax.swing.JFrame {

    public AuthForm() {
        initComponents();
        init();
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0));
        getContentPane().setBackground(new Color(0, 0, 0, 0));
        backgroundPanel.setOpaque(false);
        btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMinimizarLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        aplicarFormaRedondeada();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                aplicarFormaRedondeada();
            }
        });

        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        setFocusable(true);
        backgroundPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                requestFocusInWindow();
            }
        });

        banner.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                requestFocusInWindow();
            }
        });

        btnMinimizarLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setState(javax.swing.JFrame.ICONIFIED);
            }
        });
    }

    private void aplicarFormaRedondeada() {
        if (getWidth() > 0 && getHeight() > 0) {
            setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new components.RoundedPanel();
        btnClose = new components.Picture();
        banner = new view.Banner();
        login1 = new view.Login();
        btnMinimizarLogin = new components.Picture();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        backgroundPanel.setLayout(null);

        btnClose.setPath("/assets/close.png");
        backgroundPanel.add(btnClose);
        btnClose.setBounds(830, 21, 20, 20);
        backgroundPanel.add(banner);
        banner.setBounds(15, 15, 350, 580);
        backgroundPanel.add(login1);
        login1.setBounds(400, 110, 420, 350);

        btnMinimizarLogin.setPath("/assets/minimizar.png");
        backgroundPanel.add(btnMinimizarLogin);
        btnMinimizarLogin.setBounds(790, 20, 30, 28);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new AuthForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedPanel backgroundPanel;
    private view.Banner banner;
    private components.Picture btnClose;
    private components.Picture btnMinimizarLogin;
    private view.Login login1;
    // End of variables declaration//GEN-END:variables
}
