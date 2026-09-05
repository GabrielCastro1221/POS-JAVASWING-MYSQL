package view;

import form.Clientes;
import form.Config;
import form.NuevaVenta;
import form.Productos;
import form.Proveedores;
import form.Reportes;
import form.Usuarios;
import form.Ventas;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;

public class System extends javax.swing.JFrame implements SelectOption {

    public System() {
        setUndecorated(true);
        initComponents();
        this.init();
        sidebar.getListMenu1().setSelected(true);
        sidebar.optionsEvent(this);
        addForm(new NuevaVenta());
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0));
        getContentPane().setBackground(new Color(0, 0, 0, 0));

        backPanel.setOpaque(false);
        backPanel.setBackground(new Color(0, 0, 0, 0));

        jPanel1.setOpaque(false);
        jPanel1.setBackground(new Color(0, 0, 0, 0));

        jPanel2.setOpaque(false);
        jPanel2.setBackground(new Color(0, 0, 0, 0));

        aplicarFormaRedondeada();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                aplicarFormaRedondeada();
            }
        });
    }

    private void aplicarFormaRedondeada() {
        if (getWidth() > 0 && getHeight() > 0) {
            setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
        }
    }

    public void addForm(JComponent com) {
        formContainer.removeAll();
        formContainer.setOpaque(true);
        formContainer.setBackground(new Color(61, 63, 65));
        formContainer.setLayout(new java.awt.BorderLayout());
        formContainer.add(com, java.awt.BorderLayout.CENTER);
        formContainer.revalidate();
        formContainer.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backPanel = new components.RoundedPanel();
        jPanel1 = new javax.swing.JPanel();
        sidebar = new view.Sidebar();
        jPanel2 = new javax.swing.JPanel();
        search1 = new view.Search();
        formContainer = new components.FormContainer();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        backPanel.setPreferredSize(new java.awt.Dimension(1105, 618));

        jPanel1.setBackground(new java.awt.Color(61, 63, 65));
        jPanel1.setLayout(null);
        jPanel1.add(sidebar);
        sidebar.setBounds(0, 0, 210, 720);

        jPanel2.setBackground(new java.awt.Color(60, 61, 65));
        jPanel2.setLayout(null);
        jPanel2.add(search1);
        search1.setBounds(0, 10, 520, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(220, 0, 1180, 60);

        formContainer.setBackground(new java.awt.Color(61, 63, 65));

        javax.swing.GroupLayout formContainerLayout = new javax.swing.GroupLayout(formContainer);
        formContainer.setLayout(formContainerLayout);
        formContainerLayout.setHorizontalGroup(
            formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        formContainerLayout.setVerticalGroup(
            formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        jPanel1.add(formContainer);
        formContainer.setBounds(220, 60, 1180, 660);

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
        );
        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new System().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.RoundedPanel backPanel;
    private components.FormContainer formContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private view.Search search1;
    private view.Sidebar sidebar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void changeForm(int id) {
        JComponent formToChange;
        switch (id) {
            case 1 ->
                formToChange = new NuevaVenta();
            case 2 ->
                formToChange = new Productos();
            case 3 ->
                formToChange = new Proveedores();
            case 4 ->
                formToChange = new Ventas();
            case 5 ->
                formToChange = new Clientes();
            case 6 ->
                formToChange = new Reportes();
            case 7 ->
                formToChange = new Usuarios();
            case 8 ->
                formToChange = new Config();
            default ->
                formToChange = new NuevaVenta();
        }
        addForm(formToChange);
    }
}
