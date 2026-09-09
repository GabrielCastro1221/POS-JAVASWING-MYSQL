package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import config.Conexion;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReporteInventario {

    public static void reporteInventario() {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Inventario");

        try {
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            Font fuenteTitulo = book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short) 16);
            tituloEstilo.setFont(fuenteTitulo);

            Row filaTitulo = sheet.createRow(0);
            Cell celdaTitulo = filaTitulo.createCell(0);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de Inventario - Productos");

            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 7));

            String[] cabecera = new String[]{
                "Código", "Nombre", "Proveedor", "Categoría",
                "Stock", "Precio Neto", "Precio Bruto", "Fecha Registro"
            };

            CellStyle headerStyle = book.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.THIN);

            Font font = book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short) 12);
            headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(3);
            for (int i = 0; i < cabecera.length; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i]);
            }

            Conexion con = Conexion.getInstancia();
            Connection conn = con.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT codigo, nombre, proveedor_id, categoria_id, stock, precio_neto, precio_bruto, fecha FROM productos"
            );
            ResultSet rs = ps.executeQuery();

            CellStyle datosEstilo = book.createCellStyle();
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderTop(BorderStyle.THIN);

            int numFilaDatos = 4;
            int totalProductos = 0;
            int totalStock = 0;
            double costoTotal = 0;
            double valorVentaTotal = 0;

            while (rs.next()) {
                Row filaDatos = sheet.createRow(numFilaDatos);

                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                int proveedor = rs.getInt("proveedor_id");
                int categoria = rs.getInt("categoria_id");
                int stock = rs.getInt("stock");
                double precioNeto = rs.getDouble("precio_neto");
                double precioBruto = rs.getDouble("precio_bruto");
                Timestamp fecha = rs.getTimestamp("fecha");

                filaDatos.createCell(0).setCellValue(codigo);
                filaDatos.createCell(1).setCellValue(nombre);
                filaDatos.createCell(2).setCellValue(proveedor);
                filaDatos.createCell(3).setCellValue(categoria);
                filaDatos.createCell(4).setCellValue(stock);
                filaDatos.createCell(5).setCellValue(precioNeto);
                filaDatos.createCell(6).setCellValue(precioBruto);
                filaDatos.createCell(7).setCellValue(fecha != null ? fecha.toString() : "");

                for (int i = 0; i < cabecera.length; i++) {
                    filaDatos.getCell(i).setCellStyle(datosEstilo);
                }

                totalProductos++;
                totalStock += stock;
                costoTotal += precioNeto * stock;
                valorVentaTotal += precioBruto * stock;

                numFilaDatos++;
            }

            for (int i = 0; i < cabecera.length; i++) {
                sheet.autoSizeColumn(i);
            }

            double gananciaEsperada = valorVentaTotal - costoTotal;
            int filaResumen = numFilaDatos + 2;

            Row resumen1 = sheet.createRow(filaResumen);
            resumen1.createCell(0).setCellValue("Total de productos:");
            resumen1.createCell(1).setCellValue(totalProductos);

            Row resumen2 = sheet.createRow(filaResumen + 1);
            resumen2.createCell(0).setCellValue("Total de stock (unidades):");
            resumen2.createCell(1).setCellValue(totalStock);

            Row resumen3 = sheet.createRow(filaResumen + 2);
            resumen3.createCell(0).setCellValue("Costo total inventario:");
            resumen3.createCell(1).setCellValue(costoTotal);

            Row resumen4 = sheet.createRow(filaResumen + 3);
            resumen4.createCell(0).setCellValue("Valor de venta esperado:");
            resumen4.createCell(1).setCellValue(valorVentaTotal);

            Row resumen5 = sheet.createRow(filaResumen + 4);
            resumen5.createCell(0).setCellValue("Ganancia esperada:");
            resumen5.createCell(1).setCellValue(gananciaEsperada);

            String fileName = "inventario_productos";
            String home = System.getProperty("user.home");
            File file = new File(home + "/Downloads/" + fileName + ".xlsx");
            FileOutputStream fileOut = new FileOutputStream(file);
            book.write(fileOut);
            fileOut.close();

            Desktop.getDesktop().open(file);
            JOptionPane.showMessageDialog(null, "Reporte de Inventario Generado");

        } catch (IOException | SQLException ex) {
            Logger.getLogger(ReporteInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
