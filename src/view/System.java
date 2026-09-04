package view;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

public class System extends javax.swing.JFrame {

    public System() {
        setUndecorated(true);
        initComponents();
        this.init();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backPanel = new components.RoundedPanel();
        jPanel1 = new javax.swing.JPanel();
        sidebar1 = new view.Sidebar();
        jPanel2 = new javax.swing.JPanel();
        search1 = new view.Search();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        backPanel.setPreferredSize(new java.awt.Dimension(1105, 618));

        jPanel1.setBackground(new java.awt.Color(61, 63, 65));
        jPanel1.setLayout(null);
        jPanel1.add(sidebar1);
        sidebar1.setBounds(0, 0, 210, 720);

        jPanel2.setBackground(new java.awt.Color(60, 61, 65));
        jPanel2.setLayout(null);
        jPanel2.add(search1);
        search1.setBounds(0, 20, 520, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(220, 0, 1180, 60);

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private view.Search search1;
    private view.Sidebar sidebar1;
    // End of variables declaration//GEN-END:variables
}
