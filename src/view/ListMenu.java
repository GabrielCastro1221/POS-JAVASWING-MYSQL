package view;

import components.RoundedPanelSys;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListMenu extends RoundedPanelSys {

    String path = "";
    String text = "";
    Color backgroundColor = new Color(243, 243, 243);
    Color backgroundColorHover = new Color(230, 230, 230);
    Color backgroundColorHoverSelected = new Color(234, 234, 234);
    boolean selected = false;
    int id = 0;

    public ListMenu() {
        initComponents();
        setArc(10);
        setOpaque(false);
        
        init();
    }

    private void init() {
        lblOption.setForeground(Color.DARK_GRAY);
        icon.setForeground(Color.DARK_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Color redDark = new Color(196, 94, 95);
        Color redLight = new Color(224, 109, 106);

        GradientPaint gradient = new GradientPaint(0, 0, redDark, 0, getHeight(), redLight);

        g2.setPaint(gradient);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getArc(), getArc());

        g2.dispose();
        super.paintComponent(g);
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        setBackground(selected ? backgroundColorHover : backgroundColor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
