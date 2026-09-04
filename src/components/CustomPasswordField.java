package components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class CustomPasswordField extends JPasswordField {

    private String placeholder = "";
    private boolean isPlaceholderVisible = true;
    private final Float arc = 10f;
    private Color colorPlaceholder = new Color(81, 84, 91);

    public CustomPasswordField() {
        setOpaque(false);
        setBackground(new Color(48, 51, 58));
        setBorder(new EmptyBorder(8, 12, 8, 12));
        setFont(new Font("SansSerif", Font.PLAIN, 14));

        setText(placeholder);
        setForeground(colorPlaceholder);
        setEchoChar((char) 0);

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isPlaceholderVisible) {
                    setText("");
                    setForeground(Color.WHITE);
                    setEchoChar('•');
                    isPlaceholderVisible = false;
                }
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getPassword().length == 0) {
                    setText(placeholder);
                    setForeground(colorPlaceholder);
                    setEchoChar((char) 0);
                    isPlaceholderVisible = true;
                }
                repaint();
            }
        });
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
        if (!hasFocus()) {
            return;
        }
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(1.0f));
        g2.draw(new RoundRectangle2D.Float(0.5F, 0.5F, getWidth() - 1f, getHeight() - 1f, arc, arc));
        g2.dispose();
    }

    public String getRealPassword() {
        return isPlaceholderVisible ? "" : new String(getPassword());
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        if (isPlaceholderVisible) {
            setText(placeholder);
            setForeground(colorPlaceholder);
            setEchoChar((char) 0);
        }
    }
}
