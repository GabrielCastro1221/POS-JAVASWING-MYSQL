package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class RoundedPanelSys extends JPanel {

    int arc = 20;
    boolean line = false;

    public RoundedPanelSys() {
        setOpaque(line);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D.Double roundedShape = new RoundRectangle2D.Double(
                0, 0, this.getWidth() - 1, this.getHeight() - 1, arc, arc
        );

        g2.setColor(this.getBackground());
        g2.fill(roundedShape);

        if (line) {
            g2.setColor(new Color(61, 63, 65));
            g2.draw(roundedShape);
        }

        g2.dispose();
    }

    public int getArc() {
        return arc;
    }

    public void setArc(int arc) {
        this.arc = arc;
    }

    public boolean isLine() {
        return line;
    }

    public void setLine(boolean line) {
        this.line = line;
    }
}
