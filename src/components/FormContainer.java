package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import javax.swing.JPanel;

public class FormContainer extends JPanel {

    public FormContainer() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Path2D.Double path = new Path2D.Double();
        path.moveTo(20, 0);
        path.quadTo(0, 0, 0, 20);
        path.lineTo(0, getHeight());
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth(), 0);
        path.closePath();

        Color topColor = new Color(42, 43, 48);
        Color bottomColor = new Color(30, 31, 35);
        g2.setPaint(new java.awt.GradientPaint(0, 0, topColor, 0, getHeight(), bottomColor));
        g2.fill(path);

        g2.setColor(new Color(60, 63, 65));
        g2.draw(path);

        g2.dispose();
    }
}
