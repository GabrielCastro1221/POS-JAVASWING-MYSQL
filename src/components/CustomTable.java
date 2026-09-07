package components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CustomTable extends JTable {

    public CustomTable() {
        super(new DefaultTableModel());
        aplicarEstilos();
    }

    public CustomTable(DefaultTableModel model) {
        super(model);
        aplicarEstilos();
    }

    private void aplicarEstilos() {
        setRowHeight(35);
        JTableHeader header = getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Caladea", Font.BOLD, 15));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
                cell.setFont(new Font("Caladea", Font.BOLD, 14));
                cell.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
                cell.setHorizontalAlignment(SwingConstants.CENTER);
                cell.setVerticalAlignment(SwingConstants.CENTER);

                if (isSelected) {
                    cell.setBackground(new Color(200, 200, 200));
                    cell.setForeground(Color.BLACK);
                }
                return cell;
            }
        });

        setSelectionBackground(new Color(200, 200, 200));
        setSelectionForeground(Color.BLACK);
    }
}
