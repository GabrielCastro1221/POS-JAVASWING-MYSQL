package reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import model.Venta;

public class TicketPDF {

    private JTable tableVenta;
    private double totalPagar;

    public TicketPDF(JTable tableVenta, double totalPagar) {
        this.tableVenta = tableVenta;
        this.totalPagar = totalPagar;
    }

    public void GenerarPDF(Venta venta, String rucConfig, String nombreConfig, String telefonoConfig,
            String direccionConfig, String razonConfig) {
        try {
            String carpetaUsuario = System.getProperty("user.home");
            File dir = new File(carpetaUsuario, "MiscelaneaBellavista" + File.separator + "Facturas_ventas");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, "venta" + venta.getId() + ".pdf");
            FileOutputStream archivo = new FileOutputStream(file);
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font normal = new Font(Font.FontFamily.HELVETICA, 11);
            Image img = Image.getInstance("src/assets/Logo1.png");
            img.scaleToFit(60, 60);
            String fechaFactura = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(venta.getFecha());
            String numeroMostrar = (venta.getNumero_factura() != null && !venta.getNumero_factura().isEmpty()) ? venta.getNumero_factura() : String.valueOf(venta.getId());
            Paragraph datosFactura = new Paragraph("Factura: " + numeroMostrar + "\nFecha: " + fechaFactura + "\nForma de pago: " + capitalizar(venta.getForma_pago()), normal);
            PdfPTable encabezado = new PdfPTable(3);
            encabezado.setWidthPercentage(100);
            encabezado.setWidths(new float[]{20f, 55f, 25f});
            encabezado.getDefaultCell().setBorder(0);
            encabezado.addCell(img);
            PdfPCell datosEmpresa = new PdfPCell(new Phrase("RUC: " + rucConfig + "\nNombre: " + nombreConfig + "\nTeléfono: " + telefonoConfig + "\nDirección: " + direccionConfig + "\nRazón Social: " + razonConfig, normal));
            datosEmpresa.setBorder(0);
            encabezado.addCell(datosEmpresa);
            PdfPCell datosFacturaCell = new PdfPCell(datosFactura);
            datosFacturaCell.setBorder(0);
            encabezado.addCell(datosFacturaCell);
            doc.add(encabezado);
            doc.add(new Paragraph("\nDetalle de Productos\n\n", negrita));
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.setWidths(new float[]{20f, 50f, 20f, 20f});
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
            String[] headersPro = {"Cantidad", "Descripción", "P. Unitario", "Total"};
            for (String header : headersPro) {
                PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaProductos.addCell(cell);
            }
            for (int i = 0; i < tableVenta.getRowCount(); i++) {
                tablaProductos.addCell(new Phrase(tableVenta.getValueAt(i, 3).toString(), normal));
                tablaProductos.addCell(new Phrase(tableVenta.getValueAt(i, 2).toString(), normal));
                tablaProductos.addCell(new Phrase(tableVenta.getValueAt(i, 4).toString(), normal));
                tablaProductos.addCell(new Phrase(tableVenta.getValueAt(i, 5).toString(), normal));
            }
            doc.add(tablaProductos);
            StringBuilder totalesTexto = new StringBuilder("\n");
            if (venta.getSubtotal() != null && venta.getIva_total() != null) {
                totalesTexto.append("Subtotal: $").append(String.format("%.2f", venta.getSubtotal())).append("\n");
                totalesTexto.append("IVA: $").append(String.format("%.2f", venta.getIva_total())).append("\n");
            }
            totalesTexto.append("Total a pagar: $").append(String.format("%.2f", totalPagar));
            Paragraph total = new Paragraph(totalesTexto.toString(), negrita);
            total.setAlignment(Element.ALIGN_RIGHT);
            doc.add(total);
            Paragraph firma = new Paragraph("\n\nFirma y Sello\n\n--------------------------", normal);
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            Paragraph mensaje = new Paragraph("\nGracias por su compra", negrita);
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }

    private String capitalizar(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "Efectivo";
        }
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
