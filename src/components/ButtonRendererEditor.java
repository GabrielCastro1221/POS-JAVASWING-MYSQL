package components;

import form.DetalleVentaDialog;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private JButton button;
    private int row;

    public ButtonRendererEditor(JTable table) {
        button = new JButton("DETALLE VENTA");
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(new Color(204, 0, 0));
        button.setFont(new Font("Caladea", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ventaId = (int) table.getValueAt(row, 0);
                System.out.println("Abrir detalle de venta: " + ventaId);
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ventaId = (int) table.getValueAt(row, 0);
                DetalleVentaDialog dialog = new DetalleVentaDialog(ventaId);
                dialog.setVisible(true);
            }
        });

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.row = row;
        return button;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return "DETALLE VENTA";
    }
}
