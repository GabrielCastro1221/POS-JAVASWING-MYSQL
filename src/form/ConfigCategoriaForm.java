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
import model.ValidacionesTextField;

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
        txtIdCategoria.setVisible(false);
        cargarCategorias();
        tableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tableCategoria.getSelectedRow();
                if (fila >= 0) {
                    String id = tableCategoria.getValueAt(fila, 0).toString();
                    String nombre = tableCategoria.getValueAt(fila, 1).toString();
                    txtIdCategoria.setText(id);
                    txtCategoria.setText(nombre);
                }
            }
        });

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

    private void cargarCategorias() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableCategoria.getModel();
        modelo.setRowCount(0);
        CategoriaDAO dao = new CategoriaDAO();
        for (Categoria cat : dao.listarCategorias()) {
            modelo.addRow(new Object[]{
                cat.getId(),
                cat.getNombre()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitleFormCategoria = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new components.CustomTextField();
        roundedPanelCrearCategoria = new components.RoundedPanel();
        btnCrearCategoria = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCategoria = new components.CustomTable();
        roundedPanelActualizarCategoria = new components.RoundedPanel();
        btnActualizarCategoria = new javax.swing.JLabel();
        roundedPanelEliminarCategoria = new components.RoundedPanel();
        btnEliminarCategoria = new javax.swing.JLabel();
        txtIdCategoria = new components.CustomTextField();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        lblTitleFormCategoria.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        lblTitleFormCategoria.setForeground(new java.awt.Color(204, 0, 0));
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
        roundedPanelCrearCategoria.setBounds(30, 140, 250, 40);

        tableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOMBRE"
            }
        ));
        jScrollPane1.setViewportView(tableCategoria);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 300, 250, 200);

        roundedPanelActualizarCategoria.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelActualizarCategoria.setCornerRadius(10);
        roundedPanelActualizarCategoria.setTopColor(new java.awt.Color(0, 153, 255));
        roundedPanelActualizarCategoria.setLayout(null);

        btnActualizarCategoria.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnActualizarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizarCategoria.setText("Actualizar categoria");
        btnActualizarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarCategoriaMouseClicked(evt);
            }
        });
        btnActualizarCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarCategoriaKeyPressed(evt);
            }
        });
        roundedPanelActualizarCategoria.add(btnActualizarCategoria);
        btnActualizarCategoria.setBounds(0, 0, 250, 40);

        add(roundedPanelActualizarCategoria);
        roundedPanelActualizarCategoria.setBounds(30, 190, 250, 40);

        roundedPanelEliminarCategoria.setBottomColor(new java.awt.Color(213, 69, 53));
        roundedPanelEliminarCategoria.setCornerRadius(10);
        roundedPanelEliminarCategoria.setTopColor(new java.awt.Color(224, 109, 106));
        roundedPanelEliminarCategoria.setLayout(null);

        btnEliminarCategoria.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnEliminarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarCategoria.setText("Eliminar categoria");
        btnEliminarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarCategoriaMouseClicked(evt);
            }
        });
        btnEliminarCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarCategoriaKeyPressed(evt);
            }
        });
        roundedPanelEliminarCategoria.add(btnEliminarCategoria);
        btnEliminarCategoria.setBounds(0, 0, 250, 40);

        add(roundedPanelEliminarCategoria);
        roundedPanelEliminarCategoria.setBounds(30, 240, 250, 40);
        add(txtIdCategoria);
        txtIdCategoria.setBounds(130, 50, 10, 33);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCategoriaMouseClicked
        ValidacionesTextField val = new ValidacionesTextField();
        String nombreCategoria = txtCategoria.getText().trim();
        if (!val.validarCategoria(nombreCategoria)) {
            JOptionPane.showMessageDialog(this, "La categoría debe tener al menos 3 letras y no contener números");
            return;
        }
        try {
            Categoria nuevo = new Categoria();
            nuevo.setNombre(nombreCategoria);
            CategoriaDAO cat = new CategoriaDAO();
            if (cat.registrarCategoria(nuevo)) {
                JOptionPane.showMessageDialog(this, "Categoría registrada con éxito");
                limpiarCampos();
                cargarCategorias();
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

    private void btnActualizarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarCategoriaMouseClicked
        ValidacionesTextField val = new ValidacionesTextField();
        String nombre = txtCategoria.getText().trim();
        if (!val.validarCategoria(nombre)) {
            JOptionPane.showMessageDialog(this, "La categoría debe tener al menos 3 letras y no contener números");
            return;
        }
        try {
            int id = Integer.parseInt(txtIdCategoria.getText());
            Categoria cat = new Categoria();
            cat.setId(id);
            cat.setNombre(nombre);
            CategoriaDAO dao = new CategoriaDAO();
            if (dao.modificarCategoria(cat)) {
                JOptionPane.showMessageDialog(this, "Categoría actualizada con éxito");
                limpiarCampos();
                cargarCategorias();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar categoría");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarCategoriaMouseClicked

    private void btnActualizarCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarCategoriaKeyPressed

    }//GEN-LAST:event_btnActualizarCategoriaKeyPressed

    private void btnEliminarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaMouseClicked
        try {
            int id = Integer.parseInt(txtIdCategoria.getText());
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar esta categoría?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                CategoriaDAO dao = new CategoriaDAO();
                if (dao.eliminarCategoria(id)) {
                    JOptionPane.showMessageDialog(this, "Categoría eliminada con éxito");
                    limpiarCampos();
                    cargarCategorias();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar categoría");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarCategoriaMouseClicked

    private void btnEliminarCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaKeyPressed

    }//GEN-LAST:event_btnEliminarCategoriaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarCategoria;
    private javax.swing.JLabel btnCrearCategoria;
    private javax.swing.JLabel btnEliminarCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblTitleFormCategoria;
    private components.RoundedPanel roundedPanelActualizarCategoria;
    private components.RoundedPanel roundedPanelCrearCategoria;
    private components.RoundedPanel roundedPanelEliminarCategoria;
    private components.CustomTable tableCategoria;
    private components.CustomTextField txtCategoria;
    private components.CustomTextField txtIdCategoria;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtCategoria.setText("");
        txtCategoria.requestFocus();
    }
}
