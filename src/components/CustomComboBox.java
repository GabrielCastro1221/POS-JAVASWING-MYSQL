package components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

public class CustomComboBox<E> extends JComboBox<E> {

    private final Float arc = 10f;
    private Color borderColor = new Color(255, 255, 255, 80);
    private Color focusColor = Color.WHITE;

    public CustomComboBox() {
        setOpaque(false);
        setBackground(new Color(48, 51, 58));
        setForeground(Color.WHITE);
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setBorder(new EmptyBorder(5, 10, 5, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(1, 1, getWidth() - 2, getHeight() - 2, arc, arc));

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (hasFocus()) {
            g2.setColor(focusColor);
        } else {
            g2.setColor(borderColor);
        }

        g2.setStroke(new BasicStroke(1.5f));
        g2.draw(new RoundRectangle2D.Float(0.5F, 0.5F, getWidth() - 1f, getHeight() - 1f, arc, arc));

        g2.dispose();
    }
}
