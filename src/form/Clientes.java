package form;

import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.ClientesDAO;

public class Clientes extends javax.swing.JPanel {

    private ClientesDAO dao;
    private DefaultTableModel modelo;

    public Clientes() {
        initComponents();
        setOpaque(false);
        dao = new ClientesDAO();
        modelo = (DefaultTableModel) tableClientes.getModel();
        cargarClientes();

        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tableClientes.getSelectedRow();
                if (fila >= 0) {
                    int id = Integer.parseInt(tableClientes.getValueAt(fila, 0).toString());
                    String nombre = tableClientes.getValueAt(fila, 1).toString();
                    String telefono = tableClientes.getValueAt(fila, 2).toString();
                    String correo = tableClientes.getValueAt(fila, 3).toString();
                    String fecha = tableClientes.getValueAt(fila, 4).toString();

                    clientesForm1.setDatosCliente(id, nombre, telefono, correo, fecha);
                }
            }
        });
    }

    public void cargarClientes() {
        modelo.setRowCount(0);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (Cliente c : dao.ListarClientes()) {
            String fechaFormateada = c.getFecha() != null ? sdf.format(c.getFecha()) : "";
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNombre(),
                c.getTelefono(),
                c.getCorreo(),
                fechaFormateada
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientesForm1 = new form.ClientesForm();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new components.CustomTable();

        setBackground(new java.awt.Color(61, 63, 65));

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "TELEFONO", "EMAIL", "FECHA"
            }
        ));
        jScrollPane1.setViewportView(tableClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(clientesForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clientesForm1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(77, 77, 77))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private form.ClientesForm clientesForm1;
    private javax.swing.JScrollPane jScrollPane1;
    private components.CustomTable tableClientes;
    // End of variables declaration//GEN-END:variables
}
