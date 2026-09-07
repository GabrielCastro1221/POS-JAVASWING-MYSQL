package form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import model.Categoria;
import model.CategoriaDAO;

public class ConfigCategoriaForm extends javax.swing.JPanel {

    public ConfigCategoriaForm() {
        initComponents();
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        roundedPanelCrearCategoria.setOpaque(false);
        btnCrearCategoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int arc = 20;
        RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

        g2.setColor(new Color(255, 255, 255, 80));
        g2.draw(rounded);
        g2.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitleFormCategoria = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new components.CustomTextField();
        roundedPanelCrearCategoria = new components.RoundedPanel();
        btnCrearCategoria = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        lblTitleFormCategoria.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblTitleFormCategoria.setForeground(new java.awt.Color(196, 94, 95));
        lblTitleFormCategoria.setText("Formulario categorias");
        add(lblTitleFormCategoria);
        lblTitleFormCategoria.setBounds(40, 20, 241, 28);

        lblCategoria.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria.setText("Nombre");
        add(lblCategoria);
        lblCategoria.setBounds(40, 70, 70, 17);

        txtCategoria.setForeground(new java.awt.Color(200, 200, 200));
        txtCategoria.setText("Ingresa la categoria");
        add(txtCategoria);
        txtCategoria.setBounds(30, 90, 250, 33);

        roundedPanelCrearCategoria.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelCrearCategoria.setCornerRadius(10);
        roundedPanelCrearCategoria.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelCrearCategoria.setLayout(null);

        btnCrearCategoria.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnCrearCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrearCategoria.setText("Crear categoria");
        btnCrearCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearCategoriaMouseClicked(evt);
            }
        });
        btnCrearCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCrearCategoriaKeyPressed(evt);
            }
        });
        roundedPanelCrearCategoria.add(btnCrearCategoria);
        btnCrearCategoria.setBounds(0, 0, 250, 40);

        add(roundedPanelCrearCategoria);
        roundedPanelCrearCategoria.setBounds(30, 130, 250, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCategoriaMouseClicked
        try {
            String nombreCategoria = txtCategoria.getText().trim();
            if (nombreCategoria.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre de la categoría no puede estar vacío");
                return;
            }
            Categoria nuevo = new Categoria();
            nuevo.setNombre(nombreCategoria);
            CategoriaDAO cat = new CategoriaDAO();
            if (cat.registrarCategoria(nuevo)) {
                JOptionPane.showMessageDialog(this, "Categoría registrada con éxito");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar categoría");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());

        }
    }//GEN-LAST:event_btnCrearCategoriaMouseClicked

    private void btnCrearCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCrearCategoriaKeyPressed

    }//GEN-LAST:event_btnCrearCategoriaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCrearCategoria;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblTitleFormCategoria;
    private components.RoundedPanel roundedPanelCrearCategoria;
    private components.CustomTextField txtCategoria;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtCategoria.setText("");
        txtCategoria.requestFocus();
    }
}
