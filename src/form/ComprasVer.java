package form;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Compra;
import model.CompraDAO;

public class ComprasVer extends javax.swing.JPanel {

    public ComprasVer() {
        initComponents();
        setOpaque(false);
        listarCompras();
        configurarColumnaDetalle();
        eventoDetalle();
        compraVerForm1.setTableCompras(tableCompras);

        tableCompras.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int fila = tableCompras.rowAtPoint(e.getPoint());
                int columna = tableCompras.columnAtPoint(e.getPoint());
                if (columna == 9 && fila >= 0) {
                    tableCompras.setCursor(
                            new Cursor(Cursor.HAND_CURSOR));
                } else {
                    tableCompras.setCursor(
                            new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });
    }

    private void listarCompras() {
        CompraDAO dao = new CompraDAO();
        DefaultTableModel modelo = (DefaultTableModel) tableCompras.getModel();
        modelo.setRowCount(0);
        for (Compra compra : dao.listarCompras()) {
            Object[] fila = {
                compra.getId(),
                compra.getNombreProveedor(),
                compra.getNombreUsuario(),
                compra.getNumeroFacturaProveedor(),
                compra.getFecha(),
                compra.getSubtotal(),
                compra.getIvaTotal(),
                compra.getTotal(),
                compra.getEstado(),
                "Ver detalle"
            };
            modelo.addRow(fila);
        }
    }

    private void configurarColumnaDetalle() {
        tableCompras.getColumnModel().getColumn(9)
                .setCellRenderer(new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        label.setHorizontalAlignment(JLabel.CENTER);
                        label.setText("<html><b><font color='#FF0000'>Detalle compra</font></b></html>");
                        if (!isSelected) {
                            label.setBackground(Color.WHITE);
                        }
                        return label;
                    }
                });
    }

    private void eventoDetalle() {
        tableCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tableCompras.rowAtPoint(evt.getPoint());
                int columna = tableCompras.columnAtPoint(evt.getPoint());
                if (fila >= 0 && columna == 9) {
                    int idCompra = Integer.parseInt(tableCompras.getValueAt(fila, 0).toString());
                    DetalleCompraDialog dialog = new DetalleCompraDialog(idCompra);
                    dialog.setVisible(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompras = new components.CustomTable();
        compraVerForm1 = new form.CompraVerForm();

        setBackground(new java.awt.Color(61, 63, 65));
        setPreferredSize(new java.awt.Dimension(1180, 660));
        setLayout(null);

        tableCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PROVEEDOR", "USUARIO", "# FACTURA", "FECHA", "SUBTOTAL", "IVA TOTAL", "TOTAL", "ESTADO", "DETALLE"
            }
        ));
        jScrollPane1.setViewportView(tableCompras);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 1130, 540);
        add(compraVerForm1);
        compraVerForm1.setBounds(20, 20, 650, 60);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private form.CompraVerForm compraVerForm1;
    private javax.swing.JScrollPane jScrollPane1;
    private components.CustomTable tableCompras;
    // End of variables declaration//GEN-END:variables
}
