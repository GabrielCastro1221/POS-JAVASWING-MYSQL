package reports;

import java.util.List;
import model.Venta;
import model.VentaDAO;
import model.DetalleVenta;
import model.Config;
import model.ConfigDAO;

public class TicketPOS {

    public static void imprimirTicket(int idVenta) {
        try {
            VentaDAO vDAO = new VentaDAO();
            Venta venta = vDAO.buscarVentaPorId(idVenta);
            List<DetalleVenta> detalles = vDAO.listarDetalleVenta(idVenta);
            ConfigDAO confDAO = new ConfigDAO();
            Config cfg = confDAO.obtenerUltimaConfig();
            StringBuilder ticket = new StringBuilder();
            ticket.append("================================\n");
            ticket.append("     ").append(cfg.getNombre()).append("\n");
            ticket.append("   NIT: ").append(cfg.getRuc()).append("\n");
            ticket.append("================================\n");
            ticket.append("Fecha: ").append(venta.getFecha()).append("\n");
            String numeroMostrar = (venta.getNumero_factura() != null && !venta.getNumero_factura().isEmpty()) ? venta.getNumero_factura() : String.valueOf(venta.getId());
            ticket.append("Ticket No: ").append(numeroMostrar).append("\n");
            ticket.append("Cajero: ").append(venta.getNombreVendedor()).append("\n");
            ticket.append("--------------------------------\n");
            ticket.append("Producto            Cant  Precio\n");
            ticket.append("--------------------------------\n");
            for (DetalleVenta dv : detalles) {
                ticket.append(String.format("%-18s %3d %7.2f\n",
                        dv.getNombreProducto(),
                        dv.getCantidad(),
                        dv.getCantidad() * dv.getPrecio()));
            }
            ticket.append("--------------------------------\n");
            double subtotal;
            double iva;
            if (venta.getSubtotal() != null && venta.getIva_total() != null) {
                subtotal = venta.getSubtotal();
                iva = venta.getIva_total();
            } else {
                subtotal = venta.getTotal() / 1.19;
                iva = venta.getTotal() - subtotal;
            }
            ticket.append(String.format("Subtotal: %16.2f\n", subtotal));
            ticket.append(String.format("IVA: %21.2f\n", iva));
            ticket.append(String.format("TOTAL: %17.2f\n", venta.getTotal()));
            ticket.append("--------------------------------\n");
            String formaPago = (venta.getForma_pago() != null) ? venta.getForma_pago() : "efectivo";
            ticket.append("Metodo de pago: ")
                    .append(formaPago.substring(0, 1).toUpperCase())
                    .append(formaPago.substring(1))
                    .append("\n");
            ticket.append("================================\n");
            ticket.append("   Gracias por su compra!\n");
            ticket.append("   Vuelva pronto\n");
            ticket.append("================================\n\n\n\n");
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", "echo -e \"" + ticket.toString().replace("\"", "\\\"") + "\" > /dev/usb/lp0");
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            System.out.println("Error al imprimir ticket: " + e.getMessage());
        }
    }
}
