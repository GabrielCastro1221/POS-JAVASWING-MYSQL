package view;

import components.RoundedPanelSys;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Productos;
import model.ProductosDAO;

public class Search extends RoundedPanelSys {

    private final ProductosDAO productoDAO = new ProductosDAO();
    private JPopupMenu resultsPopup;
    private DefaultListModel<Productos> listModel;
    private JList<Productos> resultsList;
    private Timer debounceTimer;
    private OnProductoSeleccionadoListener listener;
    private JScrollPane resultsScroll;

    public interface OnProductoSeleccionadoListener {

        void onProductoSeleccionado(Productos producto);
    }

    public void setOnProductoSeleccionadoListener(OnProductoSeleccionadoListener listener) {
        this.listener = listener;
    }

    public Search() {
        initComponents();
        setArc(5);
        setLine(false);
        setOpaque(false);
        configureSearchField();
        configureBtnClear();
        configureFocusEffects();
        configureIcons();
        configureBusqueda();
        this.init();

        java.awt.EventQueue.invokeLater(() -> {
            this.requestFocusInWindow();
        });

        this.setOnProductoSeleccionadoListener(producto -> {
            JOptionPane.showMessageDialog(this,
                    "Seleccionaste: " + producto.getNombre() + " - $" + producto.getPrecio_bruto());
        });
    }

    public void init() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));

        searchField.setOpaque(false);
        searchField.setBackground(new Color(0, 0, 0, 0));

        btnClear.setOpaque(false);
        btnClear.setBackground(new Color(0, 0, 0, 0));

        picture2.setOpaque(false);
        picture2.setBackground(new Color(0, 0, 0, 0));
    }

    public void configureSearchField() {
        String placeholder = "Buscar producto";
        searchField.setText(placeholder);
        searchField.setForeground(Color.WHITE);

        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                if (searchField.getText().equals(placeholder)) {
                    searchField.setText("");
                    searchField.setForeground(Color.WHITE);
                    setBackground(new Color(61, 63, 65));
                    searchField.setBackground(new Color(61, 63, 65));
                }
            }

            @Override
            public void focusLost(FocusEvent evt) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText(placeholder);
                    searchField.setForeground(Color.WHITE);
                    btnClear.setVisible(false);
                }
                setBackground(new Color(0, 0, 0, 0));
                searchField.setBackground(new Color(0, 0, 0, 0));
            }
        });
    }

    public void configureBtnClear() {
        btnClear.setVisible(false);
        searchField.addCaretListener(e -> btnClear.setVisible(!searchField.getText().isEmpty()));

        btnClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchField.requestFocus();
                searchField.setText("");
                btnClear.setVisible(false);
                requestFocusInWindow();
            }
        });
    }

    public void configureFocusEffects() {
        Color focusColor = new Color(61, 63, 65);
        Color defaultColor = new Color(61, 63, 65);
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, defaultColor));

        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent evt) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, focusColor));
            }

            @Override
            public void focusLost(FocusEvent evt) {
                setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, defaultColor));
            }
        });
    }

    public void configureIcons() {
        picture2.setBounds(10, 10, 16, 16);
        searchField.setBounds(35, 0, 440, 33);
        btnClear.setBounds(485, 10, 16, 16);
    }

    public void configureBusqueda() {
        listModel = new DefaultListModel<>();
        resultsList = new JList<>(listModel);
        resultsList.setBackground(new Color(45, 47, 49));
        resultsList.setForeground(new Color(200, 200, 200));
        resultsList.setSelectionBackground(new Color(80, 82, 84));
        resultsList.setCellRenderer(new ProductoCellRenderer());
        resultsList.setFixedCellHeight(26); // altura fija por fila, ajusta a tu gusto

        resultsScroll = new JScrollPane(resultsList);
        resultsScroll.setBorder(BorderFactory.createEmptyBorder());
        resultsScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        resultsPopup = new JPopupMenu();
        resultsPopup.setBorder(BorderFactory.createLineBorder(new Color(80, 82, 84)));
        resultsPopup.add(resultsScroll);
        resultsPopup.setFocusable(false);

        debounceTimer = new Timer(300, e -> ejecutarBusqueda());
        debounceTimer.setRepeats(false);

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onTextChange();
            }
        });

        resultsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    seleccionarProductoActual();
                }
            }
        });

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!resultsPopup.isVisible()) {
                    return;
                }
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        int next = Math.min(resultsList.getSelectedIndex() + 1, listModel.size() - 1);
                        resultsList.setSelectedIndex(next);
                        break;
                    case KeyEvent.VK_UP:
                        int prev = Math.max(resultsList.getSelectedIndex() - 1, 0);
                        resultsList.setSelectedIndex(prev);
                        break;
                    case KeyEvent.VK_ENTER:
                        seleccionarProductoActual();
                        break;
                    case KeyEvent.VK_ESCAPE:
                        resultsPopup.setVisible(false);
                        break;
                }
            }
        });
    }

    private void onTextChange() {
        String texto = searchField.getText().trim();
        if (texto.isEmpty() || texto.equals("Buscar producto")) {
            resultsPopup.setVisible(false);
            return;
        }
        debounceTimer.restart();
    }

    private void ejecutarBusqueda() {
        String criterio = searchField.getText().trim();
        if (criterio.isEmpty()) {
            resultsPopup.setVisible(false);
            return;
        }

        List<Productos> resultados = productoDAO.buscarProductos(criterio);
        listModel.clear();

        if (resultados.isEmpty()) {
            resultsPopup.setVisible(false);
            return;
        }

        for (Productos p : resultados) {
            listModel.addElement(p);
        }

        resultsList.setSelectedIndex(0);

        int filasVisibles = Math.min(resultados.size(), 6);
        int alto = filasVisibles * resultsList.getFixedCellHeight();
        resultsScroll.setPreferredSize(new java.awt.Dimension(460, alto));

        if (!resultsPopup.isVisible()) {
            SwingUtilities.invokeLater(() -> {
                resultsPopup.pack();
                resultsPopup.show(this, 0, this.getHeight());
            });
        } else {
            resultsPopup.pack();
        }
    }

    private void seleccionarProductoActual() {
        Productos seleccionado = resultsList.getSelectedValue();
        if (seleccionado != null) {
            resultsPopup.setVisible(false);
            if (listener != null) {
                listener.onProductoSeleccionado(seleccionado);
            }
            searchField.setText("");
        }
    }

    private static class ProductoCellRenderer extends javax.swing.DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Productos p) {
                setText(String.format("%s  —  %s  —  $%.2f", p.getCodigo(), p.getNombre(), p.getPrecio_bruto()));
            }
            setOpaque(true);
            setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
            if (isSelected) {
                setBackground(new Color(80, 82, 84));
                setForeground(new Color(200, 200, 200));
            } else {
                setBackground(new Color(45, 47, 49));
                setForeground(new Color(200, 200, 200));
            }
            return this;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new components.CustomTextField();
        btnClear = new components.Picture();
        picture2 = new components.Picture();

        setBackground(new java.awt.Color(61, 63, 65));
        setLayout(null);

        searchField.setForeground(new java.awt.Color(204, 204, 204));
        searchField.setText("Buscar productos");
        add(searchField);
        searchField.setBounds(0, 0, 460, 33);

        btnClear.setPath("/assets/close.png");
        add(btnClear);
        btnClear.setBounds(485, 11, 10, 10);

        picture2.setText("picture2");
        picture2.setPath("/assets/search.png");
        add(picture2);
        picture2.setBounds(500, 10, 13, 13);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.Picture btnClear;
    private components.Picture picture2;
    private components.CustomTextField searchField;
    // End of variables declaration//GEN-END:variables
}
