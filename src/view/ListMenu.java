package view;

import components.RoundedPanelSys;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListMenu extends RoundedPanelSys {

    String path = "";
    String text = "";
    Color backgroundColor = new Color(243, 243, 243);
    Color backgroundColorHover = new Color(230, 230, 230);

    public ListMenu() {
        initComponents();
        setArc(10);
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(backgroundColorHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(backgroundColor);
            }
        });
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        icon.setPath(path);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        lblOption.setText(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new components.Picture();
        lblOption = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));
        setLayout(null);

        icon.setPath("/assets/home.png");
        add(icon);
        icon.setBounds(12, 10, 18, 18);

        lblOption.setFont(new java.awt.Font("Caladea", 0, 16)); // NOI18N
        lblOption.setForeground(new java.awt.Color(43, 43, 43));
        lblOption.setText("MIicelanea Bellavista");
        add(lblOption);
        lblOption.setBounds(42, 9, 170, 20);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.Picture icon;
    private javax.swing.JLabel lblOption;
    // End of variables declaration//GEN-END:variables
}
