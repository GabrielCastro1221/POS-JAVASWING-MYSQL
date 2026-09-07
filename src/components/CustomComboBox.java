package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComboBox;

public class CustomComboBox<E> extends JComboBox<E> {

    private final Float arc = 10f;
    private Color focusColor = Color.WHITE;

    public CustomComboBox() {
        setOpaque(false);
        setBackground(new Color(61, 63, 65));
        setForeground(Color.WHITE);
        setFont(new Font("SansSerif", Font.PLAIN, 14));
        setBorder(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        if (!hasFocus()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(focusColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc.intValue(), arc.intValue());
        g2.dispose();
    }
}
