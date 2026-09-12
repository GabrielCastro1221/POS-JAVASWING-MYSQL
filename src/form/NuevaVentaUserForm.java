package form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import model.Productos;
import model.ProductosDAO;
import model.Venta;
import model.VentaDAO;
import model.Config;
import config.Session;
import model.ConfigDAO;
import model.DetalleVenta;
import model.ValidacionesTextField;
import reports.TicketPDF;
import reports.TicketPOS;

public class NuevaVentaUserForm extends javax.swing.JPanel {

    private NuevaVenta panelVenta;

    public void setPanelVenta(NuevaVenta panelVenta) {
        this.panelVenta = panelVenta;
    }

    Productos pro = new Productos();
    ProductosDAO proDAO = new ProductosDAO();
    VentaDAO vDAO = new VentaDAO();
    Venta v = new Venta();
    DetalleVenta Dv = new DetalleVenta();

    public NuevaVentaUserForm() {
        this.panelVenta = panelVenta;
        initComponents();
        this.init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        txtTelClienteVenta.setVisible(false);
        txtCorreoClienteVenta.setVisible(false);
        txtIdClienteVenta.addActionListener(e -> cargarClientePorId());
        btnGenerarVenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelVendedor.setVisible(false);
        if (Session.getUsuario() != null) {
            labelVendedor.setText(Session.getUsuario().getNombre());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int arc = 20;
        RoundRectangle2D rounded = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
        g2.setColor(new Color(255, 255, 255, 80));
        g2.draw(rounded);
        g2.dispose();
    }

    private void cargarClientePorId() {
        String idTexto = txtIdClienteVenta.getText().trim();
        if (idTexto.isEmpty()) {
            return;
        }
        try {
            int idCliente = Integer.parseInt(idTexto);
            model.ClientesDAO dao = new model.ClientesDAO();
            model.Cliente cliente = dao.buscarClientePorId(idCliente);
            if (cliente != null) {
                txtIdClienteVenta.setText(cliente.getId() + "");
                txtNombreClienteVenta.setText(cliente.getNombre());
                txtTelClienteVenta.setText(cliente.getTelefono());
                txtCorreoClienteVenta.setText(cliente.getCorreo());
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Cliente no encontrado");
                limpiarCamposCliente();
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID inválido");
        }
    }

    public void actualizarTotal(double total) {
        lblTotalVenta.setText("$ " + String.format("%.2f", total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreClienteVenta = new javax.swing.JLabel();
        txtNombreClienteVenta = new components.CustomTextField();
        lblDniClienteVenta1 = new javax.swing.JLabel();
        txtIdClienteVenta = new components.CustomTextField();
        roundedPanelGenerarVenta = new components.RoundedPanel();
        btnGenerarVenta = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        lblTotalVenta = new javax.swing.JLabel();
        txtTelClienteVenta = new javax.swing.JLabel();
        txtCorreoClienteVenta = new javax.swing.JLabel();
        labelVendedor = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 63, 65));
        setPreferredSize(new java.awt.Dimension(1000, 300));
        setLayout(null);

        lblNombreClienteVenta.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblNombreClienteVenta.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreClienteVenta.setText("Nombre cliente");
        add(lblNombreClienteVenta);
        lblNombreClienteVenta.setBounds(320, 40, 110, 17);

        txtNombreClienteVenta.setForeground(new java.awt.Color(200, 200, 200));
        txtNombreClienteVenta.setEnabled(false);
        add(txtNombreClienteVenta);
        txtNombreClienteVenta.setBounds(270, 60, 210, 33);

        lblDniClienteVenta1.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        lblDniClienteVenta1.setForeground(new java.awt.Color(255, 255, 255));
        lblDniClienteVenta1.setText("ID - Cliente");
        add(lblDniClienteVenta1);
        lblDniClienteVenta1.setBounds(80, 40, 110, 17);

        txtIdClienteVenta.setForeground(new java.awt.Color(200, 200, 200));
        txtIdClienteVenta.setText("Ingrese el ID");
        add(txtIdClienteVenta);
        txtIdClienteVenta.setBounds(20, 60, 210, 33);

        roundedPanelGenerarVenta.setBottomColor(new java.awt.Color(51, 51, 255));
        roundedPanelGenerarVenta.setTopColor(new java.awt.Color(0, 153, 255));

        btnGenerarVenta.setFont(new java.awt.Font("Caladea", 1, 14)); // NOI18N
        btnGenerarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarVentaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundedPanelGenerarVentaLayout = new javax.swing.GroupLayout(roundedPanelGenerarVenta);
        roundedPanelGenerarVenta.setLayout(roundedPanelGenerarVentaLayout);
        roundedPanelGenerarVentaLayout.setHorizontalGroup(
            roundedPanelGenerarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelGenerarVentaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roundedPanelGenerarVentaLayout.setVerticalGroup(
            roundedPanelGenerarVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelGenerarVentaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(roundedPanelGenerarVenta);
        roundedPanelGenerarVenta.setBounds(550, 50, 150, 40);

        lblTotalPagar.setFont(new java.awt.Font("Caladea", 1, 18)); // NOI18N
        lblTotalPagar.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPagar.setText("TOTAL A PAGAR");
        add(lblTotalPagar);
        lblTotalPagar.setBounds(780, 60, 150, 22);

        lblTotalVenta.setFont(new java.awt.Font("Caladea", 1, 20)); // NOI18N
        lblTotalVenta.setForeground(new java.awt.Color(255, 255, 0));
        lblTotalVenta.setText("$ ----------");
        add(lblTotalVenta);
        lblTotalVenta.setBounds(930, 50, 130, 40);
        add(txtTelClienteVenta);
        txtTelClienteVenta.setBounds(480, 30, 0, 0);
        add(txtCorreoClienteVenta);
        txtCorreoClienteVenta.setBounds(490, 70, 0, 0);

        labelVendedor.setText("Miscelanea Bellavista");
        add(labelVendedor);
        labelVendedor.setBounds(790, 10, 147, 17);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarVentaMouseClicked
        int idVenta = registrarVenta();
        ConfigDAO confDAO = new ConfigDAO();
        Config cfg = confDAO.obtenerUltimaConfig();
        if (idVenta > 0) {
            registrarDetalle(idVenta);
            TicketPDF ticket = new TicketPDF(panelVenta.getTableVenta(), panelVenta.getTotalPagar());
            ticket.GenerarPDF(idVenta, String.valueOf(cfg.getRuc()), cfg.getNombre(), cfg.getTelefono(), cfg.getDireccion(), cfg.getRazon_social());
            TicketPOS.imprimirTicket(idVenta);
            limpiarCamposCliente();
        }
    }//GEN-LAST:event_btnGenerarVentaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGenerarVenta;
    private javax.swing.JLabel labelVendedor;
    private javax.swing.JLabel lblDniClienteVenta1;
    private javax.swing.JLabel lblNombreClienteVenta;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JLabel lblTotalVenta;
    private components.RoundedPanel roundedPanelGenerarVenta;
    private javax.swing.JLabel txtCorreoClienteVenta;
    private components.CustomTextField txtIdClienteVenta;
    private components.CustomTextField txtNombreClienteVenta;
    private javax.swing.JLabel txtTelClienteVenta;
    // End of variables declaration//GEN-END:variables

    private int registrarVenta() {
        ValidacionesTextField val = new ValidacionesTextField();
        String idStr = txtIdClienteVenta.getText().trim();
        String nombre = txtNombreClienteVenta.getText().trim();
        String telefono = txtTelClienteVenta.getText().trim();
        String correo = txtCorreoClienteVenta.getText().trim();
        if (!idStr.matches("\\d+")) {
            javax.swing.JOptionPane.showMessageDialog(this, "El ID de cliente debe ser numérico");
            return -1;
        }
        if (!val.validarNombre(nombre)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El nombre debe tener al menos 8 caracteres");
            return -1;
        }
        if (!val.validarCelularColombia(telefono)) {
            javax.swing.JOptionPane.showMessageDialog(this, "El teléfono debe ser un número válido de 10 dígitos que empiece por 3");
            return -1;
        }
        if (!val.validarCorreo(correo)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un correo válido");
            return -1;
        }
        try {
            int clienteId = Integer.parseInt(idStr);
            String vendedor = labelVendedor.getText();
            double monto = panelVenta.getTotalPagar();
            java.sql.Timestamp fechaActual = new java.sql.Timestamp(System.currentTimeMillis());
            v.setCliente_id(clienteId);
            v.setNombreCliente(nombre);
            v.setNombreVendedor(vendedor);
            v.setTotal(monto);
            v.setFecha(fechaActual);
            if (vDAO.registrarVenta(v)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Venta registrada con éxito");
                return vDAO.idVenta();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al registrar la venta");
                return -1;
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "ID de cliente inválido");
            return -1;
        }
    }

    private void registrarDetalle(int idVenta) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) panelVenta.getTableVenta().getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int productoId = Integer.parseInt(modelo.getValueAt(i, 0).toString());
            int cantidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());
            double precio = Double.parseDouble(modelo.getValueAt(i, 4).toString());
            Dv.setCodigo_producto(productoId);
            Dv.setCantidad(cantidad);
            Dv.setPrecio(precio);
            Dv.setId_venta(idVenta);
            vDAO.registrarDetalleVenta(Dv);
            proDAO.restarStock(productoId, cantidad);
            proDAO.eliminarCodigosBarras(productoId, cantidad);
        }
    }

    private void limpiarCamposCliente() {
        txtIdClienteVenta.setText("");
        txtNombreClienteVenta.setText("");
        txtTelClienteVenta.setText("");
        txtCorreoClienteVenta.setText("");
    }
}
