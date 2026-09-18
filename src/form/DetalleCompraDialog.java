package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.CompraDAO;
import model.DetalleCompra;

public class DetalleCompraDialog extends JDialog {

    private JTable tableDetalle;
    private List<DetalleCompra> detalles;

    public DetalleCompraDialog(int compraId) {

        setTitle("Detalle Compra");
        setModal(true);
        setSize(700, 450);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(61, 63, 65));

        JLabel titulo = new JLabel("Detalle de la compra #" + compraId);
        titulo.setFont(new Font("Caladea", Font.BOLD, 16));
        titulo.setForeground(new Color(220, 220, 220));

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(61, 63, 65));
        header.add(titulo, BorderLayout.CENTER);

        panel.add(header, BorderLayout.NORTH);

        tableDetalle = new JTable(
                new DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                            "PRODUCTO",
                            "CANTIDAD",
                            "COSTO UNITARIO",
                            "IVA",
                            "SUBTOTAL"
                        }
                ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        JScrollPane scroll = new JScrollPane(tableDetalle);
        panel.add(scroll, BorderLayout.CENTER);

        add(panel);

        cargarDetalle(compraId);
    }

    private void cargarDetalle(int compraId) {

        CompraDAO dao = new CompraDAO();

        detalles = dao.listarDetalleCompra(compraId);

        DefaultTableModel modelo
                = (DefaultTableModel) tableDetalle.getModel();

        modelo.setRowCount(0);

        for (DetalleCompra detalle : detalles) {

            modelo.addRow(new Object[]{
                detalle.getNombreProducto(),
                detalle.getCantidad(),
                String.format("%.2f", detalle.getCostoUnitario()),
                String.format("%.2f", detalle.getIvaLinea()),
                String.format("%.2f", detalle.getSubtotalLinea())
            });
        }
    }
}
