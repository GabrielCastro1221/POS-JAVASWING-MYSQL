package reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;

public class TicketPDF {

    private JTable tableVenta;
    private double totalPagar;

    public TicketPDF(JTable tableVenta, double totalPagar) {
        this.tableVenta = tableVenta;
        this.totalPagar = totalPagar;
    }

    public void GenerarPDF(int idVenta, String rucConfig, String nombreConfig, String telefonoConfig,
            String direccionConfig, String razonConfig) {
        try {
            String rutaBase = "/home/DeathRaven1221/Documentos/Miscelanea_bellavista/Facturas_ventas";
            File dir = new File(rutaBase);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir, "venta" + idVenta + ".pdf");
            FileOutputStream archivo = new FileOutputStream(file);
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font normal = new Font(Font.FontFamily.HELVETICA, 11);

            Image img = Image.getInstance("src/assets/Logo1.png");
            img.scaleToFit(60, 60);

            String fechaActual = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            Paragraph datosFactura = new Paragraph("Factura: " + idVenta + "\nFecha: " + fechaActual, normal);

            PdfPTable encabezado = new PdfPTable(3);
            encabezado.setWidthPercentage(100);
            encabezado.setWidths(new float[]{20f, 55f, 25f});
            encabezado.getDefaultCell().setBorder(0);

            encabezado.addCell(img);
            PdfPCell datosEmpresa = new PdfPCell(new Phrase(
                    "RUC: " + rucConfig
                    + "\nNombre: " + nombreConfig
                    + "\nTeléfono: " + telefonoConfig
                    + "\nDirección: " + direccionConfig
                    + "\nRazón Social: " + razonConfig, normal));
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

            Paragraph total = new Paragraph("\nTotal a pagar: $" + String.format("%.2f", totalPagar), negrita);
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
}
