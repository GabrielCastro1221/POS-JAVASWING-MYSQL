package form;

public class Usuario extends javax.swing.JPanel {

    private model.UsuariosDAO dao;
    private javax.swing.table.DefaultTableModel modelo;

    public Usuario() {
        initComponents();
        setOpaque(false);
        dao = new model.UsuariosDAO();
        modelo = (javax.swing.table.DefaultTableModel) tableUsuarios.getModel();
        cargarUsuarios();

        tableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tableUsuarios.getSelectedRow();
                if (fila >= 0) {
                    String id = tableUsuarios.getValueAt(fila, 0).toString();
                    String nombre = tableUsuarios.getValueAt(fila, 1).toString();
                    String correo = tableUsuarios.getValueAt(fila, 2).toString();
                    String pass = tableUsuarios.getValueAt(fila, 3).toString();
                    String rol = tableUsuarios.getValueAt(fila, 4).toString();
                    String telefono = tableUsuarios.getValueAt(fila, 5).toString();

                    usuariosForm1.setDatosUsuario(id, nombre, correo, pass, rol, telefono);
                }
            }
        });
    }

    public void cargarUsuarios() {
        modelo.setRowCount(0);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (model.Usuarios u : dao.ListarUsuarios()) {
            String fechaFormateada = u.getFecha() != null ? sdf.format(u.getFecha()) : "";

            modelo.addRow(new Object[]{
                u.getId(),
                u.getNombre(),
                u.getCorreo(),
                u.getPass(),
                u.getRol(),
                u.getTelefono(),
                fechaFormateada
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuariosForm1 = new form.UsuariosForm();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new components.CustomTable();

        setBackground(new java.awt.Color(61, 63, 65));

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "EMAIL", "CONTRASEÑA", "ROL", "TELEFONO", "FECHA"
            }
        ));
        jScrollPane1.setViewportView(tableUsuarios);
        if (tableUsuarios.getColumnModel().getColumnCount() > 0) {
            tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableUsuarios.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(usuariosForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usuariosForm1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private components.CustomTable tableUsuarios;
    private form.UsuariosForm usuariosForm1;
    // End of variables declaration//GEN-END:variables
}
