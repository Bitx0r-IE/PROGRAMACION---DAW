package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class V1 {
    private JPanel pTitulo;
    private JLabel lTitulo;
    private JTextField tfNombreProd;
    private JTextField tfUnidades;
    private JLabel lNombre;
    private JLabel lUnidades;
    private JPanel PanelPrincipal;
    private JPanel pTipoOp;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private JPanel pDatosCompra;
    private JLabel lPrecio;
    private JTextField tfPrecio;
    private JComboBox cbProveedor;
    private JPanel pDatosVenta;
    private JLabel lPrecioV;
    private JFormattedTextField ftPrecio;
    private JTextField tfCliente;
    private JPanel pDescuento;
    private JTextField tfImporteVenta;
    private JLabel lImporteVenta;
    private JCheckBox cbPorVolumen;
    private JCheckBox cbProntoPago;
    private JButton bAcepar;
    private JButton bCancelar;
    private JTextField tfImporte;

    //main:
    public static void main(String[] args) {
        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //set y get (panel)

    public JPanel getPanelPrincipal() {
        return pTitulo;
    }

    public void setPanelPrincipal(JPanel pTitulo) {
        this.PanelPrincipal = PanelPrincipal;
    }

    //Acciones:

    public V1() {
        bAcepar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        tfImporteVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bAcepar.doClick();
            }
        });
        tfNombreProd.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfUnidades.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
    }
}


