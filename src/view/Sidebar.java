package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Sidebar extends javax.swing.JPanel {

    ArrayList<ListMenu> options = new ArrayList<>();

    public Sidebar() {
        initComponents();
        setOpaque(false);
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        jPanel1.setOpaque(false);
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel2.setOpaque(false);
        jPanel2.setBackground(new Color(0, 0, 0, 0));
        listMenu1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listMenu11.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void optionsEvent(SelectOption SelectOption) {
        listMenu1.setId(1);
        options.add(listMenu1);
        listMenu2.setId(2);
        options.add(listMenu2);
        listMenu3.setId(3);
        options.add(listMenu3);
        listMenu4.setId(4);
        options.add(listMenu4);
        listMenu5.setId(5);
        options.add(listMenu5);
        listMenu6.setId(6);
        options.add(listMenu6);
        listMenu7.setId(7);
        options.add(listMenu7);
        listMenu8.setId(8);
        options.add(listMenu8);
        listMenu9.setId(9);
        options.add(listMenu9);
        listMenu10.setId(10);
        options.add(listMenu10);
        listMenu11.setId(11);
        options.add(listMenu11);

        for (ListMenu option : options) {
            option.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (ListMenu op : options) {
                        op.setSelected(false);
                    }
                    SelectOption.changeForm(option.getId());
                    option.setSelected(true);
                }
            });
        }
    }

    public ListMenu getListMenu1() {
        return listMenu1;
    }

    public void setListMenu1(ListMenu listMenu1) {
        this.listMenu1 = listMenu1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        listMenu1 = new view.ListMenu();
        listMenu9 = new view.ListMenu();
        listMenu4 = new view.ListMenu();
        listMenu11 = new view.ListMenu();
        listMenu2 = new view.ListMenu();
        listMenu3 = new view.ListMenu();
        listMenu5 = new view.ListMenu();
        jPanel2 = new javax.swing.JPanel();
        listMenu6 = new view.ListMenu();
        listMenu10 = new view.ListMenu();
        listMenu7 = new view.ListMenu();
        listMenu8 = new view.ListMenu();
        picture1 = new components.Picture();

        setBackground(new java.awt.Color(243, 243, 243));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        listMenu1.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        listMenu1.setPath("/assets/factura-punto-de-venta.png");
        listMenu1.setText("Nueva venta");
        jPanel1.add(listMenu1);

        listMenu9.setPath("/assets/archivo-factura-dolar.png");
        listMenu9.setText("Nueva compra");
        jPanel1.add(listMenu9);

        listMenu4.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        listMenu4.setPath("/assets/venta.png");
        listMenu4.setText("Ventas");
        jPanel1.add(listMenu4);

        listMenu11.setPath("/assets/carrito-de-compra-anadir.png");
        listMenu11.setText("Compras");
        jPanel1.add(listMenu11);

        listMenu2.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        listMenu2.setPath("/assets/alt-de-inventario.png");
        listMenu2.setText("Inventario");
        jPanel1.add(listMenu2);

        listMenu3.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        listMenu3.setPath("/assets/proveedor.png");
        listMenu3.setText("Proveedores");
        jPanel1.add(listMenu3);

        listMenu5.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        listMenu5.setPath("/assets/revisar.png");
        listMenu5.setText("Clientes");
        jPanel1.add(listMenu5);

        add(jPanel1);
        jPanel1.setBounds(20, 150, 190, 300);

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));
        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 9));

        listMenu6.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        listMenu6.setPath("/assets/ReporteExcel.png");
        listMenu6.setText("Reportes");
        jPanel2.add(listMenu6);

        listMenu10.setPath("/assets/comercio.png");
        listMenu10.setText("Dashboard");
        jPanel2.add(listMenu10);

        listMenu7.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        listMenu7.setPath("/assets/agregar-usuario.png");
        listMenu7.setText("Usuarios");
        jPanel2.add(listMenu7);

        listMenu8.setPath("/assets/settings.png");
        listMenu8.setText("Configuracion");
        jPanel2.add(listMenu8);

        add(jPanel2);
        jPanel2.setBounds(20, 500, 190, 170);

        picture1.setPath("/assets/Logo.png");
        add(picture1);
        picture1.setBounds(10, 0, 200, 150);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private view.ListMenu listMenu1;
    private view.ListMenu listMenu10;
    private view.ListMenu listMenu11;
    private view.ListMenu listMenu2;
    private view.ListMenu listMenu3;
    private view.ListMenu listMenu4;
    private view.ListMenu listMenu5;
    private view.ListMenu listMenu6;
    private view.ListMenu listMenu7;
    private view.ListMenu listMenu8;
    private view.ListMenu listMenu9;
    private components.Picture picture1;
    // End of variables declaration//GEN-END:variables
}
