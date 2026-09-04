package components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {

    private Color topColor;
    private Color bottomColor;
    private int cornerRadius;
    private boolean backgroundDefault = true;

    public RoundedPanel(Color topColor, Color bottomColor, int cornerRadius) {
        this.topColor = topColor;
        this.bottomColor = bottomColor;
        this.cornerRadius = cornerRadius;

        setOpaque(false);
    }

    public RoundedPanel() {
        this.topColor = new Color(50, 53, 60);
        this.bottomColor = new Color(28, 29, 33);
        this.cornerRadius = 25;

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        if (backgroundDefault) {
            GradientPaint gradient = new GradientPaint(0, 0, topColor, width, height, bottomColor);
            g2.setPaint(gradient);
            g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
        } else {
            g2.setColor(new Color(200, 200, 200));
            g2.setStroke(new BasicStroke(0.5f));
            g2.drawRoundRect(1, 1, width - 2, height - 2, cornerRadius, cornerRadius);
        }
        g2.dispose();
    }

    public Color getTopColor() {
        return topColor;
    }

    public void setTopColor(Color topColor) {
        this.topColor = topColor;
        repaint();
    }

    public Color getBottomColor() {
        return bottomColor;
    }

    public void setBottomColor(Color bottomColor) {
        this.bottomColor = bottomColor;
        repaint();
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public boolean isBackgroundDefault() {
        return backgroundDefault;
    }

    public void setBackgroundDefault(boolean backgroundDefault) {
        this.backgroundDefault = backgroundDefault;
        repaint();
    }

    public void addEventListener(MouseAdapter mouseAdapter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
