package reports;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Compra;
import model.DetalleCompra;

public class CompraPDF {

    public void generarPDF(Compra compra, List<DetalleCompra> detalles, String rucConfig,
            String nombreConfig, String telefonoConfig, String direccionConfig, String razonConfig) {
        try {
            String carpetaUsuario = System.getProperty("user.home");
            File dir = new File(carpetaUsuario, "MiscelaneaBellavista" + File.separator + "Facturas_compras");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, "compra_" + compra.getId() + ".pdf");
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();
            Font titulo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font normal = new Font(Font.FontFamily.HELVETICA, 11);
            Image img = Image.getInstance("src/assets/Logo1.png");
            img.scaleToFit(60, 60);
            PdfPTable encabezado = new PdfPTable(3);
            encabezado.setWidthPercentage(100);
            encabezado.setWidths(new float[]{20f, 55f, 25f});
            encabezado.getDefaultCell().setBorder(0);
            encabezado.addCell(img);
            PdfPCell empresa = new PdfPCell(
                    new Phrase("RUC: " + rucConfig + "\nNombre: " + nombreConfig
                            + "\nTeléfono: " + telefonoConfig + "\nDirección: " + direccionConfig
                            + "\nRazón Social: " + razonConfig, normal));
            empresa.setBorder(0);
            encabezado.addCell(empresa);
            PdfPCell compraCell = new PdfPCell(
                    new Phrase("COMPRA #" + compra.getId() + "\nFactura Proveedor: "
                            + compra.getNumeroFacturaProveedor() + "\nFecha: "
                            + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(compra.getFecha()), normal));
            compraCell.setBorder(0);
            encabezado.addCell(compraCell);
            doc.add(encabezado);
            Paragraph tituloCompra = new Paragraph("\nCOMPROBANTE DE COMPRA\n\n", titulo);
            tituloCompra.setAlignment(Element.ALIGN_CENTER);
            doc.add(tituloCompra);
            Paragraph proveedor = new Paragraph("Proveedor: " + compra.getNombreProveedor()
                    + "\nUsuario: " + compra.getNombreUsuario() + "\n\n", normal);
            doc.add(proveedor);
            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{40f, 15f, 20f, 15f, 20f});
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.WHITE);
            String[] headers = {"Producto", "Cantidad", "Costo Unit.", "IVA", "Subtotal"};
            for (String h : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(h, headerFont));
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(cell);
            }
            for (DetalleCompra detalle : detalles) {
                tabla.addCell(detalle.getNombreProducto());
                tabla.addCell(String.valueOf(detalle.getCantidad()));
                tabla.addCell(String.format("%.2f", detalle.getCostoUnitario()));
                tabla.addCell(String.format("%.2f", detalle.getIvaLinea()));
                tabla.addCell(String.format("%.2f", detalle.getSubtotalLinea()));
            }
            doc.add(tabla);
            Paragraph totales = new Paragraph("\nSubtotal: $" + String.format("%.2f", compra.getSubtotal())
                    + "\nIVA: $" + String.format("%.2f", compra.getIvaTotal()) + "\nTOTAL: $"
                    + String.format("%.2f", compra.getTotal()), negrita);
            totales.setAlignment(Element.ALIGN_RIGHT);
            doc.add(totales);
            Paragraph firma = new Paragraph("\n\nFirma Responsable\n\n---------------------------", normal);
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            doc.close();
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            System.out.println("Error al generar PDF compra: " + e.getMessage());
        }
    }
}