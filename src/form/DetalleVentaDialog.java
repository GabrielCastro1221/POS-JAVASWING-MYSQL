package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Venta;
import model.VentaDAO;
import model.DetalleVenta;

public class DetalleVentaDialog extends JDialog {

    private JTable tableDetalle;
    private final int ventaId;
    private List<DetalleVenta> detallesActuales;
    private JLabel lblEstado;
    private JButton btnDevolucion;
    private JButton btnAnularVenta;

    public DetalleVentaDialog(int ventaId) {
        this.ventaId = ventaId;
        setTitle("Detalle de Venta");
        setSize(600, 480);
        setLocationRelativeTo(null);
        setModal(true);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(61, 63, 65));
        JLabel titulo = new JLabel("Detalle de la venta #" + ventaId);
        titulo.setFont(new Font("Caladea", Font.BOLD, 16));
        titulo.setForeground(new Color(200, 200, 200));
        lblEstado = new JLabel();
        lblEstado.setFont(new Font("Caladea", Font.BOLD, 13));
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(61, 63, 65));
        header.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        header.add(titulo, BorderLayout.WEST);
        header.add(lblEstado, BorderLayout.EAST);
        panel.add(header, BorderLayout.NORTH);
        tableDetalle = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"Producto", "Cantidad", "Precio Unitario", "Subtotal"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tableDetalle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(tableDetalle);
        panel.add(scroll, BorderLayout.CENTER);
        btnDevolucion = new JButton("Devolución / Reclamo");
        btnDevolucion.setOpaque(false);
        btnDevolucion.setContentAreaFilled(false);
        btnDevolucion.setBorderPainted(true);
        btnDevolucion.setForeground(new Color(200, 200, 200));
        btnDevolucion.setFont(new Font("Caladea", Font.BOLD, 14));
        btnDevolucion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDevolucion.addActionListener(e -> procesarDevolucion());
        btnAnularVenta = new JButton("Anular Venta");
        btnAnularVenta.setOpaque(false);
        btnAnularVenta.setContentAreaFilled(false);
        btnAnularVenta.setBorderPainted(true);
        btnAnularVenta.setForeground(new Color(224, 109, 106));
        btnAnularVenta.setFont(new Font("Caladea", Font.BOLD, 14));
        btnAnularVenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAnularVenta.addActionListener(e -> procesarAnulacion());
        JPanel footer = new JPanel();
        footer.setBackground(new Color(61, 63, 65));
        footer.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        footer.add(btnDevolucion);
        footer.add(btnAnularVenta);
        panel.add(footer, BorderLayout.SOUTH);
        cargarDetalle(ventaId);
        add(panel);
    }

    private void cargarDetalle(int ventaId) {
        VentaDAO vDAO = new VentaDAO();
        Venta venta = vDAO.buscarVentaPorId(ventaId);
        detallesActuales = vDAO.listarDetalleVenta(ventaId);
        DefaultTableModel modelo = (DefaultTableModel) tableDetalle.getModel();
        modelo.setRowCount(0);
        for (DetalleVenta dv : detallesActuales) {
            modelo.addRow(new Object[]{dv.getNombreProducto(), dv.getCantidad(), String.format("%.2f", dv.getPrecio()),
                String.format("%.2f", dv.getCantidad() * dv.getPrecio())});
        }
        boolean anulada = venta != null && "anulada".equalsIgnoreCase(venta.getEstado());
        if (anulada) {
            lblEstado.setText("VENTA ANULADA");
            lblEstado.setForeground(new Color(224, 109, 106));
        } else {
            lblEstado.setText("");
        }
        btnDevolucion.setEnabled(!anulada);
        btnAnularVenta.setEnabled(!anulada);
    }

    private void procesarDevolucion() {
        int filaSeleccionada = tableDetalle.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona primero el producto que deseas devolver", "Ningún producto seleccionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DetalleVenta detalleSeleccionado = detallesActuales.get(filaSeleccionada);
        int cantidadComprada = detalleSeleccionado.getCantidad();
        String input = JOptionPane.showInputDialog(this, "Producto: " + detalleSeleccionado.getNombreProducto() + "\nCantidad comprada: " + cantidadComprada
                + "\n\n¿Cuántas unidades deseas devolver?", "Devolución / Reclamo", JOptionPane.QUESTION_MESSAGE);
        if (input == null) {
            return;
        }
        int cantidadDevolver;
        try {
            cantidadDevolver = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresa un número entero válido");
            return;
        }
        if (cantidadDevolver <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad a devolver debe ser mayor a cero");
            return;
        }
        if (cantidadDevolver > cantidadComprada) {
            JOptionPane.showMessageDialog(this, "No puedes devolver más de lo comprado (" + cantidadComprada + " unidades)");
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Confirmas la devolución de " + cantidadDevolver + " unidad(es) de \""
                + detalleSeleccionado.getNombreProducto() + "\"?", "Confirmar devolución", JOptionPane.YES_NO_OPTION);
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }
        VentaDAO vDAO = new VentaDAO();
        String mensaje = vDAO.registrarDevolucion(ventaId, detalleSeleccionado.getCodigo_producto(), cantidadDevolver);
        JOptionPane.showMessageDialog(this, mensaje);
        cargarDetalle(ventaId);
    }

    private void procesarAnulacion() {
        if (config.Session.getUsuario() == null
                || !"admin".equalsIgnoreCase(config.Session.getUsuario().getRol())) {
            JOptionPane.showMessageDialog(this, "No tienes permiso para anular ventas");
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas anular COMPLETAMENTE la venta #" + ventaId + "?"
                + "\nSe restaurará el stock de todos los productos."
                + "\nEsta acción no se puede deshacer.",
                "Confirmar anulación de venta",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }
        VentaDAO vDAO = new VentaDAO();
        String mensaje = vDAO.anularVenta(ventaId);
        JOptionPane.showMessageDialog(this, mensaje);
        cargarDetalle(ventaId);
    }
}
