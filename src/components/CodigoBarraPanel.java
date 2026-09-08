package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CodigoBarraPanel extends JPanel {

    private final List<CustomTextField> listaCampos = new ArrayList<>();
    private final JButton btnAgregar;

    public CodigoBarraPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        btnAgregar = new JButton("+ código");
        btnAgregar.addActionListener((ActionEvent e) -> agregarCampo());
        agregarCampo();
        add(btnAgregar);
    }

    private void agregarCampo() {
        CustomTextField txtCodigoProducto = new CustomTextField();
        txtCodigoProducto.setPlaceholder("Ingresar código");
        txtCodigoProducto.setColumns(10);
        txtCodigoProducto.setMaximumSize(new Dimension(250, 25));
        listaCampos.add(txtCodigoProducto);
        add(txtCodigoProducto, getComponentCount() - 1);
        add(javax.swing.Box.createRigidArea(new Dimension(0, 5)), getComponentCount() - 1);
        revalidate();
        repaint();
    }

    public List<String> getCodigos() {
        List<String> codigos = new ArrayList<>();
        for (CustomTextField campo : listaCampos) {
            String valor = campo.getRealText().trim();
            if (!valor.isEmpty()) {
                codigos.add(valor);
            }
        }
        return codigos;
    }

    public void setCodigos(List<String> codigos) {
        removeAll();
        listaCampos.clear();

        for (String codigo : codigos) {
            CustomTextField txtCodigoProducto = new CustomTextField();
            txtCodigoProducto.setPlaceholder("Código");
            txtCodigoProducto.setText(codigo);
            txtCodigoProducto.setMaximumSize(new Dimension(250, 25));
            listaCampos.add(txtCodigoProducto);
            add(txtCodigoProducto);
        }
        add(btnAgregar);
        revalidate();
        repaint();
    }
}
