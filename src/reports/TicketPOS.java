package reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import model.VentaDAO;
import model.Venta;
import model.DetalleVenta;

public class TicketPOS {

    public static void generarTicket(int idVenta) {
        try {
            VentaDAO dao = new VentaDAO();
            Venta venta = dao.obtenerVentaPorId(idVenta);
            List<DetalleVenta> detalles = dao.listarDetalleVenta(idVenta);

            if (venta == null) {
                System.out.println("Venta no encontrada");
                return;
            }
            Rectangle pageSize = new Rectangle(226, 600);
            Document doc = new Document(pageSize, 10, 10, 10, 10);

            String home = System.getProperty("user.home");
            File file = new File(home + "/Downloads/ticketPOS_" + idVenta + ".pdf");
            PdfWriter.getInstance(doc, new FileOutputStream(file));

            doc.open();

            Font fontNormal = new Font(Font.FontFamily.COURIER, 9, Font.NORMAL);
            Font fontBold = new Font(Font.FontFamily.COURIER, 9, Font.BOLD);

            Paragraph header = new Paragraph("TIENDA XYZ\nNIT: 123456789\nTel: 3100000000\n", fontBold);
            header.setAlignment(Element.ALIGN_CENTER);
            doc.add(header);
            doc.add(new Paragraph("----------------------------------", fontNormal));
            doc.add(new Paragraph("Cliente: " + venta.getNombreCliente(), fontNormal));
            doc.add(new Paragraph("Vendedor: " + venta.getNombreVendedor(), fontNormal));
            doc.add(new Paragraph("Fecha: " + venta.getFecha(), fontNormal));
            doc.add(new Paragraph("----------------------------------", fontNormal));

            PdfPTable table = new PdfPTable(3);
            table.setWidths(new float[]{2f, 1f, 1f});
            table.setWidthPercentage(100);

            table.addCell(new Phrase("Producto", fontBold));
            table.addCell(new Phrase("Cant", fontBold));
            table.addCell(new Phrase("Total", fontBold));

            for (DetalleVenta dv : detalles) {
                table.addCell(new Phrase(dv.getNombreProducto(), fontNormal));
                table.addCell(new Phrase(String.valueOf(dv.getCantidad()), fontNormal));
                table.addCell(new Phrase(String.format("%.2f", dv.getCantidad() * dv.getPrecio()), fontNormal));
            }

            doc.add(table);
            doc.add(new Paragraph("----------------------------------", fontNormal));

            Paragraph totalP = new Paragraph("TOTAL: $" + String.format("%.2f", venta.getTotal()), fontBold);
            totalP.setAlignment(Element.ALIGN_RIGHT);
            doc.add(totalP);

            doc.add(new Paragraph("\nGracias por su compra\n", fontNormal));
            doc.add(new Paragraph("Software POS - Ticket\n", fontNormal));

            doc.close();

            System.out.println("Ticket generado en: " + file.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Error al generar ticket: " + e.getMessage());
        }
    }
}
