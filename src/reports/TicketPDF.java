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
            String direccionConfig, String razonConfig, String rucCliente, String nombreCliente,
            String telefonoCliente, String direccionCliente) {
        try {
            File file = new File("src/pdf/venta" + idVenta + ".pdf");
            FileOutputStream archivo = new FileOutputStream(file);
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/assets/Logo.png");
            img.scaleToFit(60, 60);

            Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font normal = new Font(Font.FontFamily.HELVETICA, 11);

            String fechaActual = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            Paragraph fecha = new Paragraph("Factura: " + idVenta + "\nFecha: " + fechaActual + "\n\n", normal);

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

            PdfPCell datosFactura = new PdfPCell(fecha);
            datosFactura.setBorder(0);
            encabezado.addCell(datosFactura);

            doc.add(encabezado);

            Paragraph clienteTitulo = new Paragraph("\nDatos del Cliente\n\n", negrita);
            doc.add(clienteTitulo);

            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.setWidths(new float[]{25f, 35f, 20f, 30f});

            String[] headersCli = {"Dni/RUC", "Nombre", "Teléfono", "Dirección"};
            String[] valuesCli = {rucCliente, nombreCliente, telefonoCliente, direccionCliente};

            for (String header : headersCli) {
                PdfPCell cell = new PdfPCell(new Phrase(header, negrita));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setBorder(Rectangle.NO_BORDER);
                tablaCliente.addCell(cell);
            }

            for (String value : valuesCli) {
                PdfPCell cell = new PdfPCell(new Phrase(value, normal));
                cell.setBorder(Rectangle.NO_BORDER);
                tablaCliente.addCell(cell);
            }

            doc.add(tablaCliente);

            Paragraph productosTitulo = new Paragraph("\nDetalle de Productos\n\n", negrita);
            doc.add(productosTitulo);

            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.setWidths(new float[]{10f, 50f, 20f, 20f});

            String[] headersPro = {"Cantidad", "Descripción", "P. Unitario", "Total"};
            for (String header : headersPro) {
                PdfPCell cell = new PdfPCell(new Phrase(header, negrita));
                cell.setBackgroundColor(BaseColor.CYAN);
                cell.setBorder(Rectangle.NO_BORDER);
                tablaProductos.addCell(cell);
            }

            for (int i = 0; i < tableVenta.getRowCount(); i++) {
                tablaProductos.addCell(new Phrase(tableVenta.getValueAt(i, 2).toString(), normal));
                tablaProductos.addCell(new Phrase(tableVenta.getValueAt(i, 1).toString(), normal));
                tablaProductos.addCell(new Phrase(tableVenta.getValueAt(i, 3).toString(), normal));
                tablaProductos.addCell(new Phrase(tableVenta.getValueAt(i, 4).toString(), normal));
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
