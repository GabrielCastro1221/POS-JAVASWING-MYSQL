package components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Picture extends JLabel {

    private String path = "";
    private BufferedImage image;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            g2.dispose();
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        loadImage();
    }

    private void loadImage() {
        URL absolutePath = getClass().getResource(path);
        if (absolutePath != null) {
            try {
                image = ImageIO.read(absolutePath);
            } catch (IOException ex) {
                Logger.getLogger(Picture.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Logger.getLogger(Picture.class.getName()).log(Level.WARNING, "Imagen no encontrada en: " + path);
        }
        repaint(); // 👈 repinta siempre, incluso si no hay imagen
    }
}
