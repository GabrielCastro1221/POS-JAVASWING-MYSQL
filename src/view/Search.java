package view;

import components.RoundedPanelSys;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

public class Search extends RoundedPanelSys {

    public Search() {
        initComponents();
        setArc(5);
        setLine(false);
        setOpaque(false);
        configureSearchField();
        configureBtnClear();
        configureFocusEffects();
        configureIcons();
        this.init();

        java.awt.EventQueue.invokeLater(() -> {
            this.requestFocusInWindow();
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
